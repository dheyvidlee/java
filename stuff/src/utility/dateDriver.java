package utility;


public class dateDriver {
	public static void main(String args[]){
		dateUtility du = new dateUtility();
		du.showDate();
		System.out.println(du.getFirstDay());
		System.out.println(du.getWeekday());
		System.out.println(du.getDaysInMonth());
		System.out.println();
		System.out.println("loop");
		du.setYear(2013);
		for(int i = 0; i < 12; i++){
			du.setMonth(i);
			System.out.println(du.getDaysInMonth());
			System.out.println(du.getFirstDay());
		}
		int max = 1;
		for(int i =0; i < max;i++)
			System.out.println("loop");
	}
}
