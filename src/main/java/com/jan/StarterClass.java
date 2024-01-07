package com.jan;

import com.jan.commons.annotations.PickClassForExecution;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Arrays;
import java.util.Set;

public class StarterClass {

    public static void main(String[] args) {
        Reflections rfl = new Reflections("com.jan");
        Set<Class<?>> annotatedClasses = rfl.getTypesAnnotatedWith(PickClassForExecution.class);
        if(!annotatedClasses.isEmpty()){
            for(Class cls: annotatedClasses){
                Method[] methods = cls.getMethods();
                for(Method mth : methods){
                    Annotation[] annotations = mth.getAnnotations();
                    if(Arrays.stream(annotations).anyMatch(item->item.annotationType().getName().equalsIgnoreCase("com.jan.commons.annotations.PickMethodForExecution"))){
                        try {
                            mth.invoke(Arrays.stream(cls.getDeclaredConstructors()).findFirst().get().newInstance());
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
        System.out.println(annotatedClasses.toString());
        System.out.println("Hello");
}
}
