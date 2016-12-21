package buttonsInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class Albums {
	private JFrame ClassAlbums;
	/**
	 * Launch the application.
	 */
	public void newScreen(AlbumManagerI albM) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Albums window = new Albums(albM);
					window.ClassAlbums.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Albums(AlbumManagerI albM) {
		initialize(albM);	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(AlbumManagerI albM) {
		ClassAlbums = new JFrame();
		ClassAlbums.setTitle("Main Menu");
		ClassAlbums.setBounds(100, 100, 450, 300);
		ClassAlbums.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ClassAlbums.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	                // Ask for confirmation before terminating the program.
	                int option = JOptionPane.showConfirmDialog(
	                        ClassAlbums, 
	                        "Are you sure you want to close the application?",
	                        "Close Confirmation", 
	                        JOptionPane.YES_NO_OPTION, 
	                        JOptionPane.QUESTION_MESSAGE);
	                if (option == JOptionPane.YES_OPTION) {
	                        System.exit(0);
	                }
	        }
	});
		ClassAlbums.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		JButton Albums = new JButton("AllAlbums");
		Albums.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllAlbums albums = new AllAlbums(albM);
				albums.newScreen(albM);
			}
		});
		ClassAlbums.getContentPane().add(Albums);
		
		JButton btnNewButton = new JButton("BasicAlbums");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasicAlbums ba = new BasicAlbums(albM);
				ba.newScreen(albM);
			}
		});
		ClassAlbums.getContentPane().add(btnNewButton);
		
		JButton btnDerivativealbums = new JButton("DerivativeAlbums");
		btnDerivativealbums.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DerivativeAlbums da = new DerivativeAlbums(albM);
			}
		});
		ClassAlbums.getContentPane().add(btnDerivativealbums);
	}

	public JFrame getClassAlbums(){
		return ClassAlbums;
	}
}
