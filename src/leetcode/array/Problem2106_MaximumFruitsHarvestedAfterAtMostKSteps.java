package leetcode.array;

/**
 * https://leetcode.cn/problems/maximum-fruits-harvested-after-at-most-k-steps/
 */
public class Problem2106_MaximumFruitsHarvestedAfterAtMostKSteps {
	public int maxTotalFruits(int[][] fruits, int startPos, int k) {
		int length = fruits.length;
		int maxIdx = Math.max(fruits[length - 1][0], startPos);
		int[] fruitArr = new int[maxIdx + 1];
		for (int i = 0; i < length; i++) {
			fruitArr[fruits[i][0]] = fruits[i][1];
		}

		if (k == 0) {
			return fruitArr[startPos];
		}

		// left[i] represents harvested fruits number when go left i step, startPos not included
		int maxLeftSteps = Math.min(startPos, k);
		int[] leftFruits = new int[maxLeftSteps + 1];
		for (int i = 1; i < leftFruits.length; i++) {
			leftFruits[i] = leftFruits[i-1] + fruitArr[startPos - i];
		}

		// right[i] represents harvested fruits number when go right i step, startPos not included
		int maxRightSteps = Math.min(maxIdx - startPos, k);
		int[] rightFruits = new int[maxRightSteps + 1];
		for (int i = 1; i < rightFruits.length; i++) {
			rightFruits[i] = rightFruits[i-1] + fruitArr[startPos + i];
		}

		int maxFruits = 0;

		int startPosFruits = fruitArr[startPos];

		for (int leftStep = 0; leftStep <= maxLeftSteps; leftStep++) {
			int leftStepFruits = leftFruits[leftStep];

			int rightStep = k - (leftStep * 2);
			if (rightStep <= 0) {
				rightStep = 0;
			} else if (rightStep > maxRightSteps) {
				rightStep = maxRightSteps;
			}
			int rightStepFruits = rightFruits[rightStep];

			if (startPosFruits + leftStepFruits + rightStepFruits > maxFruits) {
				maxFruits = startPosFruits + leftStepFruits + rightStepFruits;
			}
		}

		for (int rightStep = 0; rightStep <= maxRightSteps; rightStep++) {
			int rightStepFruits = rightFruits[rightStep];

			int leftStep = k - (rightStep * 2);
			if (leftStep <= 0) {
				leftStep = 0;
			} else if (leftStep > maxLeftSteps) {
				leftStep = maxLeftSteps;
			}
			int leftStepFruits = leftFruits[leftStep];

			if (startPosFruits + leftStepFruits + rightStepFruits > maxFruits) {
				maxFruits = startPosFruits + leftStepFruits + rightStepFruits;
			}
		}

		return maxFruits;
	}

	public static void main(String[] args) {
		Problem2106_MaximumFruitsHarvestedAfterAtMostKSteps obj =
			new Problem2106_MaximumFruitsHarvestedAfterAtMostKSteps();

		int[][] fruits = new int[][] {
			{0,7},{7,4},{9,10},{12,6},{14,8},{16,5},{17,8},{19,4},{20,1},{21,3},
			{24,3},{25,3},{26,1},{28,10},{30,9},{31,6},{32,1},{37,5},{40,9}};

		System.out.println(obj.maxTotalFruits(fruits, 21, 30));
	}
}
