import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.HashMap;

/**
 * Created by pethe on 04-02-2017.
 */




public class EventManager_choice_listener extends EventManager implements Runnable{
    //HashMap<InetAddress,Integer> hmp= new HashMap<>();
   // HashMap<Integer,InetAddress> subscription_mapping=new HashMap<>();
//
//    public void object_passing(EventManager manager)
//    {
//        hmp=manager.hmp;
//        subscription_mapping=manager.subscription_mapping;
//
//    }

    public void run() {
        try
        {

            //eventManager_choice_listener.object_passing(mys);
            System.out.println("Event Manager Choice listener Started");
            while(true) {

                System.out.println("Server listening on port number 8001");
                ss = new ServerSocket(8001);
                s = ss.accept();
//                Random rand=new Random();
//                do {
//                    port_clientPC = rand.nextInt((max - min) + 1) + min;
//                }while(hmp.containsValue(port_clientPC));
                //IpAddress.add(s.getInetAddress());
                //hmp.put(s.getInetAddress(), counter);
               // System.out.println(s);
              //  System.out.println("CLIENT CONNECTED");
              //  System.out.println(IpAddress);
//                System.out.println(hmp.get(s.getInetAddress()));
                  dis= new DataInputStream(s.getInputStream());
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



//    public static void main(String args[])
//    {
//
//    }



}
