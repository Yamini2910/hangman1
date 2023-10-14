all: Main.java Hangman.java
	javac Main.java Hangman.java
run:all
	java Main
clean:
	rm *.class
