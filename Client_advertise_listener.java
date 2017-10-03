import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pethe on 3/7/2017.
 */
public class Client_advertise_listener extends ClientPC implements Runnable {
    DataInputStream dis;
    Socket sClientAdvertise;


    public void start_listening() {
        try {
            while (true) {

                ServerSocket socketClient = new ServerSocket(8002);
                sClientAdvertise = socketClient.accept();
                dis = new DataInputStream(sClientAdvertise.getInputStream());
                System.out.println("This new article is being advertised to all the users in the system:\n" + dis.readUTF());
                socketClient.close();

            }
        } catch (Exception e) {
            
        }
    }


    public void run() {
        start_listening();
    }
}
