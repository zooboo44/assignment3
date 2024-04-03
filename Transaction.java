package assignment3;

public class Transaction {
    Transaction(int transNumber, int transId, double transAmt){
        this.transNumber = transNumber;
        this.transId = transId;
        this.transAmt = transAmt;
    }

    private int transNumber;
    private int transId;
    private double transAmt;
    private static int count = 0;

    public double getTransAmt() {
        return transAmt;
    }
    public int getTransId() {
        return transId;
    }
    public int getTransNumber() {
        return transNumber;
    }
    public static int getNextCount(){
        return count + 1;
    }

    public void setTransAmt(double transAmt) {
        this.transAmt = transAmt;
    }
    public void setTransId(int transId) {
        this.transId = transId;
    }
    public void setTransNumber(int transNumber) {
        this.transNumber = transNumber;
    }

    @Override
    public String toString() {
        String message = "";
        return message = message.concat(transId + "     " + transNumber + "     " + transAmt);
    }
}
