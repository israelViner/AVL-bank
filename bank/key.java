public class key {
    //properties
    public String name;
    public int ID;
    public double balance;
    
    //constructor    
    public key(int a, String s) {
        this.name = s;
        this.ID = a;
        this.balance = 0;
    }
    
    //methods
    public double getBalance() {
        return this.balance;
    }
    
    public void setBalance(int x) {
        this.balance += x;
    }
    
    public int getID() {
        return this.ID;
    }
}