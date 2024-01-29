package ru.marinin.utils;

import ru.marinin.animals.Bird;
import ru.marinin.animals.Meowable;
import ru.marinin.entities.Box;
import ru.marinin.entities.Storage;
import ru.marinin.geometry.*;
import ru.marinin.utils.utilsService.Applyable;
import ru.marinin.utils.utilsService.Testable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.*;
import static java.lang.Math.pow;

public class Utils {
    public static Double sumAllObjects(Number... nums) {                    // 3.3.1 Сложение.
        double sum=0;
        for (Number num : nums) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static void singAll(Bird... birds) {                             // 3.3.2 Птичий рынок.
        for (Bird bird : birds) {
            System.out.println(bird.sing());
        }
    }

    public static int allArea(Areable... figures) {                       // 3.3.3 Общая площадь.
        int sumArea = 0;
        for (Areable figure : figures) {
            sumArea += figure.getArea();
        }
        return sumArea;
    }

    public static void allMeow(Meowable... args) {                       // 3.3.4 Мяуканье.
        for (Meowable arg : args) {
            arg.meow();
        }
    }

    public static int allLength(Lengthable... geoms) {                 // 3.3.5 Измерение длины.
        int sum = 0;
        for (Lengthable geom : geoms) {
            sum += geom.length();
        }
        return sum;
    }

//    public static Polyline generalPolyline(Polylineable... objects) {         // 3.3.7 Ломай меня полностью.
//        List<Point> list = new ArrayList<>();
//        for (Polylineable object : objects) {
//            list.addAll(object.getPolyline().getPoitns());
//        }
//        return new Polyline(list);
//    }

    public static int mathPow(String[] args) {
        int x = parseInt(args[0]);
        int y = parseInt(args[1]);
        return (int) pow(x,y);
    }

    public static<T extends Point> void moveLine(Line line) {
        T startPoint = (T) line.getStart();
        if (startPoint.x>=0) {
            startPoint.x+=10;
        } else {
            startPoint.x-=10;
        }
        line.setStart(startPoint);
    }

    public static<T> double maxObjInStorage(List<Storage<? extends Number>> list) {
        if (list.isEmpty()) {
            new IllegalArgumentException();
        }
                                                                                    // как передать в дефолт не null ??
        double max = list.get(0).getObj(null).doubleValue();
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).getObj(null).doubleValue()>max) {
                max = list.get(i).getObj(null).doubleValue();
            }
        }
        return max;
    }

    public static<T extends Point> void pointInBox(Box<T> box) {  // ? super Point3D
        Random random = new Random();
        Point3D point3D = new Point3D(random.nextInt(), random.nextInt(), random.nextInt());
        box.setObj((T) point3D);
    }

    public static<T extends Number> void initList(List<T> list) {
        // ???
    }

    public static<T, P> List<P> function(List<T> list, Applyable<T,P> applyable) {
        List<P> listOut = new ArrayList<>();
        for (T element : list) {
            listOut.add(applyable.apply(element));
        }
        return listOut;
    }

    public static<T> List<T> filter(List<T> list, Testable<T> testable) {
        List<T> listOut = new ArrayList<>();
        for (T element : list) {
            if (testable.test(element)) listOut.add(element);
        }
        return listOut;
    }




}

