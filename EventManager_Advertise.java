import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pethe on 3/7/2017.
 */
public class EventManager_Advertise extends EventManager implements Runnable {
    @Override
    public void run() {

        ServerSocket ss5;
        DataOutputStream dos5;
        DataInputStream din5;
        Socket s5;
        String topic_to_advertise;




        try
        {

            //eventManager_choice_listener.object_passing(mys);
            System.out.println("Event Manager (Advertise) Started");
            while(true) {

                System.out.println("Server listening on port number 8005");
                ss5 = new ServerSocket(8005);
                s5 = ss5.accept();
                din5=new DataInputStream(s5.getInputStream());
                topic_to_advertise=din5.readUTF();
                last_topics_index++;
                topics[last_topics_index]=topic_to_advertise;
                ss5.close();
                for (int i=0;i<IpAddress.size();i++)
                {
                    new Thread(new EventManager_Advertise_Thread_Generator(IpAddress.get(i), topic_to_advertise)).start();
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }
}
