import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int size = 100; 
        Random rand = new Random();
        int[] array = new int[size];
        
        
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(500); 
        }
        
        System.out.println("Tablica przed sortowaniem:");
        printArray(array);
        
        quickSort(array, 0, size - 1);
        
        System.out.println("\nTablica po sortowaniu:");
        printArray(array);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; 
        int i = (low - 1); 
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                
               
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
       
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
