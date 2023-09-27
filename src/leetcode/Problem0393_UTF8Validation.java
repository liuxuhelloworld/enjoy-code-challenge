package leetcode;

/**
 * https://leetcode.cn/problems/utf-8-validation/
 */
public class Problem0393_UTF8Validation {
	private static final int UTF_8_1_BYTE_MASK = 0b10000000;
	private static final int UTF_8_2_BYTES_MASK = 0b11100000;
	private static final int UTF_8_2_BYTES_TARGET = 0b11000000;
	private static final int UTF_8_3_BYTES_MASK = 0b11110000;
	private static final int UTF_8_3_BYTES_TARGET = 0b11100000;
	private static final int UTF_8_4_BYTES_MASK = 0b11111000;
	private static final int UTF_8_4_BYTES_TARGET = 0b11110000;
	private static final int UTF_8_TRAILING_BYTE_MASK = 0b11000000;
	private static final int UTF_8_TRAILING_BYTE_TARGET = 0b10000000;

	public boolean validUtf8(int[] data) {
		int startIdx = 0;
		do {
			startIdx = nextStartIdx(data, startIdx);
			if (startIdx == -1) {
				break;
			}
		} while (startIdx < data.length);

		if (startIdx == -1) {
			return false;
		}

		return true;
	}

	private int nextStartIdx(int[] data, int startIdx) {
		int cur = data[startIdx];

		if ((cur & UTF_8_1_BYTE_MASK) == 0) {
			return startIdx + 1;
		}

		if ((cur & UTF_8_2_BYTES_MASK) == UTF_8_2_BYTES_TARGET) {
			if (isConsecutiveTrailingByte(data, startIdx + 1, 1)) {
				return startIdx + 2;
			}
		}

		if ((cur & UTF_8_3_BYTES_MASK) == UTF_8_3_BYTES_TARGET) {
			if (isConsecutiveTrailingByte(data, startIdx + 1, 2)) {
				return startIdx + 3;
			}
		}

		if ((cur & UTF_8_4_BYTES_MASK) == UTF_8_4_BYTES_TARGET) {
			if (isConsecutiveTrailingByte(data, startIdx + 1, 3)) {
				return startIdx + 4;
			}
		}

		return -1;
	}

	private boolean isConsecutiveTrailingByte(int[] data, int startIdx, int num) {
		for (int i = 0; i < num; i++) {
			int curIdx = startIdx + i;
			if (curIdx >= data.length) {
				return false;
			}

			int cur = data[curIdx];
			if ((cur & UTF_8_TRAILING_BYTE_MASK) != UTF_8_TRAILING_BYTE_TARGET) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Problem0393_UTF8Validation obj = new Problem0393_UTF8Validation();
		System.out.println(obj.validUtf8(new int[] {197, 130, 1}));
		System.out.println(obj.validUtf8(new int[] {235, 140, 4}));
	}
}
