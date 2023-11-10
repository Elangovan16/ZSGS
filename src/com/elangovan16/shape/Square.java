package com.elangovan16.shape;

public class Square extends Shape{
	private double side;
	Square(){
		
	}
	Square(double side){
		this.side=side;
	}

	@Override
	public double calculateAera() {	
		return side*side;
	}
	@Override
	public double calculatePerimeter() {
		return 4*side;
	}
	
}
