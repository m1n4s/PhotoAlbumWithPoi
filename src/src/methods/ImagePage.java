package src.methods;


import java.util.ArrayList;

import src.poiExtractor.*;

public class ImagePage extends Page{
	private String title;
	private String imagePath;
	private PicturePageWResizablePicExtractor pageI;
	
	public void setTitlePage(TitlePageExtractor tp){
		
	}
	
	public ImagePage(){
		this.title = " ";
		this.imagePath = " ";
		this.type = "Picture";
	}
	public ImagePage(String title ,String image){
		super();
		this.pageI=new PicturePageWResizablePicExtractor(title,image);
		this.title = title;
		this.imagePath = image;
		this.type = "Picture";
	}
	
	public PicturePageWResizablePicExtractor getPageI(){
		return pageI;
	}
	
	public void setPicturePageExtractor(PicturePageWResizablePicExtractor pp){
		this.pageI = pp;
	}
	
	public void setDate(int date[]){
		this.date = date;
	}
	
	public void setKeywords(ArrayList<String> keywords){
		this.keywords = keywords;
	}
	
	public void setImagePath(String image){
		this.imagePath = image;
		pageI = new PicturePageWResizablePicExtractor(this.title,image);
	}
	
	public void setTitle(String title){
		this.title = title;
		pageI = new PicturePageWResizablePicExtractor(title,this.imagePath);
	}
	
	public void setBlankPage(BlankPageExtractor bp){
		
	}
	public void setContentPage(ContentPageExtractor cp){
		
	}
	public void setPicturePage(PicturePageWResizablePicExtractor pp){
		this.pageI = pp;
	}
	
	public void setText(String aString){
		
	}
	
	public int[] getDate(int date[]){
		return this.date;
	}
	
	public BlankPageExtractor getBlankPageExtractor(){
		return null;
	}
	public PicturePageWResizablePicExtractor getPicturePageExtractor(){
		return pageI;
	}
	public ContentPageExtractor getContentPageExtractor(){
		return null;
	}
	public TitlePageExtractor getTitlePageExtractor(){
		return null;
	}
	
	public String getImagePath(){
		return this.imagePath;
	}
	public String getTitle(){
		return this.title;
	}
	public String getText(){
		return null;
	}
}
