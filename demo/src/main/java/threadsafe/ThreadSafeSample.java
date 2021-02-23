package threadsafe;


public class ThreadSafeSample {
    public int sharedState;
    public void nonSafeAction() {
        while (sharedState < 10000000) {
            int former = sharedState++;
            int latter = sharedState;
            if (former != latter - 1) {
                System.out.printf("Observed data race, former is " +
                        former + ", " + "latter is " + latter);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeSample sample = new ThreadSafeSample();
        Thread threadA = new Thread(){
            public void run(){
                sample.nonSafeAction();
            }
        };
        Thread threadB = new Thread(){
            public void run(){
                sample.nonSafeAction();
            }
        };
        threadA.start();
//        threadA.start();
        threadB.start();
        System.out.println("ii");
//        threadA.join();
        System.out.println("ii");
//        threadB.join();
        System.out.println("ii");
    }
}