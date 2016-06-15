package leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
	int head = 0;
	int tail = 0;
	ArrayList<TreeNode> queueArrayList;
	List<List<Integer>> result;

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		result=new ArrayList<List<Integer>>();
		if (root == null)
			return result; 
		BFSTree(root);
		return result;
	}

	public void BFSTree(TreeNode root) {
		boolean lefttoright=false;
		ArrayList<Integer> levels= new ArrayList<Integer>();
		queueArrayList=new ArrayList<TreeNode>();
		queueArrayList.add(root);
		levels.add(0);
		int currentlevel=-1;
		while (tail <= head) {
			TreeNode tempNode = queueArrayList.get(tail);
			int templevels = levels.get(tail);
			if (tempNode.left != null) {
				head++;
				queueArrayList.add(head, tempNode.left);
				levels.add(templevels + 1);
			}
			if (tempNode.right!=null) {
				head++;
				queueArrayList.add(head, tempNode.right);
				levels.add(templevels + 1);
			}
			if (templevels<=currentlevel) {
				result.get(templevels).add(tempNode.val);
			} else {
				List<Integer> tempArrayList=new ArrayList<Integer>();
				tempArrayList.add(tempNode.val);
				currentlevel++;
				result.add(currentlevel, tempArrayList);		
				if (currentlevel!=0 && currentlevel%2==0) {
					tempArrayList=result.get(currentlevel-1);
					result.remove(currentlevel-1);
					Collections.reverse(tempArrayList);
					result.add(currentlevel-1, tempArrayList);
				}
			
			}
			tail++;
		}
		currentlevel++;
		List<Integer> tempArrayList;
		if (currentlevel!=0 && currentlevel%2==0) {
			tempArrayList=result.get(currentlevel-1);
			result.remove(currentlevel-1);
			Collections.reverse(tempArrayList);
			result.add(currentlevel-1, tempArrayList);
		}
	}	
}
