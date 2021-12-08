package leetcode.slidingwindow;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/repeated-dna-sequences/
 */
public class Problem187_RepeatedDNASequences {
	private Map<Character, Integer> map = new HashMap<Character, Integer>() {{
		put('A', 0b00);
		put('C', 0b01);
		put('G', 0b10);
		put('T', 0b11);
	}};

	public List<String> findRepeatedDnaSequences(String s) {
		if (s == null) {
			return Collections.emptyList();
		}

		int len = s.length();
		if (len <= 10) {
			return Collections.emptyList();
		}

		List<String> ret = new ArrayList<>();

		Map<Integer, Integer> cnt = new HashMap<>();

		int hash = 0;
		for (int i = 0; i < 10; i++) {
			hash = hash << 2 | map.get(s.charAt(i));
		}
		cnt.put(hash, 1);

		for (int i = 1; i <= len - 10; i++) {
			char in = s.charAt(i + 9);
			hash = hash << 2 | map.get(in);
			hash = hash & 0b00000000000011111111111111111111;

			cnt.put(hash, cnt.getOrDefault(hash, 0) + 1);

			if (cnt.get(hash) == 2) {
				ret.add(s.substring(i, i + 10));
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		Problem187_RepeatedDNASequences obj = new Problem187_RepeatedDNASequences();
		List<String> ret = obj.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		System.out.println(ret);

		ret = obj.findRepeatedDnaSequences("AAAAAAAAAAAAA");
		System.out.println(ret);
	}
}
