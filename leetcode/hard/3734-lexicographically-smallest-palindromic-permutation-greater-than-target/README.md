# Lexicographically Smallest Palindromic Permutation Greater Than Target

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given two strings `s` and `target`, each of length `n`, consisting of lowercase English letters.

Return the  **lexicographically smallest string**  that is  **both**  a  **palindromic permutation**  of `s` and  **strictly**  greater than `target`. If no such permutation exists, return an empty string.

 

 **Example 1:** 

 **Input:**  s = "baba", target = "abba"

 **Output:**  "baab"

 **Explanation:** 

- The palindromic permutations of s (in lexicographical order) are "abba" and "baab".
- The lexicographically smallest permutation that is strictly greater than target is "baab".

 **Example 2:** 

 **Input:**  s = "baba", target = "bbaa"

 **Output:**  ""

 **Explanation:** 

- The palindromic permutations of s (in lexicographical order) are "abba" and "baab".
- None of them is lexicographically strictly greater than target. Therefore, the answer is "".

 **Example 3:** 

 **Input:**  s = "abc", target = "abb"

 **Output:**  ""

 **Explanation:** 

`s` has no palindromic permutations. Therefore, the answer is `""`.

 **Example 4:** 

 **Input:**  s = "aac", target = "abb"

 **Output:**  "aca"

 **Explanation:** 

- The only palindromic permutation of s is "aca".
- "aca" is strictly greater than target. Therefore, the answer is "aca".

 

 **Constraints:** 

- 1 <= n == s.length == target.length <= 300
- s and target consist of only lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 76.19%)  
**Memory:** 46.2 MB (beats 95.24%)  
**Submitted:** 2026-08-28T11:23:18.809Z  

```java
class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int halfLength = n / 2;

        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int oddCount = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                middle = (char) ('a' + i);
            }

            count[i] /= 2;
        }

        if (oddCount > 1) {
            return "";
        }

        StringBuilder half = new StringBuilder();

        int matched = 0;

        while (matched < halfLength) {

            int index = target.charAt(matched) - 'a';

            if (count[index] == 0) {
                break;
            }

            half.append(target.charAt(matched));
            count[index]--;

            matched++;
        }

        if (matched == halfLength) {

            String palindrome = buildPalindrome(
                half.toString(),
                middle,
                oddCount == 1
            );

            if (palindrome.compareTo(target) > 0) {
                return palindrome;
            }
        }

        int pos = Math.min(matched, halfLength - 1);

        while (pos >= 0) {

            if (pos < half.length()) {

                char ch = half.charAt(pos);

                count[ch - 'a']++;

                half.setLength(pos);
            }

            int targetChar = target.charAt(pos) - 'a';

            for (int j = targetChar + 1; j < 26; j++) {

                if (count[j] > 0) {

                    StringBuilder answerHalf = new StringBuilder(half);

                    answerHalf.append((char) ('a' + j));

                    count[j]--;

                    for (int k = 0; k < 26; k++) {
                        while (count[k] > 0) {
                            answerHalf.append((char) ('a' + k));
                            count[k]--;
                        }
                    }

                    return buildPalindrome(
                        answerHalf.toString(),
                        middle,
                        oddCount == 1
                    );
                }
            }

            pos--;
        }

        return "";
    }


    private String buildPalindrome(
            String half,
            char middle,
            boolean hasMiddle
    ) {

        StringBuilder result = new StringBuilder();

        result.append(half);

        if (hasMiddle) {
            result.append(middle);
        }

        result.append(
            new StringBuilder(half).reverse()
        );

        return result.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/)