public class MergeSort implements Sort{

    @Override
    public long sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        long comparisons = sort(a, aux, 0, a.length-1);

        return comparisons;
    }
    private static long sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        long comparisons = 0L;

        if (hi <= lo) return comparisons;
        int mid = lo + (hi - lo) / 2;

        comparisons += sort(a, aux, lo, mid);
        comparisons += sort(a, aux, mid + 1, hi);
        comparisons += merge(a, aux, lo, mid, hi);
        return comparisons;
    }
    public static long merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
    {
        long comparisons = 0L;

        int i = lo, j = mid+1;
        for(int k = lo; k <= hi; k++)
            aux[k]=a[k];


        for (int k = lo; k <= hi; k++) {

            comparisons++;
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
        return comparisons;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
