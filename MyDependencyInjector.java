import java.lang.reflect.Field;

class MyDependencyInjector implements DependencyInjector {

    private Container container;

    public MyDependencyInjector() {
        this.container = new Container();
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    @Override
    public void injectDependencies(Object target) {
        Class<?> clazz = target.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Object dependency = container.getDependency(field.getType());
                field.setAccessible(true);
                try {
                    field.set(target, dependency);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}