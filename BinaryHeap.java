package cs245.PA06;

public class BinaryHeap {
	// Data member
	private int[] arr;
	private int size;
	
	// Constructor
	public BinaryHeap() {
		arr = new int[1];
		size = 0;
	}
	
	// Methods
	int parent(int index) {
		return (index - 1) / 2;
	}
	
	int left_child(int index) {
		return (index * 2) + 1;
	}
	
	int right_child(int index) {
		return (index * 2) + 2;
	}
	
	private void swap(int pos1, int pos2) {
		int tmp;
		tmp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = tmp;
	}

	private void grow_arr() {
		int[] new_arr = new int[arr.length * 2];
		System.arraycopy(arr, 0, new_arr, 0, arr.length);
		arr = new_arr;
	}
	
	public void add (int priority) {
		if(arr.length <= size) {
			grow_arr();
		}
		arr[size++] = priority;
		int index = size - 1;
		while(arr[index] < arr[parent(index)]) {
			swap(index, parent(index));
			index = parent(index);
		}
	}

	public int remove() {
		int removed = arr[0];
		swap(0, --size);
		if (size != 0) {
			siftdown(0);
		}
		return removed;
	}
	private void siftdown(int position) {
		if (left_child(position) >= size)
			return;
		int child = left_child(position);
		if (right_child(position) < size && arr[right_child(position)] < arr[child])
			child = right_child(position);
		if (arr[child] < arr[position]) {
			swap(child, position);
			siftdown(child);
		}
	}


}
