public interface Account {
    int getBalance();
    void deposit(int amt);
    void changeBalance(int amt);
    boolean withdraw(int amt);

}
