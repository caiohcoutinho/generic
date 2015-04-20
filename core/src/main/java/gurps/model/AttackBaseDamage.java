package gurps.model;

/**
 * Created by Caio on 17/04/2015.
 */
public class AttackBaseDamage {

    private AttackBaseDamageType attackBaseDamageType;
    private Integer modifier;
    private Integer dices;

    public AttackBaseDamage(AttackBaseDamageType attackBaseDamageType, Integer modifier, Integer dices) {
        this.attackBaseDamageType = attackBaseDamageType;
        this.modifier = modifier;
        this.dices = dices;
    }

    public AttackBaseDamageType getAttackBaseDamageType() {
        return attackBaseDamageType;
    }

    public void setAttackBaseDamageType(AttackBaseDamageType attackBaseDamageType) {
        this.attackBaseDamageType = attackBaseDamageType;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    public Integer getDices() {
        return dices;
    }

    public void setDices(Integer dices) {
        this.dices = dices;
    }
}
