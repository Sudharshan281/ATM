public class User {
    /**
     * This class stores all the information about the user
     * In my implementation of atm, each user has a unique id and a password, a savings account
     * and a current account
     */

    private final int id;       //id is final because it can't be changed
    private int password;
    SavingsAccount savings_acc;
    CurrentAccount cur_acc;

    public User(int id, int password) {
        this.id = id;
        this.password = password;
        this.savings_acc = new SavingsAccount() ;
        this.cur_acc = new CurrentAccount();
    }

    /**
     * below are the required getters and setters for this class
     */

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
