
package model;


public class Wallet {
    private int walletID;
    private String userName;
    private double balance;

    public Wallet() {
    }

    
    
    public Wallet(int walletID, String userName, double balance) {
        this.walletID = walletID;
        this.userName = userName;
        this.balance = balance;
    }

    public int getWalletID() {
        return walletID;
    }

    public void setWalletID(int walletID) {
        this.walletID = walletID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
