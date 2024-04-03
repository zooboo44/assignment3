package assignment3;

import javax.swing.*;
import java.text.DecimalFormat;

public class Main {
    public static final String PATTERN1 = "$#,##0.00;($#,##0.00)";
    public static void main(String[] args){
        int again = 0, transactionCode;
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
        df.applyPattern(PATTERN1);
        CheckingAccount checking = new CheckingAccount(df);
        MyFrame transButtons = new MyFrame(checking, df);
        do {
            if(checking.getIsFirstTimeAccount()){
                checking.setBalance(Double.parseDouble(JOptionPane.showInputDialog("Enter Initial Balance: ")));
            }
            transButtons.setVisible(true);

//            transactionCode = Integer.parseInt(JOptionPane.showInputDialog("Enter Transaction Code:"));
//            if(transactionCode >=0 && transactionCode <=2){
//                if(transactionCode == 0){
//                    checking.endTransaction();
//                    JOptionPane.showMessageDialog(null, checking.getSummary());
//                    checking.clearSummary();
//                }
//                if(transactionCode == 1){
//                    checking.withdraw(transactionCode, Double.parseDouble(JOptionPane.showInputDialog("Enter Withdraw Amount")));
//                    JOptionPane.showMessageDialog(null, checking.getSummary());
//                    checking.clearSummary();
//                }
//                if(transactionCode == 2){
//                    checking.deposit(Double.parseDouble(JOptionPane.showInputDialog("Enter Deposit Amount: ")));
//                    JOptionPane.showMessageDialog(null, checking.getSummary());
//                    checking.clearSummary();
//                }
//            }
//            else{
//                JOptionPane.showMessageDialog(null,"Invalid Transaction Code");
//            }

        } while (again != JOptionPane.NO_OPTION || again != JOptionPane.CANCEL_OPTION);
    }
}
