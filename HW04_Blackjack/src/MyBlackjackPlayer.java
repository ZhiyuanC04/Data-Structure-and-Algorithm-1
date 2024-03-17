// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: HW 4 - Blackjack

import javax.xml.stream.FactoryConfigurationError;
public class MyBlackjackPlayer extends BlackjackPlayer{
	private int sum = 0;
	private int card_left = 52;
	private int temp_mem = 0;
	@Override
	public int getBet() {
		if(getChips()<850) {
			return 1;
		}
		if(getChips()==1000){
			return 100;
		}
		else if (getChips()>1000){
			return 10;
		}
		return 1;
	}
	@Override
	public Move getMove() {
		// I tried to calculate the average value left and make decision.
		// I also tried to use Hi Lo count, and it is coded below.
		// Both of them mentioned are not really effective as it got -400 chips after 1000 runs.
		// So I searched a general strategy and implement Hi Lo count as a reference.
		boolean ace = false;
		boolean yes = true;
		int i = 0;
		// if it's the last card in the deck, restore the counting to 0.
		if (card_left <= 0) {
			card_left = 52;
			sum = 0;
			temp_mem = 0;
		}
		// Hi Lo count, using while loop to see the value of each card
		// since Card array has 22 values and most are null, I use while loop. Also check if ace is there.
		while (yes) {
			if (this.cards[i] == null){
				yes = false;
			}
			else {
				if (this.cards[i].getRank() == 1){
				ace = true;
				}
				if(this.cards[i].getRank()>=2 || this.cards[i].getRank()<=6) {
					temp_mem += 1;
				}
				if(this.cards[i].getRank()>=7 || this.cards[i].getRank()<=9 ) {
					temp_mem += 0;
				}
				if (this.cards[i].getRank()>=10 || this.cards[i].getRank()==1) {
					temp_mem -= 1;
				}
			}
			i += 1;
		}
		// deduct one card always, since you are given a card.
		card_left -= 1;
		sum += temp_mem;
//		 purely using the Hi Lo count provides negative result. So I combine some basic strategies.
		if(ace){
			if(this.handScore() == 19 && this.handScore() == 20) {
				temp_mem = 0;
				return Move.STAY;
			}
			else if(this.handScore()==18) {
				temp_mem = 0;
				return Move.STAY;
			}
			else if((this.dealer.getVisibleCard().getRank()>=7 && this.handScore()==13 && this.handScore()==14)
				||(this.dealer.getVisibleCard().getRank() >= 4 && this.dealer.getVisibleCard().getRank() <= 6
					&& this.handScore()==15 && this.handScore()==16)
				||(this.dealer.getVisibleCard().getRank() >= 7 && this.handScore()==17)
				||(this.dealer.getVisibleCard().getRank() >= 7 && this.handScore()==17 )) {
				sum -= temp_mem;
				temp_mem = 0;
				return Move.HIT;
			}
			else{
				temp_mem = 0;
				return Move.DOUBLE;
			}
		}
		if(this.handScore()<=11) {
			// since you hit, to prevent calculate again you add what is deducted last time.
			sum -= temp_mem;
			temp_mem = 0;
			return Move.HIT;
		}
		if(	  (this.dealer.getVisibleCard().getRank() < 7 && this.handScore() > 11 && this.handScore() < 17)
			||(this.dealer.getVisibleCard().getRank() < 7 && this.handScore() > 11)
			||(this.handScore()>=17)) {
			temp_mem = 0;
			return Move.STAY;
		}
		if(this.dealer.getVisibleCard().getRank() < 7 && this.handScore() > 8 && this.handScore() < 11) {
			return Move.DOUBLE;
		}
		if(this.handScore() < 16 && sum<0) {
			return Move.HIT;
		}
		temp_mem = 0;
		return Move.STAY;
	}
	@Override
	public void handOver(Card[] dealerHand) {
		// all of this part is Hi Lo count and counting cards.
		// if it's the last card in the deck, restore the counting to 0.
		if (card_left <= 0) {
			card_left = 52;
			sum = 0;
			temp_mem = 0;
		}
		// deduct one card. This is the one of the two card give to player at the beginning.
		card_left -= 1;
		// using Hi Lo count to the dealer's card as well.
		for(int i = 0; i < dealerHand.length;i++) {
			card_left -= 1;
			double com = dealerHand[i].getRank();
			if (card_left <= 0) {
				card_left = 52;
				sum = 0;
				temp_mem = 0;
			}
			if(com >= 10 || com == 1){
				sum -= 1;
			}
			if(com >= 2 && com <= 6){
				sum += 1;
			}
			if(com >= 7 && com <= 9){
				sum += 0;
			}
		}
	}
}