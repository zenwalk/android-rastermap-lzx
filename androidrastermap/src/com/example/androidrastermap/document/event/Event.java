package com.example.androidrastermap.document.event;

public interface Event<T>
{
    void dispatchOn(Object listener);
}
