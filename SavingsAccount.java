import java.util.Date;

public class SavingsAccount implements Account{

    int balance;
    Date entry;

    public SavingsAccount() {
        this.balance = 0;
        this.entry = new Date();
    }

    protected Date getEntry() {
        return entry;
    }

    protected void setEntry(Date entry) {
        this.entry = entry;
    }

    public int getBalance() {
        return balance;
    }

    public void changeBalance(int add) {
        this.balance += add;
    }

    @Override
    public void display_balance() {

    }

    @Override
    public void display_transaction_history() {

    }

    @Override
    public void deposit(int amt) {
        this.balance += amt;
    }
}
