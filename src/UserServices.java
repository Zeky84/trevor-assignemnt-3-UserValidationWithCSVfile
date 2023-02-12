import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserServices {

    public static ArrayList<String> loadFile() throws IOException {
        /*
          Returns the file load as Arraylist
        */
        ArrayList<String> allUsersInfo = new ArrayList<>();
        BufferedReader fileReader = null;
        try{//NOTE.PLEASE EXPLAIN: Intellij IDEA suggest: 'try' can use automatic resource management. IDEA gives solution but i want to understand pretty clear before taking any action
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
        return userInput.next();//NOTE: Intellij IDEA didn't show me any warning about userInput.close(), eclipse IDEA does. want to know how to fix it. Explain please
    }

    public static void userLoginCheck(int loginAttemptsOpportunities,User alreadyUser) throws IOException {
        /*
          Check if a user belong to an already users list
         */


        while (loginAttemptsOpportunities>0){
            //Getting the user input
            String userName = getUserInfo("email");
            String userPassword = getUserInfo("password");

            for (String singleUserInfo: loadFile()) {//users info to user info
                String[] singleUserAttributes = singleUserInfo.split(",");//user info splitting to user attributes
                alreadyUser.setUserName(singleUserAttributes[0]);
                alreadyUser.setPassWord(singleUserAttributes[1]);
                alreadyUser.setName(singleUserAttributes[2]);

                if (userName.equalsIgnoreCase(alreadyUser.getUserName()) && userPassword.equals(alreadyUser.getPassWord())) {
                    System.out.println("Welcome: " + alreadyUser.getName());
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
