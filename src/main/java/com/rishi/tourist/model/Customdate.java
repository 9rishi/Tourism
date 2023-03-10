package com.rishi.tourist.model;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

public  class Customdate  {	
	public  static Object handleCase(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Field [] fields = obj.getClass().getDeclaredFields();
		for(Field field: fields) {
			field.setAccessible(true);
		Custom_Date d = field.getAnnotation(Custom_Date.class);
		if(d != null) {
		d.custom_date();
  
			// Use format method on SimpleDateFormat
	       String dateformat1 = field.get(obj).toString() ;
	       System.out.println("date:"+dateformat1);
	       SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDateStr = dmyFormat.format(dateformat1);
			System.out.println("Formatted Date in String format: "+formattedDateStr);
		
	    field.set(obj, formattedDateStr);
		}
		}
		return obj;
	}
}




//Date date = new Date();
//System.out.println("Original Date: "+date);
//SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");	        
//String formattedDateStr = dmyFormat.format(date);
//System.out.println("Formatted Date in String format: "+formattedDateStr);