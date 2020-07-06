package com.jyami.ewhaAlgorithm;

import java.util.Scanner;

public class Epper1_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double radius, area;
		System.out.print("Enter the radius:");
		radius = in.nextFloat();
		area = radius*radius*Math.PI;
		System.out.print("The area is "+area);
	}
}
