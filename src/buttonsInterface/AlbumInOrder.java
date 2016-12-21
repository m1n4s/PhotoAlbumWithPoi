package buttonsInterface;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AlbumInOrder {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public void newScreen(AlbumManagerI albM) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlbumInOrder window = new AlbumInOrder(albM);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AlbumInOrder(AlbumManagerI albM) {
		initialize(albM);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(AlbumManagerI albM) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		String albName;
		String s = (String)JOptionPane.showInputDialog("Dwste to onoma tou album : \n");
		albName = s;
		if(s!=null && s.length()>0){
			File[] files = new File(System.getProperty("user.dir")).listFiles();
			for(File file : files){
				if(file.getName().equals(albName+".pptx")){
					try {
				        Desktop desktop = Desktop.getDesktop();
				        if (desktop.isSupported(Desktop.Action.OPEN)) {
				            desktop.open(new File(albName+".pptx"));
				        } else {
				           frame.setTitle("Error.");
				        }
				    } catch (IOException exp) {
				       frame.setTitle("Error.");
				    }
				}
			}
		}
		 
	}
}
