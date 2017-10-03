import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;

/**
 * Created by pethe on 06-02-2017.
 */
public class EventManager_Notify  extends EventManager implements Runnable {
    @Override
    public void run() {

            ServerSocket ss4;
            DataOutputStream dos4;
            DataInputStream din4;
            Socket s4;
            String oldTopic;
            String updatedTopic;
            String articles;



            try
            {

                //eventManager_choice_listener.object_passing(mys);
                System.out.println("Event Manager (Notify) Started");
                while(true) {

                    System.out.println("Server listening on port number 8004");
                    ss4 = new ServerSocket(8004);
                    s4 = ss4.accept();
                    din4=new DataInputStream(s4.getInputStream());
                    dos4=new DataOutputStream(s4.getOutputStream());
                    articles="The list of articles is:\n";
                    for (int i=0;i<=last_topics_index;i++)
                    {
                        articles=articles+Integer.toString(i+1)+". "+topics[i]+"\n";
                    }
                    dos4.writeUTF(articles);
                    oldTopic=din4.readUTF();
                    //dos4.writeUTF("The topic index that you entered is:"+oldTopic);
                    updatedTopic=din4.readUTF();
                    topics[Integer.parseInt(oldTopic)-1]=updatedTopic;

                    // code below to create threads and send the update to the client listener on respective clients
		   
	           
                    //for (int i=0; i<IpAddress.size(); i++)
		    for (InetAddress key : subscription_mapping.keySet()) {
			try{
                        if(subscription_mapping.get(key).contains(Integer.parseInt(oldTopic)))
                        {
                            new Thread(new EventManager_Notify_Thread_Genreator(key,updatedTopic)).start();
                        }
}
catch(NullPointerException n1)
{
continue;
}
catch(Exception e2)
{
continue;
}
                    }








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
                    ss4.close();
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }


        }
}
