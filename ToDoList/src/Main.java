import manager.TaskManager;
import model.Task;
import util.TaskFileManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 사용자 입력
        Scanner scanner = new Scanner(System.in);
        String command = ""; // 번호 선택
        String description = ""; // 할 일 작성
        // tasks.txt 에서 파일 불러오기
        ArrayList<Task> tasks = TaskFileManager.loadFile(); // 할 일 리스트
        TaskManager taskManager = new TaskManager(tasks);

        // 메뉴 출력
        while (true) {
            System.out.println("===== Todo List =====");
            System.out.println("1. 할 일 추가");
            System.out.println("2. 할 일 삭제");
            System.out.println("3. 할 일 수정");
            System.out.println("4. 할 일 목록 조회");
            System.out.println("5. 할 일 저장");
            System.out.println("6. 프로그램 종료");

            System.out.print("수행할 작업을 번호로 입력해 주세요. >> ");
            command = String.valueOf(scanner.nextLine()); // 사용자가 메뉴 선택

            switch (command) {
                case "1":
                    System.out.print("추가할 일을 입력해주세요.(다시 메뉴를 선택하고 싶으면 m 입력) >> ");
                    description = scanner.nextLine();
                    try {
                        if (!description.equalsIgnoreCase("m")) {
                            taskManager.addTask(description.trim());
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("추가할 일을 입력해주세요.");
                    }
                    break;
                case "2":
                    taskManager.displayTasks();
                    System.out.print("삭제할 번호를 입력해주세요. >> ");
                    command = String.valueOf(scanner.nextLine());
                    taskManager.removeTask(Integer.parseInt(command) - 1);
                    break;
                case "3":
                    taskManager.displayTasks();
                    System.out.print("수정할 번호를 입력해주세요. >> ");
                    command = String.valueOf(scanner.nextLine());
                    System.out.print("수정할 일을 입력해주세요. >> ");
                    description = scanner.nextLine();
                    try {
                        taskManager.updateTask(Integer.parseInt(command) - 1, description.trim());
                    } catch (IllegalArgumentException e) {
                        System.out.println("수정할 일을 입력해주세요.");
                    }
                    break;
                case "4":
                    taskManager.displayTasks();
                    break;
                case "5":
                    TaskFileManager.saveFile(tasks);
                    System.out.println("저장이 완료되었습니다.");
                    break;
                case "6":
                    // TODO 저장하라는 메세지 주기
                    System.out.println("작업이 종료되었습니다.");
                    return;
                default:
                    System.out.println();
                    System.out.println("1 ~ 6 번 중 다시 입력해주세요.");
            }

            System.out.println();
        }
    }
}