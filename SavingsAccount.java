public class SavingsAccount implements Account{

    private int balance;

    public SavingsAccount() {       //constructor
        this.balance = 0;
    }

    /**
     * below we have methods which we override form the interface
     */

    public int getBalance() {
        return balance;
    }

    public void changeBalance(int add) {
        this.balance += add;
    }

    @Override
    public boolean withdraw(int amt) {
        if(amt > balance){
            System.out.println("NOT ENOUGH BALANCE TO WITHDRAW!");
            return false;
        }
        this.balance -= amt;
        return true;
    }

    @Override
    public void deposit(int amt) {
        this.balance += amt;
    }
}
