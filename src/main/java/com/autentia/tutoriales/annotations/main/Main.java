package com.autentia.tutoriales.annotations.main;

import com.autentia.tutoriales.annotations.classes.AutomaticWeapon;
import com.autentia.tutoriales.annotations.classes.Operator;

public class Main {

    public static void main(String[] args) {
        final AutomaticWeapon weapon = new AutomaticWeapon(30);
        final Operator operator = new Operator();
        operator.operate(weapon);
    }
}
