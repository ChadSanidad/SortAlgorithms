package adt;

/**
 * Abstract data type prism - references the superclass polygon,
 * contains the lengths of the side of the prism.
 * @author 672749
 *
 */
public abstract class PrismADT extends Polygon 
{
	private double sideLength;

	public PrismADT(double height, double sideLength, char compareType) 
	{
		super(height, compareType);
		this.sideLength = sideLength;
	}
	
	public double getSideLength()
	{
		return this.sideLength;
	}
	
	public void setSideLength(double sideLength)
	{
		this.sideLength = sideLength;
	}
	
}
