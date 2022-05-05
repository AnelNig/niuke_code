package basic_code.basic_class_01;

import java.util.Arrays;

/**
 * 冒泡排序：每一次循环就是将最大的数沉到数组最后的位置
 */
public class Code_00_BubbleSort {

	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				//不论arr[i]和arr[i+1]谁大，这次循环后都是大的一个在后面
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		/*
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
		*/
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	//以下是原来验证的对数器,笔试之前要准备数组的对数器，二叉树的对数器，堆的对数器
	//对数器的概念和使用
	//0.有一个你想要测的方法A
	//1.实现一个绝对正确但复杂度不好的方法B
	//2.实现一个随机样本产生器
	//3.实现比对的方法
	//4.把方法A和方法B比对很多次来验证方法A是否正确
	//5.如果有一个样本使得比对出错，打印样本分析是哪个方法出错
	//6.当样本数量很多时比对测试依然正确，可以确定方法A已经正确
	// for test 一个绝对正确的方法，这个方法也可以自己实现
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test 产生一个长度在0-maxSize之间的，数组中的值在-maxValue到maxValue之间的随机数组
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test 生成一个和原数组长度和数组内容都相同的数组
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

	// for test 用来判断两个数组是否相同，大小和内容都相同
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

	// for test 打印数组
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
			bubbleSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}

}
