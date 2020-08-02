package bfs;

import java.util.*;
import java.util.stream.Collectors;

public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = wordList.stream().filter(str -> isNeighbor(str, beginWord)).collect(Collectors.toSet());
        if (set.isEmpty()) {
            return 0;
        }

        Map<String, Set<String>> map = buildNeighbor(wordList);

        int res = 1;
        Set<String> visited = new HashSet<>();
        Set<String> bakSet = new HashSet<>();
        while (!set.isEmpty() || !bakSet.isEmpty()) {
            if (!set.isEmpty()) {
                for (String str : set) {
                    visited.add(str);
                    if (str.equals(endWord)) {
                        return res + 1;
                    }
                    bakSet.addAll(map.get(str).stream().filter(ele -> !visited.contains(ele)).collect(Collectors.toSet()));
                }
                set.clear();
            } else {
                for (String str : bakSet) {
                    visited.add(str);
                    if (str.equals(endWord)) {
                        return res + 1;
                    }
                    set.addAll(map.get(str).stream().filter(ele -> !visited.contains(ele)).collect(Collectors.toSet()));
                }
                bakSet.clear();
            }
            res++;
        }
        return 0;
    }

    private Map<String, Set<String>> buildNeighbor(List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < wordList.size() - 1; i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (isNeighbor(wordList.get(i), wordList.get(j))) {
                    Set<String> temp1 = map.getOrDefault(wordList.get(i), new HashSet<>());
                    temp1.add(wordList.get(j));
                    if (temp1.size() == 1) {
                        map.put(wordList.get(i), temp1);
                    }
                    Set<String> temp2 = map.getOrDefault(wordList.get(j), new HashSet<>());
                    temp2.add(wordList.get(i));
                    if (temp2.size() == 1) {
                        map.put(wordList.get(j), temp2);
                    }
                }
            }
        }
        return map;
    }

    private boolean isNeighbor(String str, String beginWord) {
        int diff = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != beginWord.charAt(i)) {
                diff++;
            }
        }
        return diff == 1 ? true : false;
    }

    public static void main(String[] args) {
        Solution127 solution = new Solution127();
        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }
}
