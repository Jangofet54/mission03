package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Stack;

public class LinkedStack<E> implements Stack<E> {

    DLL<E> data = new DLL<>();


    @Override
    public void push(E element) {

        data.addFirst(element);
    }

    @Override
    public E peek() {
        if(isEmpty()){return null;}
        return data.first();
    }

    @Override
    public E pop() {
        if(isEmpty()){return null;}
        return data.removeFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }


    @Override
    public void transfer(Stack to) {

        if(to == null){return;}

        while(isEmpty() != true){
            to.push(this.pop());
        }

    }

    @Override
    public void reverse() {

        LinkedStack<E> temp = new LinkedStack<>();

        while(isEmpty() != true){

            this.transfer(temp);
        }

        this.data = temp.data;

    }

    @Override
    public void merge(Stack other) {

        LinkedStack<E> temp = new LinkedStack<>();
        this.transfer(temp);
        other.transfer(temp);
        other.reverse();
        this.data = temp.data;
    }

    @Override
    public void printStack() {
        data.printList();
    }
}
