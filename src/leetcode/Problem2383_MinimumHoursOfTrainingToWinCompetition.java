package leetcode;

/**
 * https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/
 */
public class Problem2383_MinimumHoursOfTrainingToWinCompetition {
	public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
		int lackedEnergySum = 0, lackedExperienceSum = 0;
		int curEnergy = initialEnergy, curExperience = initialExperience;
		for (int i = 0; i < energy.length; i++) {
			int opponentEnergy = energy[i];
			int opponentExperience = experience[i];

			if (curEnergy <= opponentEnergy) {
				int lackedEnergy = (opponentEnergy - curEnergy) + 1;
				curEnergy += lackedEnergy;
				lackedEnergySum += lackedEnergy;
			}

			curEnergy = curEnergy - opponentEnergy;

			if (curExperience <= opponentExperience) {
				int lackedExperience = (opponentExperience - curExperience) + 1;
				curExperience = curExperience + lackedExperience;
				lackedExperienceSum += lackedExperience;
			}

			curExperience = curExperience + opponentExperience;
		}

		return lackedEnergySum + lackedExperienceSum;
	}

	public static void main(String[] args) {
		Problem2383_MinimumHoursOfTrainingToWinCompetition obj =
			new Problem2383_MinimumHoursOfTrainingToWinCompetition();

		System.out.println(obj.minNumberOfHours(5, 3, new int[] {1,4,3,2}, new int[] {2,6,3,1}));
	}
}
