package src.methods;

import java.util.ArrayList;
import java.util.Scanner;



public class BasicAlbum extends Album{
	
	public BasicAlbum(){
		super();
	}
	public BasicAlbum(String name,int pages){
		super(name,pages);
	}
	public BasicAlbum(String name){
		super(name);
	}
	
	public String addAlbum(AlbumManager album){
		
		int pagesN=0;
		String albumN;
		System.out.println("Dwste to onoma tou album pou thelete na ftiaksete.");
		Scanner reader = new Scanner(System.in);	
		albumN = reader.nextLine();
		System.out.println("Dwste poses selides tha exei to album:");
		pagesN=reader.nextInt();
		BasicAlbum albB = new BasicAlbum(albumN,pagesN);
		album.getAlbumList().add(albB);
		return albumN;
		
	}
	
	public void addPage(AlbumManager album,String albName,int pageNum){
		String title,imagePath,content;
		Scanner reader = new Scanner(System.in);
		String name=albName;
		System.out.println("Dwste ton typo ths selidas: "+(pageNum+1)+" (p.x title/blank/content/picture)");
		String page= reader.nextLine();
		for(Album i : album.getAlbumList()){
			if(i.getName().equals(name)){
				if(page.equals("Blank") || page.equals("blank")){
					BlankPage bp = new BlankPage();
					bp.setDate(createDate());
					bp.setKeywords(createKeywords());
					i.getAlbe().addSlideExtractor(bp.getPageI());;
					i.getPageList().add(bp);
				}
				else if(page.equals("Title") || page.equals("title")){
					System.out.println("Dwste ton titlo");
					title=reader.nextLine();
					TitlePage tp = new TitlePage(title);
					tp.setDate(createDate());
					tp.setKeywords(createKeywords());
					i.getAlbe().addSlideExtractor(tp.getPageI());
					i.getPageList().add(tp);
				}
				else if(page.equals("Content") || page.equals("content")){
					System.out.println("Dwste ton titlo");
					title=reader.nextLine();
					System.out.println("Dwste to keimeno");
					content=reader.nextLine();
					ContentPage cp = new ContentPage(title,content);
					cp.setDate(createDate());
					cp.setKeywords(createKeywords());
					i.getAlbe().addSlideExtractor(cp.getPageI());
					i.getPageList().add(cp);
				}
				else if(page.equals("Picture") || page.equals("picture")){
					System.out.println("Dwste ton titlo");
					title=reader.nextLine();
					System.out.println("Dwste to path tis eikonas");
					imagePath=reader.nextLine();
					ImagePage ip = new ImagePage(title,imagePath);
					ip.setDate(createDate());
					ip.setKeywords(createKeywords());
					i.getAlbe().addSlideExtractor(ip.getPageI());
					i.getPageList().add(ip);
				}else{
					System.out.println("Error:Lathos tupos eikonas.");
				}
				
			}
			if(i.getPageList().size() == i.getPages()){
				i.getAlbe().exportPOISlideShow();
			}
		}
	}
		
