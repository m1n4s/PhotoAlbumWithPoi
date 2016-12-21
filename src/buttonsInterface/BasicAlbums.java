package buttonsInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;


import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BasicAlbums {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void newScreen(AlbumManagerI albe) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasicAlbums window = new BasicAlbums(albe);
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
	public BasicAlbums(AlbumManagerI albM) {
		initialize(albM);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(AlbumManagerI albM) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_2 = new JButton("AddAlbum");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAlbum aa = new AddAlbum(albM);
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("AddPage");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPage ap = new AddPage(albM);
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Edit Page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditPage ep = new EditPage(albM);
			}
		});
		frame.getContentPane().add(btnNewButton);
	}

}
