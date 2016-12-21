package src.methods;


import java.util.ArrayList;

import src.poiExtractor.*;

public class ContentPage extends Page{
	private String title;
	private String content;
	private ContentPageExtractor pageI;
		
		
	public ContentPage(){
		this.title = " ";
		this.content = " ";
		this.type = "Content";
	}
	public ContentPage(String title ,String content){
		super();
		this.pageI=new ContentPageExtractor(title,content);
		this.title = title;
		this.content = content;
		this.type = "Content";
	}
	
	public ContentPageExtractor getPageI(){
		return pageI;
	}
	public void setTitlePage(TitlePageExtractor tp){
		
	}
	
	public void setContentPageExtractor(ContentPageExtractor cp){
		this.pageI = cp;
	}
	
	public void setDate(int date[]){
		this.date = date;
	}
	public  void setText(String content){
		this.content = content;
		pageI = new ContentPageExtractor(this.title,content);
	}

	public void setBlankPage(BlankPageExtractor tp){
		
	}
	public void setContentPage(ContentPageExtractor tp){
		this.pageI = tp;
	}
	public void setPicturePage(PicturePageWResizablePicExtractor tp){
		
	}
	
	public void setTitle(String title){
		this.title = title;
		pageI = new ContentPageExtractor(title,this.content);
	}
	
	public void setKeywords(ArrayList<String> keywords){
		this.keywords = keywords;
	}
	public void setImagePath(String anImage){
		
	}
	
	public BlankPageExtractor getBlankPageExtractor(){
		return null;
	}
	public PicturePageWResizablePicExtractor getPicturePageExtractor(){
		return null;
	}
	public ContentPageExtractor getContentPageExtractor(){
		return pageI;
	}
	public TitlePageExtractor getTitlePageExtractor(){
		return null;
	}
	
	public int[] getDate(int date[]){
		return this.date;
	}
	
	public String getImagePath(){
		return null;
	}
	public String getTitle(){
		return this.title;
	}
	public String getText(){
		return this.content;
	}
}



