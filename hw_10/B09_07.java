package hw_10;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class B09_07 {
    private static final int NUM_DOCTORS = 3;  // Кількість лікарів
    private static final int NUM_PATIENTS = 10; // Кількість пацієнтів
    private static final long T1 = 1500;         // Мінімальний час прибуття пацієнта (мс)
    private static final long T2 = 4500;        // Максимальний час прибуття пацієнта (мс)
    private static final long T3 = 3000;        // Мінімальний час прийому лікаря (мс)
    private static final long T4 = 9000;        // Максимальний час прийому лікаря (мс)

    public static void main(String[] args) {
        ExecutorService doctorPool = Executors.newFixedThreadPool(NUM_DOCTORS);
        Random random = new Random();

        for (int i = 1; i <= NUM_PATIENTS; i++) {
            long arrivalDelay = T1 + random.nextInt((int) (T2 - T1));
            try {
                Thread.sleep(arrivalDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int doctorId = i % NUM_DOCTORS + 1;
            long treatmentTime = T3 + random.nextInt((int) (T4 - T3));
            Patient patient = new Patient(i, doctorId, treatmentTime);
            doctorPool.submit(patient);
        }

        doctorPool.shutdown();
        try {
            doctorPool.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hospital closed for the day.");
    }

    static class Patient implements Runnable {
        private final int patientId;
        private final int doctorId;
        private final long treatmentTime;

        public Patient(int patientId, int doctorId, long treatmentTime) {
            this.patientId = patientId;
            this.doctorId = doctorId;
            this.treatmentTime = treatmentTime;
        }

        @Override
        public void run() {
            System.out.println("Patient " + patientId + " is visiting Doctor " + doctorId +
                               " and will be treated for " + treatmentTime + " ms.");
            try {
                Thread.sleep(treatmentTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Patient " + patientId + " has completed treatment by Doctor " + doctorId + ".");
        }
    }
}
