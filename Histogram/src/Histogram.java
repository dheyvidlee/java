import java.util.*;

public class Histogram {
	public static boolean debug = false;
	public static void main(String[] args){
		Random generateHist = new Random();
		int testSize = 10;
		debug = false;
		int[] testArea = new int[testSize];
		for(int i = 0; i < testSize; i++)
		{
			testArea[i] = generateHist.nextInt(10);
			System.out.println("size: " + testArea[i]);
		}
		System.out.println("Largest area is: " + getLargestArea(testArea));
		//int[] testArea2 =  {3, 5, 4, 7, 6, 5, 2};
		//System.out.println("Largest area is: " + getLargestArea(testArea2));
	}
	public static int getLargestArea(int[] histo){
		Stack indexTrack = new Stack();
		int maxSize = 0;
		for(int i = 0; i < histo.length; i++){
			while(!indexTrack.isEmpty() && histo[i] < histo[((Integer)indexTrack.peek()).intValue()])
			{
				int poppedIndex = ((Integer)indexTrack.pop()).intValue();
				if(debug)
					System.out.println("pop " + poppedIndex);
				int tempArea = 0;
				if(indexTrack.isEmpty())
					tempArea = histo[poppedIndex] * i;
				else
					tempArea = histo[poppedIndex] * (i - (((Integer)indexTrack.peek()).intValue()+1));
				if(debug){
					System.out.println("temp area debug: " + tempArea);
				}
				if(tempArea > maxSize)
					maxSize = tempArea;
			}
			if(debug)
				System.out.println("push " + i);
			indexTrack.push(new Integer(i));
		}
		while(!indexTrack.isEmpty())
		{
			int tempArea = 0;
			int poppedIndex = ((Integer)indexTrack.pop()).intValue();
			if(indexTrack.isEmpty())
				tempArea = histo[poppedIndex] * (histo.length);
			else
				tempArea = histo[poppedIndex] * (histo.length - (((Integer)indexTrack.peek()).intValue()+1));
			if(debug){
				System.out.println("temp area outside debug: " + tempArea);
				if(!indexTrack.isEmpty()){
					System.out.println("width " + (histo.length - ((Integer)indexTrack.peek()).intValue()));
					System.out.println("length " + histo.length);
					System.out.println("peek " + ((Integer)indexTrack.peek()).intValue());
					System.out.println("calculation " + (((Integer)indexTrack.peek()).intValue()));
				}
			}
			if(tempArea > maxSize)
				maxSize = tempArea;
		}
		return maxSize;
	}
}
