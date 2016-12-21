package src.methods;

import java.util.Scanner;


public class DerivativeAlbum extends Album{
	
	public DerivativeAlbum(){
		super();
	}
	
	public DerivativeAlbum(String name,int pages){
		super(name,pages);
	}
	public String addAlbum(AlbumManager album){
		return "";
	}
	
	public void addDerivativeAlbum(AlbumManager albM){
		int count2 = 0;
		String key;
		boolean found = false;
		System.out.println("Dwste to keyword gia na ftiaxtei to paragwgo album.");
		Scanner reader = new Scanner(System.in);
		key = reader.nextLine();
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
	

