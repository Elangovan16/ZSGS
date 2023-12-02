package com.elangovan16.shape;

import java.util.Scanner;

public class ShapeDemo {
	public static void main(String[] args) {
		ShapeDemo s = new ShapeDemo();
		s.start();
	}

	public void start() {
		Shape shape;
		int index;
		do {
			details();
			Scanner sc = new Scanner(System.in);
			index = sc.nextInt();
			switch (index) {
				case 1 -> {
					System.out.println("Enter Square Side :");
					int side=sc.nextInt();
					shape=new Square(side);
					System.out.println("Square Aera : "+shape.calculateAera());
					System.out.println("Square Perimeter : "+shape.calculatePerimeter()+"\n");
				}
				case 2->{
					System.out.println("Enter Rectangle Length :");
					int length=sc.nextInt();
					System.out.println("Enter Rectangle Width :");
					int width=sc.nextInt();
					shape=new Rectangle(length,width);
					System.out.println("Rectangle Aera : "+shape.calculateAera());
					System.out.println("Rectangle Perimeter : "+shape.calculatePerimeter()+"\n");
				}
				case 3->{
					System.out.println("Enter Triangle Base :");
					int base=sc.nextInt();
					System.out.println("Enter Triangle Height :");
					int height=sc.nextInt();
					System.out.println("Enter Triangle Hypotenuse : ");
					int hypotenuse=sc.nextInt();
					shape=new Triangle(base,height,hypotenuse);
					System.out.println("Triangle Aera : "+shape.calculateAera());
					System.out.println("Triangle Perimeter : "+shape.calculatePerimeter()+"\n");
				}
				case 0->{
					System.out.println("ThankYou for using shapeDemo.");
					sc.close();
				}
				default->{
					System.out.println("Invalid choice. Please Enter Valid Choice.");
				}
			}
		} while (index != 0);
	}

	public void details() {
		System.out.println("1) Create square object");
		System.out.println("2) Create Rectangle object");
		System.out.println("3) Create Triangle object");
		System.out.println("0) Exit...");
		System.out.println("Enter your choice");
	}
}
