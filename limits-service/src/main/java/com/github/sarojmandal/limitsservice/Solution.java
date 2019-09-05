package com.github.sarojmandal.limitsservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	public static void main(String[] args) {
		solution(new int[] { 9, 1, 4, 9, 0, 4, 8, 9, 0, 1 });
	}

	public static int[] solution(int[] T) {
		// write your code in Java SE 8
		HashMap<Integer, Node> allNodes = new HashMap<>();
		int capital = Integer.MIN_VALUE;
		for (int index = 0; index < T.length; index++) {
			if (index == T[index]) {
				capital = index;
				continue;
			}
			if (allNodes.get(index) != null) {
				Node baseNode = allNodes.get(index);
				Node childNode = new Node(T[index]);
				if (allNodes.get(T[index]) != null) {
					childNode = allNodes.get(T[index]);
				} else {
					allNodes.put(T[index], childNode);
				}
				baseNode.addLinks(childNode);
				childNode.addLinks(baseNode);
			} else {
				Node baseNode = new Node(index);
				Node childNode = new Node(T[index]);
				if (allNodes.get(T[index]) != null) {
					childNode = allNodes.get(T[index]);
				} else {
					allNodes.put(T[index], childNode);
				}
				baseNode.addLinks(childNode);
				childNode.addLinks(baseNode);
				allNodes.put(index, baseNode);
			}
		}
		Node capNode = allNodes.get(capital);
		System.out.println(capNode);
		return new int[] {};
	}
}

class Node {
	public Node(int value) {
		this.value = value;
	}

	int value;
	List<Node> links;

	public void addLinks(Node node) {
		if (this.links == null) {
			links = new ArrayList<>();
		}
		links.add(node);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (value != other.value)
			return false;
		return true;
	}

}