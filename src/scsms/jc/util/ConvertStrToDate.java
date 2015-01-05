package scsms.jc.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class ConvertStrToDate {

	public ConvertStrToDate() {
		// TODO Auto-generated constructor stub
	}
	public static Date StringToDate(String dateStr,String formatStr){
		SimpleDateFormat sdf=new SimpleDateFormat(formatStr,Locale.CHINA);
		Date date=null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
