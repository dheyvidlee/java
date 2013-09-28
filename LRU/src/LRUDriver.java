import java.util.Iterator;

public class LRUDriver {
	public static void main(String[] args){
		LRUCache<Integer, String> cache = new LRUCache<Integer, String>(5);
		for(int i =0; i<5;i++){
			cache.put(new Integer(i), ""+i);
		}
		//System.out.println(cache.size());
		cache.get(new Integer(0));
		cache.put(new Integer(5), "5");
		Iterator<String> it = cache.values().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
