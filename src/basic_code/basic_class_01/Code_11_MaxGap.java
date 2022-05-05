package basic_code.basic_class_01;

import java.util.Arrays;

/**
 * 求一个数组中将它排序之后相邻两个数的最大差值，用了桶排序的思路
 */
public class Code_11_MaxGap {

	public static int maxGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		int len = nums.length;
		//找出数组中的最大值和最小值
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		if (min == max) {
			return 0;
		}
		//设置数组的长度比这个数组长度大1，这样就肯定有空的位置，
		//这个空位置就排除了同一个桶内相邻数的差值
		//保证这个差值肯定在数组中两个位置中，后一个位置的最小值和前一个位置的最大值之间
		boolean[] hasNum = new boolean[len + 1];
		//下面这两个用来记录每一个桶中的最大值和最小值
		int[] maxs = new int[len + 1];
		int[] mins = new int[len + 1];
		//用来记录循环中每个数在哪个桶中
		int bid = 0;
		for (int i = 0; i < len; i++) {
			bid = bucket(nums[i], len, min, max);
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
			hasNum[bid] = true;
		}
		//计算差值的最大值，res是差值
		int res = 0;
		//前一个桶中的最大值，从0号桶开始
		int lastMax = maxs[0];
		for (int i = 1; i <= len; i++) {
			if (hasNum[i]) {
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}
		return res;
	}
	//求当前值num对应着哪个位置，计算的时候用当前值减最小值除以最大值减最小值然后乘这个数组的长度减1的值（即最后一个下标值）
	//如：这个数组最小值为0，最大值为99，共9个数，这个数组就有10个位置，第一个位置放0-9的数，最后一个位置放90-99的数
	public static int bucket(long num, long len, long min, long max) {
		//这个地方求位置应该先乘长度再除差值，先除的话会舍去小数点，就有问题了
		return (int) ((num - min) *len / (max - min));
	}

	// for test
	public static int comparator(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		Arrays.sort(nums);
		int gap = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++) {
			gap = Math.max(nums[i] - nums[i - 1], gap);
		}
		return gap;
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
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			if (maxGap(arr1) != comparator(arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}

}
