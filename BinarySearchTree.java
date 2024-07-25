import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> {
    TreeNode<T> root;
    public BinarySearchTree() {
        root = null;
    }
    public void insert(T x) {
        if (root == null) root = new TreeNode<>(x);
        else insertHelper(root, x);
    }
    private void insertHelper(TreeNode<T> node, T x) {
        if (x.compareTo(node.data) <= 0) {
            if (node.left == null) node.left = new TreeNode<>(x);
            else insertHelper(node.left, x);
        } else {
            if (node.right == null) node.right = new TreeNode<>(x);
            else insertHelper(node.right, x);
        }
    }
    public TreeNode<T> search(T x) {
        if (root == null) return null;
        else return searchHelper(root, x);
    }
    private TreeNode<T> searchHelper(TreeNode<T> node, T x) {
        if (node == null || x.compareTo(node.data) == 0) return node;
        else if (x.compareTo(node.data) < 0) return searchHelper(node.left, x);
        else return searchHelper(node.right, x);
    }
    public TreeNode<T> delete(T x) {
        return deleteHelper(root, x);
    }
    private TreeNode<T> deleteHelper(TreeNode<T> node, T x) {
        if (node == null) return node;
        else if (x.compareTo(node.data) < 0) node.left = deleteHelper(node.left, x);
        else if (x.compareTo(node.data) > 0) node.right = deleteHelper(node.right, x);
        else {
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            else {
                node.data = maxValue(node.left);
                node.left = deleteHelper(node.left, node.data);
            }
        }
        return node;
    }
    private T maxValue(TreeNode<T> node) {
        if (node.right == null) return node.data;
        else return maxValue(node.right);
    }

    public void inorder() {
        inorderHelper(root);
    }

    private void inorderHelper(TreeNode<T> root) {
        if (root == null) return;
        inorderHelper(root.left);
        System.out.println(root.data);
        inorderHelper(root.right);
    }

    public void inorderStack() {
        if (root == null) return;
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.println(curr.data);
            curr = curr.right;
        }
    }
    public void bfs() {
        if (root == null) return;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode<T> temp = queue.poll();
            System.out.println(temp.data);
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }
    }
}

