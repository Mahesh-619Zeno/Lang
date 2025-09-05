import java.util.Scanner;

public class UserLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Security Issue: Hardcoded credentials
        String correctUsername = "admin";
        String correctPassword = "12345"; // Hardcoded password (bad practice)

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Logical Issue: Uses == for string comparison instead of .equals()
        if (username == correctUsername && password == correctPassword) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials.");
        }

        // Readability Issue: No proper method extraction, everything in main()
        // Also missing input validation, no exception handling
        scanner.close();
    }
}
