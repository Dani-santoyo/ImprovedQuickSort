package HW0530;

public class ImprovedQuickSort {
    public static void quickSort(int[] list){
        quickSort(list, 0, list.length - 1);
    }

    public static void quickSort(int[] list, int first, int last){
        if(last > first){
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    public static int partition(int[] list, int first, int last){
        int low = first + 1;
        int high = last;
        int pivot = list[list.length/2];

        while(high > low){
            while(low <= high && list[high] > pivot)
                low++;
            while(low <= high && list[low] <= pivot)
                high--;

            if(high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }


        while(high > first && list[high] >= pivot)
            high--;

        if(pivot > list[high]){
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else{
            return first;
        }
    }

    private int medianOfThree(int[] arr, int left,int right){
        int mid = left + (right - left) / 2;
        if(arr[left] > arr[mid])
            swap(arr, left, mid);
        if(arr[left] > arr[right])
            swap(arr, left, right);
        if (arr[mid] > arr[right])
            swap(arr, mid, right);
        return mid;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] list = {2,3,2,5,6,1,-2,3,14,12};
        quickSort(list);
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i] + " ");
        }
    }
}
