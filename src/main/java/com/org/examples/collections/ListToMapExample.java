package com.org.examples.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapExample {

	public static void main(String[] args) {
		List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));
        
        Map<Integer, String> result1 =list.stream().collect(Collectors.toMap(Hosting::getId, Hosting::getName));
        System.out.println("Result 1 : " + result1);
        
        Map result2 = list.stream().sorted(Comparator.comparingLong(Hosting::getWebsites)).collect(Collectors.toMap(Hosting::getId,Hosting::getName));
        
        System.out.println("Result 2 : " + result2);
	}

}

class Hosting {
	private int Id;
    private String name;
    private long websites;

    public Hosting(int id, String name, long websites) {
        Id = id;
        this.name = name;
        this.websites = websites;
    }

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getWebsites() {
		return websites;
	}

	public void setWebsites(long websites) {
		this.websites = websites;
	}

	@Override
	public String toString() {
		return "Hosting [Id=" + Id + ", name=" + name + ", websites=" + websites + "]";
	}
    
    
	
}