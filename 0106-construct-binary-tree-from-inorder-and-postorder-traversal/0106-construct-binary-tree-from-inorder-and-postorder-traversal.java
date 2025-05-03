class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++) inorderMap.put(inorder[i], i);
        return bTHelper(postorder, inorder, 0, postorder.length-1, 0, inorder.length-1, inorderMap);
    }
    private TreeNode bTHelper(int[] postorder, int[] inorder, int postStart, int postEnd, int inStart, int inEnd, HashMap<Integer,Integer> inordermap){
        if(postStart > postEnd || inStart> inEnd) return null;
        TreeNode curr = new TreeNode(postorder[postEnd]);
        int currIndex = inordermap.get(postorder[postEnd]);
        int numLeft = currIndex - inStart;
        curr.left = bTHelper(postorder, inorder, postStart, postStart+numLeft-1, inStart, inStart+numLeft-1, inordermap);
        curr.right = bTHelper(postorder, inorder, postStart+numLeft, postEnd-1,inStart+numLeft+1, inEnd, inordermap);
        return curr;
    }
}