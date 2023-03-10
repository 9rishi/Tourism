package com.rishi.tourist.model;

import java.util.Calendar;
import java.util.Date;

public class f {

	int no;
	
	@Custom_Date 
	Date dat;
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

		f  ff = new f();
		// creating a Calendar object
        Calendar c1 = Calendar.getInstance();
          // MONTH starts with 0 i.e. ( 0 - Jan)
        c1.set(Calendar.MONTH, 02);
        c1.set(Calendar.DATE, 30);
        c1.set(Calendar.YEAR, 2002);
  
       //  creating a date object with specified time.
        Date dateOne = c1.getTime();
        System.out.println("Date initially: " + dateOne);
        ff.setDat(dateOne);                  
			
		ff = (f) Customdate.handleCase(ff);
		System.out.println(ff.getDat());
		
		
	}
	private void setDat(Date dateOne) {
	   this.dat = dateOne;
	}
	public Date getDat() {
		return dat;
	}
	
}


