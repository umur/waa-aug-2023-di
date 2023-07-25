public class Main {
    public static void main(String args[]) {
        Object sampleObj = "longltt";
        Object sampleObj1 = "longltt2";
        DependencyInjector dependencyInjector = new MyDependencyInjector();
        DependencyInjector dependencyInjector1 = new MySecondDependeciesInjector();
        dependencyInjector.injectDependecies(sampleObj);
        dependencyInjector.injectDependecies(sampleObj1);

        dependencyInjector1.injectDependecies(sampleObj);
        dependencyInjector1.injectDependecies(sampleObj1);
    }
}
