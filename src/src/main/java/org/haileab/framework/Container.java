package org.haileab.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private DependencyInjector customInjector;

    public Container(DependencyInjector customInjector){
        this.customInjector = customInjector;
    }


    public void injectDependecies(Object target){
        customInjector.injectDependecies(target);
    }
}
