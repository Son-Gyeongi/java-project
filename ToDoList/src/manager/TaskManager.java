package manager;

import model.Task;

import java.util.ArrayList;

/*
TaskManager - 할 일 관리 클래스
할 일 목록을 관리하고 추가/삭제/수정/조회하는 기능 담당
 */
public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    // 할 일 추가
    public void addTask(String description) {
        // TODO 값이 비어있는 경우(호출하는 곳에서 검사해야하나?) 아니면 생성자에서?
        tasks.add(new Task(description));
    }

    // 할 일 삭제
    public void removeTask(int index) {
        // 유효하지 않은 인덱스인 경우
        if (!(0 <= index && index < tasks.size())) return;

        tasks.remove(index);
    }

    // 할 일 수정
    public void updateTask(int index, String description) {
        // 유효하지 않은 인덱스인 경우
        if (!(0 <= index && index < tasks.size())) return;

        tasks.get(index).updateDescription(description);
    }

    // 할 일 목록 조회
    public void displayTasks() {
        System.out.println("----- 리스트 목록 -----");
        if (tasks.isEmpty()) System.out.println("현재 등록된 할 일이 없습니다.");

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + " : " + tasks.get(i));
        }
    }
}
