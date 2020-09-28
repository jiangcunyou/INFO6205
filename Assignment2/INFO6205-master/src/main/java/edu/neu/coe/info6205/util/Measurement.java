package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.simple.InsertionSort;

import java.util.function.Supplier;

public class Measurement{


    public static void main(String[] args) {

        Integer n1[] = {6,9,2,1,5,8,3,7,9};
        Integer n2[] = {1,2,3,5,6,7,8,9,9};
        Integer n3[] = {1,2,3,6,7,9,8,9,5};
        Integer n4[] = {9,9,8,7,6,5,3,2,1};

        InsertionSort<Integer> nsort = new InsertionSort<>();

        for (int i = 10; i < 100001;  i = i * 10) {

            Timer timer1 = new Timer();
            Timer timer2 = new Timer();
            Timer timer3 = new Timer();
            Timer timer4 = new Timer();

            // The whole array is random so from = 0, to = 1
            Double timrep1 = timer1.repeat(i, () -> {
                nsort.sort(n1, 0, 1);
                return null;
            });

            // The whole array is ordered so from = 0, to = 9
            Double timrep2 = timer2.repeat(i, () -> {
                nsort.sort(n2, 0, 9);
                return null;
            });

            // The array is partially-ordered so from = 0, to = 6
            Double timrep3 = timer3.repeat(i, () -> {
                nsort.sort(n3, 0, 6);
                return null;
            });

            // The whole array is reverse-ordered so from = 0, to = 1
            Double timrep4 = timer4.repeat(i, () -> {
                nsort.sort(n4, 0, 1);
                return null;
            });



            System.out.println("n = " + i + " random array sort cost            " + timrep1);
            System.out.println("n = " + i + " ordered array sort cost           " + (timrep2 - timrep1));
            System.out.println("n = " + i + " partially-ordered array sort cost " + (timrep3 - timrep2));
            System.out.println("n = " + i + " reverse-ordered array sort cost   " + (timrep4 - timrep3));
            System.out.println("==============================================");
        }

    }
}
