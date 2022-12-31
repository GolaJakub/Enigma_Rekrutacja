package Main.model.Tree;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ConiferousTree extends Tree {


    @Override
    public String introduceYourself() {
        return "I am conifer and I have needles!\t" + this.toString();
    }
}
