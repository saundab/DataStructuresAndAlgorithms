package baloonBurst;

import java.util.ArrayList;
import java.util.List;

//Find all permutations of the INDICES. 
//once a permutation is finished, calculate the cost by following the permuted index 

public class BaloonBurst_Recursive {

	public static void main(String[] args) {
		new BaloonBurst_Recursive().find();
	}

	private void find() {
		int[] arr= {3,1,5,8};
		
		int[] idxArr = new int[arr.length];
		int count=0;
		for(int i=0;i<arr.length;i++) {
			idxArr[i]=count++;
		}
		
		int maxPoints=find(arr, idxArr, 0);
		System.out.println("maxPoints : " + maxPoints);
	}

	//method to permute
	private int find(int[] arr, int[] idxArr, int start) {
		if(start==idxArr.length-1) {
			return calculateCost(arr, idxArr);
		}
		
		int max=0;
		for(int i=start; i<idxArr.length; i++) {
			int currMax=0;
			
			swap(idxArr, start, i);
			
			currMax=find(arr, idxArr, start+1);
			max=Math.max(max, currMax);
			
			swap(idxArr, start, i);
		}
		
		return max;
	}

	//method to follow the permuted indices and calculate cost
	private int calculateCost(int[] arr, int[] arrIdx) {
		int cost=0;
		
		List<Integer> bursted = new ArrayList<>();
		for(int i=0;i<arrIdx.length;i++) {
		
			int idx=arrIdx[i];
			
			bursted.add(new Integer(idx));
			
			cost=cost 
				+ arr[idx]*elementToleft(arr, idx, bursted)*elementToRight(arr, idx, bursted);
		}
		
		for(int i=0;i<arrIdx.length;i++) {
			System.out.print(arr[arrIdx[i]] + " ");
		}
		System.out.print(" - " + cost);
		System.out.println();
		
		return cost;
	}

	private void swap(int[] arr, int i, int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	
	private int elementToRight(int[] arr, int idx, List<Integer> bursted) {
		int i=idx+1;
		int val=1;
		while(i<arr.length) {
			if(!bursted.contains(i)) {
				val=arr[i];
				break;
			}
			i++;
		}
		return val;
	}

	private int elementToleft(int[] arr, int idx, List<Integer> bursted ) {
		int i=idx-1;
		int val=1;
		while(i>=0) {
			if(!bursted.contains(i)) {
				val=arr[i];
				break;
			}
			i--;
		}
		return val;
	}

}