package leetcode.string;

/**
 * https://leetcode.cn/problems/count-days-spent-together/
 */
public class Problem2409_CountDaysSpentTogether {
	private static final int[] DAYS_PER_MONTH = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
		int arriveAliceMonth = month(arriveAlice);
		int arriveAliceDay = day(arriveAlice);
		int leaveAliceMonth = month(leaveAlice);
		int leaveAliceDay = day(leaveAlice);
		int arriveBobMonth = month(arriveBob);
		int arriveBobDay = day(arriveBob);
		int leaveBobMonth = month(leaveBob);
		int leaveBobDay = day(leaveBob);

		int biggerArriveMonth, biggerArriveDay;
		int cmp = compare(arriveAliceMonth, arriveAliceDay, arriveBobMonth, arriveBobDay);
		if (cmp < 0) {
			biggerArriveMonth = arriveBobMonth;
			biggerArriveDay = arriveBobDay;
		} else {
			biggerArriveMonth = arriveAliceMonth;
			biggerArriveDay = arriveAliceDay;
		}

		int smallerLeaveMonth, smallerLeaveDay;
		cmp = compare(leaveAliceMonth, leaveAliceDay, leaveBobMonth, leaveBobDay);
		if (cmp < 0) {
			smallerLeaveMonth = leaveAliceMonth;
			smallerLeaveDay = leaveAliceDay;
		} else {
			smallerLeaveMonth = leaveBobMonth;
			smallerLeaveDay = leaveBobDay;
		}

		return days(biggerArriveMonth, biggerArriveDay, smallerLeaveMonth, smallerLeaveDay);
	}

	private int compare(int month1, int day1, int month2, int day2) {
		int cmp = month1 - month2;
		if (cmp != 0) {
			return cmp;
		}

		return day1 - day2;
	}

	private int days(int startMonth, int startDay, int endMonth, int endDay) {
		int cmp = compare(startMonth, startDay, endMonth, endDay);
		if (cmp > 0) {
			return 0;
		} else if (cmp == 0) {
			return 1;
		} else {
			if (startMonth == endMonth) {
				return endDay - startDay + 1;
			} else {
				int days = 0;
				days += DAYS_PER_MONTH[startMonth] - startDay + 1;
				for (int i = startMonth + 1; i < endMonth; i++) {
					days += DAYS_PER_MONTH[i];
				}
				days += endDay;

				return days;
			}
		}
	}

	private int month(String date) {
		return Integer.parseInt(date.substring(0, 2));
	}

	private int day(String date) {
		return Integer.parseInt(date.substring(3, 5));
	}

	public static void main(String[] args) {
		Problem2409_CountDaysSpentTogether obj = new Problem2409_CountDaysSpentTogether();
		System.out.println(obj.countDaysTogether("08-15", "08-18", "08-16", "08-19"));
		System.out.println(obj.countDaysTogether("10-01", "10-31", "11-01", "12-31"));
		System.out.println(obj.countDaysTogether("10-01", "11-15", "10-10", "11-21"));
	}
}
