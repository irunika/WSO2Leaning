package wso2.codeWithJson;

import org.json.simple.JSONObject;

import javax.xml.transform.Source;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.PrivilegedExceptionAction;
import java.util.Observable;
import java.util.Scanner;

/**
 * Created by irunika on 11/10/15.
 */
public class Client{

    static  JSONObject object = new JSONObject();


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        if(!scanner.hasNextInt()){
            System.err.println("Enter valid input (Integer) !");
            System.exit(1);
        }

        Integer req = scanner.nextInt();

        try {
            InetAddress address = InetAddress.getByName("localhost");

            Socket s = new Socket(address, Server.port);

            PrintStream out = new PrintStream(s.getOutputStream());
            out.println(req);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            Object j = in.readObject();

            if(j == null){
                System.out.println("No any person with index " + req);
            }else{
                JSONObject json = (JSONObject)j;
                System.out.println(json.toJSONString());
            }
            s.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
