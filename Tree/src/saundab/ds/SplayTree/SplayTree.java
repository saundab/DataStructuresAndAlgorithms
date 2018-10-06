package saundab.ds.SplayTree;

/**
 * 
 * @author Abhinav Saund
 * Title: Splay Tree
 * Desc: Changes the tree on search operation. The node searched for becomes the root.
 *	
 */
public class SplayTree {

	public static void main(String[] args) {
		Node root=new SplayTree().makeBST();
		
		Node searchNode=new SplayTree().search(root, 4);
		if(searchNode==null) {
			System.out.println("Not found");
		}else {
			root=searchNode;
		}
		
		
	}

	private Node makeBST() {
		Node root=null;
		root=insert(root, 5);
		root=insert(root, 3);
		root=insert(root, 4);
		root=insert(root, 2);
		root=insert(root, 10);
		root=insert(root, 15);
		root=insert(root, 7);
		return root;
	}
	
	private Node search(Node root, int ele) {
		if(root==null)
			return null;
		if(root.val==ele) {
			return root;
		}
		if(ele < root.val) {//left-zig
			if(root.left==null) {
				return null;
			}else {
				if(ele <= root.left.val) {//left-zig-> left-zig
					root=rightRotation(root);
				}else if(ele > root.left.val){//left-zig-> right-zag
					root.left=leftRotation(root.left);
					root=rightRotation(root);
				}
			}
		}else if(ele > root.val){//right-zig
			if(root.right==null) {
				return null;
			}else {
				if(ele < root.right.val) {//right-zig -> left-zag
					root.right=rightRotation(root.right);
					root=leftRotation(root);
				}else if(ele >= root.right.val) {//right-zig -> right-zag
					root=leftRotation(root);
				}
			}
		}
		
		return search(root, ele);
	}

	private Node leftRotation(Node node) {
		Node right=node.right;
		node.right=right.left;
		right.left=node;
		
		return right;
	}

	private Node rightRotation(Node node) {
		Node left=node.left;
		node.left=left.right;
		left.right=node;
		
		return left;
	}

	private Node insert(Node root, int ele) {
		if(root==null)
			return new Node(ele);
		
		if(ele < root.val) {
			root.left=insert(root.left, ele);
		}else if(ele > root.val) {
			root.right=insert(root.right, ele);
		}
		
		return root;
	}

	private class Node{
		int val;
		Node left, right;
		Node(int val){
			this.val=val;
		}
	}
}
