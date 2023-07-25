import java.lang.reflect.Field;

public class MyDependencyInjector implements DependencyInjector {
    private Container container;

    public MyDependencyInjector(Container container) {
        this.container = container;
    }

    @Override
    public void injectDependencies(Object target) {
        Class<?> clazz = target.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(DependecyInject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = container.getDependency(fieldType);

                if (dependency == null) {
                    throw new RuntimeException("Dependency not found for field: " + field.getName());
                }
                field.setAccessible(true);
                try {
                    field.set(target, dependency);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error injecting dependency into field: " + field.getName(), e);
                }
            }
        }
    }
}
