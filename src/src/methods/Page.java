package src.methods;

import java.util.ArrayList;


import src.poiExtractor.BlankPageExtractor;
import src.poiExtractor.ContentPageExtractor;
import src.poiExtractor.IPageExtractorToPoi;
import src.poiExtractor.PicturePageExtractor;
import src.poiExtractor.PicturePageWResizablePicExtractor;
import src.poiExtractor.TitlePageExtractor;

public abstract class Page{
	protected ArrayList<String> keywords = new ArrayList<>();
	protected int[] date = new int[3];
	protected String type;
	public abstract void setImagePath(String image);
	public abstract void setTitle(String title);
	public abstract void setText(String content);
	public abstract void setDate(int date[]);
	public abstract void setKeywords(ArrayList<String> keywords);
	public abstract void setTitlePage(TitlePageExtractor tp);
	public abstract void setBlankPage(BlankPageExtractor bp);
	public abstract void setContentPage(ContentPageExtractor cp);
	public abstract void setPicturePage(PicturePageWResizablePicExtractor pp);
	public abstract int[] getDate(int date[]);
	public abstract String getImagePath();
	public abstract String getTitle();
	public abstract String getText();
	public abstract BlankPageExtractor getBlankPageExtractor();
	public abstract PicturePageWResizablePicExtractor getPicturePageExtractor();
	public abstract ContentPageExtractor getContentPageExtractor();
	public abstract TitlePageExtractor getTitlePageExtractor();
	
	public Page(){
		ArrayList<String> keywords = new ArrayList<>();
		int[] date = new int[3];
	}
	
	public int[] getDate(){
		return this.date;
	}
	
	public String getType(){
		return this.type;
	}
	
	public ArrayList<String> getKeywords(){
		return this.keywords;
	}
	
	public void setType(String type){
		this.type = type;
	}
	

}
