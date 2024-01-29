package ru.marinin.cities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class City {
    private String name;
    protected List<Road> roads = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<Road> getRoads() {
        return new ArrayList<>(roads);
    }


    public City(String name) {
        this.name = name;
    }

    public boolean hasRoadTo(City target) {
        for (Road r : roads) {
            if (r.getWayTo() == target)
                return true;
        }
        return false;

    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof City) ) return false;
        City city = (City) o;
        return Objects.equals(name, city.name)
                && city.roads.size()==roads.size()
                && roads.containsAll(city.roads);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void add(City target, int cost) {
        for (Road r : roads) {
            if (r.getWayTo() == target) {
                r.setCost(cost);
                return;
            }
        }
        roads.add(new Road(target, cost));
    }

    public void deleteByIndex(int n) {
        roads.remove(n);
    }

    public void deleteByRoad(Road road) {
        roads.remove(road);
    }

    @Override
    public String toString() {
        return "City " + name + " has roads to " + roads;
    }
}