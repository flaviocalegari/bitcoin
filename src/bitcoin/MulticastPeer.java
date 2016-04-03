package bitcoin;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class MulticastPeer {

    public MulticastPeer() {
        
        MulticastSocket socket = null; // O mesmo socket para send e receive ...

        try {

            InetAddress group = InetAddress.getByName("225.1.1.1");
            socket = new MulticastSocket(6789);
            socket.joinGroup(group);
            DatagramPacket messageOut;
            PeerReceive p = new PeerReceive(socket); // Iniciando thread do receive (socket como parâmetro) ...
                        
          
            Scanner scan = new Scanner(System.in);
            String message = "entrar";
            
            while (!message.equals("sair")) { // Enquanto não digitar 'sair' fica no loop ...
                
                message = scan.nextLine();
                messageOut = new DatagramPacket(message.getBytes(), message.length(), group, 6789);
                socket.send(messageOut);
            }
            
            socket.leaveGroup(group);
            
        } catch (SocketException e) {

            System.out.println("Socket: " + e.getMessage());

        } catch (IOException e) {

            System.out.println("IO: " + e.getMessage());

        } finally {

            if (socket != null) {
                socket.close();
            }
        }
    }

}

class PeerReceive extends Thread {
    
    private final MulticastSocket s;
    
    public PeerReceive(MulticastSocket s) {
        
        this.s = s;
        this.start(); // Inicia thread ...
    }
    
    
    public void run() {
        
        try {
            
            
            while (true) { // Loop para ficar recebendo mensagens ...
                
                
                byte[] buffer = new byte[1000];
                DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
                String message;
            
                s.receive(messageIn);
                message = new String(messageIn.getData());
                System.out.println("Received:" + message);
            }
            
        } catch (IOException ex) {
            
            System.out.println("Um abraço");
        }
        
    }
}
