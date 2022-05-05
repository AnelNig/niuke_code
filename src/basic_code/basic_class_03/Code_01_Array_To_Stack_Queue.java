package basic_code.basic_class_03;

/**
 * 数组实现大小固定的栈和队列
 */
public class Code_01_Array_To_Stack_Queue {
	/**
	 * 数组实现栈
	 */
	public static class ArrayStack {
		private Integer[] arr;
		private Integer size;

		public ArrayStack(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			//size指向的始终是栈中空着的第一个位置
			size = 0;
		}
		//返回栈顶的元素，但不删除这个元素
		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[size - 1];
		}

		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			arr[size++] = obj;
		}
		//返回栈顶元素并删除这个元素
		public Integer pop() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			return arr[--size];
		}
	}

	/**
	 * 数组实现队列
	 */
	public static class ArrayQueue {
		private Integer[] arr;
		private Integer size;
		private Integer first;
		private Integer last;

		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			//size用来辅助判断这个队列中存储的元素个数
			size = 0;
			//first是取数据用的指针，始终指向存放数据的第一条
			//last是用来放数据的指针，始终指向需要放数据的第一个位置
			first = 0;
			last = 0;
		}
		//队列的peek方法就是取出队列中第一个数，但是不删除
		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[first];
		}

		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			size++;
			arr[last] = obj;
			last = last == arr.length - 1 ? 0 : last + 1;
		}

		public Integer poll() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			size--;
			int tmp = first;
			first = first == arr.length - 1 ? 0 : first + 1;
			return arr[tmp];
		}
	}

	public static void main(String[] args) {
		
	}

}
