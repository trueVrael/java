package classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

//Serializable zapewnia trwa³oœæ
public abstract class ObjectPlus implements Serializable {
    
	private static Hashtable<Class<?>, List<ObjectPlus>> classesExtension = new Hashtable<>();

    
    // Default constructor
    ObjectPlus() {
    	Class<? extends ObjectPlus> childCls = this.getClass();
    	List<ObjectPlus> childClsExtent;

    	if (classesExtension.containsKey(childCls)) {
    		childClsExtent = classesExtension.get(childCls);
        }
    	else {
    		childClsExtent = new LinkedList<>();
    		classesExtension.put(childCls, childClsExtent);
    	}

    	childClsExtent.add(this);
    	addParentClasses(this);
    }

    protected static void showExtension(Class<? extends ObjectPlus> cls) {
        System.out.println(String.format("Extension of %s", cls));

        for (ObjectPlus instance : classesExtension.getOrDefault(cls, new LinkedList<>())) {
            System.out.println(instance);
        }
        System.out.println();
    }

    protected static List<ObjectPlus> getExtension(Class<? extends ObjectPlus> cls) {
        return classesExtension.get(cls);
    }

    // Adds super classes up to extension
    private void addParentClasses(ObjectPlus instance) {
        Class<?> superClass = instance.getClass();

        while ((superClass = superClass.getSuperclass()) != ObjectPlus.class) {
            List<ObjectPlus> superClsExtension;

            if (classesExtension.containsKey(superClass)) {
                superClsExtension = classesExtension.get(superClass);
            } else {
                superClsExtension = new LinkedList<>();
                classesExtension.put(superClass, superClsExtension);
            }

            superClsExtension.add(this);
        }
    }
    
}
