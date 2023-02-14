import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    private List<String> loadFile() throws IOException {
        /*
          Returns the file load as Arraylist
        */
        List<String> allUsersInfo = new ArrayList<>();
        BufferedReader fileReader = null;
        try{
            fileReader = new BufferedReader(new FileReader("data.txt"));
            String line ="";

            while ((line =fileReader.readLine()) != null) {
                allUsersInfo.add(line);
            }
            }
        finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
        return allUsersInfo;
    }

    public static String getUserInfo(String userAttribute){
        /*
          Returns the user input.
         */
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter your " + userAttribute + ":");
        return userInput.next();
    }

    public void userLoginCheck(int loginAttemptsOpportunities) throws IOException {
        /*
          Check if a user belong to an already users list
         */

        while (loginAttemptsOpportunities>0){
            //Getting the user input
            String userName = getUserInfo("email");
            String userPassword = getUserInfo("password");

            for (String singleUserInfo: loadFile()) {//users info to user info
                String[] UserAttributes = singleUserInfo.split(",");//user info splitting to user attributes
                User user = new User(UserAttributes[0],UserAttributes[1],UserAttributes[2]);

                if (userName.equalsIgnoreCase(user.getUserName()) && userPassword.equals(user.getPassWord())) {
                    System.out.println("Welcome: " + user.getName());
                    loginAttemptsOpportunities=0;
                    break;
                }
            }
            if(loginAttemptsOpportunities>1){
                loginAttemptsOpportunities--;
                System.out.println("Invalid login, please try again");
            }
            else if (loginAttemptsOpportunities==1){
                loginAttemptsOpportunities--;
                System.out.println("Too many failed login attempts, you are now locked out.");
            }
        }
    }
}
