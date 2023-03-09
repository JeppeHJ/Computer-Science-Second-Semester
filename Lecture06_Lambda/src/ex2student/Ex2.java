package ex2student;

import ex5student.Runner;

import java.util.ArrayList;
import java.util.List;

public class Ex2 {

	public static void main(String[] args) {
		List<ex5student.Runner> runners = new ArrayList<>();
		runners.addAll(List.of(
				new ex5student.Runner("Ib", 30),
				new ex5student.Runner("Per", 50),
				new ex5student.Runner("Ole", 27),
				new ex5student.Runner("Ulla", 40),
				new ex5student.Runner("Jens", 35),
				new Runner("Hans", 28)));
		System.out.println(runners);
		System.out.println();

	}
}