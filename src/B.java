
/*
Heap sort
N = 1000: 16778
N = 100000: 3019986
N = 200000: 6439860
N = 500000: 17396906
N = 1000000: 36795052

Merge sort
N = 1000: 9976
N = 100000: 1668928
N = 200000: 3537856
N = 500000: 9475712
N = 1000000: 19951424

Quick sort
N = 1000: 11596
N = 100000: 2001021
N = 200000: 4343197
N = 500000: 13003240
N = 1000000: 25517666

*/


void main() {

    Random random = new Random(10);

    Integer[] a3 = random.ints(1000, 1, 100).boxed().toArray( Integer[]::new );
    Integer[] a5 = random.ints(100000, 1, 10000).boxed().toArray( Integer[]::new );
    Integer[] a52 = random.ints(200000, 1, 1000000).boxed().toArray( Integer[]::new );
    Integer[] a55 = random.ints(500000, 1, 10000000).boxed().toArray( Integer[]::new );
    Integer[] a6 = random.ints(1000000, 1, 100000000).boxed().toArray( Integer[]::new );

    HeapSort heap = new HeapSort();
    MergeSort merge= new MergeSort();
    QuickSort quick = new QuickSort();

    IO.println("Heap sort");
    print(a3, heap);
    print(a5, heap);
    print(a52, heap);
    print(a55, heap);
    print(a6, heap);

    IO.println("Merge sort");
    print(a3, merge);
    print(a5, merge);
    print(a52, merge);
    print(a55, merge);
    print(a6, merge);

    IO.println("Quick sort");
    print(a3, quick);
    print(a5, quick);
    print(a52, quick);
    print(a55, quick);
    print(a6, quick);

}

public static void print(Comparable[] a, Sort sort){

    long comparisons;
    Comparable[] clone = a.clone();

    comparisons = sort.sort(clone);
    IO.println("N = " + a.length + ": " + comparisons);

    if(!isSorted(clone)) throw new AssertionError();
}

public static boolean isSorted(Comparable[] a) {
    for (int i = 2; i < a.length; ++i){
        if(!less(a[i - 1], a[i])) return false;
    }
    return true;
}

private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) <= 0;
}

