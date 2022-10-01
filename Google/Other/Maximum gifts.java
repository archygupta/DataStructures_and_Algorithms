import java.util.*;

//class Pair{
//	int day;
//	int cost;
//	public Pair(int day, int cost) {
//		this.day=day;
//		this.cost=cost;
//	}
//}

public class MaximumGifts {
	static HashMap<String, Integer> map = new HashMap<>();
	public static int findMaxGifts(int amount, int[] day, int[] cost, int idx, int n) {
		
		if(idx>=n)
			return 0;
		
		if(idx!=0) {
			amount += day[idx] - day[idx-1];
		}
		
		int res = 0;
		String key =day[idx]+","+cost[idx]+","+amount;
		if(map.containsKey(key))
			return map.get(key);
		
		
		if(amount >= cost[idx]) {
		  res = Math.max(1+ findMaxGifts(amount-cost[idx], day, cost, idx+1, n), findMaxGifts(amount, day, cost, idx+1, n));
			
		}
		else {
			res = findMaxGifts(amount, day, cost, idx+1, n);
		}
		map.put(key, res);
		return res;
	}
		

	public static void main(String[] args) {
	int n = 4;
	int[] day = new int[] {3,5,6,7};
	int[] cost = new int[] {2,3,2,3};
	System.out.println(findMaxGifts(day[0], day, cost, 0, n));
	
	n = 3;
	day = new int[] {100,101,102};
    cost = new int[] {100,3,2};
    System.out.println(findMaxGifts(day[0], day, cost, 0, n));
	}
}
