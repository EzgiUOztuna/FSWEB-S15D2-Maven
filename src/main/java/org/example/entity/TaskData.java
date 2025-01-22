package org.example.entity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getTasks(String name) {
        switch (name) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(annsTasks, bobsTasks, carolsTasks);
//                Set<Task> allTasks = new HashSet<>();
//                allTasks.addAll(annsTasks);
//                allTasks.addAll(bobsTasks);
//                allTasks.addAll(carolsTasks);
//                allTasks.addAll(unassignedTasks);
//                return allTasks;
            default:
                return unassignedTasks;
        }
    }
    public Set<Task> getUnion(Set<Task>... sets) { /*Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks*/
            HashSet<Task> allTasks = new LinkedHashSet<>();
            for(Set<Task> tasks: sets) {
                allTasks.addAll(tasks);
            }
            return allTasks;
    }
    public Set<Task> getIntersection(Set<Task>first, Set<Task>second) {
        Set<Task> intersection = new HashSet<>(first);
        intersection.retainAll(second);
        return intersection;
    }
    public Set<Task> getDifferences(Set<Task>first, Set<Task>second) {
        Set<Task> difference = new HashSet<>(first);
        difference.removeAll(second);
        return difference;
    }

}
