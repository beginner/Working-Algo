package design;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class LC3408_TaskManager {

    public static void main(String[] args) {
        final var tasks = List.of(List.of(10,26,25));
        LC3408_TaskManager problem = new LC3408_TaskManager(tasks);
        problem.rmv(26);
        System.out.println(problem.execTop());

    }
    TreeSet<Cell> set;
    HashMap<Integer, Cell> map;
    public LC3408_TaskManager(List<List<Integer>> tasks) {
        set = new TreeSet<>();
        map = new HashMap<>();
        for (List<Integer> task : tasks) {
            Cell cell = new Cell(task.get(0), task.get(1), task.get(2));
            set.add(cell);
            map.put(task.get(1), cell);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Cell cell = new Cell(userId, taskId, priority);
        set.add(cell);
        map.put(taskId, cell);
    }

    public void edit(int taskId, int newPriority) {
        Cell cell = map.get(taskId);
        set.remove(cell);
        cell.priority = newPriority;
        set.add(cell);
    }

    public void rmv(int taskId) {

        Cell cell = map.get(taskId);
        map.remove(taskId);
        set.remove(cell);
    }

    public int execTop() {
        if (set.isEmpty()) return -1;
        Cell last = set.last();
        map.remove(last.taskId);
        set.removeLast();
        return last.userId;
    }

}

class Cell implements Comparable<Cell> {
    int userId, taskId, priority;
    public Cell(int userId, int taskId, int priority) {
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Cell)) return false;
        Cell other = (Cell) o;
        return other.userId == userId && other.taskId == taskId
                && other.priority == priority;
    }

    public int hashCode() {
        return Objects.hash(userId, taskId, priority);
    }

    public int compareTo(Cell other) {
        int result = Integer.compare(priority, other.priority);
        if (result != 0) return result;
        return Integer.compare(taskId, other.taskId);
    }
}