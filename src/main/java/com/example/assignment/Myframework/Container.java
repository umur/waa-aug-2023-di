package com.example.assignment.Myframework;

public class Container {
    private DependecyInjector customInjector;

    public Container(DependecyInjector customInjector){
        this.customInjector = customInjector;
    }
    public void injectDependecies(Object target){
        customInjector.injectDependecies(target);
    }


}
