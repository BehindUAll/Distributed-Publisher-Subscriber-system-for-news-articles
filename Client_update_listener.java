import java.io.DataInputStream;
import java.net.*;

/**
 * Created by pethe on 04-02-2017.
 */

public class Client_update_listener extends ClientPC implements Runnable {
    DataInputStream dis;
    Socket sUpdate;


    public void start_listening() {
        try {
            while (true) {

                ServerSocket socketClient = new ServerSocket(8001);
                sUpdate = socketClient.accept();
                dis = new DataInputStream(sUpdate.getInputStream());
                System.out.println("This article has been updated:\n" + dis.readUTF());
                socketClient.close();

            }
        } catch (Exception e) {
            
        }
    }


    public void run() {
        start_listening();
    }
}

//    public static void main(String args[])
//    {
//
//    }

