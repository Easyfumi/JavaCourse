package ru.marinin.people;

public interface Command {
    void add(int grade);
    void undo();
}
