package ChatServerPac;


import java.util.ArrayList;

public class UserName {

    public String userName;
    public static ArrayList listString = new ArrayList();

    public UserName(String text){
        userName = text;
        listString.add(userName);
    }



}
