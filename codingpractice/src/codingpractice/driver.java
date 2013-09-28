package codingpractice;
public class driver {
	public static void main(String[] args){
		stringmanipulation testset = new stringmanipulation();
		System.out.println(testset.unqiueChar(null));
		System.out.println(testset.unqiueChar(""));
		System.out.println(testset.unqiueChar("hello"));
		System.out.println(testset.unqiueChar("abcdefghijklmnopqrstuvwxyz"));
		
	}
}
