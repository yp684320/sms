package 斗地主;

import java.util.Objects;

public class Card {
    private String hs;
    private String ds;

    public Card(String hs, String ds) {
        this.hs = hs;
        this.ds = ds;
    }

    @Override
    public String toString() {
        return  hs + ds;


    }
}
