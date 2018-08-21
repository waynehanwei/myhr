package com.bc.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class myClass {

	 public static void main(String[] args) {  
	        // TODO Auto-generated method stub  
	        myClass tree = new myClass();  
	        int[] datas = new int[]{1,2,3,4,5,6,7,8,9};  
	        
	        List<Node> nodelist = new LinkedList<>();  
	        tree.creatBinaryTree(datas, nodelist);  
	        
	        Node root = nodelist.get(0);  
	        System.out.println("�ݹ����������");  
	        tree.preOrderTraversal(root);  
	        System.out.println();  
	        System.out.println("�ǵݹ����������");  
	        tree.preOrderTraversalbyLoop(root);  
	        System.out.println();  
	        System.out.println("�ݹ����������");  
	        tree.inOrderTraversal(root);  
	        System.out.println();  
	        System.out.println("�ǵݹ����������");  
	        tree.inOrderTraversalbyLoop(root);  
	        System.out.println();  
	        System.out.println("�ݹ���������");  
	        tree.postOrderTraversal(root);  
	        System.out.println();  
	        System.out.println("�ǵݹ���������");  
	        tree.postOrderTraversalbyLoop(root);  
	        System.out.println();  
	        System.out.println("������ȱ�����");  
	        tree.bfs(root);  
	        System.out.println();  
	        System.out.println("������ȱ�����");  
	        List<List<Integer>> rst = new ArrayList<>();  
	        List<Integer> list = new ArrayList<>();  
	        tree.dfs(root,rst,list);  
	        System.out.println(rst);  
	    }  
	    /** 
	     *  
	     * @param datas ʵ�ֶ��������ڵ�ֵ������ 
	     * @param nodelist ������list 
	     */  
	    private void creatBinaryTree(int[] datas,List<Node> nodelist){  
	        //��������node�ڵ�  
	        for(int nodeindex=0;nodeindex<datas.length;nodeindex++){  
	            Node node = new Node(datas[nodeindex]);  
	            nodelist.add(node);  
	        }  
	        //�����и��ڵ��趨�ӽڵ�  
	        for(int index=0;index<nodelist.size()/2-1;index++){  
	            //���Ϊn�Ľڵ��������ӽڵ���Ϊ2*n ���ӽڵ���Ϊ2*n+1 ������Ϊlist��0��ʼ��ţ����Ի�Ҫ+1  
	            //���︸�ڵ���1��2,3��,2��4,5��,3��6,7��,4��8,9�� �������һ�����ڵ��п���û�����ӽڵ� ��Ҫ��������  
	            nodelist.get(index).setLeft(nodelist.get(index*2+1));   
	            nodelist.get(index).setRight(nodelist.get(index*2+2));  
	        }  
	        //�����������һ�����ڵ�  ��Ϊ���п���û�����ӽڵ�  
	        int index = nodelist.size()/2-1;  
	        nodelist.get(index).setLeft(nodelist.get(index*2+1)); //���������ӽڵ�  
	        if(nodelist.size() % 2 == 1){ //������������ڵ㣬���һ�����ڵ�������ӽڵ�  
	            nodelist.get(index).setRight(nodelist.get(index*2+2));  
	        }  
	    }  
	    /** 
	     * ������ǰ�ڵ��ֵ 
	     * @param nodelist 
	     * @param node 
	     */  
	    public void checkCurrentNode(Node node){  
	        System.out.print(node.getVar()+" ");  
	    }  
	    /** 
	     * ������������� 
	     * @param root ���������ڵ� 
	     */  
	    public void preOrderTraversal(Node node){  
	        if (node == null)  //����Ҫ��������� ������Ҷ�ӽڵ�����ֹͣ���±���  
	            return;    
	        checkCurrentNode(node);  
	        preOrderTraversal(node.getLeft());  
	        preOrderTraversal(node.getRight());  
	    }  
	    /** 
	     * ������������� 
	     * @param root ���ڵ� 
	     */  
	    public void inOrderTraversal(Node node){  
	        if (node == null)  //����Ҫ���������  
	            return;    
	        inOrderTraversal(node.getLeft());  
	        checkCurrentNode(node);  
	        inOrderTraversal(node.getRight());  
	    }  
	    /** 
	     * ������������� 
	     * @param root ���ڵ� 
	     */  
	    public void postOrderTraversal(Node node){  
	        if (node == null)  //����Ҫ���������  
	            return;    
	        postOrderTraversal(node.getLeft());  
	        postOrderTraversal(node.getRight());  
	        checkCurrentNode(node);  
	    }  
	      
	    /** 
	     * �ǵݹ�ǰ����� 
	     * @param node 
	     */  
	    public void preOrderTraversalbyLoop(Node node){  
	        Stack<Node> stack = new Stack();  
	        Node p = node;  
	        while(p!=null || !stack.isEmpty()){  
	            while(p!=null){ //��p��Ϊ��ʱ���Ͷ�ȡp��ֵ�������ϸ���pΪ�����ӽڵ㣬�����϶�ȡ���ӽڵ�  
	                checkCurrentNode(p);  
	                stack.push(p); //��p��ջ  
	                p = p.getLeft();  
	            }  
	            if(!stack.isEmpty()){  
	                p = stack.pop();  
	                p = p.getRight();  
	            }  
	        }  
	    }  
	    /** 
	     * �ǵݹ�������� 
	     * @param node 
	     */  
	    public void inOrderTraversalbyLoop(Node node){  
	        Stack<Node> stack = new Stack();  
	        Node p = node;  
	        while(p!=null || !stack.isEmpty()){  
	            while(p!=null){  
	                stack.push(p);  
	                p = p.getLeft();  
	            }  
	            if(!stack.isEmpty()){     
	                p = stack.pop();  
	                checkCurrentNode(p);  
	                p = p.getRight();  
	            }  
	        }  
	    }  
	    /** 
	     * �ǵݹ������� 
	     * @param node 
	     */  
	    public void postOrderTraversalbyLoop(Node node){  
	        Stack<Node> stack = new Stack<>();  
	        Node p = node,prev = node;  
	        while(p!=null || !stack.isEmpty()){  
	            while(p!=null){  
	                stack.push(p);  
	                p = p.getLeft();  
	            }  
	            if(!stack.isEmpty()){  
	                Node temp = stack.peek().getRight();  
	                if(temp == null||temp == prev){  
	                    p = stack.pop();  
	                    checkCurrentNode(p);  
	                    prev = p;  
	                    p = null;  
	                }else{  
	                    p = temp;  
	                }     
	            }  
	        }  
	    }  
	      
	    /** 
	     * ������ȱ��������ϵ��±����������� 
	     * @param root 
	     */  
	    public void bfs(Node root){  
	          if(root == null) return;  
	          LinkedList<Node> queue = new LinkedList<Node>();  
	          queue.offer(root); //���Ƚ����ڵ�������  
	          //����������ֵʱ��ÿ��ȡ�����׵�node��ӡ����ӡ֮���ж�node�Ƿ����ӽڵ㣬���У����ӽڵ�������  
	          while(queue.size() > 0){   
	            Node node = queue.peek();  
	            queue.poll(); //ȡ������Ԫ�ز���ӡ  
	            System.out.print(node.var+" ");  
	            if(node.left != null){ //��������ӽڵ㣬����������  
	              queue.offer(node.left);  
	            }  
	            if(node.right != null){ //��������ӽڵ㣬����������  
	              queue.offer(node.right);  
	            }  
	          }  
	    }  
	    /** 
	     * ������ȱ��� 
	     * @param node 
	     * @param rst 
	     * @param list 
	     */  
	    public void dfs(Node node,List<List<Integer>> rst,List<Integer> list){  
	        if(node == null) return;  
	        if(node.left == null && node.right == null){  
	            list.add(node.var);  
	            /* ���ｫlist����rst��ʱ������ֱ�ӽ�list���룬����ͨ���½�һ��list��ʵ�֣� 
	             * ��Ϊ���ֱ����list�Ļ�������remove��ʱ��Ҳ�Ὣ�����һ����Ľڵ�ɾ��*/  
	            rst.add(new ArrayList<>(list));  
	            list.remove(list.size()-1);  
	        }  
	        list.add(node.var);  
	        dfs(node.left,rst,list);  
	        dfs(node.right,rst,list);  
	        list.remove(list.size()-1);  
	    }  
	    /** 
	     * �ڵ��� 
	     * var �ڵ�ֵ 
	     * left �ڵ����ӽڵ� 
	     * right ���ӽڵ� 
	     */   
	    class Node{  
	        int var;  
	        Node left;  
	        Node right;  
	        public Node(int var){  
	            this.var = var;  
	            this.left = null;  
	            this.right = null;  
	        }  
	        public void setLeft(Node left) {  
	            this.left = left;  
	        }  
	        public void setRight(Node right) {  
	            this.right = right;  
	        }  
	        public int getVar() {  
	            return var;  
	        }  
	        public void setVar(int var) {  
	            this.var = var;  
	        }  
	        public Node getLeft() {  
	            return left;  
	        }  
	        public Node getRight() {  
	            return right;  
	        }  
	          
	    }  
}
