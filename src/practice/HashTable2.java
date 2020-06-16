package practice;

public class HashTable2<K, V> {
	
	private HashEntry<K, V>[] buckets;
	
	private static final int INITIAL_CAP = 16;
	
	private int size = 0;
	
	
	public HashTable2() {
		this(INITIAL_CAP);
	}
	public HashTable2(int cap) {
		this.buckets = new HashEntry[cap];
	}
	
	public void add(K key, V value) {
		HashEntry<K, V> entry = new HashEntry<>(key, value, null);
		
		int indx = key.hashCode() % this.INITIAL_CAP;
		
		HashEntry<K, V> existing = this.buckets[indx];
		
		if(existing == null) {
			this.buckets[indx] = entry;
			size ++;
		}
		else {
			while(existing.next != null) {
				if(existing.key.equals(key)) {
					existing.value = value;
					return;
				}
				existing = existing.next;
			}
			if(existing.key.equals(key)) {
				existing.value = value;
				
			}
			else {
				existing.next = entry;
				size++;
			}
		}
	}
	
	public V get(K key) {
		
		int indx = key.hashCode() % this.INITIAL_CAP;
		
		HashEntry<K, V> list = this.buckets[indx];
		
		while (list != null) {
			if(list.key.equals(key)) {
				
				return list.value;
			}
			list = list.next;
		}
		
		
		return null;
	}
	
	
	
	
}
