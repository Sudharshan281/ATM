public class CurrentAccount implements Account{

    private int balance;
    private int withdrawals;

    public CurrentAccount() {
        this.balance = 0;
        this.withdrawals = 0;
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

    @Override
    public boolean withdraw(int amt) {
        if(amt > balance){
            System.out.println("NOT ENOUGH BALANCE TO WITHDRAW");
            return false;
        }
        else if (setWithdrawals()){
            this.balance -= amt;
            return true;
        }
        else{
            System.out.println("YOU CAN'T WITHDRAW MORE THAN THRICE A DAY!");
            return false;
        }
    }

    public boolean setWithdrawals() {
        if(this.withdrawals  == 3){
            return false;
        }
        this.withdrawals += 1;
        return true;
    }
}
