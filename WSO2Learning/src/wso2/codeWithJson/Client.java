package wso2.codeWithJson;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.PrivilegedExceptionAction;
import java.util.Scanner;

/**
 * Created by irunika on 11/10/15.
 */
public class Client{
    public static void main(String[] args){

        try {
            InetAddress address = InetAddress.getByName("localhost");

            Socket s = new Socket(address, Server.port);
            Scanner scan = new Scanner(s.getInputStream());

            PrintStream out = new PrintStream(s.getOutputStream());
            out.println("Hi Server");
            System.out.println(scan.nextLine());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
