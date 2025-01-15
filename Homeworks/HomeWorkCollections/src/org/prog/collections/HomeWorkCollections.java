package org.prog.collections;

import java.util.*;

class Main {
    public static void main(String[] args) {

        Map<String, Set<String>> ownerToCarsMap = new HashMap<>();


        addCarToOwner(ownerToCarsMap, "Jane", "Car1");
        addCarToOwner(ownerToCarsMap, "Jane", "Car2");
        addCarToOwner(ownerToCarsMap, "Jane", "Car3");
        addCarToOwner(ownerToCarsMap, "John", "Car4");
        addCarToOwner(ownerToCarsMap, "Bill", "Car1");
        addCarToOwner(ownerToCarsMap, "Bill", "Car5");
        addCarToOwner(ownerToCarsMap, "Sarah", "Car4");


        for (Map.Entry<String, Set<String>> entry : ownerToCarsMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        Map<String, Set<String>> carToOwnersMap = new HashMap<>();


        for (Map.Entry<String, Set<String>> entry : ownerToCarsMap.entrySet()) {
            String owner = entry.getKey();
            for (String car : entry.getValue()) {
                carToOwnersMap.computeIfAbsent(car, k -> new HashSet<>()).add(owner);
            }
        }


        for (Map.Entry<String, Set<String>> entry : carToOwnersMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }


    private static void addCarToOwner(Map<String, Set<String>> map, String owner, String car) {
        map.computeIfAbsent(owner, k -> new HashSet<>()).add(car);
    }
}
