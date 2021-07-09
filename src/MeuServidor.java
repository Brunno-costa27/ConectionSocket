import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MeuServidor {

	public static void main(String[] args) {
		
		try {
			System.out.println("iniciando o servidor...");
			ServerSocket servidor = new ServerSocket(12345);
			System.out.println("O servidor passa a aguardar conexoes...");
			Socket o_cliente = servidor.accept();
			System.out.println("Cliente "+o_cliente.getInetAddress().getHostAddress()+" conectado!");
			//Thread.sleep(2000);
			
			Scanner leDoSocketCliente = new Scanner(o_cliente.getInputStream());
			while(leDoSocketCliente.hasNextLine()){
				System.out.println(leDoSocketCliente.nextLine());				
			}
			leDoSocketCliente.close();
			leDoSocketCliente = null;
			o_cliente.close();
			o_cliente = null;
			servidor.close();
			servidor = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
