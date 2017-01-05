package ChatServerPac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ChatServer {

    static Console console = new Console();

    ServerSocket sSocket;
    Socket socket;

    PrintWriter out;
    BufferedReader in;

    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<UserName> names = new ArrayList<UserName>();

    String name;
    String name2;
    UserName uN;
    public ChatServer(){


        try {
            sSocket = new ServerSocket(25567);



            new Thread(new Runnable() {

                @Override
                public void run() {

                    while(true){

                        try {
                            socket = sSocket.accept();

                            out = new PrintWriter(socket.getOutputStream(),true);
                            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            users.add(new User(out,in));
                            out.println("Welcome to server");
                            System.out.print(111);

                            //---------------------------------------------------------------------//

                            new Thread(new Runnable(){

                                @Override
                                public void run() {

                                    BufferedReader i = in;
                                    PrintWriter o = out;

                                    o.println("Welcome to my server");

                                    try {

                                        name = in.readLine(); //user name
                                        uN = new UserName(name);
                                        name2 = uN.userName;


                                        while(true){


                                            // try {
                                            String text = i.readLine();

                                            broadcast(text);
                                            //} catch (IOException ex){ex.printStackTrace();}



                                        }

                                    }catch (Exception ex){ex.printStackTrace();}







                                }

                            }).start();





                        } catch (IOException ex) {ex.printStackTrace();}

                    }



                }
            }).start();




        } catch (Exception ex) { ex.printStackTrace(); }


    }

    public static void main(String[] args){
        new ChatServer();
        console.wtiteToConsole("Server started!");
    }


    public  void broadcast(String text){
        for(int i = 0 ; i < users.size() ; i++){


            User user = users.get(i);
            if(user == null || user.out == null){
                users.remove(i);
            }else { user.out.println(text);}


        }
    }



}
