package buttonsInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import src.methods.Album;
import java.awt.BorderLayout;
import java.awt.Color;

public class AlbumList {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	public void newScreen(AlbumManagerI allAlbums) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlbumList window = new AlbumList(allAlbums);
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
	public AlbumList(AlbumManagerI alb) {
		initialize(alb);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(AlbumManagerI alb) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Albums");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBackground(new Color(135, 206, 250));
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		
		String k = new String("<html>");
		for(Album i:alb.getAlbumList()){
			k += i.getName() + "<br>";
		}
		k += "</html>";
		lblNewLabel.setVerticalAlignment(JLabel.TOP);
		lblNewLabel.setOpaque(true);
		
		lblNewLabel.setText(k);
	}

}
