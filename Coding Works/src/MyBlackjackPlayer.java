//// Name: Zhiyuan Chang
//// Computing ID: vgs3qt
//// Homework Name: HW 4 - Blackjack
//
//import javax.xml.stream.FactoryConfigurationError;
//public class MyBlackjackPlayer extends BlackjackPlayer{
//	private int sum = 0;
//	private int card_left = 52;
//	private int value_mem = 0;
//	private int temp_mem = 0;
//	@Override
//	public int getBet() {
//		return 10; //always bet 10
//	}
//	@Override
//	public Move getMove() {
//		boolean yes = true;
//		int i = 0;
//		if (card_left <= 0) {
//			card_left = 52;
//			sum = 0;
//			value_mem = 0;
//			temp_mem = 0;
//		}
//		if(!(value_mem==0)) {
//			sum += value_mem;
//		}
//		while (yes) {
//			if (this.cards[i] == null){
//				yes = false;
//			}
//			else if(this.cards[i].getRank()>=2 || this.cards[i].getRank()<=6) {
//				temp_mem += 1;
//			}
//			else if(this.cards[i].getRank()>=7 || this.cards[i].getRank()<=9 ) {
//				temp_mem += 0;
//			}
//			else if (this.cards[i].getRank()>=10 || this.cards[i].getRank()==1) {
//				temp_mem -= 1;
//			}
//			i += 1;
//		}
//		card_left -= 1;
//		sum += temp_mem;
//		if(sum>0 && this.handScore()<11) {
//			value_mem = temp_mem;
//			return Move.HIT;
//		}
//		if(sum<0 && this.handScore()>11) {
//			value_mem = temp_mem;
//			return Move.HIT;
//		}
//		if(sum==0 && this.handScore()<17) {
//			value_mem = temp_mem;
//			return Move.HIT;
//		}
//		temp_mem = 0;
//		value_mem = 0;
//		return Move.STAY;
//	}
//	@Override
//	public void handOver(Card[] dealerHand) {
//		if (card_left <= 0) {
//			card_left = 52;
//			sum = 0;
//			value_mem = 0;
//			temp_mem = 0;
//		}
//		card_left -= 1;
//		for(int i = 0; i < dealerHand.length;i++) {
//			card_left -= 1;
//			if (card_left <= 0) {
//				card_left = 52;
//				sum = 0;
//			}
//			double com = dealerHand[i].getRank();
//			if(com >= 10 || com == 1){
//				sum -= 1;
//			}
//			if(com >= 2 && com <= 6){
//				sum += 1;
//			}
//			if(com >= 7 && com <= 9){
//				sum += 0;
//			}
//		}
//	}
//}

// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: HW 4 - Blackjack
//
//import javax.xml.stream.FactoryConfigurationError;
//public class MyBlackjackPlayer extends BlackjackPlayer{
//    private int sum = 0;
//    private int card_left = 52;
//    private int temp_mem = 0;
//    @Override
//    public int getBet() {
//        return 10; //always bet 10
//    }
//    @Override
//    public Move getMove() {
//        // I tried to calculate the average value left and make decision.
//        // I also tried to use Hi Lo count, and it is coded below.
//        // Both of them mentioned are not really effective as it got -400 chips after 1000 runs.
//        // So I searched a general strategy and implement Hi Lo count as a reference.
//        // Now I get positive values like 400 after 1000 runs.
//        boolean ace = false;
//        boolean yes = true;
//        int i = 0;
//        // if it's the last card in the deck, restore the counting to 0.
//        if (card_left <= 0) {
//            card_left = 52;
//            sum = 0;
//            temp_mem = 0;
//        }
//        // Hi Lo count, using while loop to see the value of each card
//        // since Card array has 22 values and most are null, i use while loop.
//        while (yes) {
//            if (this.cards[i] == null){
//                yes = false;
//            }
//            else {
//                if (this.cards[i].getRank() == 1){
//                    ace = true;
//                }
//                if(this.cards[i].getRank()>=2 || this.cards[i].getRank()<=6) {
//                    temp_mem += 1;
//                }
//                if(this.cards[i].getRank()>=7 || this.cards[i].getRank()<=9 ) {
//                    temp_mem += 0;
//                }
//                if (this.cards[i].getRank()>=10 || this.cards[i].getRank()==1) {
//                    temp_mem -= 1;
//                }
//            }
//            i += 1;
//        }
//        // deduct one card always, since you are given a card.
//        card_left -= 1;
//        sum += temp_mem;
//        // purely using the Hi Lo count provides negative result. So I combine basic strategies.
//        if( this.handScore()<=11) {
//            // since you hit, to prevent calculate again you add what is deducted last time.
//            sum -= temp_mem;
//            temp_mem = 0;
//            return Move.HIT;
//        }
//        if(this.handScore()>19){
//            temp_mem = 0;
//            return Move.STAY;
//        }
//        if( this.handScore()<17 && ace) {
//            sum -= temp_mem;
//            temp_mem = 0;
//            return Move.HIT;
//        }
//        // when sum<0, it means more low card in deck.
//        if( this.handScore()>11 && this.handScore()< 14 && sum<0) {
////			&& sum<0
//            sum -= temp_mem;
//            temp_mem = 0;
//            return Move.HIT;
//        }
//        temp_mem = 0;
//        return Move.STAY;
//    }
//    @Override
//    public void handOver(Card[] dealerHand) {
//        // if it's the last card in the deck, restore the counting to 0.
//        if (card_left <= 0) {
//            card_left = 52;
//            sum = 0;
//            temp_mem = 0;
//        }
//        // deduct one card. This is the one of the two card give to player at the beginning.
//        card_left -= 1;
//        // using Hi Lo count to the dealer's card as well.
//        for(int i = 0; i < dealerHand.length;i++) {
//            card_left -= 1;
//            double com = dealerHand[i].getRank();
//            if (card_left <= 0) {
//                card_left = 52;
//                sum = 0;
//                temp_mem = 0;
//            }
//            else if(com >= 10 || com == 1){
//                sum -= 1;
//            }
//            else if(com >= 2 && com <= 6){
//                sum += 1;
//            }
//            else if(com >= 7 && com <= 9){
//                sum += 0;
//            }
//        }
//    }
//}


