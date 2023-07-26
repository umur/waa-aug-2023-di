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
                    System.out.println("0"+fieldType);
                    System.out.println("1"+field.get(target));

                    Object dependencyInstance = container.getDependency(fieldType);
                    System.out.println("dependencyInstance"+dependencyInstance);

                    if (dependencyInstance == null) {
                        throw new RuntimeException("Dependency not found for class: " + fieldType.getName());
                    }
                    System.out.println("2"+field.get(target));
                    field.set(target, dependencyInstance);
                    System.out.println("3"+field.get(target));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while performing dependency injection", e);
        }
    }
}
