package reflection.example.di;

import java.lang.reflect.Field;
import java.util.Set;
import org.reflections.Reflections;
import reflection.example.di.annotations.Component;
import reflection.example.di.annotations.InjectField;

import static org.reflections.scanners.Scanners.SubTypes;
import static org.reflections.scanners.Scanners.TypesAnnotated;

public class MyDependencyInjector implements DependencyInjector {

    private Container diContainer;
    private Reflections reflections;

    public MyDependencyInjector() {
        this.diContainer = new Container();
        this.reflections = new Reflections("app");
    }

    @Override
    public void injectDependencies(Object target) {
        setupDI();
    }

    public void setupDI() {
        Set<Class<?>> dependenciesComponent = getAllDependenciesComponent();

        for (Class<?> component : dependenciesComponent) {
            diContainer.registerDependency(component);
        }
    }

    private Set<Class<?>> getAllDependenciesComponent() {
        return reflections.get(SubTypes.of(TypesAnnotated.with(Component.class)).asClass());
    }

    public void getDependableClassForDI(Object classObject) throws IllegalAccessException {
        for (Field field : classObject.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectField.class)) {
                field.setAccessible(true);
                field.set(classObject, diContainer.fetchDependency(field.getType()));
            }
        }
    }
}
