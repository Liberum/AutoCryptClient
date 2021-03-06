import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public void StartClient() throws UnknownHostException, IOException {

	String host = "127.0.0.1";
	int port = 4567;

	String sentence;
	String modifiedSentence;

	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
		System.in));

	Socket clientSocket = new Socket(host, port);

	DataOutputStream outToServer = new DataOutputStream(
		clientSocket.getOutputStream());

	BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
		clientSocket.getInputStream()));

	sentence = inFromUser.readLine();
	outToServer.writeBytes(sentence + '\n');
	modifiedSentence = inFromServer.readLine();
	System.out.println("FROM SERVER: " + modifiedSentence);

	clientSocket.close();

    }
}
