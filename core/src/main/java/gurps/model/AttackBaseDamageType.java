package main.java.gurps.model;

import main.java.gurps.application.Label;

/**
 * Created by Caio on 17/04/2015.
 */
public enum AttackBaseDamageType {

    GDP(Label.MODEL_ATTACK_BASE_DAMAGE_TYPE_GDP),
    GDB(Label.MODEL_ATTACK_BASE_DAMAGE_TYPE_GDB),
    FIX(Label.MODEL_ATTACK_BASE_DAMAGE_TYPE_FIX);

    private final String description;

    AttackBaseDamageType(String description) {
        this.description = description;
    }
}
