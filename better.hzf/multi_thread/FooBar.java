package multi_thread;

import java.util.concurrent.Semaphore;

/**
 * 1115. Print FooBar Alternately
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 */
public class FooBar {

    private int n;

    private final Semaphore fooSema = new Semaphore(1);
    private final Semaphore barSema = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            fooSema.acquire();

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();

            barSema.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            barSema.acquire();

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();

            fooSema.release();
        }
    }
}
