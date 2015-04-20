package main.java.gurps.model;

import main.java.gurps.application.Label;

/**
 * Created by Caio on 17/04/2015.
 */
public enum AttackType {

    PERF(Label.MODEL_ATTACK_TYPE_PERF),
    CONT(Label.MODEL_ATTACK_TYPE_CONT),
    BURN(Label.MODEL_ATTACK_TYPE_BURN),
    CORR(Label.MODEL_ATTACK_TYPE_CORR),
    PA1(Label.MODEL_ATTACK_TYPE_PA1),
    PA2(Label.MODEL_ATTACK_TYPE_PA2),
    PA3(Label.MODEL_ATTACK_TYPE_PA3),
    PA4(Label.MODEL_ATTACK_TYPE_PA4),
    FAT(Label.MODEL_ATTACK_TYPE_FAT),
    TOX(Label.MODEL_ATTACK_TYPE_TOX);


    private final String description;

    AttackType(String description) {
        this.description = description;
    }
}
