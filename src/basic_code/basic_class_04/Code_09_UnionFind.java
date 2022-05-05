package basic_code.basic_class_04;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

//并查集结构
public class Code_09_UnionFind {

	public static class Node {
		// whatever you like
	}

	public static class DisjointSets {
		public HashMap<Node, Node> fatherMap;
		public HashMap<Node, Integer> rankMap;

		public DisjointSets() {
			fatherMap = new HashMap<Node, Node>();
			rankMap = new HashMap<Node, Integer>();
		}

		//将list放入结构初始化
		public void makeSets(List<Node> nodes) {
			fatherMap.clear();
			rankMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				rankMap.put(node, 1);
			}
		}
		//findFather递归版
		public Node findFather(Node node) {
			Node father = fatherMap.get(node);
			if (father != node) {
				father = findFather(father);
			}
			fatherMap.put(node, father);
			return father;
		}

		//findFather迭代版
		public Node findFather2(Node node) {
			Stack<Node> stack = new Stack<>();
			Node cur = node;
			Node parent = fatherMap.get(cur);
			while (cur != parent){
				stack.push(cur);
				cur = parent;
				parent = fatherMap.get(cur);
			}
			while (!stack.isEmpty()){
				fatherMap.put(stack.pop(),parent);
			}
			return parent;
		}

		//并查集功能1，判断两个是否是同一个结构
		public boolean isSameSet(Node a, Node b){
			return findFather(a) == findFather(b);
		}
		//并查集功能2，两个结构合并为一个
		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aFather = findFather(a);
			Node bFather = findFather(b);
			if (aFather != bFather) {
				int aFrank = rankMap.get(aFather);
				int bFrank = rankMap.get(bFather);
				if (aFrank <= bFrank) {
					fatherMap.put(aFather, bFather);
					rankMap.put(bFather, aFrank + bFrank);
				} else {
					fatherMap.put(bFather, aFather);
					rankMap.put(aFather, aFrank + bFrank);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
