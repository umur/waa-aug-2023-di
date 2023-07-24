package org.haileab;

import org.haileab.framework.Container;
import org.haileab.framework.DependencyInjector;
import org.haileab.framework.MyCustomDependencyInjector;
import org.haileab.optinalFuncTesting.AnotherClass;

public class Main {
    public static void main(String[] args) {
        DependencyInjector dependencyInjector = new MyCustomDependencyInjector();
        Container container = new Container(dependencyInjector);

        UserService userService = new UserService();
        container.injectDependecies(userService);

        if(userService.getUserRepository() != null) System.out.println(userService.getUserRepository());

        AnotherClass anotherClass = new AnotherClass();
        container.injectDependecies(anotherClass);

        if(anotherClass.getDep1() != null) System.out.println(anotherClass.getDep1());
        if(anotherClass.getDep2() != null) System.out.println(anotherClass.getDep2());
        if(anotherClass.getDep3() != null) System.out.println(anotherClass.getDep3());

    }

}