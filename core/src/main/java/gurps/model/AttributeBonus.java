package gurps.model;

/**
 * Created by caio on 20/04/15.
 */
public class AttributeBonus {
    private Attribute attribute;
    private Integer modifier;

    public AttributeBonus(Attribute attribute, Integer modifier) {
        this.attribute = attribute;
        this.modifier = modifier;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }
}
