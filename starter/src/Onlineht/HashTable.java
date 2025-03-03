package Onlineht;


import starter.newb;

public class HashTable<K, V> {
	private class HTPair {
		K key;
		V value;

		public HTPair(K key, V value) {
			// TODO Auto-generated constructor stub
			this.key = key;
			this.value = value;
		}

		public boolean equals(Object other) {
			HTPair t = (HTPair) other;
			return this.key.equals(t.key);
		}

		public String toString() {
			return "{" + this.key + "-" + this.value + "}";

		}

	}

	private LinkedList<HTPair> bucketArray[];
	private int size;
	private static final int default_capacity = 10;

	public HashTable() {
		// TODO Auto-generated constructor stub
		this(default_capacity);
	}

	public HashTable(int Capacity) {
		// TODO Auto-generated constructor stub
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[Capacity];
		this.size = 0;

	}

	public void put(K key, V value) throws Exception {
		int bi = hashfunction(key);
		HTPair pta = new HTPair(key, value);

		LinkedList<HashTable<K, V>.HTPair> bucket = this.bucketArray[bi];
		if (bucket == null) {
			bucket = new LinkedList<HTPair>();
			bucket.addLast(pta);
			this.size++;
			this.bucketArray[bi] = bucket;
		} else {
			int findAt = bucket.find(pta);
			if (findAt == -1) {
				bucket.addLast(pta);
				this.size++;
			} else {
				HTPair pair = bucket.getAt(findAt);
				pair.value = value;
			}
		}
		double lf=(this.size*1.0)/this.bucketArray.length;
		if(lf>=0.75) {
			rehash();
		}

	}

	private void rehash() throws Exception {
		// TODO Auto-generated method stub
		LinkedList<HTPair> oba[]=this.bucketArray;
		this.bucketArray=(LinkedList<HTPair>[])new LinkedList[this.bucketArray.length*2];
		for(LinkedList<HTPair> bucket:oba) {
			while(bucket!=null&&!bucket.isEmpty()) {
				HTPair pair=bucket.removeFirst();
				this.put(pair.key, pair.value);
				
				
			}
		}
		
	}

	private int hashfunction(K key) {
		// TODO Auto-generated method stub
		int a = key.hashCode();
		a = Math.abs(a);
		int bi = a % this.bucketArray.length;
		return bi;
	}

	public void display() {
		for (LinkedList<HTPair> bucket : this.bucketArray) {
			if (bucket != null && !bucket.isEmpty()) {
				bucket.display();
			} else {
				System.out.println("NULL");
			}
			System.out.println("==============================");
		}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	public V getValue(K key) throws Exception {
		HTPair ptf = new HTPair(key, null);
		int bi = hashfunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		if (bucket == null) {
			return null;

		} else {
			int findAt=bucket.find(ptf);
			if(findAt==-1) {
				return null;
			}else {
				HTPair pair=bucket.getAt(findAt);
				return pair.value;
			}
			
			
		}
	}
	public V remove(K Key) throws Exception {
		int bi=this.hashfunction(Key);
		HTPair ptr=new HTPair(Key,null);
		LinkedList<HTPair> bucket=this.bucketArray[bi];
		if(bucket==null) {
			return null;
		}else {
			int findAt=bucket.find(ptr);
			if(findAt==-1) {
				return null;
			}else {
				HTPair pair=bucket.getAt(findAt);
				V r=pair.value;
				bucket.removeAt(findAt);
				this.size--;
				return r;
			}
			
		}
		
	}

}