package basic_code.basic_class_01;

import java.util.Arrays;

/**
 * 基数排序
 */
public class Code_07_RadixSort {

	// only for no-negative value
	public static void radixSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		radixSort(arr, 0, arr.length - 1, maxbits(arr));
	}
	//计算数组中最大的数有几位，如15有两位
	public static int maxbits(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int res = 0;
		while (max != 0) {
			res++;
			max /= 10;
		}
		return res;
	}

	public static void radixSort(int[] arr, int begin, int end, int digit) {
		final int radix = 10;
		int i = 0, j = 0;
		//10个位置用来计数
		int[] count = new int[radix];
		//数组中多少个数就多少个桶
		int[] bucket = new int[end - begin + 1];
		//先是个位，然后十位百位等
		for (int d = 1; d <= digit; d++) {
			//将count数组的每个元素置0
			for (i = 0; i < radix; i++) {
				count[i] = 0;
			}
			//在count中对每个数的个位，十位等出现次数进行计数
			for (i = begin; i <= end; i++) {
				j = getDigit(arr[i], d);
				count[j]++;
			}
			//在count中将每个位上进行累加,radix是10
			for (i = 1; i < radix; i++) {
				count[i] = count[i] + count[i - 1];
			}
			for (i = end; i >= begin; i--) {
				j = getDigit(arr[i], d);
				//count[j]表示j位置及之前的位置上有几个数字，由于数组从0开始，所以要减一
				bucket[count[j] - 1] = arr[i];
				count[j]--;
			}
			for (i = begin, j = 0; i <= end; i++, j++) {
				arr[i] = bucket[j];
			}
		}
	}
	//获取数字的个位，十位等位上的数，如d=1时就是求x个位上的数字
	public static int getDigit(int x, int d) {
		return ((x / ((int) Math.pow(10, d - 1))) % 10);
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random());
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
		int maxValue = 100000;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			radixSort(arr1);
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
//		int[] arr = {16,2,9,76,90,167,4,2};
		printArray(arr);
		radixSort(arr);
		printArray(arr);

	}

}
