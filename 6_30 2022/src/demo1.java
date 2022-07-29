/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/30 21:13
 * @Version 1.0
 */

class MyCalendar {
    class Node {
        // ls 和 rs 分别代表当前节点的左右子节点在 tr 的下标
        // val 代表当前节点有多少数
        // add 为懒标记
        int ls, rs, add, val;
    }
    int N = (int)1e9, M = 120010, cnt = 1;
    Node[] tr = new Node[M];
    void update(int u, int lc, int rc, int l, int r, int v) {
        if (l <= lc && rc <= r) {
            tr[u].val += (rc - lc + 1) * v;
            tr[u].add += v;
            return ;
        }
        create(u);
        pushdown(u, rc - lc + 1);
        int mid = lc + rc >> 1;
        if (l <= mid) update(tr[u].ls, lc, mid, l, r, v);
        if (r > mid) update(tr[u].rs, mid + 1, rc, l, r, v);
        pushup(u);
    }
    //查询
    int query(int u, int lc, int rc, int l, int r) {
        if (l <= lc && rc <= r) return tr[u].val;
        create(u);
        pushdown(u, rc - lc + 1);
        int mid = lc + rc >> 1, ans = 0;
        if (l <= mid) ans = query(tr[u].ls, lc, mid, l, r);
        if (r > mid) ans += query(tr[u].rs, mid + 1, rc, l, r);
        return ans;
    }
    //动态开点
    void create(int u) {
        if (tr[u] == null) tr[u] = new Node();
        if (tr[u].ls == 0) {
            tr[u].ls = ++cnt;
            tr[tr[u].ls] = new Node();
        }
        if (tr[u].rs == 0) {
            tr[u].rs = ++cnt;
            tr[tr[u].rs] = new Node();
        }
    }
    //清除懒标记
    void pushdown(int u, int len) {
        tr[tr[u].ls].add += tr[u].add; tr[tr[u].rs].add += tr[u].add;
        tr[tr[u].ls].val += (len - len / 2) * tr[u].add; tr[tr[u].rs].val += len / 2 * tr[u].add;
        tr[u].add = 0;
    }
    void pushup(int u) {
        tr[u].val = tr[tr[u].ls].val + tr[tr[u].rs].val;
    }
    public boolean book(int start, int end) {
        if (query(1, 1, N + 1, start + 1, end) > 0) return false;
        update(1, 1, N + 1, start + 1, end, 1);
        return true;
    }
}

public class demo1 {
}
