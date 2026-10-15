public class QuickSort implements Sort{

    @Override
    public long sort(Comparable[] a){

        return sort(a, 0, a.length - 1);
    }

    private static long sort(Comparable[] a, int lo, int hi){
        Long[] comparisons = {0L};

        if(hi <= lo) return 0L;
        int j = partition(a,lo, hi, comparisons);
        comparisons[0] += sort(a, lo, j-1);
        comparisons[0] += sort(a, j+1, hi);

        return comparisons[0];
    }

    private static int partition(Comparable[] a, int lo, int hi, Long[] comparisons){
        int i = lo, j = hi +1;
        while(true){

            while(true){
                comparisons[0] += 1;

                if(!less(a[++i], a[lo])) break;

                if (i == hi) break;

            }

            while(true){
                comparisons[0] += 1;

                if(!less(a[lo], a[--j])) break;

                if(j == lo) break;
            }

            if(i >= j) break;
            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int min) {
        Comparable temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }
}
