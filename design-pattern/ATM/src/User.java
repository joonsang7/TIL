public class User {
	
    public String id;
    public String pw;
    public String address;
    public String phone;

    // addUser 있기에 비워 둔다. 
    public User() {}

    // 계정 추가 메서드 
    public boolean addUser(String id, String pw, String address, String phone) {
        // id가 이미 존재하면 false 반환하기! 
        if (this.checkUser(id)) return false;

        this.id = id;
        this.pw = pw;
        this.address = address;
        this.phone = phone;
        return true;
    }
    

    // 계정 정보 업데이트 메서드 
    public boolean updateUser(String id, String pw, String address, String phone) {
        if (this.id == null || !this.id.equals(id)) return false; // id 검사 
        this.pw = pw;
        this.address = address;
        this.phone = phone;
        return true;
    }

    // 계정 삭제 메서드 
    public boolean deleteUser(String id) {
        if (this.id == null || !this.id.equals(id)) return false; //id 검사 
        this.id = null;
        this.pw = null;
        this.address = null;
        this.phone = null;
        return true;
    }

    // 계정 검색 메서드 - id 찾아서 해당 id 존재하면 true 반환 
    public boolean searchUser(String id) {
        return this.id != null && this.id.equals(id); 
    }

    // 계정 체크 메서드 — id 유효성 확인용  
    public boolean checkUser(String id) {
        return this.id != null && this.id.equals(id);
    }

}
