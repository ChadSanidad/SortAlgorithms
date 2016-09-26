package domain;

import adt.Polygon;

/**
 * Polygon cone class - extends polygon, contains all of the methods required to create a polygon clone.
 * Also contains the method to calculate the base area, and volume. 
 * @author 672749
 *
 */
public class Cone extends Polygon 
{
	private double radius; 

	public Cone(double height,  double radius, char compareType)
	{
		super(height, compareType);
		this.radius = radius;
	}
	
	public void setRadius()
	{
		this.radius = radius;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	@Override
	public double calcBaseArea()
	{
		double baseArea = 0;
		baseArea = Math.PI * Math.pow(getRadius(), 2);
		return baseArea;
	}

	@Override
	public double calcVolume()
	{
		double volume;
		
		volume = ((double)1/3) * Math.PI * Math.pow(getRadius(), 2) * getHeight(); 
		return volume;
	}
	

	@Override
	public String toString()
	{
		return "Cone -" + "Height: " + getHeight() + " Radius: " + getRadius() + " Base Area: " + calcBaseArea() + " volume: " + calcVolume();
	}
	
}
