package domain;

import java.math.*;

import adt.Polygon;


/**
 * Polygon cylinder class - extends polygon, contains all of the methods required to create a polygon cylinder.
 * Also contains the method to calculate the base area, and volume. 
 * @author 672749
 *
 */
public class Cylinder extends Polygon
{
	private double radius;

	
	public Cylinder(double height,  double radius, char compareType) 
	{
		super(height, compareType);
		this.radius = radius;
	}


	@Override
	public double calcBaseArea() 
	{
		double baseArea = 0;
		baseArea = Math.PI * Math.pow(radius, 2);
		return baseArea;
	}

	@Override
	public double calcVolume() 
	{
		double volume = 0;
		volume =  Math.PI * Math.pow(radius, 2) * this.getHeight(); 
		return volume;
		
	}

	@Override
	public String toString() 
	{
		return "Cylinder - Height:" + this.getHeight() + " Area: " + this.calcBaseArea() + "volume: " + this.calcVolume();
	}

}
