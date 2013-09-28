package codingpractice;
import java.util.HashMap;
import java.util.Iterator;
public class stringmanipulation {
	public stringmanipulation(){
		
	}
	
	public boolean unqiueChar(String input){
		if(input == null)
			return true;
		char[] table = new char[128];
		for(int i = 0; i < table.length;i++)
			table[i] = 0;
		for(int i = 0; i < input.length(); i++){
			if(table[input.charAt(i)] != 0)
				return false;
			else
				table[input.charAt(i)]++;
		}
		return true;
	}
}
