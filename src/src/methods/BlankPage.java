package src.methods;
import java.util.ArrayList;

import src.poiExtractor.*;
public class BlankPage extends Page{
	
	private BlankPageExtractor pageI;
	
	public BlankPage(){
		pageI=new BlankPageExtractor();
		this.type = "Blank";
	}
	
	public BlankPageExtractor getPageI(){
		return pageI;
	}
	public void setTitlePage(TitlePageExtractor tp){
		
	}
	public void setDate(int date[]){
		this.date = date;
	}
	public void setKeywords(ArrayList<String> keywords){
		this.keywords = keywords;
	}
	public void setTitle(String title){
		
	}
	public  void setText(String content){
		
	}
	public void setImagePath(String anImage){
		
	}
	
	public BlankPageExtractor getBlankPageExtractor(){
		return pageI;
	}
	public PicturePageWResizablePicExtractor getPicturePageExtractor(){
		return null;
	}
	public ContentPageExtractor getContentPageExtractor(){
		return null;
	}
	public TitlePageExtractor getTitlePageExtractor(){
		return null;
	}
	
	public void setBlankPage(BlankPageExtractor bp){
		this.pageI = bp;
	}
	public void setContentPage(ContentPageExtractor cp){
		
	}
	public void setPicturePage(PicturePageWResizablePicExtractor pp){
		
	}
	
	public int[] getDate(int date[]){
		return this.date;
	}
	
	public String getImagePath(){
		return null;
	}
	public String getTitle(){
		return null;
	}
	public String getText(){
		return null;
	}
}
