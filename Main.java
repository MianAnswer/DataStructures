class Main {
    public static void main(String args[]) {
        testLinkedList();
        testInsertion();
        testMerge();
        testQuick();
    }

    private static void testInsertion() {
        int arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortAlgorithm.insertion(arr);
    }

    private static void testMerge() {
        int arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortAlgorithm.merge(arr);
    }

    private static void testQuick() {
        int arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortAlgorithm.quick(arr);
    }
 
    private static void testLinkedList() {
        LinkedListAlgorithm link = new LinkedListAlgorithm();
        link.Insert(8);
        link.list();
    }
}