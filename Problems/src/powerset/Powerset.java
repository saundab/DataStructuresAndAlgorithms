package powerset;

public class Powerset {

	public static void main(String[] args) {
		new Powerset().find();
	}

	private void find() {
		String[] arr= {"A","B","C"};
		find(arr, 0, "");
	}

	private void find(String[] arr, int idx, String str) {
		if(idx==arr.length) {
			System.out.println(str==""?"phi":str);
			return;
		}
		find(arr, idx+1, str+arr[idx]);
		find(arr, idx+1, str);
		
		return;
	}
}
