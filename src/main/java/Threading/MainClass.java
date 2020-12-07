package Threading;

import java.util.Arrays;

public class MainClass {
    static final int SIZE = 10000000;
    static final int HALF = SIZE/2;

    public static void main(String[] args) {
        methodOne(arrayNew());
        methodTwo(arrayNew());

    }

    private static float[] arrayNew(){
        float[] arr = new float[SIZE];
        Arrays.fill(arr,1);
        return arr;
    }
     private static void methodOne(float[] arr) {
        long a = System.currentTimeMillis();
         for (int i = 0; i < arr.length; i++) {
             arr[i] = (float)(arr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
         }
         System.out.println(Arrays.toString(arr));
         System.out.println("Total time methodOne: ");
         System.out.println(System.currentTimeMillis() - a);
     }


     private static void methodTwo(float[] arr) {
         System.out.println(Arrays.toString(arr));
         float[] arrOne = new float[HALF];
         float[] arrTwo = new float[HALF];
         long b = System.currentTimeMillis();
         System.arraycopy(arr,0,arrOne,0, HALF);
         System.arraycopy(arr, HALF, arrTwo, 0 , HALF);
         System.out.println(Arrays.toString(arrOne));
         System.out.println(Arrays.toString(arrTwo));
         Thread one = new Thread(new Runnable() {
             @Override
             public void run() {
                 for (int i = 0; i < arrOne.length; i++) {
                     arrOne[i] = (float)(arrOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                 }
             }
         });
         one.start();

         Thread two = new Thread(new Runnable() {
             @Override
             public void run() {
                 for (int i = 0; i < arrOne.length; i++) {
                     arrOne[i] = (float)(arrOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                 }
             }
         });
         two.start();

         try {
             one.join();
             two.join();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         System.arraycopy(arrOne, 0, arr, 0, HALF);
         System.arraycopy(arrTwo, 0 , arr, HALF, HALF);
         System.out.println(Arrays.toString(arr));
         System.out.println("New time: ");
         System.out.println(System.currentTimeMillis() - b);

     }

}
