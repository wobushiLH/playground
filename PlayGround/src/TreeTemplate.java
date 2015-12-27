
public class TreeTemplate {

	private Node tree;
	
	public TreeTemplate(String treeTemplate){
		if (treeTemplate.equals("unbalancedTree"))
			this.tree = getUnbalancedTree();
		if (treeTemplate.equals("balancedTree"))
			this.tree = getBalancedTree();
	}
	
	public Node getTree(){
		return tree;
	}
	
	private Node getUnbalancedTree(){
		// left branch 1
		Node node12 = new Node(12, null, null);
		Node node14 = new Node(14, node12, null);
		Node node9 = new Node(9, null, node14);
		// left branch 2
		Node node19 = new Node(19, null, null);
		Node node23 = new Node(23, node19, null);
		// left branch
		Node node17 = new Node(17, node9, node23);
		// right branch
		Node node67 = new Node(67, null, null);	
		Node node72 = new Node(72, node67, null);
		Node node54 = new Node(54, null, node72);
		Node node76 = new Node(76, node54, null);
		// whole tree
		Node rootNode = new Node(50, node17, node76);
		return rootNode;
	}
	
	private Node getBalancedTree(){
		Node node9 = new Node(9, null, null);
		Node node14 = new Node(14, null, null);
		Node node12 = new Node(12, node9, node14);
		
		Node node19 = new Node(19, null, null);
		Node node23 = new Node(23, node19, null);
		Node node17 = new Node(17, node12, node23);
		
		Node node67 = new Node(67, null, null);
		Node node54 = new Node(54, null, node67);
		Node node76 = new Node(76, null, null);
		Node node72 = new Node(72, node54, node76);
		
		Node rootNode = new Node(50, node17, node72);
		return rootNode;
	}
		
	
}
