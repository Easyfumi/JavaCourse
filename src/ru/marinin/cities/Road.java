package ru.marinin.cities;

import java.util.Objects;

public class Road {
    private City wayTo;
    private int cost;
    public Road(City wayTo, int cost) {
        this.wayTo = wayTo;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public City getWayTo() {
        return wayTo;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return cost == road.cost && wayTo==road.wayTo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wayTo.getName(), cost);
    }

    @Override
    public String toString() {
        return wayTo.getName()+"(cost "+cost+")";
    }
}