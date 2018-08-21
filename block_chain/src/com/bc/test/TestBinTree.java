package com.bc.test;

import org.junit.Test;

public class TestBinTree {
	
	@Test
	public void test1() {
		  BinTree binTree=new BinTree();  
	        Object[] objs={0,1,2,3,4,5,6,7};  
	        binTree.createTree(objs);  
         binTree.preorder(binTree.getRoot()); //先序遍历  
 	  //    binTree.inorder(binTree.getRoot());  //中序遍历  
	    //  binTree.afterorder(binTree.getRoot()); //后序遍历  
		
		
	}
}
