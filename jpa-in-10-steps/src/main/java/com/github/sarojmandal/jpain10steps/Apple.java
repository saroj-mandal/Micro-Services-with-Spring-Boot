package com.github.sarojmandal.jpain10steps;

import java.util.HashMap;

public class Apple {
	private String color;
 
	public Apple(String color) {
		this.color = color;
	}
	
	private void show(String s,String as) {
		System.out.println(s+as);
	}
	
	private void show(String s,Object as) {
		System.out.println("oBJECT"+s+as);
	}
 
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if (!(obj instanceof Apple))
			return false;	
		if (obj == this)
			return true;
		return this.color.equals(((Apple) obj).color);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
 
	public static void main(String[] args) {
		Apple a1 = new Apple("green");
		Apple a2 = new Apple("red");
 
		//hashMap stores apple type and its quantity
		HashMap<Apple, Integer> m = new HashMap<Apple, Integer>();
		m.put(a1, 10);
		m.put(a2, 20);
		m.put(new Apple("green"), 20);
		System.out.println(m.get(new Apple("green")));
		a1.show("1", new StringBuffer("2"));
	}
}