
public class BinaryTree {
	
	private Node tree;
	
	public BinaryTree() {
		
	}
	public BinaryTree (Node tree){
		this.tree = tree;
	}
	
	public Node getTree(){
		return tree;
	}
	
	
	public Node getNodeLevelByValue(int value){
		
		
		
		
		return new Node();
	}
	

	// Get node level by its node value
	// need to call the method "nodeIsInTree(Node tree, int nodeValue)" every recursion
	public int getNodeLevel(int count, Node root, int nodeValue){
		int level = count;
		if (root.hasLeftNode()&&nodeIsInTree(root.getLeftNode(), nodeValue))
			level = 1 + getNodeLevel(level, root.getLeftNode(), nodeValue);
		if (root.hasRightNode()&&nodeIsInTree(root.getRightNode(), nodeValue))
			level = 1 + getNodeLevel(level, root.getRightNode(), nodeValue);
		return level;
	}
	
	// Check the existence of a node with a given node value
	public boolean nodeIsInTree(Node tree, int nodeValue){
		if (tree == null)
			return false;
		if (tree.getNodeValue() == nodeValue)
			return true;
		if (nodeIsInTree(tree.getLeftNode(), nodeValue)||nodeIsInTree(tree.getRightNode(), nodeValue))
			return true;
		return false;
	}
	
	
	// Get node access number
	public int accessCounter(int count, Node node){
		int result = count;
		if (node == null){
			return 0;
		}
		result = result + 1;
		return result + accessCounter(result, node.getLeftNode()) + accessCounter(result, node.getRightNode());
	}		
	
	// calculate tree height
	public int getTreeHeight(int count, Node node){
		int leftHeight = count;
		int rightHeight = count;
		if (node == null)
			return 0;
		if (!node.hasLeftNode()&&!node.hasRightNode())
			return 1;
		else{
			if (node.hasLeftNode())
				leftHeight = 1 + getTreeHeight(leftHeight, node.getLeftNode());
			if (node.hasRightNode())
				rightHeight = 1 + getTreeHeight(rightHeight, node.getRightNode());
				
			if (rightHeight < leftHeight)	
				return leftHeight;
			return rightHeight;			
		}
	}	
	
	
	
	
}
































