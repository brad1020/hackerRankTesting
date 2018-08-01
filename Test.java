import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		
		//int[] arr = {1, 2, 3, 4, 5};
		//System.out.println(Arrays.toString(rotLeft(arr,2)));
		
		//minimumBribes(new int[] {2,1,5,3,4});
		
		//System.out.println(minimumSwaps(new int[] {4,3,1,2}));
		
		System.out.println(arrayManipulation(10, new int[][] {{1,5,3},
															 {4,8,7},
															 {6,9,1}}));

	}

	static int[] rotLeft(int[] a, int d) {
		
		int[] result = new int[a.length];
		
		for (int i = 0; i < a.length; i++) {
			result[i] = a[(i + d) % a.length];
		}
		
		return result;
    }
	
	static void minimumBribes(int[] q) {

			int bribes = 0;
			
			for (int i = 0; i < q.length; i++) {
				
				if (q[i] - (i + 1) > 2) {
					System.out.println("Too chaotic");
					return;
				}
				
				for (int j = Math.max(0, q[i] - 2); j < i; j++) {
					if (q[j] > q[i])
						bribes++;
					
				}
					
			}
			
			System.out.println(bribes);

    }
	
	static int minimumSwaps(int[] arr) {
		  
		  int swaps = 0;
		  
		  for (int i = 0 ; i < arr.length; i++) {
			 
			//  System.out.println(Arrays.toString(arr));
			  if (arr[i] - 1 == i)
				  continue;
			  
			  else {
				  int temp = arr[arr[i] - 1];
				  arr[arr[i] - 1] = arr[i];
				  arr[i] = temp;
				  swaps++;
				  i--;
				  
			  }
			 
		  }
		  
		  return swaps;

	    }
	  
	static long arrayManipulation(int n, int[][] queries) {

		long largest = 0;
		
		long[] result = new long[n + 1];
		
		for(int i = 0; i < queries.length; i++) {
			
			int startingIndex = queries[i][0];
			int endingIndex = queries[i][1] + 1;
			int numberToAdd = queries[i][2];
			
			result[startingIndex] += numberToAdd;
			if (endingIndex <= n) {	
				result[endingIndex] -= numberToAdd;
			}
			
			
			System.out.println(Arrays.toString(result));
		}
		
		 long max = 0, addedDifference = 0;
		    for (int j=1; j<=n; j++) 
		    {
		        addedDifference = addedDifference + result[j];
		        if (max < addedDifference)
		            max = addedDifference;
		    }
		
		return max;

	    }

		
}
