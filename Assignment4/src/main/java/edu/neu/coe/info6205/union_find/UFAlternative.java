package edu.neu.coe.info6205.union_find;

import edu.neu.coe.info6205.GetCurrentTime;

import java.util.Random;

public class UFAlternative {

    GetCurrentTime gct = new GetCurrentTime();

    //Set an array for the value of n
    int n[] = {3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049};

    //count function running time
    int m = 1000;

    public static int count(int n) {

        UF_HWQUPC uf_hwqupc = new UF_HWQUPC(n, true);
        Random random = new Random();
        int pairs = 0;

        while(uf_hwqupc.components() != 1){

            int ran1 = random.nextInt(n);
            int ran2 = random.nextInt(n);
            pairs++;

            if(!uf_hwqupc.connected(ran1, ran2)) {
                uf_hwqupc.connect(ran1, ran2);
            }

        }

        return pairs;
    }

    public static int countgp(int n){

        WQUPC wqupc = new WQUPC(n);
        Random random = new Random();
        int pairs = 0;

        while (wqupc.count() > 1){

            int ran1 = random.nextInt(n);
            int ran2 = random.nextInt(n);

            wqupc.union(ran1, ran2);
            pairs++;
        }

        return pairs;
    }

    public void run(){


        System.out.println("After running " + m + " times.. ");


        for (int i = 0; i < n.length; i++) {

            System.out.println("The number of objects(n): " + n[i]);

            double sum = 0;
            double sumgp = 0;

            gct.start();
            for (int j = 0; j < m; j++) {

                sum += count(n[i]);

            }
            gct.end();
            sum = sum / m;


            System.out.println(" WQU The average number of pairs: "
                    + sum) ;
            System.out.println("Spend time:" + gct.getRunningTime());

            gct.start();
            for (int j = 0; j < m; j++) {

                sumgp += countgp(n[i]);
            }

            sumgp = sumgp / m;
            gct.end();

            System.out.println(" WQUPC with grandparent The average number of pairs: "
                    + sumgp) ;
            System.out.println("Spend time:" + gct.getRunningTime());

        }
    }

    public static void main(String[] args) {

        UFAlternative ufa = new UFAlternative();

        ufa.run();
    }
}