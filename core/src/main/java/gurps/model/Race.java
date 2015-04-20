package gurps.model;

import java.util.List;

/**
 * Created by caio on 20/04/15.
 */
public class Race {
    private List<AttributeBonus> bonusList;
    private List<Advantage> advantageList;
    private List<Disadvantage> disadvantageList;

    public Race(List<AttributeBonus> bonusList,
                List<Advantage> advantageList,
                List<Disadvantage> disadvantageList) {
        this.bonusList = bonusList;
        this.advantageList = advantageList;
        this.disadvantageList = disadvantageList;
    }

    public List<AttributeBonus> getBonusList() {
        return bonusList;
    }

    public void setBonusList(List<AttributeBonus> bonusList) {
        this.bonusList = bonusList;
    }

    public List<Advantage> getAdvantageList() {
        return advantageList;
    }

    public void setAdvantageList(List<Advantage> advantageList) {
        this.advantageList = advantageList;
    }

    public List<Disadvantage> getDisadvantageList() {
        return disadvantageList;
    }

    public void setDisadvantageList(List<Disadvantage> disadvantageList) {
        this.disadvantageList = disadvantageList;
    }
}
