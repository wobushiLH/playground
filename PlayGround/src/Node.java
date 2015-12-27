
public class Node {
	
	private boolean isRoot;
	private boolean isEnd;
	
	
	private int degree;
	private int level;
	private int height;
	
	
	private int nodeValue;
	private Node leftNode;
	private Node rightNode;
	
	public Node(){
	}
	
	public Node(int nodeValue, Node leftNode, Node rightNode){
		this.isRoot = false;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		
		this.nodeValue = nodeValue;
		
		if ((rightNode == null)&&(leftNode == null))
			this.isEnd = true;
		else
			this.isEnd = false;
	}
	
	public int getNodeValue(){
		return nodeValue;
	}
	
	public int getHeight(){
		return height;
	}	
	
	public void setLevel(int nodeValue){
		if (this.nodeValue == nodeValue){
			
		}
		
	}
	
	public int getLevel(){
		return level;
	}	
	
	public int getDegree(){
		return degree;
	}
	
	
	
	
	public void setRoot(){
		this.isRoot = true;
	}
	public boolean getIsRoot(){
		return isRoot;
	}
	
	public boolean getIsEnd(){
		return isEnd;
	}
	
	public Node getLeftNode(){
		return leftNode;
	}
	public Node getRightNode(){
		return rightNode;
	}
	
	public void addLeftNode (Node leftNode){
		this.leftNode = leftNode;
	}
	public void addRightNode (Node rightNode){
		this.rightNode = rightNode;
	}
	public boolean hasLeftNode(){
		if (leftNode == null)
			return false;
		return true;
	}
	public boolean hasRightNode(){
		if (rightNode == null)
			return false;
		return true;
	}	
}


























