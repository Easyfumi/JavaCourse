package ru.marinin;

import ru.marinin.Trafficlight.Colors;
import ru.marinin.Trafficlight.Trafficlight;
import ru.marinin.geometry.Line;
import ru.marinin.people.Builder;
import ru.marinin.people.Name;
import ru.marinin.people.Student;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // task #1 Stream API
        Tests.streamOne();

        // task #2 Stream API
        try {
            Tests.streamTwo();
        } catch (IOException e) {
            new IllegalArgumentException().printStackTrace();
        }
    }
}


