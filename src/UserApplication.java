import java.io.IOException;

public class UserApplication {

    public static void main(String[] args) throws IOException {

        UserService loggingCheck = new UserService();
        int loginAttemptsOpportunities = 5;

        //User check-in login method
        loggingCheck.userLoginCheck(loginAttemptsOpportunities);
    }
}