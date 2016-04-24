package es.everis.library.support;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * 
 * Utilidad de apoyo para informacion sobre Class
 *
 */
public class GenericClassHelper {
	
	private GenericClassHelper() {
	}
	
	@SuppressWarnings("unchecked")
	public static Class<? extends Object> getFirstArgument(Object instance, Class<? extends Object> superclass) {
		Class<? extends Object> clazz = instance.getClass();
		while (clazz != null && clazz.getSuperclass() != superclass) {
			clazz = clazz.getSuperclass();
		}
		
		Type[] typeArr = ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments();

		Type t = typeArr[0];
		if (t instanceof TypeVariable) {
			return getFirstArgument(instance, clazz);
		} else if (t instanceof Class<?>) {
			return (Class<? extends Object>)t;
		} else {
			throw new RuntimeException("FirstArgument not found");
		}
			
	}

	public static String[] getTypeNames(@SuppressWarnings("rawtypes") Class clazz) {
		@SuppressWarnings("rawtypes")
		TypeVariable[] typeParameters = clazz.getTypeParameters();
		String[] typeNames = new String[typeParameters.length];
		for (int cont=0; cont<typeParameters.length; cont++) {
			typeNames[cont] = typeParameters[cont].getName();
		}
		return typeNames;
	}
	
	public static Type[] getTypeArgumentsForSuperClass(Class<? extends Object> clazz) {
		Type t =  clazz.getGenericSuperclass();
		if (t == null || !(t instanceof ParameterizedType)) return new Type[0];
		ParameterizedType pt = (ParameterizedType) t;
		return pt.getActualTypeArguments();
	}

	public static Type getTypeArgumentForSuperClass(Class<? extends Object> clazz, String superClassTypeName) {
		String[] names = GenericClassHelper.getTypeNames(clazz.getSuperclass());
		if (names == null || names.length == 0) return null;
		Type[] types = GenericClassHelper.getTypeArgumentsForSuperClass(clazz);
		for (int cont=0; cont<names.length; cont++) {
			if (names[cont].equals(superClassTypeName)) return types[cont];
		}
		return null;
	}



}