	public void editPage(AlbumManager albM){
		String answer,pageType,name,answerStr;
		int pageNumber = 0;
		Scanner reader = new Scanner(System.in);
		System.out.println("Dwste to onoma tou album pou yparxei h selida pou thelete na allaksete");
		name = reader.nextLine();
		for(Album i : albM.getAlbumList()){
			if(i.getName().equals(name)){
				BasicAlbum editAlbum = new BasicAlbum(name,i.getPages());
				System.out.println("Dwste ton arithmo ths selidas pou thelete na alla3ete:");
				pageNumber = reader.nextInt() - 1;
				reader.nextLine();
				editAlbum.setPageList(i.getPageList());
				pageType=i.getPageList().get(pageNumber).getType();
				copyAlbum(i,1,pageNumber,editAlbum); // Otan to 2o orisma ( to 1 sth sigkekrimenh periptwsh ) isoutai me 1, tote kanoume copy to aristero meros tou album se ena allo album.
				if(pageType.equals("Blank")){
					System.out.println("H selida einai typou Blank. Thelete na allaksete thn hmeromhnia?(yes/no)");
					answer=reader.nextLine();
					if(answer.equals("yes")){
						i.getPageList().get(pageNumber).setDate(createDate());
					}
					System.out.println("Thelete na allaksete ta keywords?(yes/no)");
					answer=reader.nextLine();
					if(answer.equals("yes")){
						i.getPageList().get(pageNumber).setKeywords(createKeywords()); //stin setKeywords antikathistountai ta palia keywords me to arraylist twn kainouriwn.
					}
					editAlbum.getAlbe().addSlideExtractor(editAlbum.getPageList().get(pageNumber).getBlankPageExtractor());
				}else if(pageType.equals("Picture")){
					System.out.println("H selida einai typou Picture.Thelete na allaksete thn hmeromhnia?(yes/no)");
					answer=reader.nextLine();
					if(answer.equals("yes")){
						i.getPageList().get(pageNumber).setDate(createDate());
					}
					System.out.println("Thelete na allaksete ta keywords?(yes/no)");
					answer=reader.nextLine();
					if(answer.equals("yes")){
						i.getPageList().get(pageNumber).setKeywords(createKeywords()); //stin setKeywords antikathistountai ta palia keywords me to arraylist twn kainouriwn.
					}
					System.out.println("Thelete na allaksete to ImagePath?(yes/no)");
					answer=reader.nextLine();
					if(answer.equals("yes")){
						System.out.println("Plhktrologhste to kainourio ImagePath:");
						answerStr=reader.nextLine();
						i.getPageList().get(pageNumber).setImagePath(answerStr);
					}
					System.out.println("Thelete na allaksete ton titlo?(yes/no)");
					answer=reader.nextLine();
					if(answer.equals("yes")){
						System.out.println("Plhktrologhste ton kainourio titlo");
						answerStr=reader.nextLine();
						i.getPageList().get(pageNumber).setTitle(answerStr);
					}
					editAlbum.getAlbe().addSlideExtractor(editAlbum.getPageList().get(pageNumber).getPicturePageExtractor());
				}else if(pageType.equals("Content")){
					System.out.println("H selida einai typou Content.Thelete na allaksete thn hmeromhnia?(yes/no)");
					answer=reader.nextLine();
					if(answer.equals("yes")){
						i.getPageList().get(pageNumber).setDate(createDate());
					}

					System.out.println("Thelete na allaksete ton titlo?(yes/no)");
					answer=reader.nextLine();
					if(answer.equals("yes")){
						System.out.println("Plhktrologhste ton kainourio titlo");
						answerStr=reader.nextLine();
						i.getPageList().get(pageNumber).setTitle(answerStr);
					}
					System.out.println("Thelete na allaksete to keimeno?(yes/no)");
					answer=reader.nextLine();
					if(answer.equals("yes")){
						System.out.println("Plhktrologhste to kainourio keimeno");
						answerStr=reader.nextLine();
						i.getPageList().get(pageNumber).setText(answerStr);
					}
					
					System.out.println("Thelete na allaksete ta keywords?(yes/no)");
					answer=reader.nextLine();
					if(answer.equals("yes")){
						i.getPageList().get(pageNumber).setKeywords(createKeywords()); //stin setKeywords antikathistountai ta palia keywords me to arraylist twn kainouriwn.
					}
					editAlbum.getAlbe().addSlideExtractor(editAlbum.getPageList().get(pageNumber).getContentPageExtractor());
				}else if(pageType.equals("Title")){
					System.out.println("H selida einai typou Title.Thelete na allaksete thn hmeromhnia?(yes/no)");
					answer=reader.nextLine();
					if(answer.equals("yes")){
						i.getPageList().get(pageNumber).setDate(createDate());
					}
					System.out.println("Thelete na allaksete ton titlo?(yes/no)");
					answer=reader.nextLine();
					if(answer.equals("yes")){
						System.out.println("Plhktrologhste ton kainourio titlo");
						answerStr=reader.nextLine();
						i.getPageList().get(pageNumber).setTitle(answerStr);
					}
					System.out.println("Thelete na allaksete ta keywords?(yes/no)");
					answer=reader.nextLine();
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
	
	
	

	
	public int[] createDate(){
		 int[] newdate = new int[3];
		 boolean flag=true;
		 int day = 0,month = 0,year = 0;
		 Scanner reader = new Scanner(System.in);
		 System.out.println("Dwste thn hmeromhnia ths selidas\n");
		 while(flag==true){
		 	System.out.println("Dwste thn hmera (p.x 13)");
			 day=reader.nextInt();
			 System.out.println("Dwste to mhna (p.x 1 (gia Ianouarios))");
			 month=reader.nextInt();
			 System.out.println("Dwste to xrono (p.x 2016)");
			 year=reader.nextInt();	
			 if(day<1 || day>31){
				 System.out.println("Lathos Hmera. Ksanaprospathiste");
			 }
			 else if(month<1 || month>12){
				 System.out.println("Lathos mhnas. Ksanaprospathiste");
			 }
			 else if(year<0){
				 System.out.println("Lathos xronos. Ksanaprospathiste");
			 }else{
				 flag=false;
			 }
		 }
		 newdate[0]=day;
		 newdate[1]=month;
		 newdate[2]=year;
		 return newdate;
	 }
	
		
	public ArrayList<String> createKeywords(){
		
		String k;
		ArrayList<String> newkeywords = new ArrayList<>();
		System.out.println("Dwste ta keywords. Gia na stamathsete pathste 'stop'");
		Scanner reader = new Scanner(System.in);
		while(!(k=reader.nextLine()).equals("stop")){
			newkeywords.add(k);
		}
		return newkeywords;
		
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

	
	public void setPageList(ArrayList<Page> pagelist){
		this.pageList = pagelist;
	}
	
}
