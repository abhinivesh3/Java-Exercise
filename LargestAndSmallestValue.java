//Write a program that randomly fills a 4 by 5 by 8 array, then prints the largest and smallest values in the array.
//Output should print the contents of the matrix and the largest and smallest values.

import java.util.Random;

public class LargestAndSmallestValue {
    public static void main(String[] args){
        int dim1=4;
        int dim2=5;
        int dim3=8;
        int[][][] arr=new int[dim1][dim2][dim3];
        Random random=new Random();
        for(int i=0;i<dim1;i++){
            for(int j=0;j<dim2;j++){
                for(int k=0;k<dim3;k++){
                    arr[i][j][k]=random.nextInt(10000);
                }
            }
        }
        int maximumValue = Integer.MIN_VALUE;
        int minimumValue = Integer.MAX_VALUE;
        for(int i=0;i<dim1;i++){
            for(int j=0;j<dim2;j++){
                for(int k=0;k<dim3;k++){
                    System.out.print(arr[i][j][k]+" ");
                    maximumValue=Math.max(maximumValue,arr[i][j][k]);
                    minimumValue=Math.min(minimumValue,arr[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Largest Value : "+maximumValue);
        System.out.println("Smallest Value : "+minimumValue);
    }

}
