package printers;

import java.util.List;

import tree.Statistics;

public class StatisticsPrinter {
	public static void printStatistics(Statistics statistics){
		List<String> lines = List.of(
			String.format("Numero de passos na arvore:           %6d", statistics.getCountOfTreeWalks()),
			String.format("Numero de comparações com os nodos:   %6d", statistics.getCountOfComparisons()),
			String.format("Numero de calculos com os nodos:      %6d", statistics.getCountOfNodeCalculations()),
			String.format("Numero de interações com os nodos:    %6d", statistics.getCountOfInteractions()),
			String.format("Numero de rotações necessarias para"),
			String.format("               balancear a arvore:    %6d", statistics.getCountOfRebalance())
		);

		int tam = 0;
		for(String s: lines){
			tam = Math.max(tam, s.length());
		}
		System.out.printf("|%s|\n", "-".repeat(tam));
		for(String l: lines){
			System.out.printf("|%-"+String.valueOf(tam)+"s|\n", l);
		}
		System.out.printf("|%s|\n", "-".repeat(tam));
	}
}