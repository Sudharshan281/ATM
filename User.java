public class User {
    /**
     * User has id, password, savings account, current account
     */

    private final int id;
    private int password;
    SavingsAccount savings_acc;
    CurrentAccount cur_acc;

    public User(int id, int password) {
        this.id = id;
        this.password = password;
        this.savings_acc = new SavingsAccount() ;
        this.cur_acc = new CurrentAccount();
    }

    public int getId() {
        return id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
