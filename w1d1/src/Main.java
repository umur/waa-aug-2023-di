import app.UserRepository;
import app.UserService;
import reflection.example.di.Container;
import reflection.example.di.MyDependencyInjector;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        Container container = new Container();
        container.registerDependency(UserRepository.class);

        MyDependencyInjector myDependencyInjector = new MyDependencyInjector();
        myDependencyInjector.injectDependencies(userService);
    }
}
