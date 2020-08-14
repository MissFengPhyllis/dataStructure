/*
2021 bilibili 秋招面试题2 字符串匹配
判断一个字符串是否有效，字符串中只包含括号字符“[]{}()”这三种，同类型的括号才能匹配。且必须按照顺序匹配
输入“[{()}]” 输出 true
输入“[{()]}” 输出 false
输入“]{()}[” 输出 false
*/

package com.dataStructure;

public class stringMatch {
    public static boolean matchString(String s){
        boolean flag = false;
        char[] str = new char[s.length()];
        for(int i = 0; i<s.length(); i++){
            str[i] = s.charAt(i);
        }
        int left = 0;
        int right = str.length-1;
        while(left<right){
            if(str[left] == '[' && str[right] == ']' || str[left] == '(' && str[right] == ')' || str[left] == '{' && str[right] == '}'){
                flag = true;
                left++;
                right --;
            }else{
                flag = false;
                break;
            }
            break;
        }
        return flag;
    }
    public static void main(String[] args) {
        String ss = "{[()}]";
        System.out.println(matchString(ss));
    }
}
