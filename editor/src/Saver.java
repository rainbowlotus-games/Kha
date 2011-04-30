import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Saver implements ActionListener {
	private JFrame parent;

	public Saver(JFrame parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		if (chooser.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION) {
			try {
				File file = chooser.getSelectedFile();
				String filename = file.getAbsolutePath();
				DataOutputStream stream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
				Level.getInstance().save(stream);
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}