package Outco_DS3_HashTable;

import java.util.Iterator;

// key must be unique in hash table.
// storing key as  int(age) value as string(name) 

// Time Comp for insert, delete, retrieve is O(1) if hash function distribute objects evenly
// else O(n)

// space Comp: O(n)

public class HashMapImpl {

	public static KeyValueObjectList[] array;
	public static int numOfKeyValuePairs;
	public static int numOfBuckets;

	// this constructor is used when object is created for this class.
	public HashMapImpl() {
		constructHashMap();
		numOfBuckets = array.length;
	}

	public static void main(String[] args) {
		constructHashMap();
		numOfBuckets = array.length;

		//System.out.println(hashFunction(66));
		KeyValueObject kvpair = new KeyValueObject(24,"sravya");
		insert(kvpair);
		
		KeyValueObject kvpair1 = new KeyValueObject(30,"vineel");
		insert(kvpair1);
		
		KeyValueObject kvpair2 = new KeyValueObject(29,"divya");
		insert(kvpair2);
		
		KeyValueObject kvpair3 = new KeyValueObject(27,"srikanya");
		insert(kvpair3);
		
		KeyValueObject kvpair4 = new KeyValueObject(60,"satya");
		insert(kvpair4);
		
		KeyValueObject kvpair5 = new KeyValueObject(55,"sailaja");
		insert(kvpair5);
		
		KeyValueObject kvpair6 = new KeyValueObject(66,"anji");
		insert(kvpair6);
		
		KeyValueObject kvpair7 = new KeyValueObject(62,"getha");
		insert(kvpair7);
		
		KeyValueObject kvpair8 = new KeyValueObject(64,"venkay");
		insert(kvpair8);
		
		KeyValueObject kvpair9 = new KeyValueObject(63,"lakshmi");
		insert(kvpair9);
		
		KeyValueObject kvpair10 = new KeyValueObject(59,"kuma");
		insert(kvpair10);
		
		System.out.println(retrieve(24));
		System.out.println(retrieve(30));
		System.out.println(retrieve(29));
		System.out.println(retrieve(27));
		System.out.println(retrieve(60));
		System.out.println(retrieve(55));
	
		System.out.println(retrieve(66));
		System.out.println(retrieve(62));
		System.out.println(retrieve(64));
		System.out.println(retrieve(63));
		System.out.println(retrieve(59));
		
		remove(59);
		
		System.out.println(retrieve(59));
		

	}

	private static void remove(int key) {
		int hash = hashFunction(key);
		KeyValueObjectList list = array[hash];
		Iterator<KeyValueObject> it = list.getList().iterator();
		while(it.hasNext()){
			KeyValueObject kv = it.next();
			if(kv.getKey() == key){
				list.getList().remove(kv);
				 numOfKeyValuePairs -- ;
			}
		}
		
		
	}

	private static String retrieve(int key) {
		int hash = hashFunction(key);
		KeyValueObjectList list = array[hash];
		Iterator<KeyValueObject> it = list.getList().iterator();
		while(it.hasNext()){
			KeyValueObject kv = it.next();
			if(kv.getKey() == key){
				return kv.getValue();
			}
		}
		return "no key";
		
	}

	private static void insert(KeyValueObject kvpair) {
		boolean lock = true;
		int key = kvpair.getKey();
		numOfKeyValuePairs ++;
		
		if(loadFactor() >= 0.75){
			System.out.println("resizing start");
			resize();
			System.out.println("resizing ends");
		}
		
		int hash = hashFunction(key);
		KeyValueObjectList list = array[hash];
		Iterator<KeyValueObject> iterator = list.getList().iterator();
		while(iterator.hasNext()){
			KeyValueObject kv = iterator.next();
			if(kv.getKey() == key){
				kv.setValue(kvpair.getValue());
				lock = false;
			}
		}
		if(lock){
			list.getList().add(kvpair);
		}
		return;
	}

	// 97 is largest prime number under 100
	public static int hashFunction(int key) {
		return (key % 97) % array.length;
	}

	public static double loadFactor() {
		return ((double) numOfKeyValuePairs) / array.length;
	}

	private static void resize() {
		int currentSize = array.length;
		System.out.println("current array size is " +currentSize);
		
		KeyValueObjectList[] oldArray = array;
		// creating tempArray with double the size of current array
		KeyValueObjectList[] newArray;
		newArray = new KeyValueObjectList[currentSize * 2];
		System.out.println("new Array size is " + newArray.length);
		
		// initializing new created array with linked lists..
		constructDynamicArray(newArray);
		
		System.out.println("now array size is " + array.length);
		
	    // going through all the old key value pairs in old array(array) and inserting them in new array
		// (tempArray)
		
		for (int i = 0; i < oldArray.length; i++) {
			KeyValueObjectList list = oldArray[i];
			Iterator<KeyValueObject> it = list.getList().iterator();
			while(it.hasNext()){
				KeyValueObject kv = it.next();
				System.out.println("inserting into new array");
				insert(kv);
			}
		}

		// need to copy all values from old hash map..

	}

	private static void constructDynamicArray(KeyValueObjectList[] newArray) {
		System.out.println("constructing new array");
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = new KeyValueObjectList();
		}
		array = newArray;
		
	}

	private static void constructHashMap() {

		array = new KeyValueObjectList[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = new KeyValueObjectList();
		}

	}

	public static KeyValueObjectList[] getArray() {
		return array;
	}

	public static void setArray(KeyValueObjectList[] array) {
		HashMapImpl.array = array;
	}

	public static int getNumOfKeyValuePairs() {
		return numOfKeyValuePairs;
	}

	public static void setNumOfKeyValuePairs(int numOfKeyValuePairs) {
		HashMapImpl.numOfKeyValuePairs = numOfKeyValuePairs;
	}

	public static int getNumOfBuckets() {
		return numOfBuckets;
	}

	public static void setNumOfBuckets(int numOfBuckets) {
		HashMapImpl.numOfBuckets = numOfBuckets;
	}

	// return key % prime number or
	// Look for FNV hash function on internet in java

	// refer to ouco datastructure 3 lecture on FNV hash function and ..
	// http://www.java2s.com/Code/Java/Development-Class/FNVHash.htm

	/*
	 * public static int hashFunction64(int key){ String keyString =
	 * String.valueOf(key);
	 * 
	 * long FNV_64_INIT = 0xcbf29ce484222325L; long FNV_64_PRIME =
	 * 0x100000001b3L;
	 * 
	 * int length = keyString.length(); for(int i = 0; i < length; i ++){
	 * FNV_64_INIT = FNV_64_INIT ^ keyString.charAt(i); FNV_64_INIT =
	 * (FNV_64_INIT * FNV_64_PRIME); } return (int) (FNV_64_INIT %
	 * numOfBuckets);
	 * 
	 * }
	 */
}
