public class Main {
    public static void main(String[] args) {
        Object object = "longltt";
        Object object1 = "longltt1";

        DependencyInjector dependencyInjector = new MyDependencyInjector();
        DependencyInjector dependencyInjector1 = new MySecondDependeciesInjector();

        dependencyInjector.injectDependecies(object);
        dependencyInjector.injectDependecies(object1);

        dependencyInjector1.injectDependecies(object);
        dependencyInjector1.injectDependecies(object1);
    }
}