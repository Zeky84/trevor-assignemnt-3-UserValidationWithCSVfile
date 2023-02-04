import java.io.IOException;

public class UserApplication {

    public static void main(String[] args) throws IOException {

        User alreadyUser = new User(); //instance to store the info from my file
        int loginAttemptsOpportunities = 5;

        UserServices.userLoginCheck(loginAttemptsOpportunities,alreadyUser);
    }
}