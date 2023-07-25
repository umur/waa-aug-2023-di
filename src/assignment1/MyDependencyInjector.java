package assignment1;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyDependencyInjector implements DependencyInjector {

    private Container container;

    public MyDependencyInjector(Container container) {
        this.container = container;
    }

    @Override
    public <T> T injectDependencies(T target) {
    	Field[] fields = target.getClass().getDeclaredFields();
    	List<Field> dependencyFields = Arrays.stream(fields).filter(x ->{ 
    		x.setAccessible(true);
    		return x.isAnnotationPresent(Dependency.class);
    		}).toList();
    	dependencyFields.forEach(x -> {
    		x.setAccessible(true);    		
			try {
				x.set(target, container.getDependency(x.getType()));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x.setAccessible(false);
		});
    	return target;
    }
      
}
