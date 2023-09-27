package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class Problem846_HandOfStraights {
	public boolean isNStraightHand(int[] hand, int groupSize) {
		int len = hand.length;
		if (len % groupSize != 0) {
			return false;
		}

		Map<Integer, Integer> cnt = new TreeMap<>();
		for (int i = 0; i < len; i++) {
			cnt.put(hand[i], cnt.getOrDefault(hand[i], 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
			int key = entry.getKey();
			int val = entry.getValue();

			if (val == 0) {
				continue;
			}

			cnt.put(key, 0);
			for (int j = 1; j < groupSize; j++) {
				if (!cnt.containsKey(key + j)
					|| cnt.get(key + j) < val) {
					return false;
				} else {
					cnt.put(key + j, cnt.get(key + j) - val);
				}
			}
		}

		return cnt.values().stream()
			.allMatch(e -> e == 0);
	}

	public static void main(String[] args) {
		Problem846_HandOfStraights obj = new Problem846_HandOfStraights();
		System.out.println(obj.isNStraightHand(new int[] {1,2,3,6,2,3,4,7,8}, 3));
		System.out.println(obj.isNStraightHand(new int[] {1,2,3,4,5}, 5));
	}
}
