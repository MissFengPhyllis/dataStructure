package com.dataStructure;
import java.util.ArrayList;


  class ArrayStack {
  //初始化一个数组对象
    ArrayList<Integer> arrStack  = new ArrayList();

//push方法
   public void push (int value){
    arrStack.add(value);

   }
   
   //pop方法
    public int pop(){

     return arrStack.remove(arrStack.size()-1);
    }
    //取栈顶
    public int peek(){
        return arrStack.get(arrStack.size()-1);
    }
    
    //判断是否为空
    public boolean isEmpty(){
        if(arrStack.size() ==0){
            return true;
        }
        return false;
    }
    
    //求取栈的大小
    public int size(){
        return arrStack.size();
    }
    
    //栈的打印
    public void iterab() {
        System.out.print("[");
        for (Object a : arrStack) {
            System.out.print(a + ",");
        };
        System.out.println("]");
    }
    
    
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        stack.push(2);
        stack.push(4);
        stack.iterab();
        System.out.println(stack.peek()); 
        System.out.println(stack.pop());
        stack.push(5);
        stack.iterab();
    }
}
