package printers;

import tree.Statistics;

public class StatisticsPrinter {
	public static void printStatistics(Statistics statistics){
		System.out.printf("Numero de passos na arvore:\t\t%2d\n", statistics.getCountOfTreeWalks());
		System.out.printf("Numero de comparações com os nodos:\t%2d\n", statistics.getCountOfComparisons());
		System.out.printf("Numero de calculos com os nodos:\t%2d\n", statistics.getCountOfNodeCalculations());
		System.out.printf("Numero de interações com os nodos:\t%2d\n", statistics.getCountOfInteractions());
		System.out.printf("Numero de rotações necessarias para\n"+
							"\t\tbalancear a arvore:\t%2d\n", statistics.getCountOfRebalance());
	}
}
