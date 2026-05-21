import java.util.Scanner;

class UserAccount {
    private String username;
    private String password;

    UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class SecurityValidator {

    public boolean isValid(UserAccount user) {

        String password = user.getPassword();

        boolean hasDigit = false;
        boolean hasUppercase = false;

        if (password.length() < 8) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isDigit(ch)) {
                hasDigit = true;
            }

            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }
        }

        if (hasDigit && hasUppercase) {
            return true;
        } else {
            return false;
        }
    }
}

public class PasswordValidatorProject {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        UserAccount user = new UserAccount(username, password);

        SecurityValidator validator = new SecurityValidator();

        boolean result = validator.isValid(user);

        System.out.println("\nUsername: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());

        if (result) {
            System.out.println("Password is VALID");
        } else {
            System.out.println("Password is INVALID");
        }

        sc.close();
    }
}