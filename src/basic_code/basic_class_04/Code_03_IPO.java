package basic_code.basic_class_04;

import java.util.Comparator;
import java.util.PriorityQueue;
//第8讲
//项目利润问题，看怎么做项目利润最大
/**
 * 输入：
 * 参数1，正数数组costs,costs[i]表示i号项目的花费
 * 参数2，正数数组profits,profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 * 参数3，正数k,表示你不能并行、只能串行的最多做k个项目
 * 参数4，正数m, 表示你初始的资金
 * 说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个项目。
 * 输出：你最后获得的最大钱数。
 */
public class Code_03_IPO {
	public static class Node {
		public int p;//项目代价
		public int c;//项目利润

		public Node(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}

	public static class MinCostComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o1.c - o2.c;
		}

	}

	public static class MaxProfitComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o2.p - o1.p;
		}

	}

	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		Node[] nodes = new Node[Profits.length];
		for (int i = 0; i < Profits.length; i++) {
			nodes[i] = new Node(Profits[i], Capital[i]);
		}

		PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
		PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
		for (int i = 0; i < nodes.length; i++) {
			minCostQ.add(nodes[i]);
		}
		for (int i = 0; i < k; i++) {
			while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
				maxProfitQ.add(minCostQ.poll());
			}
			if (maxProfitQ.isEmpty()) {
				return W;
			}
			W += maxProfitQ.poll().p;
		}
		return W;
	}

}
