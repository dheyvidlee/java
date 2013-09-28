import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap< K, V> {
	private int capacity;
	public LRUCache(){
		capacity = 5;
	}
	public LRUCache(int capacity){
		super(capacity+1, 1.0f, true);
		this.capacity = capacity;
	}
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
		return (size() > this.capacity);
	}
}
