package Utillities;

import java.util.Random;

import adt.Polygon;
/**
 * Each utility class will perform their corresponding sorts
 * and those sorts will print out the first index, last index, and
 * every 1000th value in between. 
 *
 */

public class UtilityClass 
{
	long start,stop; 
	private long runTime;
	
	public UtilityClass()
	{
	}
	
    //*****************************************Insertion Sort****************************************************/
/**
 * Insertion sort, goes through the array finds the largest element and places in into the start of the array list
 * and continues to does so until the list is sorted from largest to smallest
 * @param polygons
 */
	public void insertionSort(Polygon [] polygons) 
	{
		for (int i = 1; i < polygons.length; i++) 
		{
            Polygon test = polygons[i];
            int j = i;
            while (j > 0 && test.compareTo(polygons[j-1]) > 0) {
            	polygons[j] = polygons[j - 1];
                j = j - 1;
            }
            polygons[j] = test;
        }
		stop = System.currentTimeMillis();
		for(int i = 0; i < polygons.length - 1; i= i+ 1000)
		{
			System.out.println(polygons[i]);
		}
		System.out.println(polygons[polygons.length-1]);

	}
	
    //*****************************************Selection Sort****************************************************//
	/**
	 * Goes through the arraylist and finds the largest polygon then swaps it with the first element, then finds the next smallest
	 * element and brings it into the next position afterwards
	 */
	public void selectionSort(Polygon [] polygons)
	{
		for (int i = 0; i < polygons.length - 1; i++)
	    {
	      int max = i;
	      for (int j = i + 1; j < polygons.length; ++j)
	      {
	        if (polygons[j].compareTo(polygons[max]) > 0)
	        {
	        	max = j;
	        }
	      }
	      Polygon temp = polygons[i];
	      polygons[i] = polygons[max];
	      polygons[max] = temp;
	    }		
		stop = System.currentTimeMillis();
		for(int i = 0; i < polygons.length - 1; i= i+ 1000)
		{
			System.out.println(polygons[i]);
		}
		System.out.println(polygons[polygons.length-1]);
	}
	
    //*****************************************Bubble Sort****************************************************/
	/**
	 * Gets the largest value in the arraylist and then swaps it with the previous value in the array list until every value 
	 * after it is smaller, and every value before it is larger
	 */
	public void bubbleSort(Polygon[] polygons)
	{
		start = System.currentTimeMillis();
        Polygon temp;
        for(int i=0; i < polygons.length-1; i++){
             
            for(int j=1; j < polygons.length-i; j++){
                if(polygons[j-1].compareTo(polygons[j]) < 0){
                    temp=polygons[j-1];
                    polygons[j-1] = polygons[j];
                    polygons[j] = temp;
                }
            }

        }
        stop = System.currentTimeMillis();
        
		for(int i = 0; i < polygons.length - 1; i= i+ 1000)
		{
			System.out.println(polygons[i]);
		}
		System.out.println(polygons[polygons.length-1]);
		
	}
	
    //*****************************************Merge Sort****************************************************/	
	/**
	 * Merge sort splits the entire array and splits up the array into smaller arrays and sorts those arrays
	 * The sorted array is then merged with another sorted array and is sorted again, this process is repeated
	 * until the entire array is returned.
	 */
	public void startMergeSort(Polygon[] polygons)
	{
		mergeSort(polygons);
		for(int i1 = 0; i1 < polygons.length - 1; i1= i1+ 1000)
		{
			System.out.println(polygons[i1]);
		}
		System.out.println(polygons[polygons.length-1]);
	}
	
    public void mergeSort(Polygon[] polygons) 
    {
		start = System.currentTimeMillis();
        if (polygons.length < 2)
        {
            return;
        }
        int mid = polygons.length / 2;
        int leftSize = mid;
        int rightSize = polygons.length - mid;
        Polygon[] left = new Polygon[leftSize];
        Polygon[] right = new Polygon[rightSize];
        for (int i = 0; i < mid; i++) 
        {
            left[i] = polygons[i];

        }
        for (int i = mid; i < polygons.length; i++)
        {
            right[i - mid] = polygons[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, polygons);
    }

    public void merge(Polygon[] left, Polygon[] right, Polygon[] polygons) 
    {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) 
        {
            if (left[i].compareTo(right[j]) >= 0 ) 
            {
            	polygons[k] = left[i];
                i++;
                k++;
            } else 
            {
            	polygons[k] = right[j];
                k++;
                j++;
            }
        }
        while (i < left.length) 
        {
        	polygons[k] = left[i];
            k++;
            i++;
        }
        while (j < right.length) 
        {
        	polygons[k] = right[j];
            k++;
            j++;
        }
    }
	
    //***************************************Quick sort *************************************************************************/
	/**
	 * Selects a pivot from the array, then reorders the array so that the larger values are before the pivot
	 *  And recursively calls with a new pivot
	 */
    public void quickSort(Polygon[] polygons) 
	{
		quickSort(polygons, 0, polygons.length - 1);    
		
		for(int i1 = 0; i1 < polygons.length - 1; i1= i1+ 1000)
		{
			System.out.println(polygons[i1]);
		}
		System.out.println(polygons[polygons.length-1]);
	}
	public void quickSort(Polygon[] polygons, int start, int end)
	{
	        int i = start;                        
	        int k = end;                           
	
	        if (end - start >= 1)                
	        {
                Polygon pivot = polygons[start];  
                while (k > i)                
                {
                        while (polygons[i].compareTo(pivot) >= 0 && i <= end && k > i)  
                                i++;                                
                        while (polygons[k].compareTo(pivot) <= 0 && k >= start && k >= i) 
                            k--;                                     
                        if (k > i)                              
                                swap(polygons, i, k);                     
                }
                swap(polygons, start, k);          
                                                
                quickSort(polygons, start, k - 1); 
                quickSort(polygons, k + 1, end);   
	        }
	        else 
	        {
	                return;              
	        }
	       			
	}
	public void swap(Polygon[] polygons, int index1, int index2) 
	{
		Polygon temp = polygons[index1];          
		polygons[index1] = polygons[index2];    
		polygons[index2] = temp;               
	}
	
	//*************************************************** Shell Sort ***********************************************************/	
/**
 * splits the array and then sorts the columns of that array, the data is partially sorted
 * repeat with a smaller section of the array until the entire array is sorted.
 */
	public void shellSort( Polygon[] polygons )
	  {
	    int j;
	    for( int space = polygons.length / 2; space > 0; space = space/2 )
	    {
	      for( int i = space; i < polygons.length; i++ )
	      {
	         Polygon temp = polygons[i];
	         for(j = i; j >= space && temp.compareTo(polygons[j-space]) > 0; j= j - space )
	         {
	        	 polygons[j] = polygons[j-space];
	         }
	         polygons[ j ] = temp;
	      }
	    }
	        
		for(int i = 0; i < polygons.length - 1; i= i+ 1000)
		{
			System.out.println(polygons[i]);
		}
		System.out.println(polygons[polygons.length-1]);
	  }
}
