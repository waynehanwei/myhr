package com.bc.test;

import org.junit.Test;

public class TestBinTree {
	
	@Test
	public void test1() {
		  BinTree binTree=new BinTree();  
	        Object[] objs={0,1,2,3,4,5,6,7};  
	        binTree.createTree(objs);  
         binTree.preorder(binTree.getRoot()); //�������  
 	  //    binTree.inorder(binTree.getRoot());  //�������  
	    //  binTree.afterorder(binTree.getRoot()); //�������  
		
		
	}
}
