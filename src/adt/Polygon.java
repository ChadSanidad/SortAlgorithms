package adt;

/**
 * Polygon ADT - contains the values, height, type that the subclass will contain and any methods to be overridden. 
 * 
 * Implements the compareTo() method for use with the sorting algorithms.
 * @author 672749
 *
 */
public abstract class Polygon implements Comparable<Polygon>
{
	private double height;
	private char compareType;
	
	public Polygon(double height, char compareType) 
	{
		this.height = height;
		this.compareType = compareType;
	}

	public double getHeight()
	{
		return this.height;
	}
	
	public void setHeight(double height)
	{
		this.height = height;
	}
	/*
	 * Compare type will be provided as input to the program
	 * -h height
	 * -v volume
	 * -a for base area
	 */
	public char getCompareType()
	{
		return this.compareType;
	}
	
	public void setCompareType(char compareType)
	{
		this.compareType = compareType;
	}
	
	public abstract double calcBaseArea();
	
	public abstract double calcVolume();
	

	
	public String toString()
	{
		return this.toString();
	}
 
	public int compareTo(Polygon polygon)
	{
		char compareType = this.getCompareType();
		int compareNum = 0;
		switch(compareType)
		{
			case 'v': // volume
				compareNum =  (int) (this.calcVolume() - ((Polygon) polygon).calcVolume());
				break;
			case 'a': // base area
				compareNum =  (int) (this.calcBaseArea() - ((Polygon) polygon).calcBaseArea());
				break;
			case 'h': //height
				compareNum =  (int) (this.getHeight() - ((Polygon) polygon).getHeight());
				break;
			default: // if not a, h, or v
				System.out.println("The default comparison type is not v, a, or h");
				System.exit(0);
				break;
		}
		return compareNum;
	}
}
