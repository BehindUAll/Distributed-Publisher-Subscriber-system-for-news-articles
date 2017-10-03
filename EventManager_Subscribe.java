import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by pethe on 06-02-2017.
 */
public class EventManager_Subscribe extends EventManager implements Runnable {


    @Override
    public void run() {

        ServerSocket ss2;
        DataOutputStream dos2;
        DataInputStream din2;
        Socket s2;
        String articles;
        String input;


        try {

            //eventManager_choice_listener.object_passing(mys);
            System.out.println("Event Manager (Subscribe) Started");
            while (true) {

                System.out.println("Server listening on port number 8002");
                ss2 = new ServerSocket(8002);
                s2 = ss2.accept();
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
                dos2 = new DataOutputStream(s2.getOutputStream());
                dos2.writeUTF(articles);
                din2 = new DataInputStream(s2.getInputStream());
                input = din2.readUTF();

//                    if(subscription_mapping.get(s2.getInetAddress())==null)
//                    {
//                        subscription_mapping.put(s2.getInetAddress(),new ArrayList<Integer>());
//
//                    }
                subscription_mapping.putIfAbsent(s2.getInetAddress(), new ArrayList<Integer>());

                if (last_topics_index >= Integer.parseInt(input)) {
                    if(!subscription_mapping.get(s2.getInetAddress()).contains(Integer.parseInt(input))) {
                        subscription_mapping.get(s2.getInetAddress()).add(Integer.parseInt(input));
                    }
                }
                ss2.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
