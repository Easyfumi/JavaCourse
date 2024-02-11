package ru.marinin;
import ru.marinin.cities.City;
import ru.marinin.cities.CityWithTwoRoads;
import ru.marinin.entities.Box;
import ru.marinin.entities.Storage;
import ru.marinin.geometry.*;

import ru.marinin.people.Save;
import ru.marinin.utils.Utils;
import ru.marinin.utils.utilsService.Applyable;
import ru.marinin.utils.utilsService.Testable;
import ru.marinin.math.Fraction;
import ru.marinin.people.Student;
import ru.marinin.work.Department;
import ru.marinin.work.Employee;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Tests {
    static public void test_cities() {
        City a = new City("a");
        City b = new City("b");
        City c = new City("c");

        City d = new CityWithTwoRoads("d");
        City e = new CityWithTwoRoads("e");


        a.add(b, 10);
        a.add(c, 15);
        b.add(c, 5);
        a.add(c, 20);

        a.add(d, 20);
        d.add(e,10);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        System.out.println(d);
        System.out.println(e);

    }       // test of cities package.
    static public void test_4_1_3() {
        // 	7+11/3+3.21+12345678912345678912
        int i1 = 7;
        Fraction i2 = new Fraction(11,3);
        double i3 = 3.21;
        BigInteger i4 = new BigInteger("12345678912345678912");
        System.out.println(Utils.sumAllObjects(i1,i2,i3,i4));

    }       // test of 4.1.3 Сложение из пакетов.
    static public void test_4_1_5() {
        java.awt.Point p1 = new java.awt.Point();
        ru.marinin.geometry.Point p2 = new ru.marinin.geometry.Point(1,1);
        System.out.println(p1);
        System.out.println(p2);
    }       // test of 4.1.5 Простые имена.
    static public void test_4_2_1() {

        Department depIT = new Department("IT");
        Department depSecurity = new Department("Security");

        Employee emp1 = new Employee("Ivanov", depIT);
        Employee emp2 = new Employee("Petrov", depIT);
        Employee emp3 = new Employee("Sidorov", depIT);
        Employee emp4 = new Employee("Sergeev", depSecurity);

        depIT.setBoss(emp1);

        System.out.println(depIT.getEmployeeList());

        depSecurity.setBoss(emp1);
        System.out.println("_______________");

        System.out.println(depIT.getEmployeeList());
        System.out.println(depSecurity.getEmployeeList());








    }       // test of 4.2.1 Отделы доверяют начальникам.
    static public void test_3_4_1() {
        Fraction fraction1 = new Fraction(2,3);
        Fraction fraction2 = new Fraction(2,3);
        System.out.println(fraction1.equals(fraction2));
    }
    static public void test_3_4_5() {
        City cityA = new City("A");
        City cityB = new City("B");

        CityWithTwoRoads twoRoadsCityA = new CityWithTwoRoads("A");

        cityA.add(cityB, 5);
        twoRoadsCityA.add(cityB, 5);

        System.out.println(cityA.equals(twoRoadsCityA));
    }
    static public void test_city_clone() {
        City a = new City("A");
        City b = new City("B");
        City c = new City("A");
        City d = new City("B");

        a.add(b,3);
        b.add(a,3);
        c.add(b,3);
        d.add(c,3);

        System.out.println(a.equals(c));
    }
    static public void test_5_1_1() {
        Box box1 = new Box();
//        String str1 = "str1";
//        String str2 = "str2";
//        box1.setObj(str1);
//        System.out.println(box1.getObj());
//        System.out.println(box1.getObj());
//
//        box1.setObj(str1);
//        box1.setObj(str2);

        int i1 = 1;
        int i2 = 2;

        System.out.println(box1.getObj());

        box1.setObj(i1);
        box1.setObj(i2);


    }
    static public void test_5_1_4() {
        Student st1 = new Student("Oleg", 3,3,4,4,5);
        Student st2 = new Student("Vasya", 5,5,5,5,5);
        Student st3 = new Student("Petya", 4,4,3,3,5);
        System.out.println(st1.compare(st2));  // = -1
        System.out.println(st3.compare(st1));  // = 0
        System.out.println(st2.compare(st3));  // = 1
    }
    static public void test_5_1_5() {
        Point3D point1 = new Point3D(1,1,1);
        Point3D point2 = new Point3D(5,5,5);
        Point3D point3 = new Point3D(9,9,9);
        Line<Point3D> line3D = new Line<>(point1, point2);
        System.out.println(line3D);
        System.out.println(line3D.length());


        Polyline<Point3D> polyline3d = new Polyline<>(point1,point2,point3);
        System.out.println(polyline3d);

        Polyline<Point> polyline = new Polyline<>(point1, point2);
        System.out.println(polyline);

        System.out.println(polyline3d.length());
        System.out.println(polyline.length());
    }

    static public void test_5_2_1() {
        Point3D p1 = new Point3D(1,1,1);
        Point3D p2 = new Point3D(3,3,3);

        Line<Point3D> point3DLine = new Line<>(p1,p2);
        System.out.println(point3DLine);
        Utils.moveLine(point3DLine);
        System.out.println(point3DLine);

        Point p3 = new Point(-7,-7);
        Point p4 = new Point(9,9);

        Line<Point> pointLine = new Line<>(p3,p4);
        System.out.println(pointLine);
        Utils.moveLine(pointLine);
        System.out.println(pointLine);
    }

    static public void test_5_2_2() {
        List<Storage<? extends Number>> list = new ArrayList<>();
        Storage<Integer> integerStorage = Storage.create(5);
        Storage<Double> doubleStorage = Storage.create(3.0);
        Storage<Float> floatStorage = Storage.create(6f);
        Storage<Float> nullStorage = Storage.create(null);
        Storage<String> stringStorage = Storage.create("asd");

        list.add(integerStorage);
        list.add(doubleStorage);
        list.add(floatStorage);
        // list.add(stringStorage);
        // list.add(nullStorage);

        System.out.println(Utils.maxObjInStorage(list));
    }

    static public void test_5_2_3() {
        Box<Point> box = new Box<>();
        Utils.pointInBox(box);
        System.out.println(box.getObj());
    }

    static public void test_5_2_4() {
        List<Integer> list = new ArrayList<>();
        Utils.initList(list);
        System.out.println(list);
    }

    static public void test_5_3_1() {
        // 1st
        List<String> list1 = new ArrayList<>();
        list1.add("qwerty");
        list1.add("asdfg");
        list1.add("zx");
        Applyable<String, Integer> applyable1 = (o1) -> {
            return o1.length();
        };
        System.out.println(Utils.function(list1, applyable1));
        // 2nd
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(-7);
        list2.add(3);
        Applyable<Integer, Integer> applyable2 = (o1) -> {
            return Math.abs(o1);
        };
        System.out.println(Utils.function(list2, applyable2));
        // 3rd
        List<int[]> list3 = new ArrayList<>();
        list3.add(new int[]{1,2,3});
        list3.add(new int[]{4,33,2,-1});
        list3.add(new int[]{0,99,3,9,100});
        Applyable<int[], Integer> applyable3 = (o1) -> {
            return Arrays.stream(o1).max().getAsInt();
        };
        System.out.println(Utils.function(list3, applyable3));
    }

    static void test_5_3_2() {
        // 1st
        List<String> list1 = new ArrayList<>();
        list1.add("qwerty");
        list1.add("asdfg");
        list1.add("zx");
        Testable<String> testable1 = (o1) -> {
            return o1.length()>2;
        };
        System.out.println(Utils.filter(list1, testable1));
        // 2nd
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(-7);
        list2.add(3);
        Testable<Integer> testable2 = (o1) -> {
            return o1<0;
        };
        System.out.println(Utils.filter(list2,testable2));
        // 3rd
        List<int[]> list3 = new ArrayList<>();
        list3.add(new int[]{1,2,3});
        list3.add(new int[]{4,33,2,-1});
        list3.add(new int[]{0,99,3,9,100});
        Testable<int[]> testable3 = (o1) -> {
            for (int i=0; i<o1.length; i++) {
                if (o1[i]<0) return false;
            }
            return true;
        };

        for (int[] array : Utils.filter(list3,testable3)) {
            List<Integer> list = new ArrayList<>();
            for (int element : array) {
                list.add(element);
            }
            System.out.print(list);
        }
    }

    static void test_group() {
        Triangle triangle = new Triangle(new Point(1,1), new Point(10,10), new Point(10,1));

//        System.out.println(triangle);
//        System.out.println("Move x-> +10\n");
//        triangle.move(10,0);
//        System.out.println(triangle);

        Line<Point> line = new Line<>(new Point(10,10), new Point(30,30));

//        System.out.println(line);
//        System.out.println("Move x-> -10, y-> -10\n");
//        line.move(-10,-10);
//        System.out.println(line);

        Circle circle = new Circle(new Point(-20,-20), 10);

//        System.out.println(circle);
//        System.out.println("Move x-> +20, y-> +10\n");
//        circle.move(20,10);
//        System.out.println(circle);


        Group group = Group.of(triangle, line, circle);
        System.out.println(group);
        System.out.println("Move group x-> +10, y-> +10\n");
        group.move(10,10);
        System.out.println(group);
        System.out.println("Move circle x-> -30, y-> -30\n");
        circle.move(-30,-30);
        System.out.println(group);

        Square square = new Square(new Point(0,0), 10);

        Group group1 = Group.of(group, square);
        System.out.println(group1);
        System.out.println("Move group x-> -20, y-> +20\n");
        group1.move(-20,20);
        System.out.println(group1);

        System.out.println("Move triangle x-> +100, y-> +100\n");
        triangle.move(100,100);
        System.out.println(group1);

        Point point = new Point(1,1);
        Point3D point3D = new Point3D(2,2,2);

        Group group2 = Group.of(point, point3D, group1);
        System.out.println(group2);
        System.out.println("Move group x-> +1, y-> +1\n");
        group2.move(1,1);
        System.out.println(group2);

        Polyline<Point> polyline = new Polyline<>(new Point(1,1), new Point(2,2), new Point(3,3), new Point(4,4));
        Group group3 = Group.of(point, polyline);
        System.out.println(group3);
        System.out.println("Move group x-> -1, y-> -1\n");
        group3.move(-1,-1);
        System.out.println(group3);
    }

    static void testStudentCache() {
        Student student = new Student("Oleg", 4,4,5,5);

        System.out.println(student);
        student.setName("Vasya");
        System.out.println(student);
        student.undo();
        System.out.println(student);
        student.addGrade(2);
        student.addGrade(3);
        Save save = student.getSave();
        System.out.println(student);
        student.undo();
        System.out.println(student);
        student.removeGrade(1);
        System.out.println(student);
        student.undo();
        System.out.println(student);
        student.undo();
        student.undo();
        student.undo();
        System.out.println(student);
        student.undo();
        student.undo();
        student.addGrade(1,2,3);
        System.out.println(student);
        student.undo();
        System.out.println(student);
        student.setName("Ivan");
        student.addGrade(1,2,3);
        System.out.println(student);
        student.undo();
        System.out.println(student);
        student.undo();
        System.out.println(student);
        save.load();
        System.out.println(student);
        student.undo();
        System.out.println(student);
        student.setName("Ivan");
        student.addGrade(1,2,3);
        System.out.println(student);
        student.undo();
        System.out.println(student);




    }

}
