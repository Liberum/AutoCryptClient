import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class MountAdapter {

    // TODO тут сделать зашифрованную отсылку пути на сервер
    // обработчик нажатия клавиш размонтирования
    public void UnMount(Object btn, final String dsk) {
	JButton myBtn = (JButton) btn;
	myBtn.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent event) {
		List<String> lstUnMount = Arrays.asList(dsk);
		Encryptor enc = new Encryptor();
		try {
		    enc.cpt(lstUnMount);
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	});
    }

    // обработчик нажатия клавиш монтирования
    public void Mount(Object btn, final String dPach, final String dsk,
	    final Object jp1) {
	JButton myBtn = (JButton) btn;
	final JPasswordField jp = (JPasswordField) jp1;
	myBtn.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent event) {
		List<String> lstUnMount = Arrays.asList(dsk, dPach,
			(new String(((JPasswordField) jp1).getPassword())));
		Encryptor enc = new Encryptor();
		try {
		    enc.cpt(lstUnMount);
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		jp.setText(null);

	    }
	});

    }

}
