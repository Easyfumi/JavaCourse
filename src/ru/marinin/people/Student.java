package ru.marinin.people;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student implements Compare, Cloneable {
    private String name;
    private List<Integer> grades;
    private List<Student> cache = new ArrayList<>();

    public Student(String name, Integer... args) {
        this.name = name;
        this.grades = new ArrayList<>(Arrays.asList(args));
        cache.add(this.clone());
    }
    private Student(String name, List<Integer> gradesList) {
        this.name = name;
        this.grades = gradesList;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        cache.add(this.clone());
    }
    public List<Integer> getGrades() {
        return new ArrayList(grades);
    }
    public void addGrade(int grade) {
        grades.add(grade);
        cache.add(this.clone());
    }
    public List<Student> getCache() {
        return cache;
    }
    public void undo() {
        if (cache.size()!=1)  {
            this.name = cache.get(cache.size()-2).getName();
            this.grades = cache.get(cache.size()-2).getGrades();
            cache.remove(cache.size()-1);
        }
    }
    public Student getLastSave() {
        return cache.get(cache.size()-1);
    }
    public void removeGrade(int index) {
        try {
            grades.remove(index);
        } catch (IndexOutOfBoundsException e) {

        }
        cache.add(this.clone());
    }
    public double getMiddleGrade() {
        int sum = 0;
        if (grades.isEmpty())
            return 0;
        for (int i=0; i<grades.size(); i++) {
            sum += grades.get(i);
        }
        return (double) sum/grades.size();
    }
    public boolean isExcellentStudent() {
        if (this.grades.isEmpty())
            return false;
        if (this.grades.contains(1) || this.grades.contains(2) || this.grades.contains(3) || this.grades.contains(4))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return name + ": " + grades;
    }
    @Override
    public int compare(Object obj) {
        double diff = this.getMiddleGrade() - ((Student) obj).getMiddleGrade();
        if (diff>0) return 1;
        if (diff<0) return -1;
        return 0;
    }
    public Student clone() {
        return new Student(name, new ArrayList<>(grades));
    }
}