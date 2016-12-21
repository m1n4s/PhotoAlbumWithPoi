package buttonsInterface;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import src.methods.Album;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlbumManagerI {
	private JFrame frame;
	private ArrayList<Album> allAlbums;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlbumManagerI window = new AlbumManagerI();
					window.initialize(window);
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
	public AlbumManagerI() {
		allAlbums = new ArrayList<Album>();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(AlbumManagerI albM) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btnAlbummanager = new JButton("AlbumManager");
		btnAlbummanager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Albums alb = new Albums(albM);
				frame.setVisible(false);
				frame.dispose();
				alb.newScreen(albM);
			}
		});
		frame.getContentPane().add(btnAlbummanager, BorderLayout.CENTER);
	}

	public ArrayList<Album> getAlbumList(){
		return allAlbums;
	}
	
	public JFrame getFrame(){
		return this.frame;
	}
		
}
