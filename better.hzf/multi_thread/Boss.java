package multi_thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * BOSS一面问题
 * 实现translate方法：调用三种翻译工具进行翻译，哪种先执行完则立即返回给客户端
 * 这个当时没想出来，还是平时不怎么用到多线程，掌握的不好
 */
public class Boss {

    public static void main(String[] args) {
        Boss boss = new Boss();
        try {
            System.out.println(boss.translate("boss"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String translate(String content) throws Exception {

        FutureTask<String>[] task = new FutureTask[3];

        task[0] = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return baidu(content);
            }
        });
        task[1] = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return google(content);
            }
        });
        task[2] = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return youdao(content);
            }
        });

        for(int i = 0; i < task.length; i++) {
            new Thread(task[i]).start();
        }

        while (true){
            for(int i = 0; i < task.length; i++) {
                if(task[i].isDone()) {
                    for(int j = 0; j < task.length; j++) {
                        task[j].cancel(true);
                    }
                    return task[i].get();
                }
            }
        }
    }

    public String baidu(String content) {
        randomSleep();
        return "baiduresult";
    }

    public String google(String content) {
        randomSleep();
        return "googleresult";
    }

    public String youdao(String content) {
        randomSleep();
        return "youdaoresult";
    }

    private void randomSleep() {
        try {
            Thread.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
