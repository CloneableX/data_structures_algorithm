package com.clo.dsa.stack;

/**
 * com.clo.dsa.stack.ExpandArrayStack
 *
 * @author Cloneable
 * @date 2019/4/20 21:47:20
 * @description stack by expandable array
 */
public class ExpandArrayStack extends ArrayStack {
    public ExpandArrayStack(int size) {
        super(size);
    }

    @Override
    public void push(String data) {
        if(topIndex == size) {
            expandArray();
        }
        super.push(data);
    }

    private void expandArray() {
        size = size * 2;
        String[] newStack = new String[size];
        for(int i = 0; i < size / 2; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
    }
}
