package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class Problem39_CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();

    candidates = Arrays.stream(candidates).sorted().toArray();
    backtrack(result, combination, candidates, 0,  target);

    return result;
  }

  private void backtrack(List<List<Integer>> result,
                         List<Integer> combination,
                         int[] candidates,
                         int curIdx,
                         int target) {

    if (curIdx == candidates.length) {
      return;
    }

    if (target == 0) {
      result.add(new ArrayList<>(combination)); // pay attention here
      return;
    }

    int curVal = candidates[curIdx];
    if (curVal > target) {
      return;
    }

    // curIdx excluded
    backtrack(result, combination, candidates, curIdx+1, target);

    // curIdx included
    combination.add(curVal);
    backtrack(result, combination, candidates, curIdx, target-curVal);
    combination.remove(combination.size()-1);
  }

  public static void main(String[] args) {
    Problem39_CombinationSum obj = new Problem39_CombinationSum();
    System.out.println(obj.combinationSum(new int[] {2, 7, 6, 3, 5, 1}, 9));
  }
}
