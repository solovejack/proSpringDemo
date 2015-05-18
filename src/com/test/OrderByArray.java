package com.test;

public class OrderByArray {

	public int[] sort(int[] array){
		for(int i=0;i<array.length-1;i++){
			for(int j=0;j<array.length-1-i;j++){
				if(array[j] < array[j+1]){
					int h = array[j];
					array[j] = array[j+1];
					array[j+1] = h;
				}
			}
		}
		return array;
	}
	
	public int[] ascSort(int[] array){
		for(int i=0;i<array.length;i++){
    		for(int j=i;j<array.length;j++){
    			if(array[i]>array[j]){
    				int s = array[i];
    				array[i] = array[j];
    				array[j] = s;
    			}
    		}
    	}
		return array;
	}	
	
	public int[] ascSort1(int[] array){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-1-i;j++){
				if(array[j] > array[j+1]){
					int h = array[j];
					array[j] = array[j+1];
					array[j+1] = h;
		    }
    	}
	 }
		return array;
	}
		
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
        int[] array = {1,8,5,2,4,9,7};
        OrderByArray or = new OrderByArray();
        System.out.println("********sort*********");
        int[] ret = or.sort(array);
        for(int i=0;i<ret.length;i++){
        	System.out.println(ret[i]);
        }
        System.out.println("******ascSort***********");
        int[] ret1 = or.ascSort(array);
        for(int i=0;i<ret1.length;i++){
        	System.out.println(ret1[i]);
        }
        System.out.println("******ascSort1***********");
        int[] ret2 = or.ascSort1(array);
        for(int i=0;i<ret2.length;i++){
        	System.out.println(ret2[i]);
        }
	}
}
