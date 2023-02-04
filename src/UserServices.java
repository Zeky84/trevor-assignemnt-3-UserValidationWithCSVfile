import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserServices {

    public static ArrayList<String> loadFile() throws IOException {
        /*
          Returns the file load as Array List
        */

        ArrayList<String> allUsersInfo = new ArrayList<>();
        BufferedReader fileReader = null;
        try{//NOTE.PLEASE EXPLAIN: Intellij IDEA suggest: 'try' can use automatic resource management
            fileReader = new BufferedReader(new FileReader("data.txt"));
            String line ="";
            while ((line =fileReader.readLine()) != null) {allUsersInfo.add(line);}
            }
        finally {fileReader.close();} // NOTE.PLEASE EXPLAIN Intellij IDEA says: Method invocation 'close' may produce 'NullPointerException'
        return allUsersInfo;
    }//

    public static String getUserInfo(String userAttribute){
        /*
          Returns the user input.
         */

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter your " + userAttribute + ":");
        return userInput.next();
    }

    public static void userLoginCheck(int loginAttemptsOpportunities,User alreadyUser) throws IOException {
        /*
          Check if a user belong to an already users list
         */

        Object[] allUsersAttributesObject = (loadFile()).toArray();//loading file as ArrayList

        while (loginAttemptsOpportunities>0){
            //Getting the user input
            String userName = getUserInfo("email");
            String userPassword = getUserInfo("password");

            for (int x = 0; x < allUsersAttributesObject.length; x++) {//NOTE.PLEASE EXPLAIN: Intellij IDEA suggest: 'for' loop can be replaced with enhance with for
                String[] singleUserAttributes = (allUsersAttributesObject[x]).toString().split(",");//users info to user info
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
