package ru.marinin.cities;

public class CityWithTwoRoads extends City {

    public CityWithTwoRoads(String name) {
        super(name);
    }

    @Override
    public void add(City target, int cost) {
        super.add(target, cost);
        if (!target.hasRoadTo(this))
            target.add(this, cost);

    }

}
