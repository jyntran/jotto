package jotto;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

import java.util.Observable;

public class JottoModel extends Observable {

	public static int NUM_LETTERS = 5;
	public static final String[] LEVELS = {
	  "Easy", "Medium", "Hard", "Any Difficulty"};

	private String guess;

	private WordList wordlist = new WordList("words.txt");
	private String mystery = wordlist.randomWord().getWord();

//	private ArrayList<Word> words = new ArrayList<Word>();
	private ArrayList<Guess> guesses = new ArrayList<Guess>();
	private boolean DEBUG = true;

        private String[] columnNames = {"Word",
                                        "Exact",
					"Partial"};

	JottoModel() {
		setChanged();
	}
/*
	public ArrayList<Word> getWords() {
		return words;
	}
*/
	public ArrayList<Guess> getGuesses() {
		return guesses;
	}
/*
	public void setWords(ArrayList<Word> newwords) {
		words = newwords;
	}
*/
	public void setGuesses(ArrayList<Guess> newguesses) {
		guesses = newguesses;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public String getMystery() {
		return mystery;
	}

	public void setMystery(String s) {
		mystery = s;
	}

	public String getGuess() {
		return guess;
	}

	public void setGuess(String s) {
		guess = s;
	}

	public boolean isGuessCorrect() {
		return (guess.equals(mystery));
	}

	public int findExact(){
		int exactTotal = 0;
		String mystery = getMystery();
//    		System.out.println(mystery);
		String guess = getGuess();
  //  		System.out.println(guess);
		for (int i = 0; i < mystery.length(); i++){
    			char cg = guess.charAt(i);
    			char cm = mystery.charAt(i);
			if (cg == cm) {
				exactTotal++;
			}
		}
		return exactTotal;
	}

	public int findPartial(){
		int partialTotal = 0;
		String mystery = getMystery();
		String guess = getGuess();
		for (int i = 0; i < mystery.length(); i++){
    			char cm = mystery.charAt(i);
			for (int j = 0; j < guess.length(); j++){
    				char cg = guess.charAt(j);
				if (i != j && cg == cm) {
					partialTotal++;
					break;
				}
			}
		}
		return partialTotal;
	}

	public void submitGuess(String guessedWord){
		setGuess(guessedWord);
		System.out.println("mystery: " + mystery);
		System.out.println("guess: " + guessedWord);
		int exact = findExact();
		int partial = findPartial();
		System.out.println("E: " + exact + " P: " + partial);
		Guess g = new Guess(guessedWord, exact, partial);
//		ArrayList<Word> newwords = getWords();
		ArrayList<Guess> newguesses = getGuesses();
		newguesses.add(g);
		setGuesses(newguesses);
		setChanged();
		notifyObservers();
		if (isGuessCorrect()) {
			System.out.println("The word has been guessed!");
		}
	}

	/*
	 * Make an instance of an abstract table model to use with JTables.
	 */
	private AbstractTableModel atmInstance = new AbstractTableModel(){
	   	// our data, note we can call these whatever we want

        // need to define these three methods:

        public int getColumnCount() {
            return 3;
        }

        public int getRowCount() {
            return guesses.size();
        }

        public Object getValueAt(int row, int col) {
        	switch(col) {
        		case 0: return guesses.get(row).getWord();
        		case 1: return guesses.get(row).getExact();
        		case 2: return guesses.get(row).getPartial();
/*        		case 3: return persons.get(row).years;
        		case 4: return persons.get(row).vegitarian;
*/        	}
        	return null;	// for the compiler :(
        }

        // define this if you don't want default 'A', 'B', ... names
        public String getColumnName(int col) {
            return columnNames[col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass(); // reflection!
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell appendress is constant,
            //no matter where the cell appears onscreen.
        	//(because it's the appendress in the MODEL, not the VIEW)
//            if (col < 2) {
                return false;
//            } else {
//                return true;
//            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }
/*
            switch(col) {
            	// columns 0, 1 aren't editable
            	case 2: persons.get(row).sport = (String)value; break;
            	case 3: persons.get(row).years = (Integer)value; break;
            	case 4: persons.get(row).vegitarian = ((Boolean)value).booleanValue(); break;

            }
*/
            fireTableCellUpdated(row, col);

            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }
	};

	public TableModel getTableModel() {
		return atmInstance;
	}

    private void printDebugData() {
//    	for(Person p : this.persons) {
    	for(Guess g : this.guesses) {
    		System.out.println(g);
    	}
        System.out.println("--------------------------");
    }



}
