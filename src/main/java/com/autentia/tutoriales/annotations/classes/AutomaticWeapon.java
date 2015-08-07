package com.autentia.tutoriales.annotations.classes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autentia.tutoriales.annotations.annotations.MultipleInvocation;

public class AutomaticWeapon {

    private static final Logger LOG = LoggerFactory.getLogger(AutomaticWeapon.class);

    private static final int BURST_FIRE_ROUNDS = 3;

    private static final int AUTO_FIRE_ROUNDS = 5;

    private int ammo;

    public AutomaticWeapon(int ammo) {
        this.ammo = ammo;
    }

    @MultipleInvocation
    public void singleFire() {
        ammo--;
        LOG.info("Single fire! Ammo left: {}", ammo);
    }

    @MultipleInvocation(timesToInvoke = BURST_FIRE_ROUNDS)
    public void burstFire() {
        ammo--;
        LOG.info("Burst fire! Ammo left: {}", ammo);
    }

    @MultipleInvocation(timesToInvoke = AUTO_FIRE_ROUNDS)
    public void autoFire() {
        ammo--;
        LOG.info("Auto fire! Ammo left: {}", ammo);
    }
}
