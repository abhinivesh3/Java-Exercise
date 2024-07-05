/*Write a server/client in java. Refer here . Run the server and client in different machines. Stop the server application and try to connect it from the client. Shut down the server machine and try to connect it from the client. Check what are the errors thrown. */

package ServerAndClient;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
    private Socket socket = null;
    private ServerSocket serverSocket =null;
    private DataInputStream dataInputStream= null;

    public Server(int port){
        try{
            serverSocket=new ServerSocket(port);
            System.out.println("Server started");

			System.out.println("Waiting for a client ...");

            socket=serverSocket.accept();
            System.out.println("Client accepted");
            
            dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        }
        catch (UnknownHostException e) {
			System.out.println(e);
		}
		catch (IOException e) {
			System.out.println(e);
		}
        String line="";
        while(!line.equals("Over")){
            try{
                line=dataInputStream.readUTF();
                System.out.println(line);
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
        try {
			dataInputStream.close();
			socket.close();
		}
		catch (IOException e) {
			System.out.println(e);
		}
    }
    public static void main(String args[]){
		Server server = new Server(5000);
	}
    
}