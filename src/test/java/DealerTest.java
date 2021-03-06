import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

	public class DealerTest {

		Dealer dealer;
		Deck deck;
		Card card;
		Card card2;

		@Before
		public void before(){
			dealer = new Dealer("Jock");
			deck = new Deck();
			card = new Card(SuitType.HEARTS, RankType.FIVE);
			card2 = new Card(SuitType.CLUBS, RankType.ACE);
		}

		@Test
		public void GameDealerCanDeal(){
			deck.populateDeckWithCards();
			deck.shuffleCards();
			Card card = dealer.deal(deck);
			assertNotNull(card);
			assertEquals(51, deck.getDeckCardCount());
		}

		@Test
		public void DealerHasName(){
			assertEquals("Jock", dealer.getDealerName());
		}

		@Test
		public void checkNoCardsInDealersHand(){
			assertEquals(0, dealer.countDealersCards());
		}

		@Test
		public void canAddCardsToDealersHand(){
			dealer.addCardsToDealersHand(card);
			dealer.addCardsToDealersHand(card2);
			assertEquals(2, dealer.countDealersCards());
		}

		@Test
		public void canClearDealersHand(){
			dealer.addCardsToDealersHand(card);
			dealer.addCardsToDealersHand(card);
			assertEquals(2, dealer.countDealersCards());
			dealer.removeAllCardsFromDealer();
			assertEquals(0, dealer.countDealersCards());
		}

		@Test
		public void canCheckValueOfDealersHand(){
			dealer.addCardsToDealersHand(card);
			assertEquals(1, dealer.countDealersCards());
			assertEquals(5, dealer.checkDealerScore());
		}


	}





