package org.example;

public interface DependencyInjector {
    public void injectDependencies(Object target) throws InstantiationException, IllegalAccessException;
}
