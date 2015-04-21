package main.java.gurps.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by caio on 20/04/15.
 */
public class GurpsCharacter {
    private String name;
    private String age;
    private String appearance;
    private Race race;
    private List<AttributeBonus> attributes;
    private List<Advantage> advantages;
    private List<Disadvantage> disadvantages;
    private Map<Gear, Integer> gear;
    private Integer ST;

    private final static List<Attribute> BASE_ATTRIBUTES = Arrays.asList(new Attribute[]{
            Attribute.ST, Attribute.DX, Attribute.IQ, Attribute.HT
    });
    private Integer DX;
    private Integer IQ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public List<AttributeBonus> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeBonus> attributes) {
        this.attributes = attributes;
    }

    public List<Advantage> getAdvantages() {
        return advantages;
    }

    public void setAdvantages(List<Advantage> advantages) {
        this.advantages = advantages;
    }

    public List<Disadvantage> getDisadvantages() {
        return disadvantages;
    }

    public void setDisadvantages(List<Disadvantage> disadvantages) {
        this.disadvantages = disadvantages;
    }

    public Map<Gear, Integer> getGear() {
        return gear;
    }

    public void setGear(Map<Gear, Integer> gear) {
        this.gear = gear;
    }

    public Integer getST() {
        return calculateAttribute(Attribute.ST);
    }

    public Integer getDX() {
        return calculateAttribute(Attribute.DX);
    }

    public Integer getIQ() {
        return calculateAttribute(Attribute.IQ);
    }

    private Integer calculateAttribute(Attribute attribute){
        Integer value = this.getAttribute(attribute);
        Race race = this.getRace();

        List<AdvantageBase> allAdvantages = new ArrayList<AdvantageBase>();
        this.addIfNotNull(allAdvantages, this.getAdvantages());
        this.addIfNotNull(allAdvantages, this.getDisadvantages());
        if(race != null) {
            value += this.filterAttributeBonus(attribute, race.getBonusList());
            this.addIfNotNull(allAdvantages, race.getAdvantageList());
            this.addIfNotNull(allAdvantages, race.getDisadvantageList());
        }
        if(allAdvantages != null) {
            for (AdvantageBase adv : allAdvantages) {
                value += this.filterAttributeBonus(attribute, adv.getAttributeBonusList());
                for (ConditionalBonus cb : adv.getConditionalBonusList()) {
                    AttributeBonus attributeBonus = cb.getAttributeBonus();
                    if (attributeBonus.getAttribute().equals(attribute) && cb.getCondition().applies()) {
                        value += attributeBonus.getModifier();
                    }
                }
            }
        }
        value += this.defaultValue(attribute);
        return value;
    }

    private Integer defaultValue(Attribute attribute) {
        return BASE_ATTRIBUTES.contains(attribute) ? 10 : 0;
    }

    private <T> void addIfNotNull(List<T> firtsList, List<? extends T> secondList) {
        if(firtsList != null && secondList != null){
            firtsList.addAll(secondList);
        }
    }

    private Integer getAttribute(Attribute attribute) {
        return this.filterAttributeBonus(attribute, this.getAttributes());
    }

    private Integer filterAttributeBonus(Attribute attribute, List<AttributeBonus> attributes) {
        if(attributes != null) {
            for (AttributeBonus ab : attributes) {
                if (ab.getAttribute().equals(attribute)) {
                    return ab.getModifier();
                }
            }
        }
        return 0;
    }

}
