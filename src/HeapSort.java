public class HeapSort implements Sort{

    @Override
    public long sort(Comparable[] a) {
        long comparisons = 0L;

        int N = a.length - 1;
        for (int k = N/2; k >= 1; k--) {
            comparisons += sink(a, k, N);
        }
        while (N > 1) {
            exch(a, 1, N--);
            comparisons += sink(a, 1, N);
        }
        return comparisons;
    }

    private static long swim(Comparable[] a, int k) {
        long comparisons = 0L;

        while (k > 1) {
            comparisons++;

            if(less(a[k/2], a[k])){
                exch(a, k, k / 2);
                k = k / 2;
            }
            else break;
        }
        return comparisons;
    }

    private static long sink(Comparable[] a, int k, int n) {
        long comparisons = 0L;

        while (2*k <= n) {
            int j = 2*k;

            comparisons += 2;
            if (j < n && less(a[j], a[j+1])) j++;
            if (!less(a[k], a[j])) break;
            exch(a, k, j);
            k = j;
        }

        return comparisons;
    }

    private static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
