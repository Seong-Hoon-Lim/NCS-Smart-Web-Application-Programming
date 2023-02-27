package com.kudangtang.jvx330.di.example1;

public class Foo {
	private Bar bar;
	
	public Foo( ) {
		System.out.println("Foo() is called");
	}
		
	public Foo(Bar bar) {
		this.bar = bar;
	}
	
	public void setBar(Bar bar) {
		this.bar = bar;
	}
	
	public String getRelationship() {
		return "Foo associated with" + bar;
		
	}
	
	public static void main(String[] args) {
		Bar bar = new Bar();
		Foo foo = new Foo(bar);
		System.out.println(foo.getRelationship());
	}
}

