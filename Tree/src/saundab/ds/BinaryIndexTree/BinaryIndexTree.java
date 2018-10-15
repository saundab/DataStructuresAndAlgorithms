package saundab.ds.BinaryIndexTree;

/**
 * @author Abhinav Saund
 * 
 * BINARY INDEX TREE or FENWICK TREE 
 * Its not a binary tree but an n-ary tree.
 * The number of children is random based on the binary value of the int index
 *
 */
public class BinaryIndexTree {

	public static void main(String[] args) {
		int[] arr= {2,1,1,3,2,3,4,5,6,7,8,9};
		int[] BIT=new BinaryIndexTree().makeTree(arr);
		System.out.println(new BinaryIndexTree().getSumTill(BIT, 11));
		
		System.out.println("done");
	}

	private int getSumTill(int[] BIT, int idx) {
		int count=0;
		for(idx=idx+1;idx>0; idx-=idx&(-idx)) {
			count+=BIT[idx];
		}
		return count;
	}

	private int[] makeTree(int[] arr) {
		int[] BIT=new int[arr.length+1];
		for(int i=0; i<arr.length; i++) {
			update(BIT, i, arr[i]);
		}
		return BIT;
	}

	private void update(int[] BIT, int i, int val) {
		int idx=i+1;
		for(;idx<BIT.length; idx+= idx&(-idx)) {
			BIT[idx]+=val;
		}
	}
	
}
