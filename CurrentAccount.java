public class CurrentAccount implements Account{

    int balance;
    int withdrawals;

    public CurrentAccount() {
        this.balance = 0;
        this.withdrawals = 0;
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

    public int getBalance() {
        return balance;
    }

    public void changeBalance(int add) {
        this.balance += add;
    }

    public int getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(int withdrawals) {
        this.withdrawals = withdrawals;
    }
}
