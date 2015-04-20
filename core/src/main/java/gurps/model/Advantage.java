package gurps.model;

import java.util.List;

/**
 * Created by caio on 20/04/15.
 */
public class Advantage extends AdvantageBase{

    public Advantage(String description, Integer cost, List<AttributeBonus> attributeBonusList, List<ConditionalBonus> conditionalBonusList) {
        super(description, cost, attributeBonusList, conditionalBonusList);
    }
}
