package basic_code.basic_class_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 寻找两个有序数组中，B数组中存在，A数组中不存在的数，逻辑是顺序遍历一个数组，另一个数组二分查找
 */
public class Code_10_GetAllNotIncluded {

	public static List<Integer> GetAllNotIncluded(int[] A, int[] B) {
		List<Integer> res = new ArrayList<>();
		//B要进行遍历
		for (int i = 0; i < B.length; i++) {
			int l = 0;
			int r = A.length - 1;
			boolean contains = false;
			//如果最终没找到就跳出这个循环，这里用了二分查找
			while (l <= r) {
				int mid = l + ((r - l) >> 1);
				//A的中间值如果等于当前遍历的B的这个值，说明B的这个元素A里有了，
				//就跳出当前while，到下一个B的元素
				if (A[mid] == B[i]) {
					contains = true;
					break;
				}
				//如果A的中间值大于B当前的这个值，就在A的前一半中找
				if (A[mid] > B[i]) {
					r = mid - 1;
				//否则，如果A的中间值小于B当前的这个值，就在A的后一半中找
				} else {
					l = mid + 1;
				}
			}
			if (!contains) {
				res.add(B[i]);
			}
		}
		return res;
	}

	// for test
	public static List<Integer> comparator(int[] A, int[] B) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < B.length; i++) {
			boolean contains = false;
			for (int j = 0; j < A.length; j++) {
				if (A[j] == B[i]) {
					contains = true;
					break;
				}
			}
			if (!contains) {
				res.add(B[i]);
			}
		}
		return res;
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
	public static boolean isEqual(List<Integer> l1, List<Integer> l2) {
		if (l1.size() != l2.size()) {
			return false;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (Integer i : l1) {
			if (!map.containsKey(i)) {
				map.put(i, 0);
			}
			map.put(i, map.get(i) + 1);
		}
		for (Integer i : l2) {
			if (!map.containsKey(i)) {
				return false;
			}
			map.put(i, map.get(i) - 1);
			if (map.get(i) < 0) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void main(String[] args) {
//		int testTime = 300000;
//		int sortedArrayMaxSize = 300;
//		int unsortedArrayMaxSize = 10;
//		int maxValue = 100;
//		boolean succeed = true;
//		for (int i = 0; i < testTime; i++) {
//			int[] A = generateRandomArray(sortedArrayMaxSize, maxValue);
//			int[] B = generateRandomArray(unsortedArrayMaxSize, maxValue);
//			Arrays.sort(A);
//			List<Integer> res1 = GetAllNotIncluded(A, B);
//			List<Integer> res2 = comparator(A, B);
//			if (!isEqual(res1, res2)) {
//				succeed = false;
//				break;
//			}
//		}
//		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
		int[] A = {3,4,6,7,8,11,78,98,100};
		int[] B = {4,5,6,7,8,11,67,98,100};
		List<Integer> integers = GetAllNotIncluded(A, B);
		System.out.println(integers);
	}

}
