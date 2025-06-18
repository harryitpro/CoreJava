package basic.concurrency.resourceManager;

/**
 * demo synchronized method
 */
public class SynchronizedMethodBankAccountManager {
    private BankAccount bankAccount;

    public SynchronizedMethodBankAccountManager(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public SynchronizedMethodBankAccountManager() {
        this.bankAccount = new BankAccount();
    }

    public synchronized boolean withdraw(double amount, String customer) {
        if (bankAccount.getBalance() >= amount) {
            bankAccount.setBalance(bankAccount.getBalance() - amount);
            return true;
        }
        return false;
    }
}
