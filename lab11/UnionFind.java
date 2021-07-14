
public class UnionFind {

    int size;
    int parents[];

    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {

        size = N;
        parents = new int[size];

        for (int i = 0; i < size; i++) {
            parents[i] = -1;
        }
    }

    private void checkBounds(int v) {
        if (v < 0 || v >= size) {
            throw new IllegalArgumentException();
        }
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {

        checkBounds(v);
        return -parents[find(v)];
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {

        checkBounds(v);
        return parents[v];
    }

    /* Returns true if nodes V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {

        checkBounds(v1);
        checkBounds(v2);
        return find(v1) == find(v2);
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {

        int p = parent(v);

        if (p < 0) {
            p = v;
        } else {
            p = find(p);
            parents[v] = p;
        }

        return p;
    }

    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing a item with itself or items that are
       already connected should not change the structure. */
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        int weight1 = -parent(p1);
        int weight2 = -parent(p2);

        if (weight2 < weight1) {
            parents[p1] += parents[p2];
            parents[p2] = p1;
        } else {
            parents[p2] += parents[p1];
            parents[p1] = p2;
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);
        uf.union(1, 2);
        uf.union(2, 3);
        System.out.println(uf.connected(1, 3));
    }
}
