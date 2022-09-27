import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    ArrayList<User> users = new ArrayList<>();
    private int[] pins;
    protected final int[] ids;

    public ATM() {
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

    protected boolean check(int acc_no, int password) {
        int id_len = String.valueOf(acc_no).length();
        int password_len = String.valueOf(password).length();
        boolean acc_found = false;

        if(id_len != 5 || password_len != 5){
            System.out.println("INVALID ACCOUNT");
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

    private User findUser(int acc_no, int password) {
        for(int i=0; i<60; ++i){
            User u = users.get(i);
            if(u.getId() == acc_no && u.getPassword() == password){
                return u;
            }
        }
        return null;
    }


    protected void withdrawal(int acc_no, int password) {
        System.out.println("Select Amount");
        System.out.println("1)1000");
        System.out.println("2)2000");
        System.out.println("3)4000");
        System.out.println("4)5000");
        System.out.println("5)8000");
        System.out.println("6)10000");
        System.out.print("Enter your option: ");

        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        if(n == 1){

        }
        else if (n == 2){

        }
        else if (n == 3){

        }
        else if (n == 4){

        }
        else if (n == 5){

        }
        else if( n == 6){

        }
    }
    
    private int getAmt(){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter the amount you want to deposit " +
                "by entering the COUNT of each denominations");
        int ones, twos, fives, fifty , hundreds, twoHundreds, fiveHundreds, twoThousands;
        System.out.print(" 1 : ");
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

        return (ones) + (2 * twos) + (5 * fives) + (100 * hundreds) + 
                    (200 * twoHundreds) + (500 * fiveHundreds) + (2000 * twoThousands);
    }

    protected void deposit(int acc_no, int password) {
        Scanner in = new Scanner(System.in);
        System.out.println("----------DEPOSIT TO----------");
        System.out.println("1)Current A/c");
        System.out.println("2)Savings(SB) A/c");
        System.out.print("Enter your option: ");
        int option = in.nextInt();
        int amt = getAmt();

        for(int i=0; i<60; ++i){
            if(users.get(i).getPassword() == password && users.get(i).getId() == acc_no){
                if(option == 1)
                    users.get(i).cur_acc.deposit(amt);
                else
                    users.get(i).savings_acc.deposit(amt);
            }
        }
    }

    protected void balanceEnquiry(int acc_no, int password) {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose your account to check balance");
        System.out.println("1)Current A/c");
        System.out.println("2)SB A/c");
        System.out.println("Enter your option");
        int option = in.nextInt();

        User u = findUser(acc_no, password);
        assert u != null;
        assert ((option == 1) || (option == 2));
        int balance;
        if(option == 1) {
            balance = u.savings_acc.getBalance();
        }
        else{
            balance = u.cur_acc.getBalance();
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

    private boolean checkBalance(User u, int req_balance, int option){
        int balance;
        if(option == 1){
            balance = u.cur_acc.getBalance();
        }
        else balance = u.savings_acc.getBalance();
        return balance >= req_balance;
    }

    public void money_transfer(int acc_no, int password) {
        Scanner in = new Scanner(System.in);

        System.out.println("Choose your account to transfer money from");
        System.out.println("1)Current A/c");
        System.out.println("2)SB A/c");
        int option = in.nextInt();

        System.out.print("Enter the other account number: ");
        int transferNo = in.nextInt();
        assert isValid_acc(transferNo);

        System.out.print("Please enter transaction amount: ");
        int transferAmt = in.nextInt();
        assert checkBalance(findUser(acc_no, password), transferAmt, option);

        System.out.println("\n------------PLEASE WAIT------------");
        System.out.println("Your transaction is being processed\n");

        for(int i=0; i<60; ++i){
            if(users.get(i).getId() == transferNo){
                users.get(i).cur_acc.changeBalance(transferAmt);
            }
            if(users.get(i).getId() == acc_no && users.get(i).getPassword() == password){
                if(option == 1){
                    users.get(i).cur_acc.changeBalance(-transferAmt);
                }
                else if (option == 2){
                    users.get(i).savings_acc.changeBalance(-transferAmt);
                }
            }
        }

        System.out.println("Your transaction has been completed successfully!\n");

    }

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
