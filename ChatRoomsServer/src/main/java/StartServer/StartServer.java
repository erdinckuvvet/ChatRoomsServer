package StartServer;

import Server.Server;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartServer {
    
    public static void main(String[] args) {
       Server server = new Server(5000);
       server.ListenClientConnectionRequests();
       
        while (!server.socket.isClosed()) {

            try {
                System.out.println("Client Counter: "+Server.clients.size());
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
