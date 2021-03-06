package poker;

import org.junit.Before;
import org.junit.Test;
import poker.enums.Denomination;
import poker.enums.Symbol;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 28/10/2018.
 */
public class HoldingCardsTest {

    private HoldingCards holdingCards;

    @Before
    public void setUp () {
        holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.SPADE, Denomination.A),
                new Card(Symbol.HEART, Denomination.TEN),
                new Card(Symbol.CLOVER, Denomination.NINE),
                new Card(Symbol.DIAMOND, Denomination.SEVEN),
                new Card(Symbol.SPADE, Denomination.EIGHT)
        ));
    }

    @Test
    public void sorted_메서드는_자신의_카드순서를_변경시키지_않으면서_정렬시킨_다른_HoldingCards_를_반환해야한다() {
        List<Card> beforeSortedCards = holdingCards.getCards();
        List<Card> afterSortedCards = holdingCards.sorted().getCards();

        assertEquals(new Card(Symbol.SPADE, Denomination.A), beforeSortedCards.get(0));
        assertEquals(new Card(Symbol.HEART, Denomination.TEN), beforeSortedCards.get(1));
        assertEquals(new Card(Symbol.CLOVER, Denomination.NINE), beforeSortedCards.get(2));
        assertEquals(new Card(Symbol.DIAMOND, Denomination.SEVEN), beforeSortedCards.get(3));
        assertEquals(new Card(Symbol.SPADE, Denomination.EIGHT), beforeSortedCards.get(4));

        assertEquals(new Card(Symbol.DIAMOND, Denomination.SEVEN), afterSortedCards.get(0));
        assertEquals(new Card(Symbol.SPADE, Denomination.EIGHT), afterSortedCards.get(1));
        assertEquals(new Card(Symbol.CLOVER, Denomination.NINE), afterSortedCards.get(2));
        assertEquals(new Card(Symbol.HEART, Denomination.TEN), afterSortedCards.get(3));
        assertEquals(new Card(Symbol.SPADE, Denomination.A), afterSortedCards.get(4));
    }

    @Test
    public void highCard_메서드는_가장_높은카드를_반환한다() {
        Card spadeA = new Card(Symbol.SPADE, Denomination.A);
        assertEquals(spadeA, holdingCards.highCard());
    }


}