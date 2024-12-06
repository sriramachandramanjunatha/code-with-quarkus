package org.acme.microprofile.faulttolerance.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.acme.microprofile.faulttolerance.Coffee;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CoffeeRepositoryService {
	private Map<Integer,Coffee> coffeeData= new HashMap<Integer, Coffee>();

	public CoffeeRepositoryService() {
		coffeeData.put(1, new Coffee(1,"LTIMindtree","India",1000));
		coffeeData.put(2, new Coffee(2,"Delta","India",2000));
		coffeeData.put(3, new Coffee(3,"Cisco","India",2000));
	}

	public List<Coffee> getCoffees(){
		return new ArrayList<Coffee>(coffeeData.values());
	}

	public Coffee getById(Integer id) {
		return coffeeData.get(id);
	}

	public List<Coffee> getRecommendations(Integer id){
		if(id==null) {
			return Collections.emptyList();
		}

		return coffeeData.values().stream().filter(coffee-> !id.equals(coffee.id)).limit(2).collect(Collectors.toList());
	}
}
