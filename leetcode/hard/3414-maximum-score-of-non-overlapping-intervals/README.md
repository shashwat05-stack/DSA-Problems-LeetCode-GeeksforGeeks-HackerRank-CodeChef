# Maximum Score of Non-overlapping Intervals

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a 2D integer array `intervals`, where `intervals[i] = [li, ri, weighti]`. Interval `i` starts at position `li` and ends at `ri`, and has a weight of `weighti`. You can choose  *up to*  4  **non-overlapping**  intervals. The  **score**  of the chosen intervals is defined as the total sum of their weights.

Return the lexicographically smallest array of at most 4 indices from `intervals` with  **maximum**  score, representing your choice of non-overlapping intervals.

Two intervals are said to be  **non-overlapping**  if they do not share any points. In particular, intervals sharing a left or right boundary are considered overlapping.

 

 **Example 1:** 

 **Input:**  intervals = [[1,3,2],[4,5,2],[1,5,5],[6,9,3],[6,7,1],[8,9,1]]

 **Output:**  [2,3]

 **Explanation:** 

You can choose the intervals with indices 2, and 3 with respective weights of 5, and 3.

 **Example 2:** 

 **Input:**  intervals = [[5,8,1],[6,7,7],[4,7,3],[9,10,6],[7,8,2],[11,14,3],[3,5,5]]

 **Output:**  [1,3,5,6]

 **Explanation:** 

You can choose the intervals with indices 1, 3, 5, and 6 with respective weights of 7, 6, 3, and 5.

 

 **Constraints:** 

- 1 <= intevals.length <= 5 * 104
- intervals[i].length == 3
- intervals[i] = [li, ri, weighti]
- 1 <= li <= ri <= 109
- 1 <= weighti <= 109

## Solution

**Language:** Java  
**Runtime:** 219 ms (beats 9.26%)  
**Memory:** 190.9 MB (beats 38.89%)  
**Submitted:** 2026-09-12T07:48:03.076Z  

```java
class Solution {
    static class Interval {
        int start, end, weight, index;

        Interval(int start, int end, int weight, int index) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.index = index;
        }
    }

    static class State {
        long weight;
        List<Integer> indices;

        State(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        List<Interval> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            ));
        }

        // Sort by start
        arr.sort((a, b) -> {
            if (a.start != b.start)
                return Integer.compare(a.start, b.start);
            return Integer.compare(a.end, b.end);
        });

        State[][] dp = new State[n + 1][5];

        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new ArrayList<>());
        }

        for (int i = n - 1; i >= 0; i--) {

            dp[i][0] = new State(0, new ArrayList<>());

            for (int k = 1; k <= 4; k++) {

                // Don't take current interval
                State skip = dp[i + 1][k];

                // Find next interval
                int next = findNext(arr, i + 1, arr.get(i).end);

                State nextState = dp[next][k - 1];

                List<Integer> takeList =
                    new ArrayList<>(nextState.indices);

                takeList.add(arr.get(i).index);
                Collections.sort(takeList);

                State take = new State(
                    nextState.weight + arr.get(i).weight,
                    takeList
                );

                dp[i][k] = better(take, skip);
            }
        }

        List<Integer> answer = dp[0][4].indices;

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private int findNext(
        List<Interval> arr,
        int left,
        int end
    ) {
        int right = arr.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            // STRICTLY greater because touching endpoints overlap
            if (arr.get(mid).start > end) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private State better(State a, State b) {

        if (a.weight != b.weight) {
            return a.weight > b.weight ? a : b;
        }

        // Same weight → lexicographically smaller indices
        int size = Math.min(a.indices.size(), b.indices.size());

        for (int i = 0; i < size; i++) {
            if (!a.indices.get(i).equals(b.indices.get(i))) {
                return a.indices.get(i) < b.indices.get(i) ? a : b;
            }
        }

        return a.indices.size() <= b.indices.size() ? a : b;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/)