package domain;

import adt.PrismADT;

/**
 * Polygon Pentagonal class - extends prism, contains all of the methods required to create a polygon PentagonalPrism.
 * Also contains the method to calculate the base area, and volume. 
 * @author 672749
 *
 */
public class PentagonalPrism extends PrismADT
{

	public PentagonalPrism(double height, double sideLength,  char compareType) 
	{
		super(height, sideLength,  compareType);
	}

	@Override
	public double calcBaseArea() 
	{
		return ((5*Math.pow(this.getSideLength(),2)* Math.tan(54))/4);
	}

	@Override
	public double calcVolume() 	
	{
		return (this.calcBaseArea() * this.getHeight());
	}
	
	@Override
	public String toString()
	{
		return "PentagonalPrism - Height: " + getHeight() + " Side length " + getSideLength() + " Base Area: " + calcBaseArea() + " Volume: " + calcVolume(); 
	}
}
