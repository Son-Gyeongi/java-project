package model;

/*
Task - 할 일 객체
할 일 데이터를 관리하는 클래스
 */
public class Task {
    private String description; // 할 일 데이터

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        // TODO 여기서 입력값 description 유효성 검사할 게 있나?
        // 값이 비어있는 경우(호출하는 곳에서 검사해야하나?)
        this.description = description;
    }
}
