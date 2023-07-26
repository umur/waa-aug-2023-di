public class MyDependencyInjector implements DependencyInjector {
    @Override
    public void injectDependecies(Object target) {
        System.out.println("Inject Dependecies "+target);
    }
}
