package Onlineht;

import Onlineht.HashTable;

public class client {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	HashTable<String, Integer> map = new HashTable<>(5);
	map.put("India", 300);
	map.put("Aus", 200);
	map.put("China", 350);
	map.put("Nepal", 40);
	map.put("Russia", 150);
	map.put("Pak", 430);
	map.put("SL", 300);
	map.put("SF", 200);
	map.put("Denmark", 350);
	map.put("Switerland", 40);
	map.put("New zealand", 150);
	map.put("Afganishtan", 430);
	map.put("bankok", 70);

		map.display();
//		System.out.println(map.getValue("India"));
		System.out.println(map.remove("Pak"));
		map.display();
	

	}
}
