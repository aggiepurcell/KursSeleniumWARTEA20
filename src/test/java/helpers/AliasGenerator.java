package helpers;

import java.util.Random;

public class AliasGenerator {

    private Random random = new Random();

    //guid uuid
    public String generateAlias() {
        return "alias_" + random.nextInt(10000000);
    }
}
