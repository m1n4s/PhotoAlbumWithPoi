package buttonsInterface;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import src.methods.Album;
import src.methods.BasicAlbum;
import src.methods.Page;

public class AlbumsChrono {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void newScreen(AlbumManagerI allAlbums) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlbumsChrono window = new AlbumsChrono(allAlbums);
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
	public AlbumsChrono(AlbumManagerI alb) {
		initialize(alb);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(AlbumManagerI alb) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int count = 0;
		boolean swapped = true;
		BasicAlbum tempAlbum;
		int []temp = new int[3];
		int [][]tempDate ;
		String albName = (String)JOptionPane.showInputDialog("Dwste to onoma tou album : \n");
		for(Album i : alb.getAlbumList()){
			if(i.getName().equals(albName)){
				tempDate = new int[i.getPages()][3];
				tempAlbum = new BasicAlbum(i.getName() + " Chronologically",i.getPages());
				for(int s=0;s<i.getPages();s++){
					tempDate[s] = i.getPageList().get(s).getDate();
				}
				while(swapped){
					swapped = false;
					count++;
					for(int j=0;j<i.getPages()-count;j++){
						if(tempDate[j][2]>tempDate[j+1][2]){
							temp = tempDate[j];
							tempDate[j] = tempDate[j+1];
							tempDate[j+1] = temp;
							swapped = true;
						}
						else if(tempDate[j][1]>tempDate[j+1][1]){
							temp = tempDate[j];
							tempDate[j] = tempDate[j+1];
							tempDate[j+1] = temp;
							swapped = true;
						}
						else if(tempDate[j][0]>tempDate[j+1][0]){
							temp = tempDate[j];
							tempDate[j] = tempDate[j+1];
							tempDate[j+1] = temp;
							swapped = true;
						}
					}
				}
				for(int k = 0;k<i.getPages();k++){
					for(Page l : i.getPageList()){
						temp = l.getDate();
						if(temp[2] == tempDate[k][2] && temp[1] == tempDate[k][1] && temp[0] == tempDate[k][0]){
							if(l.getType().equals("Blank")){
								tempAlbum.getPageList().add(l);
								tempAlbum.getAlbe().addSlideExtractor(l.getBlankPageExtractor());
							}
							if(l.getType().equals("Title")){
								tempAlbum.getPageList().add(l);
								tempAlbum.getAlbe().addSlideExtractor(l.getTitlePageExtractor());
							}
							if(l.getType().equals("Picture")){
								tempAlbum.getPageList().add(l);
								tempAlbum.getAlbe().addSlideExtractor(l.getPicturePageExtractor());
							}
							if(l.getType().equals("Content")){
								tempAlbum.getPageList().add(l);
								tempAlbum.getAlbe().addSlideExtractor(l.getContentPageExtractor());
							}
						}
					}
				}
				tempAlbum.getAlbe().exportPOISlideShow();
				try {
					Desktop desktop = Desktop.getDesktop();
				    File file = new File(System.getProperty("user.dir")+"/"+tempAlbum.getName()+".pptx");
				    if (desktop.isSupported(Desktop.Action.OPEN)) {
				    	desktop.open(file);
					}else {
						frame.setTitle("Error.");
					}
					file.deleteOnExit();
				}catch(IOException exp) {
					exp.printStackTrace();
				}
			}
		}
	}

}
