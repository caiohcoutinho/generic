package main.java.gurps.model;

import java.util.List;

/**
 * Created by caio on 20/04/15.
 */
public class Disadvantage extends AdvantageBase{
    public Disadvantage(String description, Integer cost, List<AttributeBonus> attributeBonusList, List<ConditionalBonus> conditionalBonusList) {
        super(description, cost, attributeBonusList, conditionalBonusList);
    }
}
