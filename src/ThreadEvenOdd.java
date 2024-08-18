public class ThreadEvenOdd implements Runnable{
    Object o;
    static int count = 1;
    ThreadEvenOdd(Object obj){
        this.o = obj;
    }
    public static void main(String[] args){
        Object o = new Object();
        Runnable r1 = new ThreadEvenOdd(o);
        Runnable r2 = new ThreadEvenOdd(o);
        new Thread(r1, "Even").start();;
        new Thread(r2, "Odd").start();
    }

    @Override
    public void run() {
        while(count <= 15){
            if(count % 2 == 0 && Thread.currentThread().getName().equals("Even")){
                synchronized(o){
                    System.out.println("Thread Name" +Thread.currentThread()+ ": value: " +count);
                    count++;
                    try {
                        o.wait();

                    }catch(InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
            if(count % 2 != 0 && Thread.currentThread().getName().equals("Odd")){
                synchronized(o){
                    System.out.println("Thread Name" +Thread.currentThread()+ ": value: "+count);
                    count++;
                    o.notify();
                }
            }
        }
    }
}
