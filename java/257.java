import java.util.ArrayList;
import java.util.List;
 

public class BinaryTreePath {

	public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root == null)    return result;
        if(root.left == null && root.right == null)
        	result.add(root.val + "");
        if(root.left != null) {
        	List<String> left = binaryTreePaths(root.left);
        	for(String tmp : left)
            	result.add(root.val + "->" + tmp);
        }
        if(root.right != null) {
        	List<String> right = binaryTreePaths(root.right);
            for(String tmp : right)
            	result.add(root.val + "->" + tmp);
        }
        return result;
    }
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		BinaryTreePath btp = new BinaryTreePath();
		System.out.println(btp.binaryTreePaths(n1));
	}
}