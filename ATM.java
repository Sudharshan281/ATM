import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    //an arraylist of users, which stores all information of the users in the bank
    ArrayList<User> users = new ArrayList<>();
    
    //array of valid pins
    private int[] pins;
    
    //array of valid passwords
    protected final int[] ids;

    public ATM() {
        
        /**
         * initializes valid pins with respective passwords
         */

        this.ids = new int[]
                        {61298, 98984, 97703, 16715, 62974, 35647, 35251, 45736, 23227, 37196, 50291, 45525,
                        65714, 31961, 70192, 61686, 37482, 12591, 51349, 59193, 75535, 98860, 74771, 66315,
                        45641, 28786, 99375, 86021, 27863, 64993, 90681, 14540, 96242, 41474, 33737, 97158,
                        21673, 24873, 83535, 24874, 94425, 51298, 83077, 31234, 28903, 52925, 15126, 94617,
                        77027, 57959, 37384, 31140, 55105, 50182, 26680, 11534, 80734, 31439, 45713, 89306};

        this.pins = new int[]
                {33094, 63938, 59327, 32001, 93193, 59904, 15423, 75007, 81977, 42030, 63284, 21148,
                67818, 98895, 48389, 29138, 96882, 79899, 79855, 75641, 79724, 43872, 22846, 42296,
                67003, 32172, 73145, 46244, 59490, 72399, 99243, 68339, 68160, 78085, 62339, 77803,
                91650, 82681, 11231, 48499, 76202, 87656, 39290, 99504, 14845, 18941, 82727, 96436,
                69042, 69661, 59815, 55071, 81706, 75731, 68852, 70392, 23830, 40211, 73564, 74875};

        for(int i=0; i<60; ++i){
            users.add(i,new User(0,0));
        }

        for(int i=0; i<60; ++i){
            users.set(i,new User(ids[i], pins[i]));
        }

    }

    /**
     * @param acc_no
     * @param password
     * @return false if there is no such account found
     */
    
    protected boolean check(int acc_no, int password) {
        int id_len = String.valueOf(acc_no).length();
        int password_len = String.valueOf(password).length();
        boolean acc_found = false;

        if(id_len != 5 || password_len != 5){
            System.out.println("INVALID ACCOUNT!");
            return false;
        }

        for(int i=0; i<60; ++i){
            User u = users.get(i);
            int id = u.getId();
            int pin = u.getPassword();
            if(acc_no == id){
                acc_found = true;
                if(password == pin)
                    return true;
            }
        }

        if(acc_found){
            System.out.println("INVALID PASSWORD");
            return false;
        }

        System.out.println("INVALID ACCOUNT NO");
        return false;
    }

    /**
     * @param acc_no
     * @param password
     * @return returns id of the user found or -1 if no such user exists
     */
    
    private int findUser(int acc_no, int password) {
        for(int i=0; i<60; ++i){
            User u = users.get(i);
            if(u.getId() == acc_no && u.getPassword() == password){
                return i;
            }
        }
        return -1;
    }

    /**
     * displays the information regarding cash withdrawal
     * @return returns the amount entered by the user to the method 'withdrawal'
     */
    
    private int get_withdrawal_amt() {
        System.out.println("Select Amount");
        System.out.println("1)500");
        System.out.println("2)1000");
        System.out.println("3)2000");
        System.out.println("4)4000");
        System.out.println("5)5000");
        System.out.println("6)10000");
        System.out.println("Please Choose your option.");
        System.out.println("(Cash Available:Rs 500,Rs 1000,Rs 2000,Rs 4000,Rs 5000,Rs 10000)");
        System.out.println("Option: ");

        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int amt = 10000;

        if(n == 1) amt = 500;
        else if ( n == 2) amt = 1000;
        else if ( n == 3) amt = 2000;
        else if ( n == 4) amt = 4000;
        else if ( n == 5) amt = 5000;

        return amt;
    }

    /**
     *
     * @param amt
     * @param user_idx
     * @param option
     * @return true if amount is less than balance in the respective account
     */
    
    private boolean balanceAvailable(int amt, int user_idx, int option){
        if (option == 1){
            return users.get(user_idx).cur_acc.withdraw(amt);
        }

        return users.get(user_idx).savings_acc.withdraw(amt);
    }

    /**
     * after menu input, this method is run to help withdrawal of user amt
     * @param acc_no
     * @param password
     */
    
    protected void withdrawal(int acc_no, int password) {
        Scanner in = new Scanner(System.in);

        int amt = get_withdrawal_amt();
        int user_idx = findUser(acc_no, password);

        System.out.println("""
                Please select an account to withdraw:
                ENTER  1 - Current Ac
                       2 - SB Ac
                """);

        int option = in.nextInt();
        assert (option == 1 || option == 2) ;

        if(balanceAvailable(amt, user_idx, option)){
            System.out.println("------------Please wait------------");
            System.out.println("Your transaction is being processed");
            System.out.println("You can collect you cash " + amt);
        }

    }

    /**
     * Helper method to get amount from the user in
     * count of each denomination
     * @return
     */
                           
    private int getAmt(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the amount you want to deposit " +
                "by entering the COUNT of each denominations");
        int ones, twos, fives, hundreds, twoHundreds, fiveHundreds, twoThousands;
        System.out.print("1 : ");
        ones = in.nextInt();
        System.out.print("2 : ");
        twos = in.nextInt();
        System.out.print("5 : ");
        fives = in.nextInt();
        System.out.print("100 : ");
        hundreds = in.nextInt();
        System.out.print("200 : ");
        twoHundreds = in.nextInt();
        System.out.print("500 : ");
        fiveHundreds = in.nextInt();
        System.out.print("2000 : ");
        twoThousands = in.nextInt();
        int amt = (ones) + (2 * twos) + (5 * fives) + (100 * hundreds) +
                (200 * twoHundreds) + (500 * fiveHundreds) + (2000 * twoThousands);

        System.out.println("\nYour Transaction is being processed, Please wait\n");

        System.out.println("------------------SUMMARY------------------");
        System.out.println("   DNM       CNT             SUB           ");
        System.out.println("-------------------------------------------");
        System.out.println(" 2000    *   "+ twoThousands + "      =   "+ (2000*twoThousands));
        System.out.println(" 500     *   "+ fiveHundreds + "     =   "+ (500*fiveHundreds));
        System.out.println(" 100     *   "+ hundreds + "     =   "+ (100*hundreds));
        System.out.println(" 200     *   "+ twoHundreds + "     =   "+ (200*twoHundreds));
        System.out.println(" 5       *   "+ fives + "     =   "+ (5*fives));
        System.out.println(" 2       *   "+ twos + "     =   "+ (2*twos));
        System.out.println(" 1       *   "+ ones + "     =   "+ (ones));
        System.out.println("------------------------------------------");
        System.out.println("                            TOTAL = " + amt);

        return amt;
    }

    /**
     * Deposits the amount in users respective account
     * @param acc_no
     * @param password
     */
                           
    protected void deposit(int acc_no, int password) {
        Scanner in = new Scanner(System.in);
        System.out.println("----------DEPOSIT TO----------");
        System.out.println("1)Current A/c");
        System.out.println("2)Savings(SB) A/c");
        System.out.print("Enter your option: ");
        int option = in.nextInt();
        int amt = getAmt();

        int user_idx = findUser(acc_no, password);
        if(option == 1){
            users.get(user_idx).cur_acc.deposit(amt);
        }
        else{
            users.get(user_idx).savings_acc.deposit(amt);
        }
    }

    /**
     * Shows the balance in users respective account
     * @param acc_no
     * @param password
     */
                           
    protected void balanceEnquiry(int acc_no, int password) {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose your account to check balance");
        System.out.println("1)Current A/c");
        System.out.println("2)SB A/c");
        System.out.println("Enter your option");
        int option = in.nextInt();

        int user_idx = findUser(acc_no, password);
        assert user_idx != -1;
        assert ((option == 1) || (option == 2));
        int balance;
        if(option == 1) {
            balance = users.get(user_idx).cur_acc.getBalance();
        }
        else{
            balance = users.get(user_idx).savings_acc.getBalance();
        }
        System.out.println("Your Balance Amount is : " + balance);
    }

    private boolean isValid_acc(int acc_no){
        for(int i=0; i<60; ++i){
            if(this.ids[i] == acc_no)
                return true;
        }
        return false;
    }

    /**
     * checks if required balance is available in the users account or not
     * @param u
     * @param req_balance
     * @param option
     * @return true if available, else false
     */

    private boolean checkBalance(User u, int req_balance, int option){
        int balance;
        if(option == 1){
            balance = u.cur_acc.getBalance();
        }
        else balance = u.savings_acc.getBalance();
        return balance >= req_balance;
    }

    /**
     * Formal agreement asked before making transaction
     * in an ATM
     * @return agree or not?
     */
                           
    private int transferAgreements(){
        Scanner in = new Scanner(System.in);
        System.out.println("""
                
                --------------------------------------------------------------------------
                
                I AM TRANSFERRING THE AMOUNT THROUGH ATM AND I AGREE/ACCEPT THE FOLLOWING.

                THE BANK SHALL NOT BE LIABLE IN ANY MANNER
                FOR ANY FAILURE TO PROVIDE SERVICES FOR ANY
                CONSEQUENTIAL EFFECTS WHERE THE FAILURE IS
                DUE TO ANY MALFUNCTIONING OF THE ATM/COMMUNICATION LINES.
                
                --------------------------------------------------------------------------
                """);
        System.out.println("""
                         Enter 1 - AGREE
                               2 - DISAGREE
                                    """);
        return in.nextInt();
    }

    /**
     * Helper function for money_transfer
     * add balance to the resp acc
     * @param acc_no
     * @param amt
     */
                           
    private void transferUserAmt(int acc_no, int amt){
        for(int i=0; i<60; ++i){
            if(users.get(i).getId() == acc_no){
                users.get(i).cur_acc.changeBalance(amt);
            }
        }
    }

    /**
     * reduces money from user acc and add money to the other account
     * with all valid checks ( such as balance is more than money asked)
     * @param acc_no
     * @param password
     */
                           
    public void money_transfer(int acc_no, int password) {
        Scanner in = new Scanner(System.in);
        int agree = transferAgreements();
        if(agree != 1) return;

        System.out.println("CHOOSE YOUR ACCOUNT TO TRANSFER THE MONEY");
        System.out.println("1)Current A/c");
        System.out.println("2)SB A/c");
        System.out.print("Enter 1 or 2: ");
        int option = in.nextInt();

        System.out.print("ENTER THE BENEFICIARY ACCOUNT NUMBER: ");
        int transferNo = in.nextInt();
        assert isValid_acc(transferNo) : "ENTER A VALID ACCOUNT NUMBER";

        System.out.print("PLEASE ENTER TRANSACTION AMOUNT :");
        int transferAmt = in.nextInt();
        User U = users.get(findUser(acc_no, password));
        assert checkBalance(U, transferAmt, option);

        int user_idx = findUser(acc_no, password);
        assert  user_idx != -1 ;

        if(balanceAvailable(transferAmt, user_idx, option)) {

            transferUserAmt(transferNo, transferAmt);

            System.out.println("\nYour transaction is being processed");
            System.out.println("            PLEASE WAIT            \n");
            System.out.println("TRANSACTION SUCCESSFUL!");
        }

    }

    /**
     * This methods will help the user to change pin for the respective id
     * @param acc_no
     * @param password
     */
                           
    public void changePin(int acc_no, int password) {
        Scanner in = new Scanner(System.in);
        for(int i=0; i<60; ++i){
            User u = users.get(i);
            int id = u.getId();
            int pin = u.getPassword();

            if( id == acc_no && pin == password){
                System.out.print("Enter a new FIVE DIGIT pin: ");
                int new_pin = in.nextInt();
                assert String.valueOf(new_pin).length() == 5;
                users.get(i).setPassword(new_pin);
                this.pins[i] = new_pin;

                System.out.println("Your password has been reset successfully!");
            }
        }
    }

}
