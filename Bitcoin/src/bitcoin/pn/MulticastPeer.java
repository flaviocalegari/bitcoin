package bitcoin.pn;
import bitcoin.BitCoin;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class MulticastPeer {

    public BitCoin sessao;
    InetAddress group;
    MulticastSocket socket;
    PeerReceive p;
    
    public MulticastPeer(BitCoin sessao) {
        
        this.socket = null; // O mesmo socket para send e receive ...
        this.sessao = sessao;
        try {

            this.group = InetAddress.getByName("225.1.1.1");
            this.socket = new MulticastSocket(6789);
            this.socket.joinGroup(group);
            DatagramPacket messageOut;
            this.p = new PeerReceive(this.socket); // Iniciando thread do receive (socket como parâmetro) ...
                        
          
            Scanner scan = new Scanner(System.in);
            String message = "entrar";
            message = this.sessao.getNome()+  " entrou no sistema!";
            messageOut = new DatagramPacket(message.getBytes(), message.length(), this.group, 6789);
            this.socket.send(messageOut);
            
            while (!message.equals("sair")) { // Enquanto não digitar 'sair' fica no loop ...
                
                message = scan.nextLine();
                messageOut = new DatagramPacket(message.getBytes(), message.length(), this.group, 6789);
                
                socket.send(messageOut);
                            }
            
            this.socket.leaveGroup(this.group);
            
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
    
    public void teste(){
        
        System.out.println("Teste");
    }
    
     public void anunciaEntrada(){
         
       
        try {            
            DatagramPacket messageOut;                                
          
            //Scanner scan = new Scanner(System.in);
            String message = "entrar";
            //message = "Usuario " + this.sessao.getNome() + "entrou no sistema!";
            
            messageOut = new DatagramPacket(message.getBytes(), message.length(), this.group, 6789);
            System.out.println("Antes envio");
            this.socket.send(messageOut);    
            System.out.println("depois envio");
        } catch (SocketException e) {

            System.out.println("Socket: " + e.getMessage());

        }
        catch (IOException e) {

            System.out.println("IO: " + e.getMessage());

        }
         finally {
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
