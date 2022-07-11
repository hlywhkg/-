import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/11 17:34
 * @Version 1.0
 */

class MagicDictionary {

    static class Node{
        Node[] ans= new Node[26];
        boolean end;
    }

    Node root;

    public MagicDictionary() {
        root = new Node();
    }

    public void insert(String s){
        int n = s.length();
        Node tmp = root;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if(tmp.ans[c] == null)tmp.ans[c] = new Node();
            tmp = tmp.ans[c];
        }
        tmp.end = true;
    }

    public boolean query(String s,boolean limit,int index,Node cur){
        if(index == s.length())return limit && cur.end;
        int c = s.charAt(index) - 'a';
        if(cur.ans[c] != null){
            if(query(s,limit,index+1,cur.ans[c])) return true;
        }
        if(!limit){
            for (int i = 0; i < 26; i++) {
                if(i != index && cur.ans[i] != null){
                    if(query(s,true,index+1,cur.ans[i])) return true;
                }
            }
        }
        return false;
    }

    public void buildDict(String[] dictionary) {
        for (String str : dictionary) {
            insert(str);
        }
    }

    public boolean search(String searchWord) {
        return query(searchWord,false,0,root);
    }
}

public class demo1 {
    public static void main(String[] args) {

    }
}
