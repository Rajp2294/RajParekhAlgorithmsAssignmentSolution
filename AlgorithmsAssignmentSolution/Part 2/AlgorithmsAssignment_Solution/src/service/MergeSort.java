package service;

public class MergeSort {
	// Merges two subarrays of type double arr[].
    // First subarray is arr[left..mid]
    // Second subarray is arr[mid+1..right]
			
	public static void merge(double arr[], int left, int mid, int right)
		{
		// Find sizes of two subarrays to be merged
			int n1 = mid - left + 1;
			int n2 = right - mid;
			
			 /* Create temp arrays */
			double leftArr[] = new double[n1];
			double rightArr[] = new double[n2];
			
			/*Copy data to temp arrays*/
			for(int i = 0; i < n1; i++) 
				leftArr[i] = arr[left + i];
			for(int j = 0; j < n2; j++) 
				rightArr[j] = arr[mid + 1 + j];
			
			
			/* Merge the temp arrays */
			 
	        // Initial indexes of first and second subarrays
				int i, j, k;
				i = 0;
				j = 0;
				k = left;  // Initial index of merged subarray array
				
			while (i < n1 && j < n2) {
				if (leftArr[i] <= rightArr[j]) {
					arr[k] =leftArr[i];
					i++;
				} else {
					arr[k] = rightArr[j];
					j++;
				}
				k++;
			}
			
			/* Copy remaining elements of Leftarray[] if any */
			while(i < n1) {
				arr[k] = leftArr[i];
				i++;
				k++;
			}
			
			/* Copy remaining elements of R[] if any */
	        while (j < n2)
	        {
	            arr[k] = rightArr[j];
	            j++;
	            k++;
	        }
	    }
		
	// Main function that sorts arr[l..r] using
    // merge()		
	public static double[] sort(double arr[], int left, int right) {
			if(left<right)
			{
				int mid = (left+right)/2;
				
				sort(arr,left,mid);
				sort(arr,mid+1,right);
				
				merge(arr,left,mid,right);
			}
			return arr;
		}
	}


