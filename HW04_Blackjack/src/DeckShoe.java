// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: HW 4 - Blackjack
public class DeckShoe {
    private Deck[] decks;
    private int count_deck = 0;
    private int total_deck = 0;
    private int count_card = 0;
    public DeckShoe(int numDecks) {
        decks = new Deck[numDecks];
        for(int i = 0; i < (numDecks); i++) {
            decks[i] = new Deck();
        }
        total_deck = decks.length;
    }
    public Card dealTopCard() {
        // count how many cards you deal out.
        count_card += 1;
        // remember the top card now and deal it out.
        Card ret = decks[count_deck].dealTopCard();
        // if you just deal the last of the deck, go to next deck.
        if(count_card == 52) {
            count_deck += 1;
            count_card = 0;
        }
        // if the deck is the last deck, restore.
        if(count_deck == total_deck) {
            restoreDecks();
        }
        return ret;
    }
    protected void restoreDecks() {
        // restore deck and restore all values, deal the top card when call the function.
        for(int i = 0; i < total_deck; i++) {
            decks[i].restockDeck();
            count_deck = 0;
            count_card = 0;
            }
    }
    public int cardsLeft() {
        int result = 0;
        // calculate the number of card left.
        result = ((total_deck - count_deck) * 52) - count_card;
        if(result < 0) return 0;
        return result;
    }
}