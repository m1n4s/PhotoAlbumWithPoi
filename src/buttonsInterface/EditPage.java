package buttonsInterface;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.methods.Album;
import src.methods.BasicAlbum;

public class EditPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void newScreen(AlbumManagerI alb) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPage window = new EditPage(alb);
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
	public EditPage(AlbumManagerI albM) {
		initialize(albM);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(AlbumManagerI albM) {
		editPageI(albM);
	}
	
	public void editPageI(AlbumManagerI albM){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		String answer,pageType,name,answerStr;
		int pageNumber = 0;
		name = JOptionPane.showInputDialog("Dwste to onoma tou album pou yparxei h selida pou thelete na allaksete");
		for(Album i : albM.getAlbumList()){
			if(i.getName().equals(name)){
				BasicAlbum editAlbum = new BasicAlbum(name,i.getPages());
				pageNumber = Integer.parseInt(JOptionPane.showInputDialog("Dwste ton arithmo ths selidas pou thelete na alla3ete:")) - 1;
				editAlbum.setPageList(i.getPageList());
				pageType=i.getPageList().get(pageNumber).getType();
				copyAlbum(i,1,pageNumber,editAlbum); // Otan to 2o orisma ( to 1 sth sigkekrimenh periptwsh ) isoutai me 1, tote kanoume copy to aristero meros tou album se ena allo album.
				if(pageType.equals("Blank")){
					answer = JOptionPane.showInputDialog("H selida einai typou Blank. Thelete na allaksete thn hmeromhnia?");
					if(answer.equals("yes")){
						i.getPageList().get(pageNumber).setDate(createDate());
					}
					answer = JOptionPane.showInputDialog("Thelete na allaksete ta keywords?(yes/no)");
					if(answer.equals("yes")){
						i.getPageList().get(pageNumber).setKeywords(createKeywords()); //stin setKeywords antikathistountai ta palia keywords me to arraylist twn kainouriwn.
					}
					editAlbum.getAlbe().addSlideExtractor(editAlbum.getPageList().get(pageNumber).getBlankPageExtractor());
				}else if(pageType.equals("Picture")){
					answer = JOptionPane.showInputDialog("H selida einai typou Picture.Thelete na allaksete thn hmeromhnia?(yes/no)");
					if(answer.equals("yes")){
						i.getPageList().get(pageNumber).setDate(createDate());
					}
					if(answer.equals("yes")){
						i.getPageList().get(pageNumber).setKeywords(createKeywords());
					}
					answer = JOptionPane.showInputDialog("Thelete na allaksete to ImagePath?(yes/no)");
					if(answer.equals("yes")){
						answerStr = JOptionPane.showInputDialog("Plhktrologhste to kainourio ImagePath");
						i.getPageList().get(pageNumber).setImagePath(answerStr);
					}
					answer = JOptionPane.showInputDialog("Thelete na allaksete ton titlo?(yes/no)");
					if(answer.equals("yes")){
						answerStr = JOptionPane.showInputDialog("Plhktrologhste ton kainourio titlo");
						i.getPageList().get(pageNumber).setTitle(answerStr);
					}
					editAlbum.getAlbe().addSlideExtractor(editAlbum.getPageList().get(pageNumber).getPicturePageExtractor());
				}else if(pageType.equals("Content")){
					answer = JOptionPane.showInputDialog("H selida einai typou Content.Thelete na allaksete thn hmeromhnia?(yes/no)");
					if(answer.equals("yes")){
						i.getPageList().get(pageNumber).setDate(createDate());
					}

					answer = JOptionPane.showInputDialog("Thelete na allaksete ton titlo?(yes/no)");
					if(answer.equals("yes")){
						answerStr = JOptionPane.showInputDialog("Plhktrologhste ton kainourio titlo");
						i.getPageList().get(pageNumber).setTitle(answerStr);
					}
					answer = JOptionPane.showInputDialog("Thelete na allaksete to keimeno?(yes/no)");
					if(answer.equals("yes")){
						answerStr = JOptionPane.showInputDialog("Plhktrologhste to kainourio keimeno");
						i.getPageList().get(pageNumber).setText(answerStr);
					}
					
					answer = JOptionPane.showInputDialog("Thelete na allaksete ta keywords?(yes/no)");
					if(answer.equals("yes")){
						i.getPageList().get(pageNumber).setKeywords(createKeywords()); //stin setKeywords antikathistountai ta palia keywords me to arraylist twn kainouriwn.
					}
					editAlbum.getAlbe().addSlideExtractor(editAlbum.getPageList().get(pageNumber).getContentPageExtractor());
				}else if(pageType.equals("Title")){
					answer = JOptionPane.showInputDialog("H selida einai typou Title.Thelete na allaksete thn hmeromhnia?(yes/no)");
					if(answer.equals("yes")){
						i.getPageList().get(pageNumber).setDate(createDate());
					}
					answer = JOptionPane.showInputDialog("Thelete na allaksete ton titlo?(yes/no)");
					if(answer.equals("yes")){
						answerStr = JOptionPane.showInputDialog("Plhktrologhste ton kainourio titlo");
						i.getPageList().get(pageNumber).setTitle(answerStr);
					}
					answer = JOptionPane.showInputDialog("Thelete na allaksete ta keywords?(yes/no)");
					if(answer.equals("yes")){
						i.getPageList().get(pageNumber).setKeywords(createKeywords()); //stin setKeywords antikathistountai ta palia keywords me to arraylist twn kainouriwn.
					}
					editAlbum.getAlbe().addSlideExtractor(editAlbum.getPageList().get(pageNumber).getTitlePageExtractor());
				}
				copyAlbum(i,0,pageNumber,editAlbum); // h 2h eisodos(to 0 ) an einai diaforetiko apo 1 tha kanei copy to deksi meros meta to pageNumber.
				i.setAlbe(editAlbum.getAlbe());
				i.getAlbe().exportPOISlideShow();
			}	
		}
	}
	
	
	
	public ArrayList<String> createKeywords(){
		String k;
		ArrayList<String> newkeywords = new ArrayList<>();
		k = (String)JOptionPane.showInputDialog("Dwste ta keywords ena-ena.(close the window to stop)");
		while((k != null)){
			newkeywords.add(k);
			k = (String)JOptionPane.showInputDialog("Dwste to epomeno keyword.");
		}
		return newkeywords;
	}
	
	
	public int[] createDate(){
		JTextField fldDay = new JTextField(3);
        JTextField fldMonth = new JTextField(3);
        JTextField fldYear = new JTextField(4);
        int[] newdate = new int[3];
        JPanel message = new JPanel();
        message.add(fldDay);
        message.add(new JLabel("/"));
        message.add(fldMonth);
        message.add(new JLabel("/"));
        message.add(fldYear);

        int result = JOptionPane.showConfirmDialog(null, message, "Enter Date", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String sDay = fldDay.getText();
            String sMonth = fldMonth.getText();
            String sYear = fldYear.getText();

            try {
                int day = Integer.parseInt(sDay);
                newdate[0] = day;
                if(day <= 0 || day > 31){ //in case of a wrong date recall the method for the user to enter the correct date.
                	createDate();
                }
                int month = Integer.parseInt(sMonth);
                newdate[1] = month;
                if(month <= 0 || month > 12){
                	createDate(); //same for the month..
                }
                int year = Integer.parseInt(sYear);
                newdate[2] = year;
                if(year <= 0){
                	createDate(); //same for the year..
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "The values you entered are invalid");
                createDate();
            }
        }
        return newdate;
	}
	
	public void copyAlbum(Album album,int chooseSide,int pageNum,Album editAlbum){
		if(chooseSide == 1){
			for(int i=0;i<pageNum;i++){
				if(album.getPageList().get(i).getType().equals("Blank")){
					editAlbum.getPageList().get(i).setBlankPage(album.getPageList().get(i).getBlankPageExtractor());
					editAlbum.getAlbe().addSlideExtractor(album.getPageList().get(i).getBlankPageExtractor());
				}
				else if(album.getPageList().get(i).getType().equals("Content")){
					editAlbum.getPageList().get(i).setContentPage(album.getPageList().get(i).getContentPageExtractor());
					editAlbum.getAlbe().addSlideExtractor(album.getPageList().get(i).getContentPageExtractor());
				}
				else if(album.getPageList().get(i).getType().equals("Picture")){
					editAlbum.getPageList().get(i).setPicturePage(album.getPageList().get(i).getPicturePageExtractor());
					editAlbum.getAlbe().addSlideExtractor(album.getPageList().get(i).getPicturePageExtractor());
				}
				else if(album.getPageList().get(i).getType().equals("Title")){
					editAlbum.getPageList().get(i).setTitlePage(album.getPageList().get(i).getTitlePageExtractor());
					editAlbum.getAlbe().addSlideExtractor(album.getPageList().get(i).getTitlePageExtractor());
				}
			}
		}
		else{
			if(pageNum<album.getPages()){
				for(int i=pageNum+1;i<album.getPages();i++){
					if(album.getPageList().get(i).getType().equals("Blank")){
						editAlbum.getPageList().get(i).setBlankPage(album.getPageList().get(i).getBlankPageExtractor());
						editAlbum.getAlbe().addSlideExtractor(album.getPageList().get(i).getBlankPageExtractor());
					}
					else if(album.getPageList().get(i).getType().equals("Content")){
						editAlbum.getPageList().get(i).setContentPage(album.getPageList().get(i).getContentPageExtractor());
						editAlbum.getAlbe().addSlideExtractor(album.getPageList().get(i).getContentPageExtractor());
					}
					else if(album.getPageList().get(i).getType().equals("Picture")){
						editAlbum.getPageList().get(i).setPicturePage(album.getPageList().get(i).getPicturePageExtractor());
						editAlbum.getAlbe().addSlideExtractor(album.getPageList().get(i).getPicturePageExtractor());
					}
					else if(album.getPageList().get(i).getType().equals("Title")){
						editAlbum.getPageList().get(i).setTitlePage(album.getPageList().get(i).getTitlePageExtractor());
						editAlbum.getAlbe().addSlideExtractor(album.getPageList().get(i).getTitlePageExtractor());
					}
				}
			}
		}
	}

}
