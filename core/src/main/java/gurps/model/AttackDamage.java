package main.java.gurps.model;

/**
 * Created by Caio on 17/04/2015.
 */
public class AttackDamage {

    private AttackType attackType;
    private AttackBaseDamage attackBaseDamage;

    public AttackDamage(AttackType attackType, AttackBaseDamage attackBaseDamage) {
        this.attackType = attackType;
        this.attackBaseDamage = attackBaseDamage;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    public AttackBaseDamage getAttackBaseDamage() {
        return attackBaseDamage;
    }

    public void setAttackBaseDamage(AttackBaseDamage attackBaseDamage) {
        this.attackBaseDamage = attackBaseDamage;
    }
}
