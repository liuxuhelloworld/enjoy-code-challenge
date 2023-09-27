package leetcode;

/**
 * https://leetcode.cn/problems/decode-the-message/
 */
public class Problem2325_DecodeTheMessage {
	public String decodeMessage(String key, String message) {
		char[] table = new char[26];
		for (int i = 0; i < 26; i++) {
			table[i] = 0;
		}

		char[] keyCharArr = key.toCharArray();
		char ch = 'a';
		for (int i = 0; i < keyCharArr.length; i++) {
			char cur = keyCharArr[i];
			if (cur != ' ' && table[cur - 'a'] == 0) {
				table[cur - 'a'] = ch;
				ch = (char)(ch + 1);
			}
		}

		char[] messageCharArr = message.toCharArray();
		char[] decodedCharArr = new char[messageCharArr.length];
		for (int i = 0; i < messageCharArr.length; i++) {
			char cur = messageCharArr[i];
			if (cur != ' ') {
				decodedCharArr[i] = table[cur - 'a'];
			} else {
				decodedCharArr[i] = ' ';
			}
		}

		return String.valueOf(decodedCharArr);
	}

	public static void main(String[] args) {
		Problem2325_DecodeTheMessage obj = new Problem2325_DecodeTheMessage();
		String key = "the quick brown fox jumps over the lazy dog";
		String message = "vkbs bs t suepuv";
		System.out.println(obj.decodeMessage(key, message));
	}
}
