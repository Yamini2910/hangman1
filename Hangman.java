import java.util.*;
public class Hangman{
	private String word;
	private char[] guess;
	private int attempts;
	public Hangman(){
		attempts=8;
		word=generaterandom();
		guess= new char[word.length()];
		for(int i=0;i<guess.length;i++){
			guess[i]='-';
		}
	}
	private String generaterandom(){
		String[] arr={"hangman"};
		Random random=new Random();
		return arr[random.nextInt(arr.length)];
	}
	public boolean gameover(){
		return attempts<=0 || wordguess();
	}
	public boolean wordguess(){
		for(char letter:guess){
			if(letter=='-'){
				return false;
			}
		}
		return true;
	}
	public boolean guessletter(char letter){
		boolean found=false;
		for(int i=0;i<word.length();i++){
			if(word.charAt(i)==letter){
			guess[i]=letter;
			found=true;
		}
	}
	if(!found){
		attempts--;
	}
	return found;
	}
	public String getword(){
		return word;
	}
	public int getattempts(){
		return attempts;
	}
	public String display(){
		return new String(guess);
	}
}

