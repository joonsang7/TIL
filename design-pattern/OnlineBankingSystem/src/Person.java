public class Person {
    protected String userId;
    protected String name;

    public Person(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    // 공통 메서드: 자식 클래스에서 오버라이딩 가능
    public boolean checkUser(String userId) {
        return this.userId.equals(userId);
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    // 정보 출력 (자식에서 오버라이딩)
    public void printInfo() {
        System.out.println("ID: " + userId + " | 이름: " + name);
    }
}