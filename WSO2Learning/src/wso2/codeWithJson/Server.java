package wso2.codeWithJson;

import org.json.simple.JSONObject;
import sun.tools.jar.CommandLine;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by irunika on 11/10/15.
 */
public class Server {

    public final static int port =  22000;



    public static void main(String[] args){

        JsonObjects map = new JsonObjects();
        final int port = 22000;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Waiting for a client");

            while (true){
                Socket s = serverSocket.accept();  // Accept the cliet who is trying to connect
                System.out.println("Client is connected from " + s.getLocalAddress().getHostName() );

                Scanner scan = new Scanner(s.getInputStream());

                Integer request = scan.nextInt();

                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                out.writeObject(map.getDetails(request));
                System.out.println("Returned the details of " + request);

                out.flush();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
