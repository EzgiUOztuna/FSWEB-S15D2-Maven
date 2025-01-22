package org.example;

import org.example.entity.*;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Task> annsTasks = new HashSet<>();
        Task taskAnn = new Task("workintech", "dummy desc", "ann", Status.IN_PROGRESS, Priority.HIGH);
        Task taskAnn1 = new Task("workintech", "dummy desc 1", "ann", Status.IN_PROGRESS, Priority.HIGH);
        annsTasks.add(taskAnn);
        annsTasks.add(taskAnn1);


        Set<Task> bobsTasks = new HashSet<>();
        Task taskBob = new Task("workintech", "dummy desc", "bob", Status.IN_PROGRESS, Priority.HIGH);
        Task taskBob1 = new Task("workintech", "dummy desc 1", "bob", Status.IN_PROGRESS, Priority.HIGH);
        bobsTasks.add(taskBob);
        bobsTasks.add(taskBob1);

        Set<Task> carolsTasks = new HashSet<>();
        Task taskCarol = new Task("workintech", "dummy desc 2", "carol", Status.IN_PROGRESS, Priority.HIGH);
        Task taskCarol1 = new Task("workintech", "dummy desc 3", "carol", Status.IN_PROGRESS, Priority.HIGH);
        carolsTasks.add(taskCarol);
        carolsTasks.add(taskCarol1);

        Set<Task> unassignedTasks = new HashSet<>();
        Task unassignedTask = new Task("workintech", "dummy desc 4", null, Status.IN_PROGRESS, Priority.HIGH);
        unassignedTasks.add(unassignedTask);

        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks );
        System.out.println("bobstasks: " + taskData.getTasks("bob"));
        System.out.println("annstasks: " + taskData.getTasks("ann"));
        System.out.println("alltasks: " + taskData.getTasks("all"));

        System.out.println("unassigned: " + taskData.getDifferences(unassignedTasks, taskData.getTasks("ann")));

        System.out.println(taskData.getIntersection(annsTasks, bobsTasks));
        System.out.println(taskData.getIntersection(annsTasks, carolsTasks));
        System.out.println( taskData.getIntersection(bobsTasks, carolsTasks));


        StringSet.findUniqueWords();
    }
}