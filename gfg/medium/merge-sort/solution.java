class Solution {
    public void mergeSort(int arr[], int start, int end) {
        // code here
        if(start >= end){
            return;
        }
        
        int mid = start + (end - start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
    
    private void merge(int[] arr, int start, int mid, int end){
        
        int[] temp = new int[end - start + 1];
        
        int i = start;
        int j = mid + 1;
        int k = 0;
        
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        
        while(i <= mid){
            temp[k] = arr[i];
            i++;
            k++;
        }
        while(j <= end){
            temp[k] = arr[j];
            j++;
            k++;
        }
        for(int x = 0; x < temp.length; x++){
            arr[start + x] =temp[x];
        }
    }
}

