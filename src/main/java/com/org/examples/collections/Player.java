package com.org.examples.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Player implements Comparable<Player> {
	private int ranking;
	private String name;
	private int age;
	
	

	public Player(int ranking, String name, int age) {
		super();
		this.ranking = ranking;
		this.name = name;
		this.age = age;
	}
	
	



	public int getRanking() {
		return ranking;
	}





	public void setRanking(int ranking) {
		this.ranking = ranking;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public int getAge() {
		return age;
	}





	@Override
	public String toString() {
		return  name;
	}





	public void setAge(int age) {
		this.age = age;
	}





	public static void main(String[] args) {
		List<Player> cricketPlayers = new ArrayList<Player>();
		
		cricketPlayers.add(new Player(1,"Virat",32));
		cricketPlayers.add(new Player(4,"Smith",33));
		cricketPlayers.add(new Player(2,"Rohit",34));
		cricketPlayers.add(new Player(7,"Ashwin",35));
		cricketPlayers.add(new Player(3,"Dhoni",39));
		cricketPlayers.add(new Player(5,"Henry",27));
		
		System.out.println("Before sorting: "+cricketPlayers);
		
		
		Collections.sort(cricketPlayers);
		
		System.out.println("After sorting: "+cricketPlayers);
		
		Comparator<Player> byAge = (Player p1, Player p2) -> Integer.compare(p1.getAge(),p2.getAge());
		
		System.out.println("Before sorting by Age: "+cricketPlayers);
        
		Collections.sort(cricketPlayers, byAge);
		
		System.out.println("After sorting by Age: "+cricketPlayers);
		
		Comparator<Player> byName = Comparator.comparing(Player::getName);
		
        System.out.println("Before sorting by Name: "+cricketPlayers);
        
		Collections.sort(cricketPlayers, byName);
		
		System.out.println("After sorting by Name: "+cricketPlayers);
	}





	@Override
	public int compareTo(Player o) {
		
		return Integer.compare(getRanking(), o.getRanking());
	}

}
