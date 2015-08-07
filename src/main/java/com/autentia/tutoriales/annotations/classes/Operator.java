package com.autentia.tutoriales.annotations.classes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autentia.tutoriales.annotations.annotations.MultipleInvocation;

public class Operator {

    private static final Logger LOG = LoggerFactory.getLogger(Operator.class);

    public void operate(AutomaticWeapon weapon) {
        final String className = weapon.getClass().getName();
        try {
            final Method[] methods = Class.forName(className).getMethods();
            for (final Method method : methods) {
                invokeMethod(method, weapon);
            }
        } catch (final Exception e) {
            LOG.error("ERROR: {}", e);
        }
    }

    private void invokeMethod(Method method, AutomaticWeapon weapon)
            throws IllegalAccessException, InvocationTargetException {

        final MultipleInvocation multipleInvocation = method.getAnnotation(MultipleInvocation.class);

        if (multipleInvocation != null) {
            final int timesToInvoke = multipleInvocation.timesToInvoke();

            for (int i = 0; i < timesToInvoke; i++) {
                method.invoke(weapon, (Object[])null);
            }
        }

    }
}
