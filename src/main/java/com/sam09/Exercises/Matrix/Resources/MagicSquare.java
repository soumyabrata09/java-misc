package com.sam09.Exercises.Matrix.Resources;

/**
 * @author Sam
 *
 */
public class MagicSquare {

	private double M;
	private static int pi,pj;
	public static int[][] getMagicSquare(int num){
		int[][] magicSquare = new int[num][num];
		//Determine the position of the first value i.e 1
		pi = num/2;
		pj = num-1;
		
		for(int i=1 ; i< Math.pow(num,2);) { 
			//populate the matrix with the numbers ranges from 1 to n*n where n is any natural number
			if(pi==-1 && pj==num) {
				pi=0;
				pj=num-2;
			}
			else {
				if(pi<0) {
                  pi =num-1;
			    }
				if(pj == num) {
					pj=0;
				}
			}
			
			if( magicSquare[pi][pj] != 0) {
				pi++;
				pj -= 2;
				continue;
			}
			else {
				magicSquare[pi][pj] = i++;
			}
			
			//Determine the position of the next element(nextVal)
			pi--;
			pj++;
		}
		
		return magicSquare;
	}
	
	public double GetMagicConstant(int num) {
		M = num*( Math.pow(num,2)+1)/2;
		return M;
	}
	public void DisplayMagicSquare(int [][]ms, int num) {
		for(int i=0; i< num; i++) {
			for(int j=0; j<num; j++) {
				System.out.print(" "+ms[i][j]+" ");
			}
			System.out.println();
		}
	}
}
