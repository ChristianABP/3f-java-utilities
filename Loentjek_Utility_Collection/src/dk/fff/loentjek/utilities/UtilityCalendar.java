package dk.fff.loentjek.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.joda.time.Days;
import org.joda.time.LocalDate;
//import org.joda.time.Months;
//import org.joda.time.Years;
import org.joda.time.LocalDateTime;

public class UtilityCalendar {

    public static final String TIMEZONE_ID = "GMT"; // "Etc/GMT-1";

    public static final String TIMEZONE_FOR_OFFSET_ID = "Europe/London"; // "Europe/Copenhagen";

    public static final TimeZone getDanishTimeZone() {
        return TimeZone.getTimeZone(TIMEZONE_FOR_OFFSET_ID);
    }

    public static final TimeZone getApplicationTimeZone() {
        return TimeZone.getTimeZone(TIMEZONE_ID);
    }

    public static Date parseDate(String s) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy.MM.dd").parse(s);
        return date1;
    }
    
    /*
    public static boolean dateInValidPeriod(Date requestDate, Date earliestDate, Date latestDate) {

        if (requestDate.after(earliestDate) && requestDate.before(latestDate)) {
            // System.out.println("Request date is in period: returns true");
            return true;
        } else {
            // System.out.println("Request date is NOT in period: returns false");
            return false;
        }
    }
    */

    public ArrayList<Date> sortlistOfDates(ArrayList<Date> dateList) {
        if (dateList.size() > 0) {
            Collections.sort(dateList);
            return dateList;
        } else {
            System.out.println("Error in sortListOfDates method: The array is empty");
        }
        return new ArrayList<Date>();
    }
    
    public static int retrieveYear(Date date) {
        if (date == null) {
            return -1;
        } else {
            LocalDateTime dt;
            dt = new LocalDateTime(date);
            return dt.getYear();
        }
    }

    public static int retrieveMonth(Date date) {
        if (date == null) {
            return -1;
        } else {
            LocalDateTime dt;
            dt = new LocalDateTime(date);
            return dt.getMonthOfYear();
        }
    }

    public static int retrieveDay(Date date) {
        if (date == null) {
            return -1;
        } else {
            LocalDateTime dt;
            dt = new LocalDateTime(date);
            return dt.getDayOfMonth();
        }
    }


    public static Date setDate(Date date, int day, int month, int year) {
        if (date == null) {
            return null;
        } else {
            Calendar cal = new GregorianCalendar(getApplicationTimeZone());
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_MONTH, day);
            cal.set(Calendar.MONTH, month - 1);
            cal.set(Calendar.YEAR, year);
            return cal.getTime();
        }
    }
    
    /*
    public static Date oldModifyYears(Date date, int years) {
        if (date == null) {
            return null;
        } else {
            Calendar cal = new GregorianCalendar(getApplicationTimeZone());
            cal.setTime(date);
            cal.add(Calendar.YEAR, years);
            return cal.getTime();
        }
    }
    
    
    public static Date oldModifyMonths(Date date, int months) {
        if (date == null) {
            return null;
        } else {
            Calendar cal = new GregorianCalendar(getApplicationTimeZone());
            cal.setTime(date);
            cal.add(Calendar.MONTH, months);
            return cal.getTime();
        }
    }
    
    public static Date modifyDays(Date date, int days) {
        if (date == null) {
            return null;
        } else {
            Calendar cal = new GregorianCalendar(getApplicationTimeZone());
            cal.setTime(date);
            cal.add(Calendar.DATE, days);
            return cal.getTime();
        }
    }
    */
    
    public static Date modifyYears(Date date, int years) {
   	 if (date == null) {
      	System.err.println("modifyMonths method received invalid input: Date cannot be empty or null");
          return date;
      }
	     //Default time zone id
	  	ZoneId defaultZoneId = ZoneId.systemDefault();
	  	java.time.LocalDate localDate = date.toInstant().atZone(defaultZoneId).toLocalDate();
	  	localDate = localDate.plusYears(years);
	  	Date result = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
	  	return result;
    }
    
    
    public static Date modifyMonths(Date date, int months) {
    	 if (date == null) {
         	System.err.println("modifyMonths method received invalid input: Date cannot be empty or null");
             return date;
         }
        //Default time zone id
     	ZoneId defaultZoneId = ZoneId.systemDefault();
     	java.time.LocalDate localDate = date.toInstant().atZone(defaultZoneId).toLocalDate();
     	localDate = localDate.plusMonths(months);
     	Date result = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
     	return result;
    }

    public static Date modifyDays(Date date, int days) {
	   	 if (date == null) {
	      	System.err.println("modifyMonths method received invalid input: Date cannot be empty or null");
	          return date;
	      }
	     //Default time zone id
	  	ZoneId defaultZoneId = ZoneId.systemDefault();
	  	java.time.LocalDate localDate = date.toInstant().atZone(defaultZoneId).toLocalDate();
	  	localDate = localDate.plusDays(days);
	  	Date result = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
	  	return result;
    }
    

    public static boolean beforeOrEqualDates(Date date1, Date date2) {
        if (date1.before(date2) || date1.equals(date2)) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean afterOrEqualDates(Date date1, Date date2) {
        if (date1.after(date2) || date1.equals(date2)) {
            return true;
        } else {
            return false;
        }

    }
    
    public static int numOfYearsBetweenDates(Date date1, Date date2) {
    	if (date1 == null || date2 == null) {
    		System.err.println("numOfYearsBetweenDates method received invalid input: Dates cannot be empty or null");
    		return -1;
    	}
	    	Calendar a = Calendar.getInstance();
	    	a.setTime(date1);
	    	Calendar b = Calendar.getInstance();
	    	b.setTime(date2);
	    	int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
	    	if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH)
	    	|| (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.getTime().after(b.getTime()))) {
	    	diff--;
    	}
    	return diff;
    }

    public static int numOfMonthsBetweenDates(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
        	System.err.println("numOfMonthsBetweenDates method received invalid input: Dates cannot be empty or null");
            return -1;
        }
        Calendar cal = Calendar.getInstance();

        cal.setTime(date1);
        int Month1 = 12 * cal.get(Calendar.YEAR) + cal.get(Calendar.MONTH);
        cal.setTime(date2);
        int Month2 = 12 * cal.get(Calendar.YEAR) + cal.get(Calendar.MONTH);

        return java.lang.Math.abs(Month2 - Month1);
    }
    
    public static int numOfDaysBetweenDates(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            System.err.println("numOfDaysBetweenDates method received invalid input: Dates cannot be empty or null");
            return -1;
        }
        return Days.daysBetween(new LocalDate(date1.getTime()), new LocalDate(date2.getTime())).getDays();
        
    }

    public static int convertYearsToMonths(int years) {
        if (years < 0) {
            System.err.println("convertYearsToMonths method received invalid input: Years must be greater than 0");
            return -1;
        }
        int result = years * 12;
        return result;
    }
    
    public static int convertYearsToDays(int years) {
        if (years < 0) {
            System.err.println("convertYearsToDays method received invalid input: Years must be greater than 0");
            return -1;
        }
        Calendar cal = Calendar.getInstance();
        int result = cal.getActualMaximum(Calendar.DAY_OF_YEAR) * years;
        return result;
    }
    
    public static int convertMonthsToDays(int months) {
        if (months < 0) {
            System.err.println("convertMonthsToDays method received invalid input: Years must be greater than 0");
            return -1;
        }
        Calendar cal = Calendar.getInstance();
        int result = months / cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        return result;
    }
    
    // This should just be between two dates NOT a fixed date.
    public static int convertYearsToDaysFromBirthDate(Date birthDate, int years) {
        if (years < 0 ) {
            System.err.println("convertYearsToDaysWithBirthDate method received invalid input: Years must be greater than 0");
            return -1;
        }
        if (birthDate == null ) {
            System.err.println("convertYearsToDaysWithBirthDate method received invalid input: birthDate is required");
            return -1;
        }
        //Get the number of days between birth date and number of years
        Date endDate = UtilityCalendar.modifyYears(birthDate, years);
        int result = UtilityCalendar.numOfDaysBetweenDates(birthDate, endDate);
        return result;
    }
    
    public static ArrayList<Integer> getRequestYearsAsList(Date requestStartDate, Date requestEndDate) {
    	ArrayList<Integer> requestYears = new ArrayList<Integer>();
    	int numOfYears = UtilityCalendar.numOfYearsBetweenDates(requestStartDate, requestEndDate);
    	for (int i = 0; i < numOfYears; i++) {
    		//We need to start from 1 as 0 represents the requestStartDate year
    		requestYears.add(i+1);
    	}
    	System.out.println(requestYears);
    	return requestYears;
    }
    
}
