//code for client

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientPC {
    Socket s;
    DataInputStream din;
    DataOutputStream dout;
    public int port_number = 8001;

    public ClientPC() {

    }

    public void ClientChat() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String stotal, topic, genre, content;
        Scanner sc = new Scanner(System.in);
        Socket s;
        Socket s1;
        Socket s2;
        Socket s3;
        Socket s4;
        Socket s5;
        DataInputStream dis;
        DataOutputStream dos;
        String topics_list;
        int choice;
        String topic_to_change;
        String updated_topic;
        String article_to_subscribe;
        String article_to_unsubscribe;
        String display_list;


//            port_number=Integer.parseInt(din.readUTF());
//            s.close();
//            Client_update_listener clientUpdateListen=new Client_update_listener();
//            clientUpdateListen.value_passing(port_number);

        try {

            while (true) {


                // s = ss.accept();
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
//            dis = new DataInputStream(s.getInputStream());
//                dos= new DataOutputStream(s.getOutputStream());
//                dos.writeUTF(Integer.toString(port_clientPC));
//                ServerChat();


                System.out.println("\nEnter your choice:\n1. Publish\n2. Subscribe\n3. Un-subscribe\n4. Edit/Notify\n5. Advertise\n");
                choice = sc.nextInt();
//            if(choice==6)
//            {
//                System.exit(1);
//            }

                switch (choice) {
                    case 1:

                        //System.out.println("Server listening on port number 8001");
                        s1 = new Socket("129.21.37.41", 8001);
                        dos = new DataOutputStream(s1.getOutputStream());
                        System.out.println("Enter the Topic name you want to publish:");
                        topic = sc.next();
                        dos.writeUTF(topic);
//                dos.writeUTF(Integer.toString(port_clientPC));
//                        System.out.println("Enter the genre:");
//                        genre = sc.next();
//                        System.out.println("Enter the content: (input ... at the end when done)");
//                        do {
//                            s1 = sc.nextLine();
//                            stotal=stotal+"\n"+s1;
//                        }while (!s1.equals("END"));
//                        content=stotal;

                        s1.close();
                        break;


                    case 2:
                        s2 = new Socket("129.21.37.41", 8002);
                        dis = new DataInputStream(s2.getInputStream());
                        System.out.println(dis.readUTF());
                        dout = new DataOutputStream(s2.getOutputStream());
                        System.out.println("Which article do you want to subscribe to? Enter the index of the respective article:\n");
                        article_to_subscribe = sc.next();
                        dout.writeUTF(article_to_subscribe);


                        s2.close();
                        break;


                    case 3:
                        //System.out.println("Unsubscribed successfully!");
                        s3 = new Socket("129.21.37.41", 8003);
                        dis = new DataInputStream(s3.getInputStream());
                        System.out.println(dis.readUTF());
                        dout = new DataOutputStream(s3.getOutputStream());
                        System.out.println("Which article do you want to unsubscribe? Enter the index of the respective article:\n");
                        article_to_unsubscribe = sc.next();
                        dout.writeUTF(article_to_unsubscribe);
                        s3.close();
                        break;


                    case 4:
                        s4 = new Socket("129.21.37.41", 8004);
                        dos = new DataOutputStream(s4.getOutputStream());
                        din = new DataInputStream(s4.getInputStream());
                        System.out.println(din.readUTF());
                        System.out.println("Enter the topic index which you want to edit:");
                        topic_to_change = sc.next();
                        System.out.println("Enter the topic name that you want to replace with:");
                        updated_topic = sc.next();
                        dos.writeUTF(topic_to_change);
                        //din.readUTF();
                        dos.writeUTF(updated_topic);
                        s4.close();
                        break;

                    case 5:
                        System.out.println("Enter the Topic name:");
                        topic = sc.next();
                        s5 = new Socket("129.21.37.41", 8005);
                        dos=new DataOutputStream(s5.getOutputStream());
                        dos.writeUTF(topic);
                        s5.close();
                        break;


                    default:
                        break;


//                s.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }


    public static void main(String as[]) {
        ClientPC myc1 = new ClientPC();
        myc1.start_running();
        //new Thread (new Client_update_listener() );
    }

    public void start_running() {
        try {
            //s=new Socket("10.10.0.3,10");
            s = new Socket("129.21.37.41", 8000);
            System.out.println(s);
            new Thread(new Client_update_listener()).start();
            new Thread(new Client_advertise_listener()).start();
            //din = new DataInputStream(s.getInputStream());
            s.close();
            //dout = new DataOutputStream(s.getOutputStream());
            ClientChat();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
