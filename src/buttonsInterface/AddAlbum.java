package buttonsInterface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import src.methods.BasicAlbum;

public class AddAlbum {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public void newScreen(AlbumManagerI alb) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAlbum window = new AddAlbum(alb);
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
	public AddAlbum(AlbumManagerI albM) {
		initialize(albM);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(AlbumManagerI albM) {
			frame = new JFrame();
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			int pagesN=0;
			String albumN = (String)JOptionPane.showInputDialog("Dwste to onoma tou album pou thelete na ftiaksete. : ");
			try {
				pagesN = Integer.parseInt(JOptionPane.showInputDialog("Dwste tis selides pou thelete na exei to album : "));
			} catch (NumberFormatException e) {
		  //   initialize(albM);
				return;		//IN CASE WE HAVE A BAD INPUT, THE ALBUM WON'T BE ADDED TO THE LIST.
			}
			if(pagesN < 0 ){
				initialize(albM);  //IN CASE OF NEGATIVE NUMBER, WE RECALL THE METHOD.
			}
			BasicAlbum albB = new BasicAlbum(albumN,pagesN);
			albM.getAlbumList().add(albB);
		}
}
