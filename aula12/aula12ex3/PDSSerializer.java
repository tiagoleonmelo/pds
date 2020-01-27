package aula12ex3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PDSSerializer {
	public static String fromObject(Object o) throws IllegalArgumentException, IllegalAccessException{
		Class cl = o.getClass();
		//Explore os metodos
		cl.getMethods();
		Field[] fields = cl.getFields();
		for(Field f : fields) {
			System.out.println(f.get(o));
		}
		
//		Method[] methods = cl.getMethods();
//		for(Method m : methods) {
//			System.out.println(m);
//		}
		
		//Veja o javadoc das classes: Class, Method, Field, Modifier
		return "string";
	}
}