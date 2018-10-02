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
	void exch(Team[] arr, int i, int j) {
		Team t = arr[j];
		arr[j] = arr[i];
		arr[i] = t; 
	}
	void sort() {
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (less(arr, j - 1, j)) {
					exch(arr, j -1, j);
				} 
			}
        }
	}
	boolean less(Team[] arr, int i, int j) {
		return  arr[i].compareTo(arr[j]) < 0;
	}
}