import java.util.*;

public class OnlineExamination {

    static Scanner sc = new Scanner(System.in);

    // Default user
    static String username = "admin";
    static String password = "1234";
    static String name = "Admin";

    static int score = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== ONLINE EXAM SYSTEM =====");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Select option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                login();
            } else {
                System.out.println("Thank you!");
                break;
            }
        }
    }

    static void login() {
        sc.nextLine();

        System.out.print("Username: ");
        String u = sc.nextLine();

        System.out.print("Password: ");
        String p = sc.nextLine();

        if (u.equals(username) && p.equals(password)) {
            System.out.println("Login Successful!\n");
            dashboard();
        } else {
            System.out.println("Invalid Login!");
        }
    }

    static void dashboard() {
        while (true) {
            System.out.println("\n===== DASHBOARD =====");
            System.out.println("1. Start Exam");
            System.out.println("2. Update Name");
            System.out.println("3. Change Password");
            System.out.println("4. Logout");
            System.out.print("Select option: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    startExam();
                    break;
                case 2:
                    updateName();
                    break;
                case 3:
                    changePassword();
                    break;
                case 4:
                    System.out.println("Logged Out Successfully!");
                    return;
            }
        }
    }

    static void updateName() {
        sc.nextLine();
        System.out.print("Enter new name: ");
        name = sc.nextLine();
        System.out.println("Name Updated Successfully!");
    }

    static void changePassword() {
        sc.nextLine();
        System.out.print("Enter old password: ");
        String old = sc.nextLine();

        if (old.equals(password)) {
            System.out.print("Enter new password: ");
            password = sc.nextLine();
            System.out.println("Password Changed Successfully!");
        } else {
            System.out.println("Wrong Old Password!");
        }
    }

    static void startExam() {

        score = 0;

        System.out.println("\nExam Started!");
        System.out.println("You have 20 seconds to finish.\n");

        long startTime = System.currentTimeMillis();
        long endTime = startTime + 20000; // 20 seconds

        // Question 1
        if (System.currentTimeMillis() < endTime) {
            System.out.println("1. Which language runs on JVM?");
            System.out.println("1. Python");
            System.out.println("2. Java");
            System.out.println("3. C++");
            System.out.print("Answer: ");
            int ans1 = sc.nextInt();
            if (ans1 == 2) score++;
        }

        // Question 2
        if (System.currentTimeMillis() < endTime) {
            System.out.println("\n2. Capital of France?");
            System.out.println("1. Berlin");
            System.out.println("2. Paris");
            System.out.println("3. Rome");
            System.out.print("Answer: ");
            int ans2 = sc.nextInt();
            if (ans2 == 2) score++;
        }

        // Question 3
        if (System.currentTimeMillis() < endTime) {
            System.out.println("\n3. OOP stands for?");
            System.out.println("1. Object Oriented Programming");
            System.out.println("2. Only One Process");
            System.out.println("3. Order Of Program");
            System.out.print("Answer: ");
            int ans3 = sc.nextInt();
            if (ans3 == 1) score++;
        }

        if (System.currentTimeMillis() >= endTime) {
            System.out.println("\nTime Over! Auto Submitting...");
        }

        System.out.println("\nExam Finished!");
        System.out.println("Your Score: " + score + "/3");
    }
}
