public interface Account {

    /**
     * This interface has the common methods required for an account
     * and both savings account and current account implements this interface
     */

    /**
     *
     * @return balance amount of the respective accounts
     */
    int getBalance();

    /**
     *
     * @param amt : gets amt and adds it to the balance of the account
     */
    void deposit(int amt);

    /**
     * @param amt
     * @return false if amt is greater than balance, or true, and it withdraws the amount
     */
    boolean withdraw(int amt);

    /**
     * @param amt : changed by balance by amount value
     */
    void changeBalance(int amt);

}
