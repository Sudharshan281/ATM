import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    ArrayList<User> users = new ArrayList<>();
    public ATM() {
        int[] ids = {61298, 98984, 97703, 16715, 62974, 35647, 35251, 45736, 23227, 37196, 50291, 45525,
                     65714, 31961, 70192, 61686, 37482, 12591, 51349, 59193, 75535, 98860, 74771, 66315,
                     45641, 28786, 99375, 86021, 27863, 64993, 90681, 14540, 96242, 41474, 33737, 97158,
                     21673, 24873, 83535, 24874, 94425, 51298, 83077, 31234, 28903, 52925, 15126, 94617,
                     77027, 57959, 37384, 31140, 55105, 50182, 26680, 11534, 80734, 31439, 45713, 89306};

        int[] pins = {33094, 63938, 59327, 32001, 93193, 59904, 15423, 75007, 81977, 42030, 63284, 21148,
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

    public boolean check(int acc_no, int password) {
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

    public User findUser(int acc_no, int password) {
        for(int i=0; i<60; ++i){
            User u = users.get(i);
            if(u.getId() == acc_no && u.getPassword() == password){
                return u;
            }
        }
        return null;
    }


    public void withdrawal(int acc_no, int password) {
        System.out.println("Select Amount");
        System.out.println("1)500");
        System.out.println("2)1000");
        System.out.println("3)1500");
        System.out.println("4)2000");
        System.out.println("5)4000");
        System.out.println("6)Other");
        System.out.print("Enter your option: ");

        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
    }
}
