package app;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import Utillities.UtilityClass;
import adt.Polygon;

/**
 * Sorting class, will be the runnable file to create the program, running the program will take the following arguments from the program
 * as filetype, comparetype, and sort type
 *
 *The read method will read the objects from the file and give all of those objects the comparetype specified. 
 *The program will then use the sorting type to determine the type of sorting to be used during the run and print out the running times of the program. 
 */
public class sort 
{
	static char compareType = 0;
	static char sortType = 0;
	static String fileName = "";


	public static void main(String[] args) 
	{
		if(args.length < 3 || args.length>3 )
		{
			throw new IllegalArgumentException("Error: must have 3 arguments to specify file, comparison, sorting algorithm");
		}
		grabArguments(args);
		UtilityClass uc = new UtilityClass();
		Polygon[] polygons = readFile(fileName);
		long runTime,start,stop;
		switch(sortType)
		{
			case 'b': // bubble
				System.out.println("Bubble sort selected, please wait...");
				start = System.currentTimeMillis();
				uc.bubbleSort(polygons);
				stop = System.currentTimeMillis();
				runTime = stop - start; 
				System.out.println("Bubble Runtime: " +  runTime);
				break;
			case 's': //selection
				System.out.println("Selection sort selected, please wait...");
				start = System.currentTimeMillis();
				uc.selectionSort(polygons);
				stop = System.currentTimeMillis();
				runTime = stop - start; 
				System.out.println("Selection Runtime: " +  runTime);
				break;
			case 'i': //insertion
				System.out.println("Insertion sort selected, please wait...");
				start = System.currentTimeMillis();
				uc.insertionSort(polygons);
				stop = System.currentTimeMillis();
				runTime = stop - start; 
				System.out.println("Insertion Runtime: " +  runTime);
				break;
			case 'm':
				System.out.println("Merge sort selected, please wait...");
				start = System.currentTimeMillis();
				uc.startMergeSort(polygons);
				stop = System.currentTimeMillis();
				runTime = stop - start; 
				System.out.println("Merge Runtime: " +  runTime);
				break;
			case 'q':
				System.out.println("Quick sort selected, please wait...");
				start = System.currentTimeMillis();
				uc.quickSort(polygons);
				stop = System.currentTimeMillis();
				runTime = stop - start; 
				System.out.println("Quick Runtime: " +  runTime);
				break;
			case 'z':
				System.out.println("Shell sort selected, please wait...");
				start = System.currentTimeMillis();
				uc.shellSort(polygons);
				stop = System.currentTimeMillis();
				runTime = stop - start; 
				System.out.println("Shell Runtime: " +  runTime);
				break;
			default:
				System.out.println("Error, wrong sort selected.");
		}
	}
	public static void grabArguments(String[] args)
	{
		for(int i=0; i < args.length; i++)
		{
			String checkArg = args[i].toLowerCase();
			if(checkArg.contains("-f"))
			{
				fileName = checkArg.substring(2, checkArg.length());
			}
			else if(checkArg.contains("-t"))
			{
				compareType = checkArg.charAt(2);
			}
			else if(checkArg.contains("-s"))
			{
				sortType = checkArg.charAt(2);
			}
			
		}
		System.out.println(fileName + " " + compareType + " " + sortType);
	}
	
	public static Polygon[] readFile(String filename)
	{
		int count; 
		String sb = null; 
		Polygon[] polygons = null;
		File file = new File("res/" + fileName);
			Scanner sc = null;
			try 
			{
				sc = new Scanner(file);
			} catch (FileNotFoundException e1) 
			{	
				e1.printStackTrace();
			}
			sc.useDelimiter(" ");
			count = Integer.parseInt(sc.next());
			polygons = new Polygon[count];
			for(int i=0; i < count; i++)
			{
				sb = sc.next();
				String className = "domain."+sb.toString(); 
				
				Class cls = null;
				try {
					cls = Class.forName(className);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
				
				Class paramTypes[] = new Class[3];
				
				paramTypes[0] = Double.TYPE;
				paramTypes[1] = Double.TYPE;
				paramTypes[2] = Character.TYPE;
				
				Constructor ct = null;
				try {
					ct = cls.getConstructor(paramTypes);
				} catch (NoSuchMethodException | SecurityException e) 
				{	
					e.printStackTrace();
				}
						
				Object argList[] = new Object[3];
				argList[0] =  Double.parseDouble(sc.next());
				argList[1] =  Double.parseDouble(sc.next());
				argList[2] = new Character(compareType);
	
				Object o = null;
				try {
					o = ct.newInstance(argList);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					
					e.printStackTrace();
				}
				polygons[i] = (Polygon)o;		
			}
		return polygons;
	}
}

