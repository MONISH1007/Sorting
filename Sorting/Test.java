import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        //Sorting obj = new Sorting();
        logSorting obj2 = new logSorting();
        obj2.quickSort(arr, 0, n-1);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
};

class Sorting { 
    public void selectionSort(int[] arr, int n){
        for(int i = 0; i < n-1; i++){
            int mini = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[mini]) mini = j;
            }
            int temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;
        }
    }

    public void bubbleSort(int[] arr, int n){
        for(int i = n-1; i >= 0; i--){
            int flag = 0;
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = 1;
                }
            }
            //System.out.println(flag);
            if(flag == 0) break;
        }
    }

    public void insertionSort(int[] arr, int n){
        for(int i = 1; i < n; i++){
            int j = i;
            while(j > 0 && arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }

}

class logSorting{
    public void mergeSort(int[] arr, int low, int high){
        if(low >= high) return; 
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
    private void merge(int[] arr, int low, int mid, int high){
        int left = low;
        int right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }
        for(int i = low; i <= high; i++){
            arr[i] = temp.get(i - low);
        }
    }

    public void quickSort(int[] arr, int start, int end){
        if(start >= end) return;
        int mid = partionAlgo(arr, start, end);
        quickSort(arr, start, mid-1);
        quickSort(arr, mid+1, end);
    }
    private int partionAlgo(int[] arr, int start, int end){
        int pivot = end;
        int lfind = start;
        int sfind = end;
        while(lfind < sfind){
            while(arr[lfind] < arr[pivot]) lfind++;
            while(arr[sfind] > arr[pivot]) sfind--;
            if(lfind < sfind){
                int temp = arr[lfind];
                arr[lfind] = arr[sfind];
                arr[sfind] = temp;
            }
        }
        int temp = arr[lfind]; 
        arr[lfind] = arr[pivot];
        arr[pivot] = temp;
        return lfind;
    }
}