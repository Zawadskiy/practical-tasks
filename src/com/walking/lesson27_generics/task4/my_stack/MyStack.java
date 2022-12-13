package com.walking.lesson27_generics.task4.my_stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyStack<E> {

    E[] stack;
    private int top = 0;
    int capacity;

    public MyStack(Class<E> clazz, int capacity) {
        stack = (E[]) Array.newInstance(clazz, capacity);
        this.capacity = capacity;
    }

    public void addElement(E element) {
        if (top == capacity) {
            updateStackCapacity();
        }
        stack[top] = element;
        top++;

    }

    //Delete element from top of stack
    public void deleteElement() {
        if (top > 0) {
            stack[top] = null;
            top--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void deleteElement(E element) {
        if (top > 0) {
            for (int i = top; i >= 0; i--) {
                if (stack[i].equals(element)) {
                    stack[i] = null;
                    reorderStack(i);
                    top--;
                    return;
                }
            }
        }
        throw new NoSuchElementException(String.format("Element %s not found", element));
    }

    public E findElement(E element) {
        for (E e : stack) {
            if (e.equals(element)) {
                return e;
            }
        }
        throw new NoSuchElementException(String.format("Element %s not found", element));
    }

    private void reorderStack(int i) {
        for (int j = i; j < top; j++) {
            stack[j] = stack[j + 1];
        }
        stack[top] = null;
    }

    private void updateStackCapacity() {
        capacity = capacity * 3 / 2;
        stack = Arrays.copyOf(stack, capacity);
    }

    @Override
    public String toString() {
        StringBuilder stackToString = new StringBuilder("[");
        for (int i = 0; i < top - 1; i++) {
            stackToString.append("{")
                    .append(stack[i])
                    .append("}")
                    .append(", ");
        }
        stackToString.append(stack[top])
                    .append("]");
        return stackToString.toString();
    }
}
