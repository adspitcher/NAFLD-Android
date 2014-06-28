package com.app.nafld.dataobjects;

public class ImageStringItems {
	
	private String itemText;
	private int itemDrawableID;
	
	public ImageStringItems( String text, int drawableID ){
		this.itemText = text;
		this.itemDrawableID = drawableID;
	}

	public String getItemText() {
		return itemText;
	}

	public int getItemDrawableID() {
		return itemDrawableID;
	}
	
	

}
