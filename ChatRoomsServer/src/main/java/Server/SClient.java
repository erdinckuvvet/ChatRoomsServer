package Server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


//This class represents the client in server-side. If this class not exists , client just seems a socket in server-side. But the clients
// are more than a socket. So this object contains all information about a client and represents the clients in server-side.
public class SClient {

    public Socket socket;
    public ObjectInputStream cInput;
    public ObjectOutputStream cOutput;
    public ClientListenThread clientListenThread;
    public String userName;

    public SClient(Socket socket) {

        try {
            this.socket = socket;
            this.cOutput = new ObjectOutputStream(this.socket.getOutputStream());
            this.cInput = new ObjectInputStream(this.socket.getInputStream());
            this.clientListenThread = new ClientListenThread(this);

        } catch (IOException ex) {
            Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Send(Object msg)
    {
        try {
            this.cOutput.writeObject(msg);
        } catch (IOException ex) {
            Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Listen() {
        this.clientListenThread.start();
    }
}
