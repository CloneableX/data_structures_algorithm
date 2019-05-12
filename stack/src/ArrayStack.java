package com.clo.dsa.stack;

/**
 * com.clo.dsa.stack.ArrayStack
 *
 * @author Cloneable
 * @date 2019/4/20 17:31:20
 * @description stack by array
 */
public class ArrayStack {
    protected int size;
    protected int topIndex = 0;
    protected String[] stack;

    public ArrayStack(int size) {
        this.size = size;
        stack = new String[size];
    }

    public void push(String data) {
        if(topIndex == size) {return;}

        stack[topIndex] = data;
        ++topIndex;
    }

    public String pop() {
        if(topIndex == 0) {return null;}
        String stackTop = stack[topIndex];
        --topIndex;
        return stackTop;
    }
}
