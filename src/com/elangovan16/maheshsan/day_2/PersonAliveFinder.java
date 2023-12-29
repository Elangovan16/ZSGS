package com.elangovan16.maheshsan.day_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
	String name;
	int birth;
	int dead;

	public Person(String name, int birth, int dead) {
		this.name = name;
		this.birth = birth;
		this.dead = dead;
	}
}

public class PersonAliveFinder {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PersonAliveFinder obj = new PersonAliveFinder();
		List<Person> personList = new ArrayList<>();
		List<Person> personAliveList = new ArrayList<>();
		obj.loadPerson(personList);
		obj.findAlivePerson(personList, personAliveList);
		obj.printAlivePerson(personAliveList);

	}

	private void printAlivePerson(List<Person> personAliveList) {
		if (personAliveList.size() != 0) {
			int index = 1;
			System.out.println("\n+---Person Alive List---+");
			for (Person p : personAliveList) {
				System.out.println(index++ + " ." + p.name);
			}
			System.out.println("+-----------------------+\n");
		} else {
			System.out.println("In this year no one was Alive .");
		}
	}

	private void findAlivePerson(List<Person> personList, List<Person> personAliveList) {
		System.out.print("Enter the year : ");
		int year = sc.nextInt();
		for (Person p : personList) {
			if (year >= p.birth && year <= p.dead) {
				personAliveList.add(p);
			}
		}

	}

	private void loadPerson(List<Person> personList) {

		personList.add(new Person("Elangovan", 2002, 2069));
		personList.add(new Person("Ram", 1999, 2070));
		personList.add(new Person("Kumar", 1902, 1948));
		personList.add(new Person("RamaSelvaThangam", 1900, 2000));
		personList.add(new Person("MuthuKumaraSamy", 2002, 2065));
		personList.add(new Person("MuthuPradeesh", 1900, 1953));
		personList.add(new Person("Natarajan", 2001, 2080));
		personList.add(new Person("Siva", 2001, 2100));

	}
}
