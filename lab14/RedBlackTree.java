public class RedBlackTree<T extends Comparable<T>> {

    /* Root of the tree. */
    public RBTreeNode<T> root;

    public static class RBTreeNode<T> {

        public final T item;
        public boolean isBlack;
        public RBTreeNode<T> left;
        public RBTreeNode<T> right;

        /* Creates a RBTreeNode with item ITEM and color depending on ISBLACK
           value. */
        RBTreeNode(boolean isBlack, T item) {
            this(isBlack, item, null, null);
        }

        /* Creates a RBTreeNode with item ITEM, color depending on ISBLACK
           value, left child LEFT, and right child RIGHT. */
        RBTreeNode(boolean isBlack, T item, RBTreeNode<T> left,
                   RBTreeNode<T> right) {
            this.isBlack = isBlack;
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    /* Creates an empty RedBlackTree. */
    public RedBlackTree() {
        root = null;
    }

    /* Creates a RedBlackTree from a given BTree (2-3-4) TREE. */
    public RedBlackTree(BTree<T> tree) {
        Node<T> btreeRoot = tree.root;
        root = buildRedBlackTree(btreeRoot);
    }

    /* Builds a RedBlackTree that has isometry with given 2-3-4 tree rooted at
       given node R, and returns the root node. */
    RBTreeNode<T> buildRedBlackTree(Node<T> r) {
        if (r == null) {
            return null;
        }

        if (r.getItemCount() == 1) {
            // TODO: Replace with code to create a 2 node equivalent
            RBTreeNode<T> left = buildRedBlackTree(r.getChildAt(0));
            RBTreeNode<T> right = buildRedBlackTree(r.getChildAt(1));
            return new RBTreeNode<T>(true, r.getItemAt(0), left, right);
        } else if (r.getItemCount() == 2) {
            RBTreeNode<T> left = new RBTreeNode<T>(false, r.getItemAt(0), buildRedBlackTree(r.getChildAt(0)), buildRedBlackTree(r.getChildAt(1)));
            RBTreeNode<T> right = new RBTreeNode(true, buildRedBlackTree(r.getChildAt(2)));
            return new RBTreeNode<T>(true, r.getItemAt(1), left, right);
        } else {
            RBTreeNode<T> left = new RBTreeNode<T>(false, r.getItemAt(0), buildRedBlackTree(r.getChildAt(0)), buildRedBlackTree(r.getChildAt(1)));
            RBTreeNode<T> right = new RBTreeNode<T>(false, r.getItemAt(2), buildRedBlackTree(r.getChildAt(2)), buildRedBlackTree(r.getChildAt(3)));
            return new RBTreeNode<T>(true, r.getItemAt(1), left, right);
        }
    }

    /* Flips the color of NODE and its children. Assume that NODE has both left
       and right children. */
    void flipColors(RBTreeNode<T> node) {
        node.isBlack = !node.isBlack;
        node.left.isBlack = !node.left.isBlack;
        node.right.isBlack = !node.right.isBlack;
    }

    /* Rotates the given node NODE to the right. Returns the new root node of
       this subtree. */
    RBTreeNode<T> rotateRight(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
        return null;
    }

    /* Rotates the given node NODE to the left. Returns the new root node of
       this subtree. */
    RBTreeNode<T> rotateLeft(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
        return null;
    }

    public void insert(T item) {
        root = insert(root, item);
        root.isBlack = true;
    }

    /* Inserts the given node into this Red Black Tree*/
    public RBTreeNode<T> insert(RBTreeNode<T> node, T item) {
        // Insert (return) new red leaf node.
        if (node == null) {
            return new RBTreeNode<>(false, item);
        }

        // Handle normal binary search tree insertion.
        int comp = item.compareTo(node.item);
        if (comp == 0) {
            return node; // do nothing.
        } else if (comp < 0) {
            node.left = insert(node.left, item);
        } else {
            node.right = insert(node.right, item);
        }

        // handle case C and "Right-leaning" situation.


        // handle case B


        // handle case A

        // TODO: YOUR CODE HERE
        return null; //fix this return statement
    }

    /* Returns whether the given node NODE is red. Null nodes (children of leaf
       nodes are automatically considered black. */
    public boolean isRed(RBTreeNode<T> node) {
        return node != null && !node.isBlack;
    }

}
