package basic.concurrency.thread.creation;

import basic.concurrency.resourceManager.BankAccountManager;

/**
 * demo
 * how to create a thread with given task.
 * how to invoke the thread by a client. (here is the main() method)
 */
public class BankAccountWithdrawThread extends Thread {
    //set up task
    private BankAccountManager bankAccountManager;

    public BankAccountWithdrawThread(BankAccountManager bankAccountManager) {
        this.bankAccountManager = bankAccountManager;
    }

    @Override
    public void run() {
        //withdraw task
        bankAccountManager.withdraw(50);
    }

    //Thread client
    public static void main(String[] args) {
        BankAccountWithdrawThread thread = new BankAccountWithdrawThread(new BankAccountManager());
        thread.start();
    }
}

