package ru.marinin.people;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student implements Compare, Cloneable {
    private String name;
    private List<Integer> grades;
    private Save save;

    public Student(String name, Integer... args) {
        this.name = name;
        this.grades = new ArrayList<>(Arrays.asList(args));
    }
    public void save(){
        this.save = new Save(this);
    }
    public Save getSave() {
        return save;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Integer> getGrades() {
        return new ArrayList(grades);
    }
    private void removeGrade(int index) {
        grades.remove(index);
    }

    private void addGrade(int grade) {
        grades.add(grade);
    }

    public static class AddGradeCommand implements Command{
        /// private static List<Command> undoList = new ArrayList<>();
        private static List<Integer> addedGrades = new ArrayList<>();
        int count = -1;
        private Student student;

        public AddGradeCommand(Student student) {
            this.student = student;
        }

        @Override
        public void add(int grade) {
            addedGrades.add(grade);
            student.addGrade(grade);
            count++;
        }

        @Override
        public void undo() {
            if (count>=0) {
                int grade = addedGrades.get(addedGrades.size()-1);
                addedGrades.remove(addedGrades.size()-1);
                int indexGrade = student.getGrades().lastIndexOf(grade);
                student.removeGrade(indexGrade);
                count--;
            }

        }
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

}
