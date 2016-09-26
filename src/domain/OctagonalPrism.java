package domain;

import adt.PrismADT;

/**
 * Polygon octagonal class - extends prism, contains all of the methods required to create a polygon OctagonalPrism.
 * Also contains the method to calculate the base area, and volume. 
 * @author 672749
 *
 */
public class OctagonalPrism extends PrismADT
{

	public OctagonalPrism(double height,  double sideLength, char compareType) 
	{
		super(height, sideLength,compareType);
	}

	@Override
	public double calcBaseArea() 
	{
		return 2*(1+Math.sqrt(2))*Math.pow(this.getSideLength(), 2);
	}

	@Override
	public double calcVolume() 	
	{
		return (this.calcBaseArea() * this.getHeight());
	}
	
	@Override
	public String toString()
	{
		return "OctagonalPrism - Height: " + getHeight() + " Side length " + getSideLength() + " Base Area: " + calcBaseArea() + " Volume: " + calcVolume(); 
	}
}
