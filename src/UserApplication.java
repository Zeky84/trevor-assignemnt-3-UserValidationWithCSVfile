import java.io.IOException;
import java.util.ArrayList;

public class UserApplication {

    public static void main(String[] args) throws IOException {

        User alreadyUser = new User(); //instance to store the info from my file
        int loggingOpportunities = 5;

        UserServices.userLoggingCheck(loggingOpportunities,alreadyUser);

//        while (true){
//            System.out.println(loginOpportunities);
//            if (loginOpportunities>=1) {
//                //Getting the user input
//                String userName = UserServices.getTheInfo("email");
//                String userPassword = UserServices.getTheInfo("password");
//
//                for (int x = 0; x < usersInfoObj.length; x++) {
//                    String[] userInfo = (usersInfoObj[x]).toString().split(",");//users info to user info
//                    alreadyUser.setUserName(userInfo[0]);
//                    alreadyUser.setPassWord(userInfo[1]);
//                    alreadyUser.setName(userInfo[2]);
//
//                    if (userName.equalsIgnoreCase(alreadyUser.getUserName()) & userPassword.equals(alreadyUser.getPassWord())) {
//                        System.out.println("Welcome: " + alreadyUser.getName());
//                        loginOpportunities=0;
//                        break;
//                    }
//            }
//                if (loginOpportunities == 0){
//                    break;
//                }
//                if(loginOpportunities>=1){
//                loginOpportunities--;
//                System.out.println("Invalid login, please try again");}
//        }
//            else{
//                System.out.print("Too many failed login attempts, you are now locked out.");
//            break;
//            }
//    }

}
}