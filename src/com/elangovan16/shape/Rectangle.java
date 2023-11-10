package com.elangovan16.shape;

public class Rectangle extends Shape {
	private double length;
	private double width;

	Rectangle() {
	}

	Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	public double calculateAera() {
		return length * width;
	}

	@Override
	public double calculatePerimeter() {
		return 2 * (length + width);
	}
}
