package fundamental.concurrency.thread.creation;

import fundamental.concurrency.resourceManager.BankAccountManager;


/**
 * implicit implement Runnable function interface through Lambda
 */
public class BankAccountWithdrawRunnableLambdaImpl {
    private BankAccountManager bankAccountManager;

    public void execute() {
        Runnable task = () -> bankAccountManager.withdraw(50);
        Thread thread = new Thread(task);
        thread.start();
    }

    public static void main(String[] args) {
        BankAccountWithdrawRunnableLambdaImpl context = new BankAccountWithdrawRunnableLambdaImpl();
        context.execute();
    }

    public BankAccountWithdrawRunnableLambdaImpl(BankAccountManager bankAccountManager) {
        this.bankAccountManager = bankAccountManager;
    }

    public BankAccountWithdrawRunnableLambdaImpl() {
        this(new BankAccountManager());
    }
}
