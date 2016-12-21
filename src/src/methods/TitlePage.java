package src.methods;
import java.util.ArrayList;

import src.poiExtractor.*;


public class TitlePage extends Page{
	private TitlePageExtractor pageI;
	private String title;
	
	public TitlePage(){
		this.type = "Title";
		this.title="";
	}
	
	public TitlePage(String atitle){
		super();
		pageI=new TitlePageExtractor(atitle);
		this.title = atitle;
		this.type = "Title";
	}

	
	public TitlePageExtractor getPageI(){
		return pageI;
	}
	
	public void setTitlePage(TitlePageExtractor tp){
		this.pageI = tp;
	}
	
	public void setBlankPage(BlankPageExtractor bp){
		
	}
	public void setContentPage(ContentPageExtractor cp){
		
	}
	public void setPicturePage(PicturePageWResizablePicExtractor pp){
		
	}
	
	public void setDate(int date[]){
		this.date = date;
	}
	
	public void setKeywords(ArrayList<String> keywords){
		this.keywords = keywords;
	}
	
	public void setTitle(String title){
		this.title = title;
		TitlePageExtractor cpy = new TitlePageExtractor(title);
		setTitlePage(cpy);
	}
	
	public void setImagePath(String AnImage){
		
	}
	
	public void setText(String aText){
		
	}
	
	public int[] getDate(int date[]){
		return this.date;
	}
	
	public BlankPageExtractor getBlankPageExtractor(){
		return null;
	}
	public PicturePageWResizablePicExtractor getPicturePageExtractor(){
		return null;
	}
	public ContentPageExtractor getContentPageExtractor(){
		return null;
	}
	public TitlePageExtractor getTitlePageExtractor(){
		return pageI;
	}
	
	public String getImagePath(){
		return null;
	}
	public String getTitle(){
		return this.title;
	}
	public String getText(){
		return null;
	}


}
