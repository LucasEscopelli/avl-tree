package tree;

public class Statistics {
	private int countOfInteractions;
	private int countOfComparisons;
	private int countOfRebalance;
	private int countOfNodeCalculations;
	private int countOfTreeWalks;
	private static Statistics instance;
	public static Statistics getInstance(){
		if(instance == null){
			instance = new Statistics();
		}
		return instance;
	}
	private Statistics() {
		clear();
	}
	public void clear() {
		this.countOfComparisons = 0;
		this.countOfInteractions = 0;
		this.countOfRebalance = 0;
		this.countOfNodeCalculations = 0;
		this.countOfTreeWalks = 0;
	}

	public void incrementComparison(){
		this.countOfComparisons++;
	}
	public void incrementInteractions(){
		this.countOfInteractions++;
	}
	public void incrementRebalance(){
		this.countOfRebalance++;
	}
	public void incrementNodeCalculations() {
		this.countOfNodeCalculations++;
	}
	public void incrementTreeWalks() {
		this.countOfTreeWalks++;
	}
	public int getCountOfInteractions() {
		return countOfInteractions;
	}
	public int getCountOfComparisons() {
		return countOfComparisons;
	}
	public int getCountOfRebalance() {
		return countOfRebalance;
	}
	public int getCountOfNodeCalculations() {
		return countOfNodeCalculations;
	}
	public int getCountOfTreeWalks() {
		return countOfTreeWalks;
	}
}
