import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserServices {

    public static ArrayList loadFile() throws IOException {
        /*
          Returns the file load as Array List
        */

        ArrayList allUsersInfo = new ArrayList();
        BufferedReader fileReader = null;
        try{
            fileReader = new BufferedReader(new FileReader("data.txt"));
            String line ="";
            while ((line =fileReader.readLine()) != null) {allUsersInfo.add(line);}
            }
        finally {fileReader.close();}
        return allUsersInfo;
    }

    public static String getUserInfo(String userAttribute){
        /*
          Returns the user input.
         */

        Scanner theInput = new Scanner(System.in);
        System.out.println("Enter your " + userAttribute + ":");
        return theInput.nextLine();
    }

    public static void userLoggingCheck(int loggingOpportunities,User alreadyUser) throws IOException {
        /*
          Check if a user belong to an already users list
         */

        Object[] allUsersAttributesObject = (loadFile()).toArray();//loading file as ArrayList

        while (loggingOpportunities>0){
            //Getting the user input
            String userName = UserServices.getUserInfo("email");
            String userPassword = UserServices.getUserInfo("password");

            for (int x = 0; x < allUsersAttributesObject.length; x++) {
                String[] singleUserAttributes = (allUsersAttributesObject[x]).toString().split(",");//users info to user info
                alreadyUser.setUserName(singleUserAttributes[0]);
                alreadyUser.setPassWord(singleUserAttributes[1]);
                alreadyUser.setName(singleUserAttributes[2]);

                if (userName.equalsIgnoreCase(alreadyUser.getUserName()) & userPassword.equals(alreadyUser.getPassWord())) {
                    System.out.println("Welcome: " + alreadyUser.getName());
                    loggingOpportunities=0;
                    break;
                }
            }

            if(loggingOpportunities>1){
                loggingOpportunities--;
                System.out.println("Invalid login, please try again");
            }

            else if (loggingOpportunities==1){
                loggingOpportunities--;
                System.out.print("Too many failed login attempts, you are now locked out.");
            }
        }
    }
}
