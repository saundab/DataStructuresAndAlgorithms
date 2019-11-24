package JobScheduling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WeightedJobScheduling {

	public static void main(String[] args) {
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1,3,5));
		points.add(new Point(2,5,6));
		points.add(new Point(4,6,5));
		points.add(new Point(6,7,4));
		points.add(new Point(5,8,11));
		points.add(new Point(7,9,2));
		
		Collections.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.start.compareTo(o2.start);
			}
		});
		
		System.out.println(new WeightedJobScheduling().getMaxValueForSchedule(points, 0, 0, null));
		System.out.println(new WeightedJobScheduling().getMaxValueSchedule(points, 0, 0, null, new ArrayList<>()));
	}
	
	private Result getMaxValueSchedule(List<Point> points, int idx, int sum, Point lastPoint, List<Point> p) {
		if(idx==points.size()) {
			Result r=new Result();
			r.value=sum;
			
			for(Point p1:p)
				r.choosenPoints.add(p1);
			
			return r;
		}
		if(idx>points.size())
			return new Result();
		
		Result takeIt=new Result();
		Result leaveIt=new Result();
		
		//take it - whether to take the current point
		Point curr=points.get(idx);
		if(null==lastPoint) {
			p.add(curr);
			takeIt=getMaxValueSchedule(points, idx+1, sum+curr.value, curr, p);
			p.remove(curr);
		}else {
			if(curr.start>=lastPoint.end) {
				p.add(curr);
				takeIt=getMaxValueSchedule(points, idx+1, sum+curr.value, curr, p);
				p.remove(curr);
			}
		}
		
		leaveIt=getMaxValueSchedule(points, idx+1, sum, lastPoint, p);
		
		return takeIt.value>leaveIt.value?takeIt:leaveIt;
	}
	
	private int getMaxValueForSchedule(List<Point> points, int idx, int sum, Point lastPoint) {
		if(idx==points.size())
			return sum;
		if(idx>points.size())
			return 0;
		
		int takeIt=0;
		int leaveIt=0;
		
		//take it - whether to take the current point
		Point curr=points.get(idx);
		if(null==lastPoint) {
			takeIt=getMaxValueForSchedule(points, idx+1, sum+curr.value, curr);
		}else {
			if(curr.start>=lastPoint.end)
				takeIt=getMaxValueForSchedule(points, idx+1, sum+curr.value, curr);
		}
		
		leaveIt=getMaxValueForSchedule(points, idx+1, sum, lastPoint);
		
		return Math.max(takeIt,  leaveIt);
	}
	
}

class Result{
	int value=0;
	List<Point> choosenPoints = new ArrayList<>();
	
	@Override
	public String toString() {
		return value+" "+choosenPoints;
	}
}

class Point{
	Integer start;
	Integer end;
	Integer value;
	Point(int start, int end, int value){
		this.start=start;
		this.end=end;
		this.value=value;
	}
	@Override
	public String toString() {
		return "["+ start +","+ end +","+ value +"]";
	}
}
