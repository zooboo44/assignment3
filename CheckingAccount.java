package assignment3;

import java.awt.font.TransformAttribute;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CheckingAccount {
    //Constructor
    CheckingAccount(DecimalFormat df){
        this.df = df;
    }
    //Variables
    private double balance = 0;
    private double totalServiceCharge = 0;
    private boolean isFirstTimeAccount = true, first500 = true;
    private String summary = "";
    private final DecimalFormat df;
    private ArrayList<Transaction> transList = new ArrayList<>();

    //Get
    public double getBalance() {
        return balance;
    }
    public double getTotalServiceCharge(){
        return totalServiceCharge;
    }
    public boolean getIsFirstTimeAccount(){
        return isFirstTimeAccount;
    }
    public String getSummary(){
        summary = summary.concat("Total balance: " + df.format(getBalance()) + "\n");
        summary = summary.concat("Total service charge amount: " + df.format(getTotalServiceCharge()) + "\n");
        if(balance < 50){
            summary = summary.concat("Warning, balance below $50" + "\n");
        }
        return summary;
    }

    public void setFirstTimeAccountFalse(){
        isFirstTimeAccount = false;
    }
    public void setBalance(double balance) {
        this.balance = balance;
        setFirstTimeAccountFalse();
    }
    public void addToTotalServiceCharge(double ServiceCharge) {
        this.totalServiceCharge += ServiceCharge;
    }
    public void withdraw(int transNumber, double amount){
        transList.add(new Transaction(transNumber, Transaction.getNextCount(), amount));
        balance -= amount;
        transList.add(new Transaction(4, Transaction.getNextCount(), 0.15));
        addToTotalServiceCharge(0.15);
        summary = summary.concat("Transaction: Check in Amount of: " + df.format(amount) + "\n");
        summary = summary.concat("Service Charge: Check --- charge " + df.format(0.15) + "\n");
        if(balance < 500 && first500){
            transList.add(new Transaction(4, Transaction.getNextCount(), 5));
            addToTotalServiceCharge(5);
            summary = summary.concat("Service Charge: Below $500 --- charge " + df.format(5.00) + "\n");
            first500 = false;
        }
        if(balance < 0){
            transList.add(new Transaction(4, Transaction.getNextCount(), 10));
            addToTotalServiceCharge(10.0);
            summary = summary.concat("Service Charge: Below $0 --- charge " + df.format(10.0)) + "\n";
        }
    }
    public void deposit(int transNumber, double amount){
        transList.add(new Transaction(transNumber, Transaction.getNextCount(), amount));
        balance += amount;
        transList.add(new Transaction(4, Transaction.getNextCount(), 0.10));
        addToTotalServiceCharge(0.10);
        summary = summary.concat("Transaction: Deposit in Amount of " + amount + "\n");
        summary = summary.concat("Total Balance: " + balance + "\n");
        summary = summary.concat("Service Charge: Check " + df.format(0.10)) + "\n";
    }
    public void clearSummary(){
        summary = "";
    }
    public void subTotalServiceCharge(){
        balance -= totalServiceCharge;
    }
    public void endTransaction(){
        subTotalServiceCharge();
        summary = summary.concat("Transaction: End" + "\n");
    }
    public ArrayList getTransList(){
        return transList;
    }
}
