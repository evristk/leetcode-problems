package lc_0_500;

import java.util.*;

/**
 * Problem #133 [Medium]
 *  Title: Clone Graph
 *  Link: https://leetcode.com/problems/clone-graph/
 *
 *  Summary: Return a deep copy (clone) of the graph.
 *
 * @author Evripidis
 */
public class CloneGraph_133
{
	/**
	 * Map to keep track of the nodes that we have copied.
	 */
	Map<Integer, Node> deepCopied = new HashMap<>();

	/**
	 * Deep copies the graph that is represented by the given node.
	 */
	public Node deepCopy(Node node)
	{
		if (node == null) {
			return null;
		}

		// Create deep copy of this node.
		Node newNode = new Node(node.val);
		deepCopied.put(node.val, newNode);

		// Make sure deep copies of its neighbors have been created.
		// But be careful don't create duplicates. Keep track of what is created.
		for (Node neighbor : node.neighbors)
		{
			boolean isNeighborCopied = deepCopied.containsKey(neighbor.val);
			Node copiedNeighbor;

			if (isNeighborCopied)
			{
				copiedNeighbor = deepCopied.get(neighbor.val);
			}
			else
			{
				copiedNeighbor = deepCopy(neighbor);
			}

			newNode.neighbors.add(copiedNeighbor);
		}

		return newNode;
	}


	public static void main(String[] args)
	{
		// Adjacency list: For each node in the graph,
		// there is a list of its neighbors.
		// The length of the adjList is the number of unique nodes.
		int[][] adjList  = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};

		CloneGraph_133 cloneGraph = new CloneGraph_133(adjList);
	}

	Map<Integer, Node> createdMap = new HashMap<>();

	public CloneGraph_133(int[][] adjList)
	{
		Node firstNode = null;

		for (int i = 0; i < adjList.length; i++)
		{
			// Create a node for each represented node in adjList
			Node node = this.getOrCreateNode(i + 1, createdMap);

			if (firstNode == null)
			{
				firstNode = node;
			}

			// Create node for each neighbor of current node
			int[] neighbors = adjList[i];

			for (int n : neighbors)
			{
				Node neighborNode = this.getOrCreateNode(n, createdMap);
				node.neighbors.add(neighborNode);
			}
		}

		Node copiedNode = deepCopy(firstNode);

		traverseGraph(firstNode);
		traverseGraph(copiedNode);
	}

	public void traverseGraph(Node firstNode)
	{
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		Stack<Node> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();

		stack.push(firstNode);

		while (!stack.isEmpty())
		{
			Node node = stack.pop();

			if (!visited.contains(node.val))
			{
				List<Integer> neighborList = new ArrayList<>();

				for (Node neighbor : node.neighbors)
				{
					neighborList.add(neighbor.val);
					stack.push(neighbor);
				}

				adjList.put(node.val, neighborList);
				visited.add(node.val);
			}
		}


		adjList.forEach((k, v) -> System.out.println(k + " " + v.toString()));
	}


	/**
	 * Creates or just retrieves already created node with the same value.
	 * This method checks the given map for a node that corresponds to given val.
	 */
	public Node getOrCreateNode(int val, Map<Integer, Node> map)
	{
		Node node;

		if (map.containsKey(val))
		{
			node = map.get(val);
		}
		else
		{
			node = new Node(val);
			map.put(val, node);
		}

		return node;
	}


	/**
	 * Innner class defining a node of a graph.
	 */
	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}
}
