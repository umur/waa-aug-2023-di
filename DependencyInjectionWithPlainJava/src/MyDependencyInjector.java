import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MyDependencyInjector implements DependencyInjector{

    private Container container;

    public void setContainer(Container container){
        this.container= container;
    }

    @Override
    public void injectDependencies(Object target) {
        Field[] targetFields= target.getClass().getDeclaredFields();
        for(Field field:targetFields){
           if (field.isAnnotationPresent(MyAutowire.class)){
               Class<?> fieldType= field.getType();
               Object dependency= container.getInstance(fieldType);

               if(dependency!=null){
                   try {
                       field.setAccessible(true);
                       field.set(target, dependency);
                   }
                   catch (IllegalAccessException e){
                       e.printStackTrace();
                   }
               }
               else throw new RuntimeException("Dependency not found for "+field.getName());
           }
        }
    }
    public void addDependency(Class<?> clazz){
        try{
            Object instance = clazz.getDeclaredConstructor().newInstance();
            container.registerDependencies(clazz,instance);
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e){
            e.printStackTrace();
            throw new RuntimeException("Failed to instantiate the class: "+clazz );
        }
    }
}
