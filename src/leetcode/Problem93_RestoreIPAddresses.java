package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class Problem93_RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		assert s != null;

		int len = s.length();
		if (len == 0) {
			return Collections.emptyList();
		}

		List<String> candidates = new ArrayList<>();

		String first = s.substring(0, 1);
		candidates.add(first);

		for (int i = 1; i < len; i++) {
			String cur = s.substring(i, i+1);

			List<String> newCandidates = new ArrayList<>();

			for (String candidate : candidates) {
				if (canBeAppended(candidate)) {
					newCandidates.add(candidate + "." + cur);
				}

				if (canBeAppendedAsWhole(candidate, cur)) {
					newCandidates.add(candidate + cur);
				}
			}

			candidates = newCandidates;
		}

		return candidates.stream()
			.filter(this::isValidIPAddress)
			.collect(Collectors.toList());
	}

	private boolean canBeAppended(String candidate) {
		int dotNum = countDotNum(candidate);
		if (dotNum <= 2) {
			return true;
		} else {
			return false;
		}
	}

	private boolean canBeAppendedAsWhole(String candidate, String appended) {
		int index = candidate.lastIndexOf('.');

		String lastPart;
		if (index == -1) {
			lastPart = candidate;
		} else {
			lastPart = candidate.substring(candidate.lastIndexOf('.') + 1);
		}

		if (lastPart.equals("0")) {
			return false;
		}

		int val = Integer.parseInt(lastPart + appended);
		if (val > 0 && val <= 255) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isValidIPAddress(String candidate) {
		int dotNum = countDotNum(candidate);

		if (dotNum == 3) {
			return true;
		} else {
			return false;
		}
	}

	private int countDotNum(String candidate) {
		int dotNum = 0;
		for (int i = 0; i < candidate.length(); i++) {
			if (candidate.charAt(i) == '.') {
				dotNum++;
			}
		}

		return dotNum;
	}

	public static void main(String[] args) {
		Problem93_RestoreIPAddresses obj = new Problem93_RestoreIPAddresses();
		System.out.println(obj.restoreIpAddresses("25525511135"));
	}
}
