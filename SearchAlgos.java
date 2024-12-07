
public class SearchAlgos 
{
	public static void main(String[] args)
	{
		int[] array = {5,6,7,8,9,10};
		System.out.println(linSearch(array, 11));
		System.out.println(linSearch(array, 10));
	}
	
	public static boolean linSearch(int[] a, int target)
	{
		for(int i=0; i < a.length; i++)
		{
			if(a[i] == target)
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean binSearch(int[] a, int target, int start, int end)
	{
		if(start > end)
			return false;
		int mid = (start + end)/2;
		if(a[mid] == target)
			return true;
		else if(a[mid] > target)
			return binSearch(a, target, start, mid);
		else
			return binSearch(a, target, mid+1, end);
	}
	
	
}
