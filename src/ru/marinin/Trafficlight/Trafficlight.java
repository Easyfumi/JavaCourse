package ru.marinin.Trafficlight;

import java.util.Date;

public class Trafficlight{
    Color color=Colors.GREEN;
    public String next(){
        color=color.next();
        return color.toString();
    }
}
interface Color{
    Colors next();
}

