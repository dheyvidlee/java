import java.util.*;

public class index {
	private static ArrayList<String> set = new ArrayList<String>();
	public static void main(String[] args){
		permutation("eeper");
		Collections.sort(set);
		Iterator it = set.iterator();
		int count = 1;
		String temp = "";
		while(it.hasNext()){
			System.out.println("index: " + count);
			temp = (String)it.next();
			System.out.println("string " + temp);
			count++;
			if(temp.equals("eeper"))
				break;
			temp = "";			
		}
		System.out.println(set.indexOf("eeper"));
	}
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) set.add(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}

}
