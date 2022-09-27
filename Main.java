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
        System.out.println("3)DEPOSIT");
        System.out.println("4)MONEY TRANSFER");
        System.out.println("5)PIN CHANGE");
        System.out.println("6)EXIT");
        System.out.println("Enter any one of the options");
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ATM atm = new ATM();
        int acc_no, password;
        do {
            int[] credentials = starterMenu();
            acc_no = credentials[0];
            password = credentials[1];
        } while (!atm.check(acc_no, password));

        while(true) {
            mainMenu();
            int option = in.nextInt();

            if (option == 1) {
                atm.withdrawal(acc_no, password);
            }
            else if (option == 2) {

            }
            else if (option == 3) {

            }
            else if (option == 4) {

            }
            else if (option == 5) {

            }
            else if (option == 6) {
                break;
            }
            else {
                System.out.println("INVALID OPTION!");
            }
        }



    }
}
