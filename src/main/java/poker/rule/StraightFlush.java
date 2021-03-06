package poker.rule;

import poker.Cards;
import poker.exceptions.NotMatchedPokerHandsException;


/**
 * IDE : IntelliJ IDEA
 * Created by minho on 30/10/2018.
 */
public class StraightFlush extends Flush {

    public StraightFlush(Cards cards) throws NotMatchedPokerHandsException {
        super(cards);
    }

    @Override
    protected String suffix() {
        return "STRAIGHT FLUSH";
    }

    @Override
    protected void check(Cards cards) throws NotMatchedPokerHandsException {
        super.check(cards);
        Straight straight = new Straight(cards);
        init(straight.getCards());
    }
}
