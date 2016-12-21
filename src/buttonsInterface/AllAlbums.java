package buttonsInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AllAlbums {

	private JFrame AllAlbums;
	private AlbumList albums;
	/**
	 * Launch the application.
	 */
	public void newScreen(AlbumManagerI m) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllAlbums window = new AllAlbums(m);
					window.AllAlbums.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AllAlbums(AlbumManagerI albM) {
		initialize(albM);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(AlbumManagerI alb) {
		AllAlbums = new JFrame();
		AllAlbums.setBounds(100, 100, 450, 300);
		AllAlbums.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		AllAlbums.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		JButton ShowAlbumList = new JButton("ShowAlbumList");
		ShowAlbumList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				albums = new AlbumList(alb);
				albums.newScreen(alb);
				AllAlbums.setVisible(false);
			}
		});
		AllAlbums.getContentPane().add(ShowAlbumList);
		
		JButton ShowAlbumInOrder = new JButton("ShowAlbumInOrder");
		ShowAlbumInOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlbumInOrder albumIO = new AlbumInOrder(alb);
				AllAlbums.setVisible(false);
			}
		});
		AllAlbums.getContentPane().add(ShowAlbumInOrder);
		
		JButton ShowAlbumByDate = new JButton("ShowAlbumByDate");
		ShowAlbumByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlbumsChrono albumChr = new AlbumsChrono(alb);
				AllAlbums.setVisible(false);
			}
		});
		AllAlbums.getContentPane().add(ShowAlbumByDate);
	}

}
