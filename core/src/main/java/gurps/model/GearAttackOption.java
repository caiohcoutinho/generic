package gurps.model;

import java.util.List;

/**
 * Created by Caio on 17/04/2015.
 */
public class GearAttackOption {

    private AttackDamage attackDamage;
    private Reach reach;

    public GearAttackOption(AttackDamage attackDamage, Reach reach) {
        this.attackDamage = attackDamage;
        this.reach = reach;
    }

    public AttackDamage getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(AttackDamage attackDamage) {
        this.attackDamage = attackDamage;
    }

    public Reach getReach() {
        return reach;
    }

    public void setReach(Reach reach) {
        this.reach = reach;
    }
}
