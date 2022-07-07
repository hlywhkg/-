import java.util.List;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/7 16:29
 * @Version 1.0
 */

class Solution {
    class Node{
        Node[]ans = new Node[26];
        boolean end;
    }
    Node root = new Node();
    public void insert(String s){
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if(p.ans[u] == null)p.ans[u] = new Node();
            p = p.ans[u];
        }
        p.end = true;
    }

    public String query(String s){
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if(p.ans[u] == null)break;
            if(p.ans[u].end)return s.substring(0,i+1);
            p = p.ans[u];
        }
        return s;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String s : dictionary) {
            insert(s);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : sentence.split(" ")) {
            stringBuilder.append(query(s)).append(" ");
        }
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }
}

public class demo1 {
}
