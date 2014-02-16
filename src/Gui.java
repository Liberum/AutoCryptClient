import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Gui {

    public static void Ui() {

	final String dPach1 = "d:\\myCrypt";
	final String dPach2 = "d:\\myCrypt";
	final String dPach3 = "d:\\myCrypt";
	final String dPach4 = "d:\\myCrypt";
	final String dPach5 = "d:\\myCrypt";

	final String dsk1 = "o";
	final String dsk2 = "p";
	final String dsk3 = "r";
	final String dsk4 = "s";
	final String dsk5 = "t";

	JFrame jf = new JFrame("AutoCrypt");
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.setSize(400, 300);
	jf.setResizable(false);// изменение размеров
	jf.setLocation(300, 300);// имзменяем местоположение фрейма.
	jf.setVisible(true);

	// создаем панель.
	JPanel p = new JPanel();
	p.setBorder(BorderFactory.createTitledBorder("CbL"));
	jf.add(p);

	// к панели добавляем менеджер FlowLayout.
	p.setLayout(new FlowLayout());

	// создаем элементы
	JCheckBox cb1 = new JCheckBox("Диск \"О\"");
	JButton jb1 = new JButton("Смонтировать");
	JButton jbx1 = new JButton("X");
	final JPasswordField jp1 = new JPasswordField(15);

	JCheckBox cb2 = new JCheckBox("Диск \"P\"");
	JButton jb2 = new JButton("Смонтировать");
	JButton jbx2 = new JButton("X");
	final JPasswordField jp2 = new JPasswordField(15);

	JCheckBox cb3 = new JCheckBox("Диск \"R\"");
	JButton jb3 = new JButton("Смонтировать");
	JButton jbx3 = new JButton("X");
	final JPasswordField jp3 = new JPasswordField(15);

	JCheckBox cb4 = new JCheckBox("Диск \"S\"");
	JButton jb4 = new JButton("Смонтировать");
	JButton jbx4 = new JButton("X");
	final JPasswordField jp4 = new JPasswordField(15);

	JCheckBox cb5 = new JCheckBox("Диск \"T\"");
	JButton jb5 = new JButton("Смонтировать");
	JButton jbx5 = new JButton("X");
	final JPasswordField jp5 = new JPasswordField(15);

	// добавляем элементы к панели
	p.add(cb1);
	p.add(jb1);
	p.add(jp1);
	p.add(jbx1);
	p.add(cb2);
	p.add(jb2);
	p.add(jp2);
	p.add(jbx2);
	p.add(cb3);
	p.add(jb3);
	p.add(jp3);
	p.add(jbx3);
	p.add(cb4);
	p.add(jb4);
	p.add(jp4);
	p.add(jbx4);
	p.add(cb5);
	p.add(jb5);
	p.add(jp5);
	p.add(jbx5);
	jf.setSize(455, 230);

	// обработчики кнопок
	MountAdapter ma = new MountAdapter();

	// -- монтирование --
	ma.Mount(jb1, dPach1, dsk1, jp1);
	ma.Mount(jb2, dPach2, dsk2, jp2);
	ma.Mount(jb3, dPach3, dsk3, jp3);
	ma.Mount(jb4, dPach4, dsk4, jp4);
	ma.Mount(jb5, dPach5, dsk5, jp5);

	// -- размонтирование --
	ma.UnMount(jbx1, dsk1);
	ma.UnMount(jbx2, dsk2);
	ma.UnMount(jbx3, dsk3);
	ma.UnMount(jbx4, dsk4);
	ma.UnMount(jbx5, dsk5);

    }

}
