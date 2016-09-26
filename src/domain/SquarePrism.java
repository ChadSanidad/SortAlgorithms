package domain;

import adt.PrismADT;

/**
 * Polygon SQuarePrism class - extends prism, contains all of the methods required to create a polygon SQuarePrism.
 * Also contains the method to calculate the base area, and volume. 
 * @author 672749
 *
 */
public class SquarePrism  extends PrismADT
{
	public SquarePrism(double height, double sideLength,  char compareType) 
	{
		super(height, sideLength, compareType);
	}

	@Override
	public double calcBaseArea() 
	{
		return Math.pow(this.getSideLength(), 2);
	}

	@Override
	public double calcVolume() 
	{
		return Math.pow(this.getSideLength(), 2) * this.getHeight();
	}
	
	@Override
	public String toString()
	{
		return "SquarePrism - Height: " + getHeight() + " Side length " + getSideLength() + " Base Area: " + calcBaseArea() + " Volume: " + calcVolume(); 
	}
}
