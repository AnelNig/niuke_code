package basic_code.basic_class_08;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 给定一个数组代表一个容器，比如[3,1,2,4]，
 * 0位置是一个宽度为1，高度为3的直方图。1位置是一个宽度为1，高度为1的直方图。
 * 2位置是一个宽度为1，高度为2的直方图。3位置是一个宽度为1，高度为4的直方图。
 * 所有直方图的底部都在一条水平线上，且紧靠着。把这个图想象成一个容器，这个容器可以装3格的水。
 * 给定一个没有负数的数组arr，返回能装几格水？
 */
public class Code_01_WaterProblem {

	public static int getWater1(int[] arr) {
		if (arr == null || arr.length < 3) {
			return 0;
		}
		int value = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			int leftMax = 0;
			int rightMax = 0;
			for (int l = 0; l < i; l++) {
				leftMax = Math.max(arr[l], leftMax);
			}
			for (int r = i + 1; r < arr.length; r++) {
				rightMax = Math.max(arr[r], rightMax);
			}
			value += Math.max(0, Math.min(leftMax, rightMax) - arr[i]);
		}
		return value;
	}

	public static int getWater2(int[] arr) {
		if (arr == null || arr.length < 3) {
			return 0;
		}
		int n = arr.length - 2;
		int[] leftMaxs = new int[n];
		leftMaxs[0] = arr[0];
		for (int i = 1; i < n; i++) {
			leftMaxs[i] = Math.max(leftMaxs[i - 1], arr[i]);
		}
		int[] rightMaxs = new int[n];
		rightMaxs[n - 1] = arr[n + 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMaxs[i] = Math.max(rightMaxs[i + 1], arr[i + 2]);
		}
		int value = 0;
		for (int i = 1; i <= n; i++) {
			value += Math.max(0, Math.min(leftMaxs[i - 1], rightMaxs[i - 1]) - arr[i]);
		}
		return value;
	}

	public static int getWater3(int[] arr) {
		if (arr == null || arr.length < 3) {
			return 0;
		}
		int n = arr.length - 2;
		int[] rightMaxs = new int[n];
		rightMaxs[n - 1] = arr[n + 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMaxs[i] = Math.max(rightMaxs[i + 1], arr[i + 2]);
		}
		int leftMax = arr[0];
		int value = 0;
		for (int i = 1; i <= n; i++) {
			value += Math.max(0, Math.min(leftMax, rightMaxs[i - 1]) - arr[i]);
			leftMax = Math.max(leftMax, arr[i]);
		}
		return value;
	}

	public static int getWater4(int[] arr) {
		if (arr == null || arr.length < 3) {
			return 0;
		}
		int value = 0;
		int leftMax = arr[0];
		int rightMax = arr[arr.length - 1];
		int l = 1;
		int r = arr.length - 2;
		while (l <= r) {
			if (leftMax <= rightMax) {
				value += Math.max(0, leftMax - arr[l]);
				leftMax = Math.max(leftMax, arr[l++]);
			} else {
				value += Math.max(0, rightMax - arr[r]);
				rightMax = Math.max(rightMax, arr[r--]);
			}
		}
		return value;
	}

	public static int[] generateRandomArray() {
		int[] arr = new int[(int) (Math.random() * 98) + 2];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 200) + 2;
		}
		return arr;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000000; i++) {
			int[] arr = generateRandomArray();
			int r1 = getWater1(arr);
			int r2 = getWater2(arr);
			int r3 = getWater3(arr);
			int r4 = getWater4(arr);
			if (r1 != r2 || r3 != r4 || r1 != r3) {
				System.out.println("What a fucking day! fuck that! man!");
			}
		}

		HashMap<String, String> map = new HashMap<String, String>();

		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " , " + entry.getValue());
		}

	}

}
