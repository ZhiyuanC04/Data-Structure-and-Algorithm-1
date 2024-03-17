// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// HomeWork: HW8-Recursion
import java.util.Random;
public class Password {
    private String oldPassword;
    private String newPassword;

    public Password() {
        // Set two variables to "".
        oldPassword = "";
        newPassword = "";
    }

    public Password(String password) {
        // If the password is valid, put it in.
        if(ValidPass(password)){
            oldPassword = password;
        }
        else{
            oldPassword = "";
        }
        newPassword = "";
    }

    public boolean ValidPass(String password){
        // Check if the password is valid. It should not be empty and contains one Digit.
        if(password == null || password.isEmpty()) {
            return false;
        }
        if(!(Check_Digit(password))){
            return false;
        }
        return true;
    }

    public String toString() {
        // Return a String with first char and last char and random number of asterisks between.
        int asterisksNum = new Random().nextInt(20) + 1;
        String asterisks = "*".repeat(asterisksNum);
        return oldPassword.charAt(0) + asterisks + oldPassword.charAt(oldPassword.length() - 1);
    }

    public boolean equals(Object obj) {
        // Determine if two instances of the Password class are equal. Two Password instances are
        // Equal if the current passwords are the same.
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Password)) {
            return false;
        }
        Password other = (Password) obj;
        return this.oldPassword.equals(other.getPassword());
    }

    public String getPassword(){
        return oldPassword;
    }

    private boolean Check_Digit(String Password){
        //  Private recursive method to check if the password contains at least one character that is a digit (0 to 9).
        //  The method should return a boolean.
        if(Password.length() == 0){
            return false;
        }
        else if (Character.isDigit(Password.charAt(0))) {
            return true;
        }
        else{
            // Subtracting the first char in the string.
            return Check_Digit(Password.substring(1));
        }
    }

    private boolean is_Equal(String oldPassword, String newPassword) {
        // Private recursive method that checks if a new password is equal to the old password.
        if (newPassword.length() != oldPassword.length()) {
            return false;
        }
        else if (newPassword.length() == 0) {
            return false;
        }
        else if (newPassword.charAt(0) != oldPassword.charAt(0)) {
            return false;
        }
        else {
            return is_Equal(oldPassword.substring(1), newPassword.substring(1));
        }
    }

    private int count_Different_Chars(String oldPassword, String newPassword) {
        // Private recursive method that returns the number of places where the two passwords have different
        if (oldPassword.length() == 0) {
            return newPassword.length();
        }
        else if (newPassword.length() == 0) {
            return oldPassword.length();
        }
        else if (oldPassword.charAt(0) == newPassword.charAt(0)) {
            return count_Different_Chars(oldPassword.substring(1), newPassword.substring(1));
        }
        else {
            return 1 + count_Different_Chars(oldPassword.substring(1), newPassword.substring(1));
        }
    }

    private boolean sufficient_diff(int requirement){
        // Private non-recursive method returning whether the two passwords are sufficiently different.
        // The method takes an int parameter indicating the minimum number of differences that qualify
        // the passwords as being sufficiently different.
        if(count_Different_Chars(this.oldPassword, this.newPassword) >= requirement){
            return true;
        }
        return false;
    }

    public boolean setPassword(String Setnew) {
        // Allow the user to change the password. The new password must contain a digit, cannot
        // be equal to the old password, and must be different in at least half of the positions
        // of the old password.
        // The method returns a boolean to indicate if the password was changed successfully.
        newPassword = Setnew;
        if (!Check_Digit(newPassword) || is_Equal(oldPassword, newPassword)) {
            newPassword = "";
            return false;
        }
        if(sufficient_diff(oldPassword.length()/2)){
            oldPassword = newPassword;
            newPassword = ""; //**
            return true;
        }
        return false;
    }
}