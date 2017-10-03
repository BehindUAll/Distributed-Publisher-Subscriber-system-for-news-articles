import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pethe on 3/7/2017.
 */
public class EventManager_Unsubscribe extends EventManager implements Runnable {
    @Override
    public void run() {

        ServerSocket ss3;
        DataOutputStream dos3;
        DataInputStream din3;
        Socket s3;
        String articles;
        String input;


        try {

            //eventManager_choice_listener.object_passing(mys);
            System.out.println("Event Manager (Unsubscribe) Started");
            while (true) {

                System.out.println("Server listening on port number 8003");
                ss3 = new ServerSocket(8003);
                s3 = ss3.accept();
//                Random rand=new Random();
//                do {
//                    port_clientPC = rand.nextInt((max - min) + 1) + min;
//                }while(hmp.containsValue(port_clientPC));
//                IpAddress.add(s.getInetAddress());
//                hmp.put(s.getInetAddress());
//                System.out.println(s);
//                System.out.println("CLIENT CONNECTED");
//                System.out.println(IpAddress);
//                System.out.println(hmp.get(s.getInetAddress()));
//                dis= new DataInputStream(s.getInputStream());
//                dos= new DataOutputStream(s.getOutputStream());
//                dos.writeUTF(Integer.toString(port_clientPC));
//                ServerChat();
                articles = "The list of articles is:\n";
                for (int i = 0; i <= last_topics_index; i++) {
                    articles = articles + Integer.toString(i + 1) + ". " + topics[i] + "\n";
                }
                dos3 = new DataOutputStream(s3.getOutputStream());
                dos3.writeUTF(articles);
                din3 = new DataInputStream(s3.getInputStream());
                input = din3.readUTF();
                try {
                    int index = subscription_mapping.get(s3.getInetAddress()).indexOf(Integer.parseInt(input));
                    subscription_mapping.get(s3.getInetAddress()).remove(index);
                } catch (ArrayIndexOutOfBoundsException e1) {

                }

                ss3.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
