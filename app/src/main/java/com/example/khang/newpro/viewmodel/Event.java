package com.example.khang.newpro.viewmodel;

public class Event<T> {
    private boolean hasBeenHandled = false;
    private T content;
    public Event(T content) {
        this.content = content;
    }

    public T getContentIfNotHandled() {
        if(hasBeenHandled)
        {
            return null;
        }
        else {
            hasBeenHandled = true;
            return content;
        }
    }

    public T peekContent(){
        return content;
    }
}