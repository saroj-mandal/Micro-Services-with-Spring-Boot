package com.github.sarojmandal.jpahibernate.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test implements A, B {

	@Override
	public void method() {
		System.out.println("in Test.method");
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.method();
		test.method1();
		test.method2();
		A.staticMethod();
		B.staticMethod();
		C.staticMethod();
		List<String> li = new ArrayList<>();
		li.add("1");
		li.add("2");
		ImmutableClass cla = new ImmutableClass("Saroj", li);
		System.out.println(cla);
		cla.getList().add("3");
		System.out.println(cla);
	}
}

interface A {
	void method();

	static String staticMethod() {
		System.out.println("in A.staticMethod");
		return "A.staticMethod";
	}

}

interface B {
	void method();

	default int method2() {
		System.out.println("In method2 of B");
		return 2;
	}

	default int method1() {
		System.out.println("In method1 of B");
		return 1;
	}

	static String staticMethod() {
		System.out.println("in B.staticMethod");
		return "B.staticMethod";
	}

}

interface C extends A, B {

	@Override
	default int method1() {
		System.out.println("in C.method1");
		return B.super.method1();
	}

	static String staticMethod() {
		System.out.println("in C.staticMethod");
		return "C.staticMethod";
	}

}