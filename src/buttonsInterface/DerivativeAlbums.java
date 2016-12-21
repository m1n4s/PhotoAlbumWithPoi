package buttonsInterface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import src.methods.Album;
import src.methods.AlbumManager;
import src.methods.BasicAlbum;
import src.methods.BlankPage;
import src.methods.ContentPage;
import src.methods.ImagePage;
import src.methods.Page;
import src.methods.TitlePage;

public class DerivativeAlbums extends Album{

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public void newScreen(AlbumManagerI alb) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DerivativeAlbums window = new DerivativeAlbums(alb);
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
	public DerivativeAlbums(AlbumManagerI albM) {
		initialize(albM);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize(AlbumManagerI albM) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addDerivativeAlbum(albM);
	}
	
	public String addAlbum(AlbumManager album){
		return "";
	}
	
	public void addDerivativeAlbum(AlbumManagerI albM){
		int count2 = 0;
		String key;
		boolean found = false;
		key = JOptionPane.showInputDialog("Dwste to keyword gia na ftiaxtei to paragwgo album.");
		BasicAlbum k1 = new BasicAlbum(key);
		for(Album i:albM.getAlbumList()){
			for(Page j : i.getPageList()){
				for(String k : j.getKeywords()){
					if(k.equals(key)){
						found = true;
						k1.incrPages();
							if(j.getType().equals("Blank")){
								BlankPage tp = new BlankPage();
							    k1.setName(key);
								tp.setKeywords(j.getKeywords());
								tp.setDate(j.getDate());
								tp.setBlankPage(j.getBlankPageExtractor());
								k1.getPageList().add(tp);
								k1.getAlbe().addSlideExtractor(tp.getBlankPageExtractor());
							}
							else if(j.getType().equals("Title")){
								TitlePage tp = new TitlePage(j.getTitle());
							    k1.setName(key);
								tp.setKeywords(j.getKeywords());
								tp.setDate(j.getDate());
								tp.setTitle(j.getTitle());
								tp.setTitlePage(j.getTitlePageExtractor());
								k1.getPageList().add(tp);
								k1.getAlbe().addSlideExtractor(tp.getTitlePageExtractor());
							}
							else if(j.getType().equals("Content")){
								ContentPage tp = new ContentPage(j.getTitle(),j.getText());
							    k1.setName(key);
								tp.setKeywords(j.getKeywords());
								tp.setDate(j.getDate());
								tp.setTitle(j.getTitle());
								tp.setText(j.getText());
								tp.setContentPage(j.getContentPageExtractor());
								k1.getPageList().add(tp);
								k1.getAlbe().addSlideExtractor(tp.getContentPageExtractor());
							}
							else if(j.getType().equals("Picture")){
								ImagePage tp = new ImagePage(j.getTitle(),j.getImagePath());
							    k1.setName(key);
								tp.setKeywords(j.getKeywords());
								tp.setDate(j.getDate());
								tp.setTitle(j.getTitle());
								tp.setImagePath(j.getImagePath());
								tp.setPicturePage(j.getPicturePageExtractor());
								k1.getPageList().add(tp);
								k1.getAlbe().addSlideExtractor(tp.getPicturePageExtractor());
							}
						}
					}
				}
			}
		if (found == true){
			for(Album i : albM.getAlbumList()){
				if(i.getName().equals(key)){
					count2 ++ ;
				}
			}
			if(count2 == 0){
				k1.getAlbe().exportPOISlideShow();
				albM.getAlbumList().add(k1);
			}
		}
	}
}
