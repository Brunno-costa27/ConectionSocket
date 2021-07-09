import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MeuCliente {

	public static void main(String[] args) {
		try {
			System.out.println("iniciando o cliente...");
			Socket iniciador = new Socket("127.0.0.1",12345);
			System.out.println("Conexao estabelecida!");
			Scanner teclado = new Scanner(System.in);
			PrintStream saidaSocketCliente = new PrintStream(iniciador.getOutputStream());
			while(teclado.hasNextLine()){
				System.out.println("Digite a msg a enviar:");
				saidaSocketCliente.println(teclado.nextLine());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
