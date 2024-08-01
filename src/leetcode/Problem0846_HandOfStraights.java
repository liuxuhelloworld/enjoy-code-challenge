package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem0846_HandOfStraights {
	public boolean isNStraightHand(int[] hand, int groupSize) {
		int len = hand.length;
		if (len % groupSize != 0) {
			return false;
		}

		Arrays.sort(hand);

		Map<Integer, Integer> cnt = new HashMap<>();
		for (int val : hand) {
			cnt.put(val, cnt.getOrDefault(val, 0) + 1);
		}

		for (int val : hand) {
			boolean contains = cnt.containsKey(val);
			if (!contains) {
				continue;
			}

			for (int i = 0; i < groupSize; i++) {
				int neededVal = val + i;
				contains = cnt.containsKey(neededVal);
				if (!contains) {
					return false;
				} else {
					int valCnt = cnt.get(neededVal);
					--valCnt;
					if (valCnt > 0) {
						cnt.put(neededVal, valCnt);
					} else {
						cnt.remove(neededVal);
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Problem0846_HandOfStraights obj = new Problem0846_HandOfStraights();
		System.out.println(obj.isNStraightHand(new int[] {1,2,3,6,2,3,4,7,8}, 3));
		System.out.println(obj.isNStraightHand(new int[] {1,2,3,4,5}, 5));
	}
}
