

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


public class ServerHello implements Runnable {
	private Socket socket;

	public ServerHello(Socket accept) {
		// TODO Auto-generated constructor stub
		this.socket = accept;
	}

	//public dealerCurr dealer = new dealerCurr();
	PrintWriter out;
	OutputStream outputStream;
	BufferedReader in;
	Boolean connect = false;
	
	//player values
	Boolean status = false;
	String username = "";
	String password = "";
	int chips = 500;
	
	
	
	
	public void run() {
		System.out.println("Started from the bottom now we're here");
		try {
			// Connect Player to server
			out = new PrintWriter(socket.getOutputStream(), true);
			outputStream = socket.getOutputStream();
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeConnect() throws IOException {
		outputStream.close();
		out.close();
		in.close();
		socket.close();
	}

	public String getString() throws NumberFormatException, IOException {
		String buffer = new String();
		String ex = null;
		int val =0;
		while((val = in.read()) != '\n'){
			char hold = (char) val;
			buffer += hold;
		}
			ex = new String(buffer);
			
		
		System.out.printf("Inside getString function\n");
		return ex;
	}

	public void sendString(String ex) {
		out.println(ex);
	}
	
	public Boolean joinGame() throws NumberFormatException, IOException{
			String clientResponse =this.getString();
			if(clientResponse.compareTo("True") == 0 ){
				return true;
			}else return false;
			
	
		
	}
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/testpoker", "root", "");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return con;
	}

}