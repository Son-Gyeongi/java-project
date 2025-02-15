package util;

import model.Task;

import java.util.ArrayList;

/*
TaskFileManager - 파일 저장 및 불러오기 담당
파일 입출력을 담당하는 클래스 (tasks.txt 파일 저장 및 불러오기)
 */
public class TaskFileManager {
    private static final String filePath = System.getProperty("user.dir"); // 현재 실행 중인 프로그램 디렉토리
    private static final String fileName = "src/textfile/tasks.txt";

    // 저장하기
    public static void saveFile(ArrayList<Task> tasks) {

    }
    
    // 불러오기
}
