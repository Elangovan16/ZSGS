package com.elangovan16.shape;

public class Triangle extends Shape {
	private double base;
	private double height;
	private double hypotenuse;

	Triangle() {
		
	}

	Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	Triangle(double base, double height, double hypotenuse) {
		this(base, height);
		this.hypotenuse=hypotenuse;
	}


	@Override
	public double calculateAera() {
		return (double) 1 / 2 * base * height;
	}

	@Override
	public double calculatePerimeter() {
		return base + height + hypotenuse;
	}

}
