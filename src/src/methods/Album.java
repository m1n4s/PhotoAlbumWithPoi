package src.methods;

import java.util.ArrayList;

import src.poiExtractor.AlbumExtractor;

public abstract class Album {
	protected String name;
	protected int pages;
	protected ArrayList<Page> pageList;
	protected AlbumExtractor albe;
	
	public Album(){
		this.name = " ";
		this.pages = 0;
		this.pageList=new ArrayList<Page>();
		albe=new AlbumExtractor(this.name);
	}
	public Album(String name){
		this.name = name;
		this.pages = 0;
		this.pageList=new ArrayList<Page>();
		albe=new AlbumExtractor(name);
	}
	
	public Album(String name,int pages){
		this.name = name;
		this.pages = pages;
		this.pageList=new ArrayList<Page>();
		albe=new AlbumExtractor(name);
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getPages(){
		return this.pages;
	}
	
	public void incrPages(){
		this.pages++;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public abstract String addAlbum(AlbumManager album);
	
	public AlbumExtractor getAlbe(){
		return this.albe;
	}
	
	public ArrayList<Page> getPageList(){
		return this.pageList;
	}
	
	public void setAlbe(AlbumExtractor alb){
		this.albe = alb;
	}
}
