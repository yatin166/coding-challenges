package com.algorithms;

import java.util.ArrayList;
import java.util.List;

public class LongestBinaryGap {

    public String getBinaryOf(long num){
        if(num == 0)
            return "0";
        String binary = "";
        while (num > 0) {
            long remainder = num % 2;
            binary += remainder;
            num /= 2;
        }
        return binary;
    }

    public int getBinaryGap(long number){
        String binary = getBinaryOf(number);
        int gap = 0;
        int temp = 0;
        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) == '1'){
                for(int j = i + 1; j < binary.length(); j++){
                    if(binary.charAt(j) == '0'){
                        temp++;
                    }
                    else {
                        break;
                    }
                }
            }
            if(temp > gap)
                gap = temp;
            temp = 0;
        }
        return gap;
    }

    public static void main(String[] args) {
        LongestBinaryGap longestBinaryGap = new LongestBinaryGap();
        System.out.println(longestBinaryGap.getBinaryGap(2117483646));
    }
}
