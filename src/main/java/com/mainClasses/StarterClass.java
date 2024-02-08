package com.mainClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;

import com.jan.commons.annotations.PickClassForExecution;

public class StarterClass {
	private static final Logger log = LogManager.getLogger(StarterClass.class); 

	public static void main(String[] args) {
		Reflections rfl = new Reflections("com.feb.Day12");
		Set<Class<?>> annotatedClasses = rfl.getTypesAnnotatedWith(PickClassForExecution.class);
		if (!annotatedClasses.isEmpty()) {
			for (Class cls : annotatedClasses) {
				Method[] methods = cls.getMethods();
				for (Method mth : methods) {
					Annotation[] annotations = mth.getAnnotations();
					if (Arrays.stream(annotations).anyMatch(item -> item.annotationType().getName()
							.equalsIgnoreCase("com.jan.commons.annotations.PickMethodForExecution"))) {
						try {
							Constructor cns = getZeroArgConstructorOfClass(cls);
							if (cns != null) {
								mth.invoke(cns.newInstance());
							}
						} catch (IllegalAccessException e) {
							throw new RuntimeException(e);
						} catch (InvocationTargetException e) {
							throw new RuntimeException(e);
						} catch (InstantiationException e) {
							throw new RuntimeException(e);
						}
					}
				}
			}
		}
		log.info("Completed");
	}

	private static Constructor getZeroArgConstructorOfClass(Class cls) {
		Constructor[] declaredConstructors = cls.getDeclaredConstructors();
		Constructor cns = null;
		for (int place = 0; place < declaredConstructors.length; place++) {
			if (declaredConstructors[place].getParameterCount() == 0) {
				cns = declaredConstructors[place];
				return cns;
			}
		}
		return null;
	}
}
