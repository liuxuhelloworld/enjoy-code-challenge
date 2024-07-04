package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/binary-watch/
 */
public class Problem0401_BinaryWatch {
	public List<String> readBinaryWatch(int turnedOn) {
		List<String> list = new ArrayList<>();

		int[] binaryOneCnt = new int[64];
		for (int i = 0; i < 64; i++) {
			binaryOneCnt[i] = cntBinaryOne(i);
		}

		StringBuilder builder = new StringBuilder();

		for (int hour = 0; hour <= 11; hour++) {
			int hourBinaryOneCnt = binaryOneCnt[hour];
			for (int minute = 0; minute <= 59; minute++) {
				int minuteBinaryOneCnt = binaryOneCnt[minute];
				if (hourBinaryOneCnt + minuteBinaryOneCnt == turnedOn) {
					builder.setLength(0);
					builder.append(hour);
					builder.append(":");
					builder.append(minute < 10 ? "0" + minute : minute);
					list.add(builder.toString());
				}
			}
		}

		return list;
	}

	private int cntBinaryOne(int val) {
		int cnt = 0;
		while (val != 0) {
			cnt++;
			val &= (val - 1);
		}

		return cnt;
	}

	public static void main(String[] args) {
		Problem0401_BinaryWatch obj = new Problem0401_BinaryWatch();
		System.out.println(obj.readBinaryWatch(9));
		System.out.println(obj.readBinaryWatch(2));
		System.out.println(obj.readBinaryWatch(0));
		System.out.println(obj.readBinaryWatch(1));
	}
}
