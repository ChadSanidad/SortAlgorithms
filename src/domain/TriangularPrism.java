package domain;

import adt.PrismADT;

/**
 * Polygon TriangularPrism class - extends prism, contains all of the methods required to create a polygon TriangularPrism.
 * Also contains the method to calculate the base area, and volume. 
 * @author 672749
 *
 */
public class TriangularPrism extends PrismADT
{

	public TriangularPrism(double height, double sideLength, char compareType)
	{
		super(height, sideLength, compareType);
	}

	@Override
	public double calcBaseArea() 
	{
		return (Math.pow(this.getSideLength(), 2) * Math.sqrt(3))/4;
	}

	@Override
	public double calcVolume() 
	{
		return (this.calcBaseArea() * this.getHeight());
	}

	@Override
	public String toString()
	{
		return "TriangularPrism - Height: " + getHeight() + " Side length " + getSideLength() + " Base Area: " + calcBaseArea() + " Volume: " + calcVolume(); 
	}
}
