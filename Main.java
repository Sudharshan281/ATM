import java.util.Scanner;

public class Main {
    
    /**
     * This is the starting function in our bank,
     * each user must go through this function before doing
     * any operations
     * @return account number, pin entered by the user
     */
    
    public static int[] starterMenu(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Account Number: ");
        int acc_no = in.nextInt();
        System.out.print("Enter PIN Number: ");
        int pin = in.nextInt();
        return new int[]{acc_no, pin};
    }

    /**
     * Displays the list of options available for the user to use
     */

    public static void mainMenu(){
        System.out.println("\nMenu:");
        System.out.println("1)CASH WITHDRAWAL");
        System.out.println("2)BALANCE ENQUIRY");
        System.out.println("3)CASH DEPOSIT");
        System.out.println("4)MONEY TRANSFER");
        System.out.println("5)RESET PIN");
        System.out.println("6)EXIT ACCOUNT");
        System.out.println("7)EXIT ATM");
        System.out.print("Enter any one of the options: ");
    }


    public static void main(String[] args) {
        System.out.println("WELCOME TO OUR ATM");
        ATM atm = new ATM();
        runATM(atm);
    }

    /**
     * Gets acc no, and password , checks it
     * if it doesn't match for more than thrice, it stops further execution
     * @param atm
     * @return
     */
    
    public static int[] getInfo(ATM atm){
        int acc_no, password, cnt_wrong_pins = 0;
        while (true){
            int[] credentials = starterMenu();
            acc_no = credentials[0];
            password = credentials[1];
            if(atm.check(acc_no, password)){
                break;
            }
            ++cnt_wrong_pins;
            if(cnt_wrong_pins == 3){
                System.out.println("YOU CAN'T TRY MORE THAN THRICE!");
                return new int[]{-1, -1};
            }
        }
        return new int[]{acc_no, password};
    }

    /**
     * Get option from the main menu() and call methods from ATM accordingly
     * @param atm
     */

    public static void runATM(ATM atm){
        Scanner in = new Scanner(System.in);
        int[] acnt_details = getInfo(atm);
        int acc_no = acnt_details[0];
        int password = acnt_details[1];

        if(acc_no == -1 && password == -1){
            return;
        }

        while(true) {
            mainMenu();
            int option = in.nextInt();

            if (option == 1) {
                atm.withdrawal(acc_no, password);
            }
            else if (option == 2) {
                atm.balanceEnquiry(acc_no, password);
            }
            else if (option == 3) {
                atm.deposit(acc_no, password);
            }
            else if (option == 4) {
                atm.money_transfer(acc_no, password);
            }
            else if (option == 5) {
                atm.changePin(acc_no, password);
            }
            else if (option == 6) {
                System.out.println("THANKS FOR VISITING OUR ATM\n");
                runATM(atm);
            }
            else if(option == 7){
                break;
            }
            else {
                System.out.println("INVALID OPTION!");
            }
        }
    }
}
