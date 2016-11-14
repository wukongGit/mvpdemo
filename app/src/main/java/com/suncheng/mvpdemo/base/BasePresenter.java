package com.suncheng.mvpdemo.base;

public interface BasePresenter<T> {
    void attachView(T view);

    void detachView();
}
