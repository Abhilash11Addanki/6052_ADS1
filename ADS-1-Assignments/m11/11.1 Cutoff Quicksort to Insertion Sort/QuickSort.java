class QuickSort {
	int partition(Comparable[] arr, int low, int high) {
		Comparable pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (less(arr[j], pivot)) {
				i++;
				swap(arr[i], arr[j]);
			}
		}
		swap(arr[i + 1], arr[high]);
		return i + 1;
	}
	void swap(Comparable a, Comparable b) {
		Comparable temp = a;
		a = b;
		b = temp;
	}
	void sort(Comparable[] arr, int low, int high, int cutoff) {
		int x = cutoff;
		if (high <= low + x) {
			insertionSort(arr, low, high);
			System.out.println("insertionSort called");
			return;
		}
		if (low < high) {
			int p = partition(arr, low, high);
			sort(arr, low, p - 1, x);
			sort(arr, p + 1, high, x);
		}
	}
	void insertionSort(final Comparable[] a,
	                   final int lo, final int hi) {
		for (int i = lo; i <= hi; i++) {
			for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}
	void exch(final Comparable[] a,
	          final int i, final int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	boolean less(final Comparable a, final Comparable b) {
		return a.compareTo(b) < 0;
	}
	void printArray(Comparable[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}