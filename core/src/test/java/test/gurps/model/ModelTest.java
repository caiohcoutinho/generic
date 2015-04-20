package test.gurps.model;

import gurps.model.*;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caio on 20/04/15.
 */
public class ModelTest {

    @Test
    public void getSTTest(){

        List<AttributeBonus> bonusList = new ArrayList<AttributeBonus>();
        bonusList.add(new AttributeBonus(Attribute.ST, 3));

        List<Advantage> advantageList = new ArrayList<Advantage>();

        ArrayList<AttributeBonus> advantageAttributeBonusList = new ArrayList<AttributeBonus>();
        advantageAttributeBonusList.add(new AttributeBonus(Attribute.ST, 4));
        ArrayList<ConditionalBonus> conditionalBonusList = new ArrayList<ConditionalBonus>();
        MockGameCondition condition = new MockGameCondition();
        conditionalBonusList.add(new ConditionalBonus(new AttributeBonus(Attribute.ST, 5), condition));
        advantageList.add(new Advantage("Animal Stregth!", 40,
                advantageAttributeBonusList,
                conditionalBonusList));

        List<Disadvantage> disadvantageList = new ArrayList<Disadvantage>();
        GurpsCharacter character = new CharacterBuilder()
                .setRace(new Race(bonusList,
                        advantageList,
                        disadvantageList)).build();

        Integer st = character.getST();
        Assert.assertNotNull(st);
        Assert.assertEquals(new Integer(22), st);
        condition.setState(false);
        Assert.assertEquals(new Integer(17), st);
    }

    private class MockGameCondition implements GameCondition {

        private boolean state;

        public boolean isMet() {
            return state;
        }

        public boolean isState() {
            return state;
        }

        public void setState(boolean state) {
            this.state = state;
        }
    }
}
