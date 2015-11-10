package wso2.codeWithJson;

import java.net.Socket;
import java.security.PrivilegedExceptionAction;

/**
 * Created by irunika on 11/10/15.
 */
public class Client implements  Runnable {

    private Socket socket;

    public Client(Socket s){
        this.socket = s;
    }

    @Override
    public void run() {

    }
}
