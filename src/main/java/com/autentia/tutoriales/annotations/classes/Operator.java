package com.autentia.tutoriales.annotations.classes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import com.autentia.tutoriales.annotations.annotations.MultipleInvocation;

public class Operator {

    private static final Logger LOG = Logger.getLogger(Operator.class.getName());

    public void operate(AutomaticWeapon weapon) {
        final String className = weapon.getClass().getName();
        try {
            final Method[] methods = Class.forName(className).getMethods();
            for (final Method method : methods) {
                invokeMethod(method, weapon);
            }
        } catch (final Exception e) {
            LOG.severe("ERROR: " + e);
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
