package basic_code.basic_class_07;

/**
 * 打印一个字符串的全部子序列，包括空字符串
 */
public class Code_03_Print_All_Subsquences {

	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		printAllSub(chs, 0, "");
	}

	public static void printAllSub(char[] arr, int i, String res) {
		if (i == arr.length){
			System.out.println(res);
			return;
		}
		printAllSub(arr, i+1, res);
		printAllSub(arr, i+1, String.valueOf(res + arr[i]));
	}

	public static void main(String[] args) {
		String test = "abc";
		printAllSubsquence(test);
	}

}
