
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nodeValue = 67;
		
		BinaryTree unbalancedTree = new BinaryTree(new TreeTemplate("unbalancedTree").getTree());
		BinaryTree balancedTree = new BinaryTree(new TreeTemplate("balancedTree").getTree());
		
		System.out.println("Unbalanced Tree:");
		System.out.print("	Tree Height: ");
		System.out.println((double)unbalancedTree.getTreeHeight(0,unbalancedTree.getTree()));
		System.out.print("	Average of node accesses from root node:  ");
		System.out.println((double)unbalancedTree.accessCounter(0, unbalancedTree.getTree())/11);
		System.out.print("	Check whether there exists a node with node value equals " + nodeValue + ": ");
		System.out.println(unbalancedTree.nodeIsInTree(unbalancedTree.getTree(), nodeValue));
		System.out.print("	Get the level of node with node value equals " + nodeValue + ": ");
		System.out.println((double)unbalancedTree.getNodeLevel(1,unbalancedTree.getTree(), nodeValue));
		
		System.out.println(" ");
		System.out.println("Balanced Tree:");
		System.out.print("	Tree Height: ");
		System.out.println((double)balancedTree.getTreeHeight(0,balancedTree.getTree()));
		System.out.print("	Average of node accesses from root node:  ");
		System.out.println((double)balancedTree.accessCounter(0, balancedTree.getTree())/11);
		System.out.print("	Check whether there exists a node with node value equals " + nodeValue + ": ");
		System.out.println(balancedTree.nodeIsInTree(balancedTree.getTree(), nodeValue));
		System.out.print("	Get the level of node with node value equals " + nodeValue + ": ");
		System.out.println((double)balancedTree.getNodeLevel(1,balancedTree.getTree(), nodeValue));
	
	}
}


















