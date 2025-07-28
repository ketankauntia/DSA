// https://leetcode.com/problems/word-ladder/

// without making graph.

import java.util.*;

public class Q9_word_ladder {

    public boolean isSimilar(String a, String b){
        if(a.length() != b.length()) return false;

        int diff_char = 0;
        for(int i=0; i<a.length() && diff_char < 2; i++){
            if(a.charAt(i)  != b.charAt(i)){
                diff_char++;
            }
        }

        return diff_char == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> que = new LinkedList<>();
        LinkedList<String> vis = new LinkedList<>();

        que.addLast(beginWord);
        vis.add(beginWord);

        int level = 1;
        while(que.size()>0){
            int size = que.size();

            while(size-- > 0){
                String top = que.removeFirst();

                for(String word : wordList){
                    if(vis.contains(word)==false && isSimilar(top,word)){
                        if(word.equals(endWord)) return level+1;

                        que.addLast(word);
                        vis.add(word);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}


// with graph =======================================

    public boolean isSimilar(String a, String b){
        if(a.length() != b.length()) return false;

        int diff_char = 0;
        for(int i=0; i<a.length() && diff_char < 2; i++){
            if(a.charAt(i)  != b.charAt(i)){
                diff_char++;
            }
        }

        return diff_char == 1;
    }

    public void addEdges(String u, HashMap<String, ArrayList<String>> graph, List<String> wordList){
        if(!graph.containsKey(u)){
            graph.put(u, new ArrayList<>());
        }

        for(String v: wordList){
            if(isSimilar(u,v)){
                graph.get(u).add(v);
            }
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> que = new LinkedList<>();
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        HashSet<String> vis = new HashSet<>();

        addEdges(beginWord, graph, wordList);
        for(String w: wordList){
            addEdges(w,graph,wordList);
        }

        que.add(beginWord);
        vis.add(beginWord);

        int level = 1;

        while(que.size() > 0){
            int size = que.size();

            while(size-- > 0){
                String top = que.removeFirst();

                for(String nbr: graph.get(top)){
                    if(!vis.contains(nbr)){
                        if(nbr.equals(endWord)) return level + 1;

                        que.addLast(nbr);
                        vis.add(nbr);
                    }
                }
            }
            level++;
        }

        return 0;
    }