package main.java.gurps.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caio on 20/04/15.
 */
public class CharacterBuilder {

    private GurpsCharacter character;

    public CharacterBuilder() {
        this.character = new GurpsCharacter();
    }

    public GurpsCharacter build(){
        return this.character;
    }

    public CharacterBuilder setRace(Race race){
        this.character.setRace(race);
        return this;
    }

    public CharacterBuilder setAdvantageList(List<Advantage> advantageList) {
        this.character.setAdvantages(advantageList);
        return this;
    }

    public CharacterBuilder setDisadvantageList(List<Disadvantage> disadvantageList){
        this.character.setDisadvantages(disadvantageList);
        return this;
    }
}
