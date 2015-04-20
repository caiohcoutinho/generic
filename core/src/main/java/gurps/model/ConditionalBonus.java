package gurps.model;

/**
 * Created by caio on 20/04/15.
 */
public class ConditionalBonus {
    private AttributeBonus attributeBonus;
    private GameCondition condition;

    public ConditionalBonus(AttributeBonus attributeBonus, GameCondition condition) {
        this.attributeBonus = attributeBonus;
        this.condition = condition;
    }

    public AttributeBonus getAttributeBonus() {
        return attributeBonus;
    }

    public void setAttributeBonus(AttributeBonus attributeBonus) {
        this.attributeBonus = attributeBonus;
    }

    public GameCondition getCondition() {
        return condition;
    }

    public void setCondition(GameCondition condition) {
        this.condition = condition;
    }
}
