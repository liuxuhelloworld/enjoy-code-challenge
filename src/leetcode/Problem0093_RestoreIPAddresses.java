package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class Problem0093_RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> ipAddresses = new ArrayList<>();
		List<String> ipParts = new ArrayList<>();

		backtrack(ipAddresses, ipParts, s, 0);

		return ipAddresses;
	}

	private void backtrack(List<String> ipAddresses,
	                       List<String> ipParts,
	                       String s,
	                       int idx) {

		if (idx == s.length()) {
			if (ipParts.size() == 4) {
				ipAddresses.add(String.join(".", ipParts));
			}
			return;
		}

		if (ipParts.size() >= 4) {
			return;
		}

		if (ipParts.size() == 3 && s.length() - idx > 3) {
			return;
		}

		for (int i = 0; i < 3 && idx+i+1 <= s.length(); i++) {
			String part = s.substring(idx, idx + i + 1);
			if (isValidIpPart(part)) {
				ipParts.add(part);
				backtrack(ipAddresses, ipParts, s, idx + i + 1);
				ipParts.remove(ipParts.size() - 1);
			}
		}
	}

	private boolean isValidIpPart(String part) {
		int len = part.length();

		if (len == 1) {
			return true;
		}

		char first = part.charAt(0);
		if (first == '0') {
			return false;
		}

		if (len == 3) {
			return part.compareTo("255") <= 0;
		}

		return true;
	}

	public static void main(String[] args) {
		Problem0093_RestoreIPAddresses obj = new Problem0093_RestoreIPAddresses();
		System.out.println(obj.restoreIpAddresses("25525511135"));
	}
}
