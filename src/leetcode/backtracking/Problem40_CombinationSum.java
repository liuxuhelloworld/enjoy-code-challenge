package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class Problem40_CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);

    List<int[]> candidatesAndFreq = new ArrayList<>();
    Arrays.stream(candidates).forEach(e -> {
      if (candidatesAndFreq.size() > 0
          && candidatesAndFreq.get(candidatesAndFreq.size()-1)[0] == e) {
        candidatesAndFreq.get(candidatesAndFreq.size() - 1)[1] += 1;
      } else {
        int[] last = new int[2];
        last[0] = e;
        last[1] = 1;
        candidatesAndFreq.add(last);
      }
    });

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();

    backtrack(result, combination, candidatesAndFreq, 0, target);

    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> combination,
                         List<int[]> candidates, int curIdx, int target) {

    if (target == 0) {
      result.add(new ArrayList<>(combination));
      return;
    }

    if (curIdx == candidates.size()) {
      return;
    }


    int curVal = candidates.get(curIdx)[0];
    int freq = candidates.get(curIdx)[1];

    if (curVal > target) {
      return;
    }

    for (int i = 0; i <= freq; i++) {
      if (target >= i * curVal) {
      	for (int j = 0; j < i; j++) {
          combination.add(curVal);
        }

        backtrack(result, combination, candidates, curIdx+1, target-i*curVal);

      	for (int j = 0; j < i; j++) {
          combination.remove(combination.size()-1);
        }
      }
    }
  }

  public static void main(String[] args) {
    Problem40_CombinationSum obj = new Problem40_CombinationSum();
    System.out.println(obj.combinationSum(new int[] {2, 5, 2, 1, 2}, 5));
    System.out.println(obj.combinationSum(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
  }
}
