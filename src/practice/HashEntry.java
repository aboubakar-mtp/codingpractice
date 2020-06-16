package practice;

public class HashEntry<K, V> {
	final K key;
	V value;
	HashEntry<K, V> next;
	public HashEntry(K key, V value, HashEntry<K, V> next) {
		super();
		this.key = key;
		this.value = value;
		this.next = next;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public HashEntry<K, V> getNext() {
		return next;
	}
	public void setNext(HashEntry<K, V> next) {
		this.next = next;
	}
	public K getKey() {
		return key;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashEntry other = (HashEntry) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
	
	
}
