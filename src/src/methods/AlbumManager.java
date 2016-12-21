package src.methods;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;




import java.awt.Desktop;
import java.io.File;

public class AlbumManager {
	private ArrayList<Album> allAlbums;
	
	public AlbumManager(){
		allAlbums=new ArrayList<Album>();
	}
	
	
	
	public static void main(String[] args) {
		String s,albumName;
		int answer=0;
		AlbumManager kurioMgr=new AlbumManager();
		BasicAlbum alm=new BasicAlbum();
		DerivativeAlbum almDeriv=new DerivativeAlbum();
		System.out.println("Dhmiourgiste ena Album(yes/no):");
		Scanner reader=new Scanner(System.in);
		s=reader.nextLine();
		if(s.equals("yes")){
			albumName=alm.addAlbum(kurioMgr);
			//albumName=reader.nextLine();
			for(Album i : kurioMgr.getAlbumList()){
				if(albumName.equals(i.getName())){
					for(int j=0;j<i.getPages();j++){
						alm.addPage(kurioMgr,albumName,j);
					}
					break;
				}
			}
			
		}
		while(answer>=0){
			
			System.out.println("Your choises:");
			System.out.println("1.WatchAlbumList");
			System.out.println("2.WatchAlbumInOrder(if album exists)");
			System.out.println("3.WatchAlbumChronologically(if album exists)");
			System.out.println("4.EditPage(if album exists)");
			System.out.println("5.Create a DerivativeAlbum");
			System.out.println("6.New Ablum");
			System.out.println("7.Exit the programm");
			answer=reader.nextInt();
			reader.nextLine();
			if(answer==1){
				kurioMgr.WatchAlbumList();
			}else if(answer==2){
				kurioMgr.WatchAlbumInOrder();
			}else if(answer==3){
				kurioMgr.WatchAlbumChronologically(kurioMgr);
			}else if(answer==4){
				alm.editPage(kurioMgr);
			}else if(answer==5){
				almDeriv.addDerivativeAlbum(kurioMgr);
			}else if(answer==6){
				System.out.println("Dhmiourgiste ena Album(yes/no):");
				s=reader.nextLine();
				if(s.equals("yes")){
					albumName=alm.addAlbum(kurioMgr);
					for(Album i : kurioMgr.getAlbumList()){
						if(albumName.equals(i.getName())){
							for(int j=0;j<i.getPages();j++){
								alm.addPage(kurioMgr,albumName,j);
							}
							break;
						}
					}
					
				}
			}else{
				System.out.println("EXIT!");
				answer=-1;
			}
		}
	
	}
	
	
	public void WatchAlbumList(){
		System.out.println("Ta onomata olwn twn album:");
		for(Album i:allAlbums){
			System.out.println(i.getName());
		}
		System.out.println("---------------");
	}
	
	public void WatchAlbumInOrder(){
		String albName,s;
		System.out.println("Dwste to onoma tou album : \n");
		Scanner reader=new Scanner(System.in);
		s=reader.nextLine();
		albName = s;
		if(s!=null && s.length()>0){
			File[] files = new File(System.getProperty("user.dir")).listFiles();
			for(File file : files){
				if(file.getName().equals(albName+".pptx")){
					try {
				        Desktop desktop = Desktop.getDesktop();
				        if (desktop.isSupported(Desktop.Action.OPEN)) {
				            desktop.open(new File(albName+".pptx"));
				        } else {
				        	System.out.println("Open is not supported");
				        }
				        file.deleteOnExit();
				    } catch (IOException exp) {
				    	exp.printStackTrace();
				    }
				}
			}
		}
		
	}
	
	public void WatchAlbumChronologically(AlbumManager alb){
		int count = 0;
		boolean swapped = true;
		BasicAlbum tempAlbum;
		int []temp = new int[3];
		int [][]tempDate ;
		System.out.println("Dwste to onoma tou album : \n");
		Scanner reader = new Scanner(System.in);
		String albName =reader.nextLine();
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
						 System.out.println("Open is not supported");
					}
				}catch(IOException exp) {
					exp.printStackTrace();
				}
			}
		}
	}
		
		

	public ArrayList<Album> getAlbumList(){
		return allAlbums;
	}
	
}
