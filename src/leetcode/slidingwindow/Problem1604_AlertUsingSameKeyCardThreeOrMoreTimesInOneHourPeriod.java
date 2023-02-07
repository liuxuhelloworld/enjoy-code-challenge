package leetcode.slidingwindow;

import java.util.*;

public class Problem1604_AlertUsingSameKeyCardThreeOrMoreTimesInOneHourPeriod {
	public List<String> alertNames(String[] keyName, String[] keyTime) {
		Map<String, List<String>> nameTimeMap = new HashMap<>();
		for (int i = 0; i < keyName.length; i++) {
			String name = keyName[i];
			String time = keyTime[i];
			if (nameTimeMap.containsKey(name)) {
				nameTimeMap.get(name).add(time);
			} else {
				List<String> list = new ArrayList<>();
				list.add(time);
				nameTimeMap.put(name, list);
			}
		}

		List<String> alertNameList = new ArrayList<>();

		for (Map.Entry<String, List<String>> entry : nameTimeMap.entrySet()) {
			String name = entry.getKey();
			List<String> timeList = entry.getValue();

			Collections.sort(timeList);

			if (existsThreeOrMoreTimesInOneHourPeriod(timeList)) {
				alertNameList.add(name);
			}
		}

		Collections.sort(alertNameList);

		return alertNameList;
	}

	private boolean existsThreeOrMoreTimesInOneHourPeriod(List<String> timeList) {
		String[] timeArray = timeList.toArray(new String[] {});
		int windowCnt = 0;
		int start = 0, end = 0;
		while (end < timeArray.length) {
			String startTime = timeArray[start];
			String endTime = timeArray[end];
			if (isOneHourPeriod(startTime, endTime)) {
				windowCnt++;
				if (windowCnt >= 3) {
					return true;
				}
				end++;
			} else {
				windowCnt--;
				start++;
			}
		}

		return false;
	}

	private boolean isOneHourPeriod(String time1, String time2) {
		int hour1 = Integer.valueOf(time1.substring(0, 2));
		int minute1 = Integer.valueOf(time1.substring(3, 5));
		int hour2 = Integer.valueOf(time2.substring(0, 2));
		int minute2 = Integer.valueOf(time2.substring(3, 5));

		int hourDiff = Math.abs(hour1 - hour2);
		if (hourDiff == 0) {
			return true;
		} else if (hourDiff == 1) {
			if (minute1 >= minute2) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Problem1604_AlertUsingSameKeyCardThreeOrMoreTimesInOneHourPeriod obj =
			new Problem1604_AlertUsingSameKeyCardThreeOrMoreTimesInOneHourPeriod();

		String[] keyName = new String[] {"alice","alice","alice","bob","bob","bob","bob"};
		String[] keyTime = new String[] {"12:01","12:00","18:00","21:00","21:20","21:30","23:00"};
		System.out.println(obj.alertNames(keyName, keyTime));
	}
}
