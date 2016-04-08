package AssociationAnalysis.DataMining_FPTree;

import java.util.ArrayList;

/**
 * FP树节点
 * 
 * @author Qstar
 * 
 */
class TreeNode implements Comparable<TreeNode>, Cloneable{
	// 节点类别名称
	private String name;
	// 计数数量
	private Integer count;
	// 父亲节点
	private TreeNode parentNode;
	// 孩子节点，可以为多个
	private ArrayList<TreeNode> childNodes;
	
	TreeNode(String name, int count){
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

    public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	TreeNode getParentNode() {
		return parentNode;
	}

	void setParentNode(TreeNode parentNode) {
		this.parentNode = parentNode;
	}

	ArrayList<TreeNode> getChildNodes() {
		return childNodes;
	}

	void setChildNodes(ArrayList<TreeNode> childNodes) {
		this.childNodes = childNodes;
	}

	@Override
	public int compareTo(TreeNode o) {
		// TODO Auto-generated method stub
		return o.getCount().compareTo(this.getCount());
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		//因为对象内部有引用，需要采用深拷贝
		TreeNode node = (TreeNode)super.clone(); 
		if(this.getParentNode() != null){
			node.setParentNode((TreeNode) this.getParentNode().clone());
		}
		
		if(this.getChildNodes() != null){
			node.setChildNodes((ArrayList<TreeNode>) this.getChildNodes().clone());
		}
		
		return node;
	}
	
}
