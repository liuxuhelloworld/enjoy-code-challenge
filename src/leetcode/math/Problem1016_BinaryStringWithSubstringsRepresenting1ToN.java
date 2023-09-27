package leetcode.math;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1016_BinaryStringWithSubstringsRepresenting1ToN {
	public boolean queryString(String s, int n) {
		String binary = toBinaryString(n);

		Queue<String> queue = new LinkedList<>();
		queue.add("1");

		while (true) {
			int size = queue.size();
			while (size-- > 0) {
				String cur = queue.poll();

				if (!s.contains(cur)) {
					return false;
				}

				if (cur.equals(binary)) {
					return true;
				}

				queue.add(cur + "0");
				queue.add(cur + "1");
			}
		}
	}

	private String toBinaryString(int n) {
		StringBuilder builder = new StringBuilder();
		while (n != 0) {
			int remainder = n % 2;
			builder.append(remainder);
			n = n / 2;
		}

		return builder.reverse().toString();
	}

	public static void main(String[] args) {
		Problem1016_BinaryStringWithSubstringsRepresenting1ToN obj =
			new Problem1016_BinaryStringWithSubstringsRepresenting1ToN();
		System.out.println(obj.queryString("0110", 4));
	}
}
