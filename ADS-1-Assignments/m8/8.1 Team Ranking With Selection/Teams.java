class Teams {
	/**
	 * { var_description }.
	 */
	Team[] arr;
	/**
	 * { var_description }.
	 */
	int size;
	/**
	 * Constructs the object.
	 */
	Teams() {
		arr = new Team[10];
		size = 0;
	}
	/**
	 * { function_description }.
	 * @param      item  The item
	 */
	public void add(final Team item) {
		//Inserts the specified element at the end of the list.
		//You can modify the code in this method.
		arr[size++] = item;
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			s += arr[i].teamname + ",";
		}
		return s.substring(0, s.length() - 1);
	}
	void sort() {
		for (int i = 0; i < size - 1; i++) {
			int index = i;
			for (int j = i + 1; j < size; j++) {
				if (less(arr, j, index)) {
					index = j;
				}
			}
			exch(arr, i , index);
		}
	}
	void exch(Team[] arr, int i, int j) {
		Team te = arr[j];
		arr[j] = arr[i];
		arr[i] = te;
	}
	boolean less(Team[] arr, int i, int j) {
		return arr[i].compareTo(arr[j]) > 0;
	}
}