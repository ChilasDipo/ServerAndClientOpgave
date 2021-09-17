import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    PrintWriter toServer = null;
    Scanner fromServer = null;
    Scanner scanner = new Scanner(System.in);

    void client(){
        try{
        Socket socket = new Socket("localhost",9000);

        fromServer = new Scanner(socket.getInputStream());
        toServer = new PrintWriter(socket.getOutputStream(),true);
        System.out.println("Connection Done");
        new Thread(() -> {
            while(true){
                if (fromServer.hasNext()){
                    System.out.println(fromServer.nextLine());
                }
            }
        }).start();


        while (true){
            toServer.println(scanner.nextLine());
        }










        }catch(IOException e){
            System.err.println(e);
        }
    }






    public static void main(String[] args) {
        Client2 client = new Client2();
        client.client();
    }

}