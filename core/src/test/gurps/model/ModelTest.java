package test.gurps.model;

import main.java.gurps.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caio on 20/04/15.
 */
public class ModelTest {

    @Test
    public void getAttributeTestAdvantagesAndRace(){

        List<AttributeBonus> bonusList = new ArrayList<AttributeBonus>();
        bonusList.add(new AttributeBonus(Attribute.ST, 3));

        List<Advantage> advantageList = new ArrayList<Advantage>();

        ArrayList<AttributeBonus> advantageAttributeBonusList = new ArrayList<AttributeBonus>();
        advantageAttributeBonusList.add(new AttributeBonus(Attribute.ST, 4));
        ArrayList<ConditionalBonus> conditionalBonusList = new ArrayList<ConditionalBonus>();
        MockGameCondition condition = new MockGameCondition();
        condition.setState(true);
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
        Assert.assertEquals(new Integer(17), character.getST());
  }

    @Test
    public void getAttributeTestDisadvantagesAndRace(){
        List<AttributeBonus> bonusList = new ArrayList<AttributeBonus>();
        bonusList.add(new AttributeBonus(Attribute.DX, -1));

        List<Advantage> advantageList = new ArrayList<Advantage>();

        List<Disadvantage> disadvantageList = new ArrayList<Disadvantage>();

        List<AttributeBonus> disadvantageAttributeBonusList = new ArrayList<AttributeBonus>();
        disadvantageAttributeBonusList.add(new AttributeBonus(Attribute.DX, -2));

        ArrayList<ConditionalBonus> conditionalBonusList = new ArrayList<ConditionalBonus>();
        MockGameCondition condition = new MockGameCondition();
        condition.setState(true);
        conditionalBonusList.add(new ConditionalBonus(new AttributeBonus(Attribute.DX, -3), condition));
        disadvantageList.add(new Disadvantage("Weak", 40,
                disadvantageAttributeBonusList,
                conditionalBonusList));
        GurpsCharacter character = new CharacterBuilder()
                .setRace(new Race(bonusList,
                        advantageList,
                        disadvantageList)).build();

        Integer dx = character.getDX();
        Assert.assertNotNull(dx);
        Assert.assertEquals(new Integer(4), dx);
        condition.setState(false);
        Assert.assertEquals(new Integer(7), character.getDX());
    }

    @Test
    public void getAttributeTestRegularAdvantage(){
        List<Advantage> advantageList = new ArrayList<Advantage>();
        List<AttributeBonus> attributeBonusList = new ArrayList<AttributeBonus>();
        attributeBonusList.add(new AttributeBonus(Attribute.IQ, 5));
        List<ConditionalBonus> conditionalBonusList = new ArrayList<ConditionalBonus>();
        advantageList.add(new Advantage("Smart!", 25, attributeBonusList, conditionalBonusList));
        List<Disadvantage> disadvantages = new ArrayList<Disadvantage>();
        List<AttributeBonus> disadvantageBonusList = new ArrayList<AttributeBonus>();
        disadvantageBonusList.add(new AttributeBonus(Attribute.IQ, -7));
        disadvantages.add(new Disadvantage("Dumb!", -15, disadvantageBonusList, new ArrayList<ConditionalBonus>()));
        GurpsCharacter character = new CharacterBuilder().
                setAdvantageList(advantageList).setDisadvantageList(disadvantages).build();

        Integer iq = character.getIQ();
        Assert.assertNotNull(iq);
        Assert.assertEquals(new Integer(8), iq);

    }



    private class MockGameCondition implements GameCondition {

        private boolean state;

        public boolean applies() {
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
