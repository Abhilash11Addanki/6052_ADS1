class Students {
	/**
	 * { var_description }.
	 */
	StudentInfo[] arr;
	/**
	 * { var_description }.
	 */
	int size;
	/**
	 * Constructs the object.
	 */
	Students(int s) {
		arr = new StudentInfo[s];
		size = 0;
	}
	/**
	 * { function_description }.
	 * @param      item  The item
	 */
	public void add(final StudentInfo item) {
		//Inserts the specified element at the end of the list.
		//You can modify the code in this method.
		arr[size++] = item;
	}
	public void show() {
		String s = "";
		for (int i = 0; i < size; i++) {
			s = arr[i].studentname + ","
			+ Integer.toString(arr[i].totalmarks) + ","
			+ arr[i].reservationcat;
		System.out.println(s);
		}
	}
	void exch(StudentInfo[] arr, int i, int j) {
		StudentInfo s = arr[j];
		arr[j] = arr[i];
		arr[i] = s;
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
	boolean less(StudentInfo[] arr, int i, int j) {
		return  arr[i].compareTo(arr[j]) < 0;
	}
}