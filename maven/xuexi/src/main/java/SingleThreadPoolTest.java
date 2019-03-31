
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

    /**
     * 用多线程去处理"123", "456", "789"三个字符串，
     * 然后以"147", "258", "369"这种形式去输出，请写出代码实现
     */
    public class SingleThreadPoolTest {

        private volatile static StringBuilder builder0 = new StringBuilder();
        private volatile static StringBuilder builder1 = new StringBuilder();
        private volatile static StringBuilder builder2 = new StringBuilder();

        static class MyThread extends Thread {
            private String str;
            private CountDownLatch countDownLatch;

            public MyThread(String str, CountDownLatch countDownLatch) {
                this.str = str;
                this.countDownLatch = countDownLatch;
            }

            @Override
            public void run() {
                try {
                    builder0.append(str.charAt(0));
                    builder1.append(str.charAt(1));
                    builder2.append(str.charAt(2));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    this.countDownLatch.countDown();
                }
            }
        }

        public static void main(String[] args) throws Exception {
            ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

            CountDownLatch countDownLatch = new CountDownLatch(3);

            String str0 = "123";
            String str1 = "456";
            String str2 = "789";

            MyThread myThread0 = new MyThread(str0, countDownLatch);
            MyThread myThread1 = new MyThread(str1, countDownLatch);
            MyThread myThread2 = new MyThread(str2, countDownLatch);

            singleThreadExecutor.submit(myThread0);
            singleThreadExecutor.submit(myThread1);
            singleThreadExecutor.submit(myThread2);

            countDownLatch.await();

            System.out.println("builder0:" + builder0.toString());
            System.out.println("builder1:" + builder1.toString());
            System.out.println("builder2:" + builder2.toString());

            singleThreadExecutor.shutdown();

            singleThreadExecutor.awaitTermination(10, TimeUnit.SECONDS);

        }

    }

