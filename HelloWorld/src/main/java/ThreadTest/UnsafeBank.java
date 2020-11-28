package ThreadTest;

public class UnsafeBank {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account("银行账户", 100);
        Bank you = new Bank("boy", 50, account);
        Bank she = new Bank("girl", 100, account);
        you.start();
        she.start();
    }
}

class Bank extends Thread {
    public Bank(String name, int nowMoney, Account account) {
        super(name);
        this.nowMoney = nowMoney;
        this.account = account;
    }

    private       int     nowMoney;
    private final Account account;

    @Override
    public void run() {

       synchronized(account){
           if (account.getMoney() - nowMoney < 0) {
               System.out.println(this.getName() + " 余额不足...");
               return;
           }
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           account.setMoney(account.getMoney() - nowMoney);
           System.out.println("账户中钱：" + account.getMoney());
           System.out.println(this.getName() + " 手中钱" + nowMoney);
       }
    }
}

class Account {
    private String name;
    private int    money;

    public Account(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
