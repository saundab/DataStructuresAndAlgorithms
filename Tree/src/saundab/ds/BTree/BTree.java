package saundab.ds.BTree;

/**
 * @author Abhinav Saund
 * B-tree insert
 * working example took 3 days
 * still needs improvement
 * 	1. max degree should be a dynamic(even only) value. Currently its 4
 * 	2. the insertion login can be called from inside split itself thus saving unnecessary traversal
 *
 */
public class BTree {

	public static void main(String[] args) throws Exception {
		Node root=null;
		root = new BTree().insert(null, 100);
		root = new BTree().insert(root, 200);
		root = new BTree().insert(root, 300);
		root = new BTree().insert(root, 400);
		root = new BTree().insert(root, 500);
		root = new BTree().insert(root, 600);
		root = new BTree().insert(root, 700);
		root = new BTree().insert(root, 800);
		root = new BTree().insert(root, 900);
		root = new BTree().insert(root, 1000);
		
		System.out.println("hell");
	}
	
	private Node insert(Node root, int ele) throws Exception {
		if(root==null) {
			Node n = new Node(4);
			n.val[0]=ele;
			return n;
		}
		
		//after this call there should be no more splits and so the inserts should be straight
		split(root, ele);
		
		root=insert2(root, ele);
		
		return root;
	}
	
	private Node insert2(Node root, int ele) throws Exception {
		int i=0;
		while(i<root.val.length && root.val[i]!=null && ele>root.val[i]) {
			i++;
		}
		if(i<root.val.length && null!=root.val[i] && ele==root.val[i]) {//already exists
			return root;
		}
		
		//here i=0 || i<arr.length; in both the cases, child may exist 
		if(i<=root.val.length && root.child[i]!=null) {
			root.child[i]= insert2(root.child[i], ele);
		}else if(i<root.val.length){
			//insert at i
			for (int j=root.val.length-1; j>i && j>=0; j--) {
				root.val[j]=root.val[j-1];
			}
			
			root.val[i]=ele;
		}
		return root;
	}

	private Node split(Node root, int ele) throws Exception {
		if(isNodeFull(root)) {
			int mid = (root.val.length-1)/2;
			Node c1=copyNode(root, 0, mid);
			Node c2=copyNode(root, mid+1, root.val.length);
			
			int val=root.val[mid];
			for(int i=0; i<root.val.length; i++) {
				root.val[i]=null;
				root.child[i]=null;
			}
			root.child[root.val.length]=null;
			
			root.val[0]=val;
			root.child[0]=c1;
			root.child[1]=c2;
			
			return root;
		}
		
		//node is not full
		//1. find place to insert
		int i=0;
		while(i<root.val.length && root.val[i]!=null && ele>root.val[i]) {
			i++;
		}
		if(null!=root.val[i] && ele==root.val[i]) {//already exists
			return null;
		}
		if(i==root.val.length) {//not possible as this means that the split did not work and it should have happened above
			throw new Exception("check this");
		}
		
		//here i=0 || i<arr.length; in both the cases, child may exist 
		if(root.child[i]!=null) {
			Node n=split(root.child[i], ele);
			if(n!=null) {//insert it into its rightfull position
				for(int j=root.val.length-1; j>i; j--) {
					root.val[j]=root.val[j-1];
					root.child[j]=root.child[j-1];
				}
				root.val[i]=n.val[0];
				root.child[i]=n.child[0];
				root.child[i+1]=n.child[1];
			}
		}
			
		return null;
	}

	private Node copyNode(Node root, int low, int high) {
		Node newNode = new Node(4); 
		int newPos=0;
		for(int i=low; i<high; i++) {
			newNode.val[newPos]=root.val[i];
			newNode.child[newPos]=root.child[i];
			newPos++;
		}
		newNode.child[newPos]=root.child[high];
		
		return newNode;
	}

	private boolean isNodeFull(Node root) {
		if(root==null)
			return true;
		
		int count=0;
		for(int i=0; i<root.val.length; i++) {
			if(root.val[i]!=null)
				count++;
		}
		
		if(count==root.val.length) {
			return true;
		}
		
		return false;
	}

	private class Node{
		Integer[] val;
		Node[] child;
		Node(int k){
			val=new Integer[k-1];
			child=new Node[k];
		}
	}
}
