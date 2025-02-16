package util;

import model.Task;

import java.io.*;
import java.util.ArrayList;

/*
TaskFileManager - 파일 저장 및 불러오기 담당
파일 입출력을 담당하는 클래스 (tasks.txt 파일 저장 및 불러오기)
 */
public class TaskFileManager {
    private static final String filePath = System.getProperty("user.dir"); // 현재 실행 중인 프로그램 디렉토리
    private static final String fileName = "\\src\\textfile\\tasks.txt";

    // 저장하기
    public static void saveFile(ArrayList<Task> tasks) {
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(new File(filePath, fileName)));

            for (int i = 0; i < tasks.size(); i++) {
                output.write(tasks.get(i).toString());
                output.newLine();
            }

            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 파일 불러오기
    public static ArrayList<Task> loadFile() {
        ArrayList<Task> list = new ArrayList<>();

        try {
            BufferedReader input = new BufferedReader(new FileReader(new File(filePath, fileName)));

            String line = "";
            for (int i = 0; (line = input.readLine()) != null; i++) {
                list.add(new Task(line));
            }

            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
