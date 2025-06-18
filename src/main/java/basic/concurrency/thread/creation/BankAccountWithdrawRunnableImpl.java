package basic.concurrency.thread.creation;

import basic.concurrency.resourceManager.BankAccountManager;

/**
 * demo
 * how to implement a Runnable interface.
 * the key: define the specific task. (method to run, either a running block, or a method from an object)
 * how to construct a Thread and start()
 */
public class BankAccountWithdrawRunnableImpl implements Runnable {
    //set up task
    private BankAccountManager bankAccountManager;

    public BankAccountWithdrawRunnableImpl(BankAccountManager bankAccountManager) {
        this.bankAccountManager = bankAccountManager;
    }

    @Override
    public void run() {
        bankAccountManager.withdraw(50.0);
    }

    //Thread client
    public static void main(String[] args) {
        BankAccountWithdrawRunnableImpl task = new BankAccountWithdrawRunnableImpl(new BankAccountManager());

        //start a thread
        Thread bankAccountManagerThread = new Thread(task);
        bankAccountManagerThread.start();
    }
}

