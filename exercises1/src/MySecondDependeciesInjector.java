public class MySecondDependeciesInjector implements DependencyInjector {

    @Override
    public void injectDependecies(Object target) {
        System.out.println("Inject Dependecies Number two "+target);
    }
}
