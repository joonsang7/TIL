public class Account {
    public String accId; // 계좌 id 
    public String accNumber;   // 계좌번호 
    public float balance; // 잔고 

    private User user; // users 참조 

    public Account(String accId, String number, float balance, User user) {
        this.accId   = accId;
        this.accNumber  = number;
        this.balance = balance;
        this.user = user;
    }

    // 입금 메서
    public float deposite(String id, float inMoney) {
        if (user == null || !user.searchUser(id)) return -1; // id 검증
        
        // 입금 후 잔고 반환 
        balance += inMoney;
        return balance;
    }

    // 출금 메서드 
    public float withdraw(String id, float outMoney) {
        if (user == null || !user.searchUser(id)) return -1; // id 검증
        if (balance < outMoney) return -1;                   // 잔고 부족 검사 

        // 출금  후 잔고 반환 
        balance -= outMoney;
        return balance;
    }

    // 송금 메서드 
    public float transfer(String id, float transferMoney, String transferNum) {
        if (user == null || !user.searchUser(id)) return -1; // id 검증
        if (balance < transferMoney) return -1;              // 잔고 부족 검사
        
        // 송금 후 잔고 반환 
        balance -= transferMoney;
        return balance;
    }
}
