
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {

   public static String login;
   public static String password;

    public Login() throws IOException {

        BufferedReader read = new BufferedReader(new FileReader("G:\\games\\ForTest\\login.txt"));

            login = read.readLine();
            password = read.readLine();
           // System.out.println(line);

    }

//    public static void main(String[] args) throws IOException {
//
//
//        new Login();
//        System.out.println(login + "  " + password);
//
//    }
}
