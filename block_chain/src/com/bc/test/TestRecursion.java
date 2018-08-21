package com.bc.test;

import org.junit.Test;

public class TestRecursion {

	public static void main(String[] args) {

	}
	
	@Test
	public void test1()
	{
		int temp = this.sumByMax2(10);
		System.out.println(temp);
	}
	
	public int sumByMax(int max)
	{
		 int result=0;
		 while(max>=1)
		{ 
			 result+=max; 
			 max--; 
		} 
		 return result; 
	
	}
	

	
	public int sumByMax2(int max){
		 if(max>=2){ 
		return max+sumByMax2(max-1);
		 }else{ 
		return max;
		 }
		 }


}
