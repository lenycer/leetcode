package com.example.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LongestSubstring {

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();

        String s1 = "abcabca";
        System.out.println(longestSubstring.lengthOfLongestSubstring(s1));

        String s2 = "bbbbbbb";
        System.out.println(longestSubstring.lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println(longestSubstring.lengthOfLongestSubstring(s3));

        String s4 = "abcaa";
        System.out.println(longestSubstring.lengthOfLongestSubstring(s4));
    }

    public int lengthOfLongestSubstring2(String s) {
        int r = 0;
        ArrayList<String> checkSet = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            String u = String.valueOf(s.charAt(i));
            if(checkSet.contains(u)){
                //이미 있는 char일 경우 기존에 있었던 것 까지 제거
                int ii=checkSet.indexOf(u);
                checkSet.subList(0,ii+1).clear();
                checkSet.add(u);
            }else{
                //일단 추가
                checkSet.add(u);
            }
            System.out.println(checkSet);
            r = Math.max(checkSet.size(),r);
        }
        return r;
    }


    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        List<String> list = new ArrayList<>();
        for(char c : s.toCharArray()) {
            String ss = String.valueOf(c);
            if(list.contains(ss)) {
                list.subList(0, list.indexOf(ss)+1).clear();
            }
            list.add(ss);
            length = Math.max(list.size(), length);
        }
        return length;
    }
}
