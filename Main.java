class Main {
    public static void main(String args[]) {
        testLinkedList();
        testInsertion();
        testMerge();
    }

    private static void testInsertion() {
        int arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Sort.insertion(arr);
    }

    private static void testMerge() {
        int arr[] = {5, 4, 3, 2, 1};
        Sort.merge(arr);
    }
 
    private static void testLinkedList() {
        LinkedList link = new LinkedList();
        link.Insert(8);
        link.list();
    }
}