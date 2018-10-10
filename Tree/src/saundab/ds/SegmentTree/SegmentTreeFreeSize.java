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
		//new SegmentTreeFreeSize ().updateSegmentTree(arr, st, 0, 0, arr.length-1, 1, 10);
		System.out.println(new SegmentTreeFreeSize ().findSumInRange(st, 1, 4, 0, arr.length-1, 0));
		System.out.println("done");
	}

	//QUERY
	//find the sum in range 3-4
	private int findSumInRange(int[] st, int lowRange, int highRange, int start, int end, int stIdx) {
		if(lowRange==start &&highRange==end) {
			return st[stIdx];
		}
		
		int mid=start+(end-start)/2;
		if(lowRange<=mid) {
			if(highRange<=mid) {
				return findSumInRange(st, lowRange, highRange, start, mid, stIdx*2+1);
			}else {
				return findSumInRange(st, lowRange, mid, start, mid, stIdx*2+1)
						+ findSumInRange(st, mid+1, highRange, mid+1, end, stIdx*2+2);
			}
		}else {
			if(highRange<=mid) {
				//not possible
			}else {
				return findSumInRange(st, lowRange, highRange, mid+1, end, stIdx*2+2);
			}
		}
		return -1;
	}
	
	//UPDATE
	private void updateSegmentTree(int[] arr, int[] st, int stIdx, int start, int end, int idx, int val) {
		if(start==end) {
			arr[idx]=val;
			st[stIdx]=val;
		}else {
			int mid=start + (end-start)/2;
			if(idx>=start && idx<=mid) {
				updateSegmentTree(arr, st, 2*stIdx+1, start, mid, idx, val);
			}else {
				updateSegmentTree(arr, st, 2*stIdx+2, mid+1, end, idx, val);
			}
			st[stIdx]=st[2*stIdx+1]+st[2*stIdx+2];
		}
		
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
