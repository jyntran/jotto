package jotto;

public class Guess extends Object {

	private String word;

	private int exact = 0;
	private int partial = 0;

	public Guess(String word, int e, int p){
		this.word = word;
		this.exact = e;
		this.partial = p;
	}

	public String getWord()
	{  return this.word;
	}
	public void setWord(String s)
	{  this.word = s;
	}

	public int getExact()
	{  return this.exact;
	}
	public void setExact(int e)
	{  this.exact = e;
	}

	public int getPartial()
	{  return this.partial;
	}
	public void setPartial(int p)
	{  this.partial = p;
	}
}
