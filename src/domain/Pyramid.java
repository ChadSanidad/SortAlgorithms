package domain;

import adt.PrismADT;


/**
 * Polygon pyramid class - extends polygon, contains all of the methods required to create a polygon pyramid.
 * Also contains the method to calculate the base area, and volume. 
 * @author 672749
 *
 */
public class Pyramid extends PrismADT
{

	public Pyramid(double height,  double sideLength, char compareType) 
	{
		super(height, sideLength, compareType);
	}

	@Override
	public double calcBaseArea() {
		return Math.pow(this.getSideLength(), 2);
	}

	@Override
	public double calcVolume() {
		return ((double)1/3)*(this.calcBaseArea()*this.getHeight());
	}
	
	@Override
	public String toString() 
	{
		return "Pyramid - Height:" + this.getHeight() + " Area: " + this.calcBaseArea() + "volume: " + this.calcVolume();
	}


}
