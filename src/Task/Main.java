package Task;


import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Vector2D vec1 = new Vector2D(1,2 ,4,2);
        Vector2D vec2 = new Vector2D(3,7 ,1,0);

        Semaphore sem = new Semaphore(1);


        Thread t1 = new Thread(() -> {
            vec2.addToThis(vec1);
            try {
                sem.acquire();
                System.out.println("addToThis:");
                System.out.println("vec2 - x1: " + vec2.getX1());
                System.out.println("vec2 - y1: " + vec2.getY1());
                System.out.println("vec2 - x2: " + vec2.getX2());
                System.out.println("vec2 - y2: " + vec2.getY2());
                sem.release();
            }catch (InterruptedException e){
                e.getMessage();
            }
        });

        Thread t2 = new Thread(() -> {
            // One of use case
            Vector2D vecTmp = vec1.add(vec2);
            try {
                sem.acquire();
                System.out.println("\nadd vector1 to vector2:");
                System.out.println("tmp - x1: " + vecTmp.getX1());
                System.out.println("tmp - y1: " + vecTmp.getY1());
                System.out.println("tmp - x2: " + vecTmp.getX2());
                System.out.println("tmp - y2: " + vecTmp.getY2());
                sem.release();
            }catch (InterruptedException e){
                e.getMessage();
            }
        });

        t1.start();
        t2.start();
    }
}
