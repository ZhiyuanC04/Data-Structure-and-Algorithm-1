import java.util.ArrayList;
import java.util.List;

//// Name: Zhiyuan Chang
//// Computing ID: vgs3qt
//// Homework Name: HW 3 - Basketball
//
public class _Examples {
    int aa = 0;
    int bb = 0;
    int m;
    public static void main(String[] args) {
/*
//        HW02_Calculator c = new HW02_Calculator();
//        HW02_Calculator c2 = new HW02_Calculator(1, 2, " ");

//        System.out.println(c); //0 0
//        System.out.println(c2); //  1 + 2

//        c.setMem1(5);
//        c.setMem2(7);
//        c.setMem1(5);
//        c.setMem2(7);
//        c.setOp("^");
//        System.out.println(c2); // 5 + 7
//        System.out.println(c.perform()); // 12



//        c.swap();
//        c.setOp("-");
//        System.out.println(c); // 12 - 5
//        System.out.println(c.perform()); // 7
//
//        c.setOp("*");
//        System.out.println(c.perform()); // 84
//
//        c.swap();
//        c.setOp("/");
//        System.out.println(c); // 84 / 12
//        System.out.println(c.perform()); // 7
//
//        System.out.println(c); // 84 / 7
//        System.out.println("mem2 is " + c.getMem2()); // mem2 is 7
//
//        System.out.println(c.performDiv()); // 12.0
//
//        c.setMem2(0);
//        System.out.println(c.perform()); // 0
//        System.out.println(c); // 84 / 0
//        HW2 Calculator

//        -----------------------
//          Players：
//          name+" "+position+" "+points_per_game+" "+field_goal_percentage
//              +" "+three_point_percentage +" "+free_throw_percentage

//          "Player name: " + name + ". Position: " + position
//            + ". Points per game: " + points_per_game + ". Field goal percentage: " + field_goal_percentage
//            + ". Three point percentage: " + three_point_percentage
//            + ". Free throw percentage: " + free_throw_percentage)+".";
//
//        Team:
//
//              "Player name: "+team[i].getName()+". Position: "+team[i].getPosition()
//                    +". Points per game: "+team[i].getPPG()+". Field goal percentage: "+team[i].getFP()
//                    + ". Three point percentage: "+team[i].getTPP()
//                    +". Free throw percentage: "+team[i].getFTP()+

//          public String toString2() {
//              return team.toString();
//                  }
//      public boolean equals(Player[] teams, Player[] players) {
//          if (Arrays.equals(teams, players)) {
//              return true;}
//           else if (team == players){
//              return true;}
//          else {
////              return false;}
//        float z = 5/10;
//        System.out.println(z);

//        -----------
//        boolean yes = true;
//        boolean ace = false;
//        int ace_value = 11;
//        int sum = 0;
//        double percentage = 100.0;
//        int i = 0;
//        if (card_left <= 0) {
//            card_left = 52;
//            card_value_left = 384;
//        }
//        while (yes) {
//            if (this.cards[i] == null){
//                yes = false;
//            }
//            else if(this.cards[i].getRank() == 1) {
//                sum += 11;
//            }
//            else if (this.cards[i].getRank() > 10) {
//                sum += 10;
//            }
//            else if(this.cards[i].getRank() <= 10 && this.cards[i].getRank() >1) {
//                sum += this.cards[i].getRank();
//            }
//            i += 1;
//        }
//        if(!(value_mem == 0)) {
//            sum -= value_mem;
//        }
//        card_value_left -= sum;
//        card_left -= 1;
//        percentage = card_value_left/(card_left-1);
//        if((21 - this.handScore()) > percentage) {
//            value_mem = sum;
//            return Move.HIT;
//        }
//        value_mem = 0;
//        return Move.STAY;
//    }
//    @Override
//    public void handOver(Card[] dealerHand) {
//        if (card_left <= 0) {
//            card_left = 52;
//        }
//        card_left -= 1;
//        for(int i = 0; i < dealerHand.length;i++) {
//            if (card_left <= 0) {
//                card_left = 52;
//                card_value_left = 384;
//            }
//            double com = dealerHand[i].getRank();
//            if(com > 10){
//                card_value_left -= 10;
//            }
//            if(com == 1){
//                card_value_left -= 11;
//            }
//            if(com <= 10 && com > 1){
//                card_value_left -= com;
//            }
//            card_left -= 1;
//        }
////		System.out.println(card_value_left);
////		System.out.println(card_left);

//        private Deck[] decks;
//        private int count_deck = 0;
//        private int total_deck = 0;
//        private int count_card = 0;
//    public DeckShoe(int numDecks) {
//            decks = new Deck[numDecks];
//            for(int i = 0; i < (numDecks); i++) {
//                decks[i] = new Deck();
//            }
//            total_deck = decks.length;
//        }
//        public Card dealTopCard() {
//            count_card += 1;
//            Card ret = decks[count_deck].dealTopCard();
//            if(count_card == 52) {
//                count_deck += 1;
//                count_card = 0;
//            }
////        System.out.println(cardsLeft());
//            return ret;
//        }
//        protected void restoreDecks() {
//            count_deck = 0;
//            count_card = 0;
//            for(int i = 0; i < decks.length; i++) {
//                decks[i].restockDeck();
//            }
//        }
//        public int cardsLeft() {
//            int result = 0;
//            result = ((total_deck - count_deck) * 52) - count_card;
////        System.out.println(result+"this is the card left");
////        System.out.println(count_deck);
//            if(result < 0) return 0;
//            return result;
//            int[] s1quizzes = {100, 95, 83, 98};
//            int[] s2quizzes = {80, 83, 82, 88};
//            int [] s3quizzes = {75, 80, 90, 82};
//            Student s1 = new Student("Maria");
//            s1.setQuizScores(s1quizzes);
//            Student s2 = new Student("Alvin");
//            s2.setQuizScores(s2quizzes);
//            Student s3 = new Student("Pat");
//            s3.setQuizScores(s3quizzes);
//            Student[] roster = {s1, s2, s3};
//
//            Course dsa1 = new Course("DSA1");
//            dsa1.setStudents(roster);
//
//            s1quizzes[0] = 0;
//            s3.setName("Kavya");
//            for(int i=0; i<s1quizzes.length;i++)
//            System.out.println(s1quizzes[i]);
//            int[] a = s1.getQuizScores();
//            for(int i=0; i<a.length;i++)
//            System.out.println(a[i]);
//            System.out.println(dsa1);

//            HW03_Player bag1 =  new HW03_Player();
//            System.out.println(bag1.equals(new HW03_Player()));



//        if(tail.getData() == null){
//			tail = new ListNode<>(data);
//			size++;
//		}
//		else if(tail.prev == null){
//			ListNode<T> at_tail = new ListNode<>(data);
//			tail.prev = at_tail;
//			size++;
//		}
//		else{



//        ListNode<T> at_head = new ListNode<>(data);
//        if(head.next == tail){
//            at_head.prev = head;
//            at_head.next = tail;
//            head.next = at_head;
//            tail.prev = at_head;
//            size++;
//        }
//        else{
//            ListNode<T> former = head.next;
//            at_head.next = former;
//            at_head.prev = head;
//            former.prev = at_head;
//            head.next = at_head;
//            size++;
//        }


//        ListNode<T> at_tail = new ListNode<>(data);
//        if(tail.prev == head){
//            at_tail.next = tail;
//            at_tail.prev = head;
//            tail.prev = at_tail;
//            head.next = at_tail;
//            size++;
//        }
//        else{
//            ListNode<T> former = tail.prev;
//            at_tail.next = tail;
//            at_tail.prev = former;
//            former.next = at_tail;
//            tail.prev = at_tail;
//            size++;
//        }

        //BigOh

        int a = 0;
        int b = 1000000;
        int c = 0;
        int d = 1;
            for(int i = 0; i <= b; i++){
                if(a>=b){
                    break;
                }
                a += d;
                d = d*2;
                System.out.println(d);
                c++;
            }

        System.out.println(c);
        System.out.println(a);

//        }

String a = "aabba";
        a= a.substring(1, a.length()-1);
System.out.println(a);
    }
//}
*/
//        int i = 1;
//        int a = i++;
//        System.out.println(a);
//        System.out.println(i);
//int x = 25;
//int y = 3;
//System.out.println(""+x+y);
////byte z = 1000;
//System.out.println((double)x/y);
//        System.out.println((double)(x/y));

//        int ss = 3;
//        switch (ss){
//            case 1 : System.out.println("1");
//            case 3 : System.out.println("3");
//        _Examples a1 = new _Examples();
//        _Examples a2 = new _Examples();
//        a2=a1;
//        a1.aa = 5;
//        System.out.println(a1.aa);
//        System.out.println(a2.aa);
//        _Examples one = new _Examples(5,5);
//    _Examples aa = new _Examples();
//    aa.m



        }
//public static void swap(_Examples a, _Examples b){
//        _Examples temp;
//        temp = a;
//        a = b;
//        b = temp;
//}
    }
