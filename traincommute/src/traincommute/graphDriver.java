package traincommute;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class graphDriver {
	static Graph trainPath;
	public static void distanceTest(String path){
		int distance = trainPath.findDistance(path);
		if(distance == 0)
			System.out.println(path + ": No such route");
		else
			System.out.println(path + ": " + distance);
	}
	public static void main(String args[]){
		trainPath = new Graph();
		String regex = "([A-Za-z])([A-Za-z])([0-9])";
		Pattern p = Pattern.compile(regex);
		for(int i = 0; i < args.length; i++){
			Matcher m = p.matcher(args[i]);
			while(m.find()){
				//System.out.println(m.group());
				trainPath.add(m.group().toUpperCase());
			}
		}
		//trainPath.print();
		distanceTest("ABC");
		distanceTest("AD");
		distanceTest("ADC");
		distanceTest("AEBCD");
		distanceTest("AED");
		System.out.println("C to C: " + trainPath.tripsWithStops("C", "C", 3, false));
		System.out.println("A to C: " + trainPath.tripsWithStops("A", "C", 4, true));
		System.out.println("A to C: " + trainPath.shortestRoute("A", "C"));
		System.out.println("B to B: " + trainPath.shortestRoute("B", "B"));
		System.out.println("C to C: " + trainPath.tripsMaxDistance("C", "C", 30));
		System.out.println();
	}
}
