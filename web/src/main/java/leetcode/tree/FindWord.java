package leetcode.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 2020-05-29 16:47
 */
public class FindWord {
    private static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        char[][] board = new char[1][2];
        board[0][0] = 'a';
        board[0][1] = 'a';

        String[] words = new String[]{"aaaa"};

        System.out.println(findWords(board, words));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visit = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(board, visit, "", i, j, trie);
            }
        }

        return new ArrayList<String>(set);
    }

    private static void dfs(char[][] board, boolean[][] visit, String str, int x, int y,Trie trie){
        if(x < 0 || x >= visit.length || y < 0 || y >= visit[0].length || visit[x][y]){
            return;
        }

        str += board[x][y];
        if(!trie.startsWith(str)){
            return;
        }

        if(trie.search(str)){
            set.add(str);
        }

        visit[x][y] = true;
        dfs(board, visit, str, x - 1, y, trie);
        dfs(board, visit, str, x, y - 1, trie);
        dfs(board, visit, str, x + 1, y, trie);
        dfs(board, visit, str, x, y + 1, trie);
        visit[x][y] = false;
    }
}
