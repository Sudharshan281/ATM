import java.util.Scanner;

public class Main {
    public static int[] starterMenu(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Account Number: ");
        int acc_no = in.nextInt();
        System.out.print("Enter PIN Number: ");
        int pin = in.nextInt();
        return new int[]{acc_no, pin};
    }

    public static void mainMenu(){
        System.out.println("\nMenu:");
        System.out.println("1)CASH WITHDRAWAL");
        System.out.println("2)BALANCE ENQUIRY");
        System.out.println("3)CASH DEPOSIT");
        System.out.println("4)MONEY TRANSFER");
        System.out.println("5)RESET PIN");
        System.out.println("6)EXIT");
        System.out.print("Enter any one of the options: ");
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ATM atm = new ATM();
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
                return;
            }
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
                System.out.println("THANK YOU FOR VISITING OUR ATM");
                break;
            }
            else {
                System.out.println("INVALID OPTION!");
            }
        }

    }
}
