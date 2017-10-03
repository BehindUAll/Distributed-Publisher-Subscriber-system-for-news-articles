import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pethe on 06-02-2017.
 */
public class EventManager_Publish extends EventManager implements Runnable {
    @Override
    public void run() {
        ServerSocket ss1;
        DataOutputStream dos1;
        DataInputStream din1;
        Socket s1;



        try
        {
            String store_topic;

            //eventManager_choice_listener.object_passing(mys);
            //System.out.println("Event Manager (Publish) Started");
            while(true) {

                System.out.println("Server listening on port number 8001");
                ss1 = new ServerSocket(8001);
                s1 = ss1.accept();
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

                din1=new DataInputStream(s1.getInputStream());
                store_topic=new String();
                store_topic=din1.readUTF();
                last_topics_index++;
                topics[last_topics_index]=store_topic;
                ss1.close();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }




    }
}
