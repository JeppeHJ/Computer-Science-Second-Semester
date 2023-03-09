package opgave2;

import ex5student.Runner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex2 {

	public static void main(String[] args) {
		List<Runner> runners = new ArrayList<>();
		runners.addAll(List.of(
				new Runner("Ib", 30),
				new Runner("Per", 50),
				new Runner("Ole", 27),
				new Runner("Ulla", 40),
				new Runner("Jens", 35),
				new Runner("Hans", 28)));
		System.out.println(runners);
		System.out.println();

		// TODO opgave a)
		runners.forEach(runner -> System.out.println(runner.getName() + runner.getLapTime()));

		// TODO opgave b)
		runners.forEach(runner -> System.out.println(runner.getName() + (runner.getLapTime() < 30)));

		// TODO opgave c)
		runners.sort(Comparator.comparingInt(Runner::getLapTime));




	}
}