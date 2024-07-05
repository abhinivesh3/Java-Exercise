package ServerAndClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket = null;
    private DataInputStream dataInputStream= null;
    private DataOutputStream dataOutputStream=null;

    public Client(String address, int port){
        try{
            socket=new Socket(address,port);
            System.out.println("Connected");

            dataInputStream=new DataInputStream(System.in);
            dataOutputStream=new DataOutputStream(socket.getOutputStream());
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
                line=dataInputStream.readLine();
                dataOutputStream.writeUTF(line);;
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
        try {
			dataInputStream.close();
			dataOutputStream.close();
			socket.close();
		}
		catch (IOException e) {
			System.out.println(e);
		}
    }

    public static void main(String[] args) {
        Client client= new Client("127.0.0.1",5000);
    }
    
}