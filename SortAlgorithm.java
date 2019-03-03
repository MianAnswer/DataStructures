import java.util.Arrays;

class SortAlgorithm {

    public static void insertion(int[] arr) {
        System.out.println("---------------------------------");
        System.out.println("-----Inside Insertion method-----\n");
        int length = arr.length;

        for (int i = 1; i < length; ++i) {
            int k = i;
            // Show list as order changes
            System.out.println("Sorting... " + Arrays.toString(arr));
            for (int j = k - 1; j >= 0; --j) {
                // If value in current location is smaller than value in preceding location,
                // then swap values
                if (arr[k] <= arr[j]) {
                    // Swap
                    swap(arr, j, k);
                    --k;
                }
                // Otherwise, exit inner-loop. Values are already in order
                else {
                    break;
                }
            }
        }

        // Final list
        System.out.println("Sorted:    " + Arrays.toString(arr));
        System.out.println("\n-----End of Insertion method-----");
        System.out.println("---------------------------------");
    }

    public static void merge(int[] arr) {
        System.out.println("---------------------------------");
        System.out.println("-----Inside Merge method-----\n");

        arr = mergeSort(arr, 0, arr.length - 1);

        // Final list
        System.out.println("Sorted:    " + Arrays.toString(arr));
        System.out.println("\n-----End of Merge method-----");
        System.out.println("---------------------------------");
    }

    private static int[] mergeSort(int[] arr, int beginning, int end) {
        int middle = (beginning + (end - beginning) / 2);

        if (beginning == end) {
            return new int[]{arr[beginning]};
        }

        // Left
        int[] arrLeft = mergeSort(arr, beginning, middle);
        int leftLength = arrLeft.length;
        // Right
        int[] arrRight = mergeSort(arr, middle + 1, end);
        int rightLength = arrRight.length;
        // Merged array
        int[] mergedArray = new int[leftLength + rightLength];

        int i = 0;
        int j = 0;
        int k = 0;

        while ((i < leftLength) && (j < rightLength)) {
            if (arrLeft[i] > arrRight[j]) {
                mergedArray[k] = arrRight[j];
                ++j;
            } else {
                mergedArray[k] = arrLeft[i];
                ++i;
            }
            ++k;
        }

        if (k < mergedArray.length) {
            int[] leftOver = {};
            int leftOverIndex = 0;
            if (i != leftLength) {
                leftOver = arrLeft;
                leftOverIndex = i;
            } else if (j != rightLength) {
                leftOver = arrRight;
                leftOverIndex = j;
            }
            while (k < mergedArray.length && leftOverIndex < leftOver.length) {
                mergedArray[k++] = leftOver[leftOverIndex++];
            }
        }
        System.out.println("Sorting... " + "[" + beginning + ", " + end + "]"+ Arrays.toString(mergedArray));
        return mergedArray;
    }

    public static void quick(int[] arr) {
        System.out.println("---------------------------------");
        System.out.println("-----Inside QuickSort method-----\n");
        System.out.println("Original:    " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        // Final list
        System.out.println("Sorted:    " + Arrays.toString(arr));
        System.out.println("\n-----End of QuickSort method-----");
        System.out.println("---------------------------------");
    }

    private static void quickSort(int[] arr, int beginning, int end) {
        if(end - beginning + 1 < 2) {
            return;
        }

        int middle = (beginning + (end - beginning) / 2);
        int pivot = arr[middle];
        int left = beginning;
        int right = end;

        while(left != middle || right != middle) {
            if(arr[left] >= pivot && arr[right] <= pivot) {
                if(arr[left] == pivot) {
                    middle = right;
                } else if(arr[right] == pivot) {
                    middle = left;
                }
                swap(arr, left, right);
            }
            if(left != middle && arr[left] <= pivot) {
                ++left;
            }
            if(right != middle && arr[right] >= pivot) {
                --right;
            }
        }
        System.out.println("Sorting... " + "[" + beginning + ", " + end + "] pivot = " + pivot + "\t" + Arrays.toString(arr));
        // Left
        quickSort(arr, beginning, middle - 1);
        // Right
        quickSort(arr, middle + 1, end);
       
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}