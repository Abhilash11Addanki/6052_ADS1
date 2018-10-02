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
		SelectionSort s = new SelectionSort();
		s.sort();
	}
}