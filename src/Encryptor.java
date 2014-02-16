import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class Encryptor {

    public void cpt(List<String> path) throws UnknownHostException, IOException {

	String host = "127.0.0.1";
	int port = 4567;

	Socket clientSocket = new Socket(host, port);

	DataOutputStream outToServer = new DataOutputStream(
		clientSocket.getOutputStream());

	FileOutputStream fos = null;

	try {
	    String keyfile = "c:\\AutoCrypt\\key.key";
	    String algorithm = "DESede";

	    KeyGenerator kg = KeyGenerator.getInstance(algorithm);
	    SecretKey key = kg.generateKey();

	    Cipher cipher = Cipher.getInstance(algorithm);
	    cipher.init(Cipher.ENCRYPT_MODE, key);

	    ObjectOutputStream oos = new ObjectOutputStream(
		    new CipherOutputStream(outToServer, cipher));

	    oos.writeObject(path);
	    // System.out.println("go to server" + oos.toString());

	    fos = new FileOutputStream(keyfile);
	    SecretKeyFactory skf = SecretKeyFactory.getInstance(algorithm);
	    DESedeKeySpec keyspec = (DESedeKeySpec) skf.getKeySpec(key,
		    DESedeKeySpec.class);
	    fos.write(keyspec.getKey());
	    fos.close();
	    oos.close();
	    outToServer.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
