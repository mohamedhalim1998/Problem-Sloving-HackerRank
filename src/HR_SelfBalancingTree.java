public class HR_SelfBalancingTree {
    static class Node {
        int val;    //Value
        int ht;        //Height
        Node left;    //Left child
        Node right;    //Right child

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.val = 3;
        root.left = new Node(2);
        Node n4 = new Node(4);
        n4.right = new Node(5);
        root.right = n4;
        insert(root, 6);
    }


    static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node();
            root.val = val;
            root.ht = setHeight(root);
            return root;
        }
        if (val <= root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }

        return balance(root);

    }

    private static Node balance(Node root) {
        int balance = height(root.left) - height(root.right);

        if (balance > 1) {
            if (height(root.left.left) >= height(root.left.right)) {
                root = moveRight(root);
            } else {
                root.left = moveLeft(root.left);
                root = moveRight(root);
            }
        } else if (balance < -1) {
            if (height(root.right.right) >= height(root.right.left)) {
                root = moveLeft(root);
            } else {
                root.right = moveRight(root.right);
                root = moveLeft(root);
            }
        } else {
            root.ht = setHeight(root);
        }
        return root;
    }

    private static int height(Node root) {
        if (root == null)
            return -1;
        else
            return root.ht;
    }

    private static int setHeight(Node root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }

    private static Node moveLeft(Node root) {
        Node oldRoot = root;
        root = root.right;
        Node oldLeft = root.left;
        root.left = oldRoot;
        oldRoot.right = oldLeft;
        root.ht = setHeight(root);
        oldRoot.ht = setHeight(oldRoot);
        return root;
    }

    private static Node moveRight(Node root) {
        Node oldRoot = root;
        root = root.left;
        Node oldRight = root.right;
        root.right = oldRoot;
        oldRoot.left = oldRight;
        root.ht = setHeight(root);
        oldRoot.ht = setHeight(oldRoot);
        return root;
    }

}