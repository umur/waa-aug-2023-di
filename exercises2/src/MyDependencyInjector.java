import java.lang.reflect.Field;

// MyDependencyInjector class to perform dependency injection
public class MyDependencyInjector implements DependencyInjector {
    private Container container;

    public MyDependencyInjector(Container container) {
        this.container = container;
    }

    @Override
    public void injectDependencies(Object target,Container container) {
        Class<?> targetClass = target.getClass();

        try {
            for (Field field : targetClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(InjectDependency.class)) {
                    field.setAccessible(true);

                    Class<?> fieldType = field.getType();
                    Object dependencyInstance = container.getDependency(fieldType);

                    if (dependencyInstance == null) {
                        throw new RuntimeException("Dependency not found for class: " + fieldType.getName());
                    }

                    field.set(target, dependencyInstance);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while performing dependency injection", e);
        }
    }
}
