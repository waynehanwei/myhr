package com.bc.test;

import java.util.ArrayList;
import java.util.List;

public class BinTree {

	private BinTree lChild;//����
	private BinTree rChild;//�Һ���
	private BinTree root;//���ڵ�
	private Object data; //������
	private List<BinTree> datas;//�洢���еĽڵ�
	public BinTree(BinTree lChild, BinTree rChild, Object data) {
		super();
		this.lChild = lChild;
		this.rChild = rChild;
		this.data = data;
	}
	public BinTree(Object data) {
		this(null, null, data);
	}
	public BinTree() {
		super();
	}
	
	public void createTree(Object[] objs){
		datas=new ArrayList<BinTree>();
		for (Object object : objs) {
			datas.add(new BinTree(object));
		}
		root=datas.get(0);//����һ����Ϊ���ڵ�
		for (int i = 0; i < objs.length/2; i++) {
			datas.get(i).lChild=datas.get(i*2+1);
			if(i*2+2<datas.size()){//����ż����ʱ�� �±�Խ��
				datas.get(i).rChild=datas.get(i*2+2);
			}
		}
	}
	//�������
	public void preorder(BinTree root){
		if(root!=null){
			visit(root.getData());
			preorder(root.lChild);
			preorder(root.rChild);
		}
		
	}
	//�������
	public void inorder(BinTree root){
		if(root!=null){
			inorder(root.lChild);
			visit(root.getData());
			inorder(root.rChild);
		}
		
	}
	//�������
	public void afterorder(BinTree root){
		if(root!=null){
			afterorder(root.lChild);
			afterorder(root.rChild);
			visit(root.getData());
		}
		
	}
	private void visit(Object obj) {
		System.out.print(obj+" ");
	}
	public Object getData() {
		return data;
	}
	public BinTree getRoot() {
		return root;
	}
}
