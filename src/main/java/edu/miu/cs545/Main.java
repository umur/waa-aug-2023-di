package edu.miu.cs545;

import edu.miu.cs545.entities.Container;
import edu.miu.cs545.entities.MyDependencyInjector;
import edu.miu.cs545.repository.UserRepository;
import edu.miu.cs545.service.UserService;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Container container = new Container();
        container.registerDependency(UserRepository.class);

        UserService userService = new UserService();
        MyDependencyInjector injector = new MyDependencyInjector();
        injector.injectDependencies(userService);
    }
}