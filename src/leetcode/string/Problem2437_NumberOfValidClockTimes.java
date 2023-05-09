package leetcode.string;

/**
 * https://leetcode.cn/problems/number-of-valid-clock-times/
 */
public class Problem2437_NumberOfValidClockTimes {
	public int countTime(String time) {
		char[] chars = time.toCharArray();
		boolean hourHighQuestionMark = chars[0] == '?';
		boolean hourLowQuestionMark = chars[1] == '?';
		boolean minuteHighQuestionMark = chars[3] == '?';
		boolean minuteLowQuestionMark = chars[4] == '?';

		int hours = 1;
		if (hourHighQuestionMark && hourLowQuestionMark) {
			hours = 24;
		} else {
			if (hourHighQuestionMark) {
				if (chars[1] > '3') {
					hours = 2;
				} else {
					hours = 3;
				}
			} else if (hourLowQuestionMark) {
				if (chars[0] < '2') {
					hours = 10;
				} else {
					hours = 4;
				}
			}
		}

		int minutes = 1;
		if (minuteHighQuestionMark) {
			minutes *= 6;
		}
		if (minuteLowQuestionMark) {
			minutes *= 10;
		}

		return hours * minutes;
	}

	public static void main(String[] args) {
		Problem2437_NumberOfValidClockTimes obj = new Problem2437_NumberOfValidClockTimes();
		System.out.println(obj.countTime("0?:0?"));
	}
}
