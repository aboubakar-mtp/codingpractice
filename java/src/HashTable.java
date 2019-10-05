import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HashTable {
	
	LinkedList<HashObject>[] hashList;
	int size;
	
	public HashTable(int sz) {
		this.size = sz;
		
		this.hashList = new LinkedList [this.size];
	}
	
	public int add(String key, String value) {
		int indx = key.hashCode() % this.size;
		HashObject ho = new HashObject(key, value);
		
		if(this.hashList[indx] == null) {
			this.hashList[indx] = new LinkedList<>();
		}
		
		this.hashList[indx].add(ho);
		
		return indx;
	}
	
	public String get(String key) {
		String found = null;
		int indx = key.hashCode() % this.size;
		HashObject ho = null;
		Iterator<HashObject> iter;
		
		if(this.hashList[indx] != null) {
			
			iter = this.hashList[indx].iterator();
			
			while(iter.hasNext()) {
				ho = iter.next();
				if(ho.getKey().equals(key)) {
					found = ho.getValue();
				}
			}
		}
		
		return found;
	}

}
