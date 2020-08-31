package src;

public class ConnectNodesAtSameLevel {

	public static void main(String[] args) {
		ConnectedTree root = new ConnectedTree(1);
		root.left = new ConnectedTree(4);
		root.left.right = new ConnectedTree(7);
		root.left.right.right = new ConnectedTree(2);
		root.right = new ConnectedTree(10);
		root.right.left = new ConnectedTree(5);
		root.right.left.left = new ConnectedTree(13);
		root.right.right = new ConnectedTree(8);
		root.right.right.left = new ConnectedTree(9);
		root.right.right.right = new ConnectedTree(17);
		root.right.right.right.left = new ConnectedTree(11);
		root.right.right.right.right = new ConnectedTree(12);
		connectAllNodesWithoutExtraSpaceUtil(root);
	}

	private static void connectAllNodesWithoutExtraSpaceUtil(ConnectedTree root) {
		if (root == null) {
			return;
		}
		ConnectedTree temp = root;
		ConnectedTree previousElementInCurrentLevelOfTemp = root;
		ConnectedTree leftestElementNotNullInNextLevel = temp.left;
		while (temp != null) {
			if (temp.left != null) {
				leftestElementNotNullInNextLevel = temp.left;
				break;
			}
			if (temp.right != null) {
				leftestElementNotNullInNextLevel = temp.right;
				break;
			}
			previousElementInCurrentLevelOfTemp = temp;
			temp = temp.nextRight;
		}
		while (previousElementInCurrentLevelOfTemp != null) {
			if (previousElementInCurrentLevelOfTemp.left != null && previousElementInCurrentLevelOfTemp.right != null) {
				previousElementInCurrentLevelOfTemp.left.nextRight = previousElementInCurrentLevelOfTemp.right;
				previousElementInCurrentLevelOfTemp.right.nextRight = getNextRight(
						previousElementInCurrentLevelOfTemp.nextRight);
			} else if (previousElementInCurrentLevelOfTemp.left == null
					&& previousElementInCurrentLevelOfTemp.right != null) {
				ConnectedTree tep = previousElementInCurrentLevelOfTemp.nextRight;
				if (tep != null) {
					previousElementInCurrentLevelOfTemp.right.nextRight = getNextRight(tep);
				}
				previousElementInCurrentLevelOfTemp = tep;
				continue;
			} else if (previousElementInCurrentLevelOfTemp.left != null
					&& previousElementInCurrentLevelOfTemp.right == null) {
				ConnectedTree tep = previousElementInCurrentLevelOfTemp.nextRight;
				if (tep != null) {
					previousElementInCurrentLevelOfTemp.left.nextRight = getNextRight(tep);
				}
				previousElementInCurrentLevelOfTemp = tep;
				continue;
			}
			if (previousElementInCurrentLevelOfTemp != null) {
				previousElementInCurrentLevelOfTemp = previousElementInCurrentLevelOfTemp.nextRight;
			}
		}
		connectAllNodesWithoutExtraSpaceUtil(leftestElementNotNullInNextLevel);
	}

	private static ConnectedTree getNextRight(ConnectedTree previousElementInCurrentLevelOfTemp) {
		while (previousElementInCurrentLevelOfTemp != null) {
			if (previousElementInCurrentLevelOfTemp.left != null) {
				return previousElementInCurrentLevelOfTemp.left;
			}
			if (previousElementInCurrentLevelOfTemp.right != null) {
				return previousElementInCurrentLevelOfTemp.right;
			}
			previousElementInCurrentLevelOfTemp = previousElementInCurrentLevelOfTemp.nextRight;
		}
		return null;
	}
}

class ConnectedTree {
	int data;
	ConnectedTree left;
	ConnectedTree right;
	ConnectedTree nextRight;

	ConnectedTree(int data) {
		this.data = data;
	}
}

//4 4 10 5 10 7 2 3 8
//5 3 4 8 10 4 7 10 2