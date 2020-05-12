package com.algorithms;

public class FloodDepth {

    public int getDepth(int[] A){
        int waterLevel = 0;
        int longestBlock = 1;
        for(int i=0; i<A.length; i++){
            if(A[i] < longestBlock){
                int smallestBlock = A[i];
                for(int j=i; j<A.length; j++){
                    int previousBlock = A[j-1];
                    int currentBlock = A[j];
                    if(currentBlock < smallestBlock)
                        smallestBlock = A[j];
                    if(previousBlock < currentBlock)
                        if(currentBlock >= longestBlock){
                            if(waterLevel < (longestBlock - smallestBlock))
                                waterLevel = longestBlock - smallestBlock;
                            longestBlock = currentBlock;
                            i=j;
                            break;
                        }else if(waterLevel < (currentBlock - smallestBlock)){
                            waterLevel = currentBlock - smallestBlock;
                        }
                }
            }else{
                longestBlock = A[i];
            }

        }
        return waterLevel;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {100,1,299999999,2, 100000000};
        FloodDepth floodDepth = new FloodDepth();
        System.out.println(floodDepth.getDepth(arr));
    }
}
