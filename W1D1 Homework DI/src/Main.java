import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {

        UserService userService=new UserService();
        Container c =new Container();
        try {
            c.registerDependency(UserRepository.class);
            c.registerDependency(CustomerRepository.class);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        MyDependencyInjector myDependencyInjector=new MyDependencyInjector(c);
        myDependencyInjector.injectDependency(userService);
        userService.printIfRepositoriesAreInjected();

    }
}