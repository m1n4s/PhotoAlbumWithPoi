package buttonsInterface;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.methods.Album;
import src.methods.BlankPage;
import src.methods.ContentPage;
import src.methods.ImagePage;
import src.methods.TitlePage;

public class AddPage {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public void newScreen(AlbumManagerI alb) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPage window = new AddPage(alb);
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
	public AddPage(AlbumManagerI albM) {
		initialize(albM);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(AlbumManagerI albM) {
		addPageI(albM);
	}
	
	public void addPageI(AlbumManagerI albM){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		String title,imagePath,content;
		String name = (String)JOptionPane.showInputDialog("Dwste to onoma tou album : ");
		String page = (String)JOptionPane.showInputDialog("Dwste ton typo ths selidas (p.x title/blank/content/picture)");
		for(Album i : albM.getAlbumList()){
			if(i.getName().equals(name)){
				if(page.equals("Blank") || page.equals("blank")){
					BlankPage bp = new BlankPage();
					bp.setDate(createDate());
					bp.setKeywords(createKeywords());
					i.getAlbe().addSlideExtractor(bp.getPageI());;
					i.getPageList().add(bp);
				}
				else if(page.equals("Title") || page.equals("title")){
					title = (String)JOptionPane.showInputDialog("Dwste ton titlo");
					TitlePage tp = new TitlePage(title);
					tp.setDate(createDate());
					tp.setKeywords(createKeywords());
					i.getAlbe().addSlideExtractor(tp.getPageI());
					i.getPageList().add(tp);
				}
				else if(page.equals("Content") || page.equals("content")){
					title = (String)JOptionPane.showInputDialog("Dwste ton titlo");
					content = (String)JOptionPane.showInputDialog("Dwste to keimeno");
					ContentPage cp = new ContentPage(title,content);
					cp.setDate(createDate());
					cp.setKeywords(createKeywords());
					i.getAlbe().addSlideExtractor(cp.getPageI());
					i.getPageList().add(cp);
				}
				else if(page.equals("Picture") || page.equals("picture")){
					title = (String)JOptionPane.showInputDialog("Dwste ton titlo");
					imagePath = (String)JOptionPane.showInputDialog("Dwste to path tis eikonas");
					ImagePage ip = new ImagePage(title,imagePath);
					ip.setDate(createDate());
					ip.setKeywords(createKeywords());
					i.getAlbe().addSlideExtractor(ip.getPageI());
					i.getPageList().add(ip);
				}
			}
			if(i.getPageList().size() == i.getPages()){
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
}
