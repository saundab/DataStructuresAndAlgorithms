package saundab.ds.SegmentTree;

/**
 * @author Abhinav Saund
 * 
 * SEGMENT TREE
 * A tree ds used to store info about intervals/segments
 * 
 * Operations
 * 1. Construct tree
 * 2. update tree
 * 
 * Conditions:
 * 1. The array can be of any size. 
 *    We need to make the tree balanced so we will be padding elements.
 *
 */
public class SegmentTreeFreeSize {

	public static void main(String[] args) {
		int[] arr= {11,12,13,14,15,16};
		int[] st=new SegmentTreeFreeSize ().createSegmentTree(arr);
		new SegmentTreeFreeSize ().updateSegmentTree(arr, st, 1, 110);
	}

	//UPDATE
	private void updateSegmentTree(int[] arr, int[] st, int idx, int val) {
		
		
	}

	//CREATE
	private int[] createSegmentTree(int[] arr) {
		int x=(int) Math.ceil(Math.log(arr.length)/Math.log(2));
		int size=(int) (2*Math.pow(2,  x)-1);
		int[] st=new int[size];
		
		createSumSegmentTree(arr, st, 0, 0, arr.length-1);
		return st;
	}

	private int createSumSegmentTree(int[] arr, int[] st, int idx, int start, int end) {
		if(start==end) {
			st[idx]=arr[start];
			return st[idx];
		}
		int mid=start + (end-start) / 2;
		st[idx]=createSumSegmentTree(arr, st, 2*idx+1, start, mid)
				+ createSumSegmentTree(arr, st, 2*idx+2, mid+1, end);
		return st[idx];
	}
	
}
