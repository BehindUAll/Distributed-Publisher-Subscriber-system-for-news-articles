import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by pethe on 3/7/2017.
 */





public class EventManager_Advertise_Thread_Generator extends EventManager_Advertise implements Runnable{
    InetAddress inet;
    String topic_to_advertise;
    Socket sAdvertise;
    EventManager_Advertise_Thread_Generator(InetAddress i, String topic)
    {
        inet=i;
        topic_to_advertise=topic;

    }


    @Override
    public void run() {
        try {
            sAdvertise = new Socket(inet, 8002);
            dos = new DataOutputStream(sAdvertise.getOutputStream());
            dos.writeUTF(topic_to_advertise);
            sAdvertise.close();

        }
        catch(Exception e)
        {

        }



    }
}
