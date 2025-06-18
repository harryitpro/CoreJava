package basic.concurrency.resourceManager;

/**
 * demo to apply synchronized keyword to block.
 */
public class SynchronizedBlockBankAccountManager {
    private BankAccount bankAccount;

    public SynchronizedBlockBankAccountManager(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public SynchronizedBlockBankAccountManager() {
        this.bankAccount = new BankAccount();
    }

    public boolean withdraw(double amount, String customer) {
        synchronized (this) {//It creates a monitor lock on the current object (this)
            if (bankAccount.getBalance() >= amount) {
                bankAccount.setBalance(bankAccount.getBalance() - amount);
                return true;
            }
            return false;
        }
    }
}
