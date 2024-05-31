
// Tag - medium
class Solution {
    public int minSteps(String source, String target) {
        int deletionsNeeded = 0;

        // Count the frequency of each character in the source string
        int[] sourceCharFrequency = new int[26];
        for (char sourceChar : source.toCharArray()) {
            sourceCharFrequency[sourceChar - 'a']++;
        }

        // Count the frequency of each character in the target string
        int[] targetCharFrequency = new int[26];
        for (char targetChar : target.toCharArray()) {
            targetCharFrequency[targetChar - 'a']++;
        }

        // Calculate the deletions needed to make the two strings anagrams
        for (int i = 0; i < targetCharFrequency.length; i++) {
            if (targetCharFrequency[i] < sourceCharFrequency[i]) {
                deletionsNeeded += sourceCharFrequency[i] - targetCharFrequency[i];
            }
        }

        return deletionsNeeded;
    }
}
