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
 * 1. The array size should be a power of 2
 *
 */
public class SegmentTree {

	public static void main(String[] args) {
		SegmentTree st = new SegmentTree();
		int[] arr={1,2,3,4,5,6,7,8};
		int[] segmentTree=st.constructSegmentTree(arr);
		st.update(arr, segmentTree, 0, 10);
	}

	private int[] constructSegmentTree(int[] arr) {
		int len=2*arr.length;
		int[] st=new int[len];
		int j=arr.length-1;
		
		for(int i=len-1; i>0; i--) {
			if(j>=0) {
				st[i]=arr[j--];
			}else {//j<0
				st[i]=Math.min(st[2*i],st[2*i+1]);
			}
		}
		return st;
	}
	
	private void update(int[] arr, int[] st, int idx, int val) {
		int newIdx=arr.length + idx;
		
		st[newIdx]=val;
		int parIdx=newIdx/2;
		
		while(parIdx>0) {
			st[parIdx]=Math.min(st[2*parIdx],st[2*parIdx+1]);
			parIdx=parIdx/2;
		}
	}
	
}
