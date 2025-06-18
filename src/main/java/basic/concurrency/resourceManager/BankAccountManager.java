package basic.concurrency.resourceManager;

/**
 * Not Thread safety
 */
public class BankAccountManager {
    private BankAccount bankAccount;

    public BankAccountManager(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BankAccountManager() {
        this(new BankAccount());
    }

    public boolean withdraw(double amount) {
        if (bankAccount.getBalance() >= amount) {
            bankAccount.setBalance(bankAccount.getBalance() - amount);
            return true;
        }
        return false;
    }

}
