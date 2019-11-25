package com.example.arithmeticDemo.basic;

import org.junit.jupiter.api.Test;

//import org.junit.Test;



public class PaiXu {
	
	int ary[]={2,3,59,7,4,2,13,58,6,21,42};
	/**
	 * 冒泡排序
	 * 比较相邻的两个元素，将较大的元素放在后面
	 */
	@Test
	public void maoPao() {
		for(int i=0;i<ary.length;i++) {
			
			for(int j=0;j<ary.length;j++) {
				
			}
		}
	}
	
	/**
	 * 插入排序
	 * ary[0]为有序数组，剩余的为无序数组，将无序数组中的值与有序数组中的值循环比较，找到合适的位置，插入元素，直到全部插入到有序数组
	 */
	@Test
	public void chaRu(){
		//ary[i]为无序数组，ary[j]为有序数组
		for(int i=1;i<ary.length;i++){
			
			int tmp = ary[i];
			//在有序数组中寻找tmp元素的插入位置
			int j=i-1;
			while(j>=0 && tmp<ary[j]){
				ary[j+1]=ary[j];
				j--;
			}
			//因为是j--之后才不满足条件跳出循环的，所以此处位置应该是j+1
			ary[j+1]=tmp;
		}
		
		out(ary);
	}

	
	/**
	 * 快速排序
	 * 选中tmpAry[0]为基准数，从右开始寻找小于tmpAry[0]的数tmpAry[right]，从左开始寻找大于tmpAry[0]的数tmpAry[left]，找到之后交换left与right位置的元素，
	 * 然后再继续寻找，直到left=right，此次循环结束，将基准值tmpAry[0]放入此处
	 * 开始下次循环，分别快速排序两个小序列
	 * @param tmpAry
	 */
	@Test
	public void kuaiSu(){
		
		ks(ary,0,ary.length-1);
		out(ary);
	}
	

	private void out(int[] ary2) {
		for(int i=0;i<ary2.length;i++){
			System.out.print(ary2[i]+",");
		}
		
	}

	private void ks(int[] tmpAry, int left, int right) {
		
		if(left>right){
            return;
        }
		//tmp为基准
		int tmp = tmpAry[left];
		
		int i=left;
		int j = right;
		
		while(i<j){
			//检查右边是否大于基准（若是等于基准，则不作操作），若大于则继续循环
			while(tmpAry[j]>=tmp && i<j){
				j--;
			}
			//检查左边是否小于基准（若是等于基准，则不作操作），若小于则继续
			while(tmpAry[i]<=tmp && i<j){
				i++;
			}
			//左边大于基准且右边小于基准，交换左右两个值
			if( i<j){
				int num = tmpAry[j];
				tmpAry[j]=tmpAry[i];
				tmpAry[i]=num;
				
			}
		}
		//左右两侧循环完之后，把中间位置与基准交换
		tmpAry[left]=tmpAry[i];
		tmpAry[i]=tmp;
		//继续循环左右两侧进行比较
		ks(tmpAry,left,j-1);
		ks(tmpAry,j+1,right);
	}
	

}
