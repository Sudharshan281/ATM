public class CurrentAccount implements Account{

    /**
     * This is same as a savings account except for the fact that
     * the user can't withdraw his money more than thrice
     */

    private int balance;
    private int withdrawals;

    public CurrentAccount() {       //constructor
        this.balance = 0;
        this.withdrawals = 0;
    }

    /**
     * below we have methods which we override form interface
     */
    @Override
    public void deposit(int amt) {
        this.balance += amt;
    }

    public int getBalance() {
        return this.balance;
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

    /**
     * this method restricts the users withdrawal frequency
     * @return false if user tries to withdraw more than thrice
     */

    public boolean setWithdrawals() {
        if(this.withdrawals  == 3){
            return false;
        }
        this.withdrawals += 1;
        return true;
    }
}
