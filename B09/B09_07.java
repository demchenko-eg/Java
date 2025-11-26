import java.util.*;
import java.util.concurrent.*;

class Doctor {
    int id;
    int time;
    boolean busy = false;

    public Doctor(int id, int time) {
        this.id = id;
        this.time = time;
    }
}

public class B09_07 {
    public static void main(String[] args) throws Exception {
        int N = 3;
        int patients = 20;
        int T1 = 300;
        int T2 = 800;
        int T3 = 500;
        int T4 = 1500;

        Random rnd = new Random();
        List<Doctor> docs = new ArrayList<>();
        for (int i = 0; i < N; i++)
            docs.add(new Doctor(i, T3 + rnd.nextInt(T4 - T3 + 1)));

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        ExecutorService pool = Executors.newFixedThreadPool(patients);

        for (int i = 0; i < patients; i++) {
            Thread.sleep(T1 + rnd.nextInt(T2 - T1 + 1));
            int pid = i;

            pool.submit(() -> {
                try {
                    queue.put(pid);
                } catch (Exception e) {}
            });
        }

        Thread dispatcher = new Thread(() -> {
            try {
                while (true) {
                    int patient = queue.take();
                    Doctor d = null;
                    while (d == null) {
                        for (Doctor doc : docs)
                            if (!doc.busy) { d = doc; break; }
                        if (d == null) Thread.sleep(50);
                    }
                    d.busy = true;
                    Doctor dd = d;

                    new Thread(() -> {
                        try {
                            Thread.sleep(dd.time);
                            dd.busy = false;
                        } catch (Exception e) {}
                    }).start();
                }
            } catch (Exception e) {}
        });

        dispatcher.start();
        Thread.sleep(10000);
        pool.shutdownNow();
        dispatcher.stop();
    }
}