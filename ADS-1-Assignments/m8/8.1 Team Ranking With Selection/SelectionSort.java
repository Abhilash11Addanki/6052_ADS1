class SelectionSort {
Teams t = new Teams();
void sort() {
		for (int i = 0; i < t.size - 1; i++) {
			int index = i;
			for (int j = i + 1; j < t.size; j++) {
				if (less(t.arr, j, index)) {
					index = j;
				}
			}
			exch(t.arr, i , index);
		}
	}
	void exch(Team[] arr, int i, int j) {
		Team te = t.arr[j];
		t.arr[j] = t.arr[i];
		t.arr[i] = te;
	}
	boolean less(Team[] arr, int i, int j) {
		return arr[i].compareTo(arr[j]) > 0;
	}
}