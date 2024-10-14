package hw_08;

import java.io.*;
import java.util.Arrays;

public class B07_01 {

    public static void main(String[] args) {
        String fileinp = "src\\hw_08\\input.double";
        String fileout = "src\\hw_08\\output.double";
        
        double[] a = {1.5, 0.0, 37.3, -54.2, 23.1, 123.9, 876.0, 753.6, 423.4, 100.0, -1.1};
        write(a, fileinp);
        
        double[] b = read(fileinp);
        System.out.println(Arrays.toString(b));

        double flag = 100.0;
        double[] c = new double[b.length];
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] > flag)
                c[j++] = b[i];
        }
        double[] d = Arrays.copyOf(c, j);
        write(d, fileout);
        
        b = read(fileout);
        System.out.println(Arrays.toString(b));
    }

    public static void write(double[] array, String filename) {
        try {
            var f = new DataOutputStream( 
                new FileOutputStream(filename)
            );
            for (int i = 0; i < array.length; i++) {
                f.writeDouble(array[i]);
            }
            f.close();
        } 
        catch (IOException e) {e.printStackTrace();}
    }
    
    public static double[] read(String filename) {
        double[] array = null;
        try {
            var f = new DataInputStream( 
                new FileInputStream(filename)
            );
            File file = new File(filename);
            int size = (int) (file.length() / Double.BYTES);
            array = new double[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = f.readDouble(); 
            }
            f.close();
        } 
        catch (IOException e) {e.printStackTrace();}
        return array;
    }
}