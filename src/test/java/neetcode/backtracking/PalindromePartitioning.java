package neetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromePartitioning {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(List.of(List.of("a", "a", "b"), List.of("aa", "b")), solution.partition("aab"));
    }

    private class Solution {
        private List<List<String>> res = new ArrayList<>();
        private List<String> part = new ArrayList<>();

        public List<List<String>> partition(String s) {
            dfs(0, 0, s);
            return res;
        }

        private void dfs(int j, int i, String s) {
            if (i >= s.length()) {
                if (i == j) {
                    res.add(new ArrayList<>(part));
                }
                return;
            }
            if (isPali(s, j, i)) {
                part.add(s.substring(j, i + 1));
                dfs(i + 1, i + 1, s);
                part.remove(part.size() - 1);
            }
            dfs(j, i + 1, s);
        }

        private boolean isPali(String s, int l, int r) {
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }
}
