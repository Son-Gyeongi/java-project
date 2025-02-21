package model;

/*
Task - 할 일 클래스
할 일 데이터를 관리하는 클래스
 */
public class Task {
    private String description; // 할 일 데이터

    public Task() {
        throw new IllegalArgumentException("할 일을 입력해주세요.");
    }

    public Task(String description) {
        // 입력값 description 유효성 검사 - 값이 비어있는 경우
        if (description.isEmpty())
            throw new IllegalArgumentException();
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void updateDescription(String description) {
        // 입력값 description 유효성 검사 - 값이 비어있는 경우
        if (description.isEmpty())
            throw new IllegalArgumentException();
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
