package gurps.model;

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


}
