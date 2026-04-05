package BookMyTrain;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    Users currentUser=null;

    Map<String,Users> users=new HashMap<>();

    public boolean userRegistration(String username,String password , String fullname,String contact){
        if(users.containsKey(username)){
            System.out.println(" User Name Already Present ");
            return false;
        }
        Users user=new Users(username,password,fullname,contact);
        users.put(username,user);
        System.out.println("User Created Successfully");
        return true;
    }

    public boolean userLogin(String username,String password){
        if(users.containsKey(username)){
            Users user=users.get(username);
            if(user.getPassword().equals(password)){
                System.out.println("Login Successfully");
                currentUser=user;
                return true;
            }
        }
        System.out.println("Incorrect Username Or Password");
        return false;
    }

    public void userLogout(){
        if(currentUser!=null)
            System.out.println(currentUser.getFullName()+" Logged Out Successfully");
        currentUser=null;
    }

    public boolean isloggedIn(){
        return currentUser!=null;
    }

    public Users getCurrentUser() {
        return currentUser;
    }

}
