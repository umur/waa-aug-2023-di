import java.lang.annotation.Retention;
public interface DependencyInjector {
    void injectDependencies(Object target);
}
