package gurps.model;

import javax.jnlp.IntegrationService;
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
        return ST;
    }
}
