package be.pxl.ja.h9_multithreading.Talker;

import java.util.Objects;

public class Talker extends Thread {

    private final String ID;

    public Talker(String id) {
        this.ID = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread with id " + ID + ". Count " + i);
            try {
//                if (Objects.equals(ID, "ID1")) {
//                    sleep(1000);
//                } else {
                    sleep(500);
//                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Talker talker = new Talker("ID1");
        Talker talker2 = new Talker("ID2");
        Talker talker3 = new Talker("ID3");
        Talker talker4 = new Talker("ID4");

        talker.start();
        talker2.start();
        talker3.start();
        talker4.start();

        talker.join();
        talker2.join();
        talker3.join();
        talker4.join();

        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)/1000);

    }
}
