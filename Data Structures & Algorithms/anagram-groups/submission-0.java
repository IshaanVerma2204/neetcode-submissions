
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> frequencyStringMap = new HashMap<>();

        for (String str : strs) {

            String freqString = getFreqString(str);

            if (frequencyStringMap.containsKey(freqString)) {
                frequencyStringMap.get(freqString).add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequencyStringMap.put(freqString, strList);
            }
        }

        return new ArrayList<>(frequencyStringMap.values());
    }

    private String getFreqString(String str) {

        int[] freq = new int[26];

        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder freqString = new StringBuilder();

        char ch = 'a';

        for (int count : freq) {
            freqString.append(ch);
            freqString.append(count);
            ch++;
        }

        return freqString.toString();
    }
}