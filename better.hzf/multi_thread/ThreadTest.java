package multi_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 阿里巴巴笔试题
 * 实现isAllTrue方法
 */
public class ThreadTest {

    public static class TestCheck {
        private boolean result;
        private int sleepSeconds;
        public TestCheck(boolean result, int sleepSeconds){
            this.result = result;
            this.sleepSeconds = sleepSeconds;
        }
        public Boolean getResult(){
            try {
                Thread.sleep(sleepSeconds * 1000);
            }
            catch (Exception ex){

            }
            return result;
        }
    }

    /**
     * 如果所有测试的 getResult 均为true 则返回true. 只要有一个返回false 则返回false. 尽量快.
     * @param testChecks
     * @return
     */
    public static boolean isAllTrue(TestCheck[] testChecks){

        long begin = System.currentTimeMillis();

        FutureTask<Boolean>[] futureTasks = new FutureTask[testChecks.length];
        for(int i = 0; i < testChecks.length; i++){
            final TestCheck tempTestCheck = testChecks[i];
            futureTasks[i] = new FutureTask<>(new Callable<Boolean>() {
                @Override
                public Boolean call(){
                    return tempTestCheck.getResult();
                }
            });
        }

        for(int i = 0; i < futureTasks.length; i++){
            new Thread(futureTasks[i]).start();
        }

        boolean hasAnyOneNotDone = true;
        try {
            while (hasAnyOneNotDone) {
                hasAnyOneNotDone = false;
                for (int i = 0; i < futureTasks.length; i++) {
                    if (futureTasks[i].isDone()) {
                        if(!futureTasks[i].get()) {
                            return false;
                        }
                    }else{
                        hasAnyOneNotDone = true;
                    }
                }
            }
        }catch (Exception e){

        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isAllTrue(new TestCheck[]{new TestCheck(true, 1), new TestCheck(false, 2), new TestCheck(true, 3)}));
        System.out.println(isAllTrue(new TestCheck[]{new TestCheck(true, 1), new TestCheck(true, 2), new TestCheck(true, 3)}));
    }
}
