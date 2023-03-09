package opgave1;

import eksempelklassen.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex1 {

	public static void main(String[] args) {
		List<eksempelklassen.Person> list = List.of(
				new eksempelklassen.Person("Bent", 25), new eksempelklassen.Person("Susan", 34),
				new eksempelklassen.Person("Mikael", 60), new eksempelklassen.Person("Klaus", 44),
				new eksempelklassen.Person("Birgitte", 17), new eksempelklassen.Person("Liselotte", 9));
		List<eksempelklassen.Person> persons = new ArrayList<eksempelklassen.Person>(list);



//		Den første person der hedder Klaus
//		System.out.println(findFirst(persons, p -> p.getName().equals("Klaus")));
//		Den første person der har et navn med længden 4
//		System.out.println(findFirst(persons, p -> p.getName().length() ==4 ));

//		Indsæt kode herunder der kalder metoderne findFirst og findAll som beskrevet i opgave 1

		// TODO opgave a)
		System.out.println(findFirst(persons, p -> p.getAge() == 44));
		// TODO opgave b)
		System.out.println(findFirst(persons, p -> p.getName().charAt(0) == 'S'));
		// TODO opgave c)
		System.out.println(findFirst(persons, p -> p.getName().chars().filter(c -> c == 'i').count() > 1));
		// TODO opgave d)
		System.out.println(findFirst(persons, p -> p.getName().length() == p.getAge()));

		// TODO opgave f)
		List<Person> list1 = findAll(persons, p -> p.getAge() < 30);
		System.out.println(list1);
		System.out.println(findAll(persons, p -> p.getName().chars().filter(c -> c == 'i').count() > 0));

		// TODO opgave g)
		System.out.println(findAll(persons, p -> p.getName().charAt(0) == 'S'));

		// TODO opgave h)
		System.out.println(findAll(persons, p -> p.getName().length() == 5));

		// TODO opgave i)
		System.out.println(findAll(persons, p -> p.getName().length() > 6 && p.getAge() < 40));




	}

	/**
	 * Returns from the list the first person
	 * that satisfies the predicate.
	 * Returns null, if no person satisfies the predicate.
	 */
	public static eksempelklassen.Person findFirst(List<eksempelklassen.Person> list, Predicate<eksempelklassen.Person> filter) {
		for (Person p : list) {
			if (filter.test(p))
				return p;
		}
		return null;
	}

	// TODO opgave e)
	public static List<Person> findAll(List<Person> list, Predicate<Person> filter) {
		List<Person> result = new ArrayList<>();
		for (Person p : list) {
			if (filter.test(p)) {
				result.add(p);
			}
		}
		return result;
	}

}
