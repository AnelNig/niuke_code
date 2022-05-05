package basic_code.basic_class_01;

/**
 * 荷兰国旗问题：一个数组中小于num的放左边，等于num的放中间，大于num的放右边，快排的思路
 */
public class Code_08_NetherlandsFlag {
	//l是这个数组的第一个元素的下标，r是这个数组的最后一个位置的下标，p就是num
	public static int[] partition(int[] arr, int l, int r, int p) {
		//刚开始认为小于num的数位于这个数组的第一个元素减一的位置，大于的在最后一个元素加一的位置
		int less = l - 1;
		int more = r + 1;
		int index = l;
		while (index < more) {
			if (arr[index] < p) {
				swap(arr, ++less, index++);
			} else if (arr[index] > p) {
				swap(arr, --more, index);
			} else {
				index++;
			}
		}
		return new int[] { less + 1, more - 1 };//返回的是等于p的数组的下标区域
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 3);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] test = generateArray();

		printArray(test);
		int[] res = partition(test, 0, test.length - 1, 1);
		printArray(test);
		System.out.println(res[0]);
		System.out.println(res[1]);

	}
}
