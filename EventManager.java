import java.io.*;
import java.net.*;
import java.util.*;

public class EventManager

{
    ServerSocket ss;
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;
    public static HashMap<InetAddress,Integer> hmp= new HashMap<>();
    public static HashMap<InetAddress,ArrayList<Integer>> subscription_mapping=new HashMap<>();
    public static ArrayList<InetAddress> IpAddress=new ArrayList<>();
    //public static ArrayList<Integer> Article
    public static String[] topics=new String[10000];
    public static int last_topics_index=0;

    public EventManager()
    {

    }

    public static void main (String as[])
    {
        EventManager mys1=new EventManager();
        new Thread(new EventManager_Subscribe()).start();
        new Thread(new EventManager_Publish()).start();
        new Thread(new EventManager_Notify()).start();
        new Thread(new EventManager_Unsubscribe()).start();
        new Thread(new EventManager_Advertise()).start();
        //new Thread(new EventManager_choice_listener());
       // EventManager_choice_listener eventManagerChoiceListener=new EventManager_choice_listener();
        mys1.start_running();
        //eventManagerChoiceListener.start_running();
        //topics[last_topics_index]="Planet Earth";

    }


    public void start_running()
    {
        //int max=7998, min=5000;
        int counter=0;
        try
        {
            counter++;
            //eventManager_choice_listener.object_passing(mys);
            System.out.println("Event Manager Started");
            while(true) {

                System.out.println("Server listening on port number 8000");
                ss = new ServerSocket(8000);
                s = ss.accept();
//                Random rand=new Random();
//                do {
//                    port_clientPC = rand.nextInt((max - min) + 1) + min;
//                }while(hmp.containsValue(port_clientPC));
                IpAddress.add(s.getInetAddress());
                hmp.put(s.getInetAddress(), counter);
                System.out.println(s);
                System.out.println("CLIENT CONNECTED");
                System.out.println(IpAddress);
//                System.out.println(hmp.get(s.getInetAddress()));
//                dis= new DataInputStream(s.getInputStream());
//                dos= new DataOutputStream(s.getOutputStream());
//                dos.writeUTF(Integer.toString(port_clientPC));
//                ServerChat();
                ss.close();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }


//    @Override
//    public void run() {
//
//    }
}
