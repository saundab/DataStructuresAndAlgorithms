package stairs;

public class WaysToNthStair {

	public static void main(String[] args) {
		new WaysToNthStair().find();
	}

	private void find() {
		int N=5;
		System.out.println("Total no. of ways :"+find(N, ""));
	}

	private int find(int N, String str) {
		if(N==0) {System.out.println(str); return 1;}
		if(N<0) return 0;
		
		int ways=0;
		for(int steps=1; steps<=N; steps++) {
			ways+=find(N-steps, str+steps);
		}
		
		return ways;
	}
}
