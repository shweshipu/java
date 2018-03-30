import java.util.*;

class deck{
	int[] cards;
	
	public deck(){
		//initializes the deck
		cards = new int[52];
		for(int i = 0; i<52;i++){
			cards[i] = i+1;
		}
	}
	public deck(int len){
		//initializes the deck
		cards = new int[len];
		for(int i = 0; i<len;i++){
			cards[i] = i+1;
		}
	}
	public int length(){
		return(cards.length);
	}
	public void print_deck(){
		System.out.println("deck:");
		for(int i = 0;i<length();i++){
			System.out.print(i + 1);
			System.out.println("	" + cards[i]);
		}
	}
	
	/*-------------------------shuffle stuff-------------------------*/
	public void shuffle(){
		
		//the variables used in all these shuffle functions
		deck[] draw_rand = {this, new deck()};
		
		//deck[0] is deck to draw from
		//deck[1] is deck to randomize
		//^ i did this setup for passing them everywhere while keeping it encapsulated in shuffle()
		int i;
		for(i=0;i<52;i++){
			draw_rand = move_random_card(i,draw_rand);
		}	
		//return the randomized deck
		cards = draw_rand[1].cards;
	}
	
	private deck[] move_random_card(int position,deck[] draw_rand){
		//make a random number within the bounds
		int r = (int)(Math.random() * draw_rand[0].length());
		//copy a random card from the draw deck to the random deck
		draw_rand[1].cards[position] = draw_rand[0].cards[r];
		//-1 is just an arbitrary number thats not in the array by default (i cant use null)
		draw_rand[0].cards[r] = -1;
		
		//remove the -1 and make it shorter
		draw_rand[0] = fix_deck(draw_rand[0]);
		return (draw_rand);
	}
	
	private deck fix_deck(deck draw_deck){
		//a method to make the deck smaller after it has been 'drawn' from
		
		int i;
		
		//have the replacement deck be one less
		deck replace_deck = new deck(draw_deck.length()-1);
		
		//have a seperate i variable for replace deck
		int ri = 0;
		//put all the non-picked (not -1) numbers into the replacement deck
		for(i = 0;i<draw_deck.length();i++){
			if(draw_deck.cards[i] != -1){
				replace_deck.cards[ri] = draw_deck.cards[i];
				ri++;
			}
		}
		return(replace_deck);
	}
	
	
	
}
public class Randcard{
	static long start_time = System.nanoTime();
	static long run_time;
	public static void main(String args[]){
		
		
		
		
		deck test_deck = new deck();
		deck ordered_deck = new deck();
		long[] i = {0,0,0,0,0,0,0,0};
		int j;
		int matches;
		int max_matches = 0;
		while(max_matches < 52){
			
			matches = 0;
			for(j = 0;j<5;j++){//5 times because i feel like it
				test_deck.shuffle();
			}
			//test_deck.print_deck();
			
			//test how many cards match the original order
			for(j=0;j<test_deck.length();j++){
				if(test_deck.cards[j] == ordered_deck.cards[j]){
					matches++;
				}
			}
			//System.out.println("matches this deck:" +matches+ "\n");
			if(max_matches<matches){
				max_matches = matches;
				
				System.out.println("new max match!: " + max_matches + "     "+ "Iteration: " + i[0] + i[1] + i[2] + i[3] + i[4] + i[5] + i[6] + i[7] + "      "+ get_time());
			}
			i = increment_i(i);
		}
		
		System.out.println("max matches found: " + max_matches);
	}
	
	public static String get_time(){
		run_time = System.nanoTime()-start_time;
		
		double time = (double)run_time /1000000000;
		
		String print_time = "time taken: ";
		
		if((long)time/86400>0){
			print_time = print_time + (long)((long)time/86400) + " days ";
			time = time%86400;
		}
		if((long)time/3600>0){
			print_time = print_time + (long)((long)time/3600) + " hours ";
			time = time%3600;
		}
		if((long)time/60>0){
			print_time = print_time + (long)((long)time/60) + " minutes ";
			time = time%60;
		}
		print_time = print_time + time + " seconds.";
		
		return(print_time);
	}
	
	public static long[] increment_i(long[] digits){
		int i = 0;
		boolean incremented=false;
		for(i=7;i>0;i--){
			if(digits[i] == Long.MAX_VALUE){
				digits[i-1]++;
				incremented=true;
			}
		}
		if(!incremented){
			digits[7]++;
		}
		return digits;
	}
}
