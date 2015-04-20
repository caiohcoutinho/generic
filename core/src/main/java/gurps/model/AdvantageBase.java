package gurps.model;

import java.util.List;

/**
 * Created by caio on 20/04/15.
 */
public class AdvantageBase {
    private String description;
    private Integer cost;
    private List<AttributeBonus> attributeBonusList;
    private List<ConditionalBonus> conditionalBonusList;

    public AdvantageBase(String description, Integer cost, List<AttributeBonus> attributeBonusList, List<ConditionalBonus> conditionalBonusList) {
        this.description = description;
        this.cost = cost;
        this.attributeBonusList = attributeBonusList;
        this.conditionalBonusList = conditionalBonusList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public List<AttributeBonus> getAttributeBonusList() {
        return attributeBonusList;
    }

    public void setAttributeBonusList(List<AttributeBonus> attributeBonusList) {
        this.attributeBonusList = attributeBonusList;
    }

    public List<ConditionalBonus> getConditionalBonusList() {
        return conditionalBonusList;
    }

    public void setConditionalBonusList(List<ConditionalBonus> conditionalBonusList) {
        this.conditionalBonusList = conditionalBonusList;
    }
}
