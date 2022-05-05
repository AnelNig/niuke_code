package basic_code.basic_class_01;

import java.util.Arrays;

/**
 * 随机快排
 */
public class Code_04_QuickSort {

	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}
	//l是这个数组的第一个数的下标，r是这个数组的最后一个数的下标
	public static void quickSort(int[] arr, int l, int r) {
		//可以直接通过if(l >= r){return;}来结束递归
		if (l < r) {
			//随机取一个数放到数组的最后一个位置，作为partition时的num
			//普通的快排最坏情况下的时间复杂度为O(n^2)，平均为O(n*logn)，最坏情况就是初始数组为顺序或逆序
			//随机快排的优势是在大数据量的情况下，数学期望下的时间复杂度为O(n*logn)
			swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
			int[] p = partition(arr, l, r);
			//递归地进行快排，p[0]是刚刚partition后arr数组中等于num的数组的第一个数的下标
			//p[1]是等于num的数组的最后一个数的下标
			quickSort(arr, l, p[0] - 1);
			quickSort(arr, p[1] + 1, r);
		}
	}
	//这个函数不是用来排序的，而是用来找出数组中的相等数组的
	public static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;
		int more = r + 1;
		int num = arr[r];
		int index = l;
		while (index < more) {
			if (arr[index] < num) {
				swap(arr, ++less, index++);
			} else if (arr[index] > num) {
				swap(arr, --more, index);
			} else {
				index++;
			}
		}
		//这里返回的不是相等的数组，而是相等数组的第一个数和最后一个数的下标，总共两个数
		return new int[] { less + 1, more - 1};
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
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

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			quickSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		quickSort(arr);
		printArray(arr);

	}

}
