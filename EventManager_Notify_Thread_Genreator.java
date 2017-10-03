import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by pethe on 3/7/2017.
 */

public class EventManager_Notify_Thread_Genreator extends EventManager_Notify implements Runnable {

    InetAddress inet;
    String topic;
    Socket sNotifyGen;
    EventManager_Notify_Thread_Genreator(InetAddress i, String topic1)
    {
        topic=topic1;
        inet=i;

    }


    @Override
    public void run()
    {
        try {
            sNotifyGen = new Socket(inet, 8001);
            dos = new DataOutputStream(sNotifyGen.getOutputStream());
            dos.writeUTF(topic);
            sNotifyGen.close();

        }
        catch(Exception e)
        {

        }



    }







}
