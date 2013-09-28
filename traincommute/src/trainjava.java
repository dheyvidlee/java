import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class trainjava {
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
		String input = "";
		if(args.length != 1){
			System.out.println("incorrect number of arguments. requires one file argument for graph edges");
			System.exit(1);
		}
		else{
			try {
				BufferedReader reader = new BufferedReader(new FileReader(args[0]));
				input = reader.readLine();
				reader.close();
			} catch (FileNotFoundException e) {
				System.out.println("File not found.");
				System.exit(1);
			} catch (IOException e) {
				System.out.println("Error reading file.");
				System.exit(1);
			}
			
		}
		for(int i = 0; i < args.length; i++){
			Matcher m = p.matcher(input);
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
		System.out.println("C to C: " + trainPath.tripsWithStops("c", "c", 3, false));
		System.out.println("A to C: " + trainPath.tripsWithStops("a", "c", 4, true));
		System.out.println("A to C: " + trainPath.shortestRoute("a", "c"));
		System.out.println("B to B: " + trainPath.shortestRoute("b", "b"));
		System.out.println("C to C: " + trainPath.tripsMaxDistance("c", "c", 30));
		System.out.println();
	}
}
