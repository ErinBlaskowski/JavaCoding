
public class SortAlgos {
	
	public static void main(String[] args)
	{
		int[] array = {5,4,3,2,1};
	}
	
	public static void selectionSort(int[] a) {
		for(int i = 0; i < a.length; i++) {
			
			int small = a[0];
			
			for(int j = i+1; j < a.length; j++)
			{
				//if(a[small] > a[j])
				//	
			}
		}
	}
	
	public static void bubbleSort(int[] a) {
		boolean swap = true;
		
		while(swap) {
			swap = false;
			for(int i = 0; i < a.length-1; i++) {
				if(a[i] > a[i+1]) {
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					swap = true;
				}
			}
		}
	}
	
	
	public static void mergeSort(int[] a)
	{
		int size = a.length;
		
		if(size < 2) //Halting condition
			return;
		
		int mid = size/2;
		int leftSize = mid;
		int rightSize = size - mid;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		
		for(int i = 0; i < mid; i++)
			left[i] = a[i];
		
		for(int i = mid; i < size; i++)
			right[i-mid] = a[i];
		
		mergeSort(left);
		mergeSort(right);
		
		merge(left, right, a);
	}
	
	public static void merge(int[] left, int[] right, int[] a)
	{
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0; //left
		int j = 0; //right
		int k = 0; // a, the merged array
		
		while(i < leftSize && j < rightSize) 
		{
			if(left[i] <= right[j]) 
			{
				a[k] = left[i];
				i++;
				k++;
			}
			else 
			{
				a[k] = right[j];
				j++;
				k++;
			}
		}	
		while(i < leftSize)
		{
			a[k] = left[i];
			i++;
			k++;
		}
		while(j < rightSize)
		{
			a[k] = right[j];
			j++;
			k++;
		}
	}
	
	public static void quickSort(int[] a, int start, int end)
	{
		if(start >= end) 
			return;
		
		int pivot = partition(a, start, end);
		quickSort(a, start, pivot-1);
		quickSort(a, start, pivot+1);
	}
	
	public static int partition(int[] a, int start, int end)
	{
		int pivot = a[end];
		int i = start;
		
		for(int j = start; j <= end; j++)
		{
			if(a[j] < pivot) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}
		int temp = a[i];
		a[i] = a[end];
		a[end] = temp;
		return i;
	}
}
