package assignment1;

public interface DependencyInjector {
	<T> T injectDependencies(T target);

}
