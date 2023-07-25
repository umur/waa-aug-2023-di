import java.lang.reflect.Field;

public class MyDependencyInjector implements  DependencyInjector {
    private final Container container;

    public MyDependencyInjector(Container container) {
        this.container = container;
    }

    @Override
    public void injectDependency(Object target) {
        Class<?> targetClass = target.getClass();
        Field[] fields = targetClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(CustomAnnotation.class)) {
                try {
                    Object dependencyInstance = container.getDependency(field.getType());
                    if (dependencyInstance == null) {
                        throw new DependencyInjectionException("Dependency not found for " + field.getName());
                    }
                    field.setAccessible(true);
                    field.set(target, dependencyInstance);
                } catch (IllegalAccessException e) {
                    throw new DependencyInjectionException("Error injecting dependency into " + field.getName(), e);
                }
            }

        }
    }
}
