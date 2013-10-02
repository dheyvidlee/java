package utility;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class dateUtility {
	private int month;
	private int year;
	private Date date;
	private Calendar calendar;
	private  String[] strDays = new String[] {
      "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    };
	private int[] firstDayOfMonth = new int[12];
	private int[] lengthOfMonth = new int[12];
	
	public dateUtility(){
		date = new Date();
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		month = calendar.get(Calendar.MONTH);
		year = calendar.get(Calendar.YEAR);
	}
	public dateUtility(boolean calculateAll){
		calendar = Calendar.getInstance();
		this.year = calendar.get(Calendar.YEAR);
		this.month = calendar.get(Calendar.MONTH);
		date = new Date();
		//calculate firstday of each Month
		//calculate length of each month
		if(calculateAll)
			for(int i = 0; i < lengthOfMonth.length;i++){
				calendar.set(Calendar.MONTH, i);
				calendar.set(Calendar.DAY_OF_MONTH, 1);
				lengthOfMonth[i] = getDaysInMonth();
				firstDayOfMonth[i] = getFirstDay();
			}
		calendar.setTime(date);
	}
	
	public boolean setMonth(int newMonth){
		calendar.set(Calendar.MONTH, newMonth);
		month = newMonth;
		return true;
	}
	public boolean setYear(int newYear){
		calendar.set(Calendar.YEAR, newYear);
		year = newYear;
		for(int i = 0; i < lengthOfMonth.length;i++){
			calendar.set(Calendar.MONTH, i);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			lengthOfMonth[i] = getDaysInMonth();
			firstDayOfMonth[i] = getFirstDay();
		}
		return true;
	}
	public boolean setDate(Date newDate){
		date = newDate;
		calendar.setTime(newDate);
		return true;
	}
	public int getMonth(){
		return month;
	}
	public int getYear(){
		return year;
	}
	public String getWeekday(){
		String weekday = "";
		weekday = new SimpleDateFormat("EEEE").format(date);
		return weekday;
	}
	public String getStringMonth(){
		String month = "";
		month = new SimpleDateFormat("MMMM").format(date);
		return month;
	}
	public String getFirstStringDay(){
		return strDays[getFirstDay()-1];
	}
	public int getFirstDay(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getYear());
		cal.set(Calendar.MONTH, getMonth());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.get(Calendar.DAY_OF_WEEK);
	}
	public void showDate(){
		System.out.println("Month " + getMonth());
		System.out.println("Year " + getYear());
	}
	public int getDaysInMonth(){
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	public int getPreviousMonthMax(){
		if(getMonth() == 0){
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, year-1);
			cal.set(Calendar.MONTH, 11);
			return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		}
		return lengthOfMonth[getMonth()-1];
	}
}
