package basic_code.basic_class_03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 队列实现栈，栈实现队列
 */
public class Code_03_StackAndQueueConvert {
	/**
	 * 栈实现队列
	 */
	public static class TwoStacksQueue {
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;

		public TwoStacksQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}
		//push的时候就放入push栈
		public void push(int pushInt) {
			stackPush.push(pushInt);
		}
		//poll的时候如果pop栈有数据，就弹出，没有数据就将push栈里的所有数据一个一个pop出来，放进pop栈，然后再弹出
		public int poll() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}
		//peek方法和pop方法类似，只是最后调用的是pop的peek方法
		public int peek() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.peek();
		}
	}

	/**
	 * 队列实现栈
	 */
	public static class TwoQueuesStack {
		private Queue<Integer> queue;
		private Queue<Integer> help;

		public TwoQueuesStack() {
			queue = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}
		//push的时候放进queue队列即可
		public void push(int pushInt) {
			queue.add(pushInt);
		}
		//peek和pop操作一样
		public int peek() {
			if (queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (queue.size() != 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			help.add(res);
			swap();
			return res;
		}
		//pop的时候将queue队列中的一个一个弹出，然后放到help队列中，最后queue队列中只剩一个，将其弹出即可
		//然后交换queue和help所指的队列
		public int pop() {
			if (queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (queue.size() != 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			swap();
			return res;
		}
		//交换help和queue变量所指的队列
		private void swap() {
			Queue<Integer> tmp = help;
			help = queue;
			queue = tmp;
		}

	}

}
