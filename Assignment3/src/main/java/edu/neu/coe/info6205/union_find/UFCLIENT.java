package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UFCLIENT {

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

    public static void main(String[] args) {

        //Set an array for the value of n
        int n[] = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536};

        //count function running time
        int m = 1000;

        System.out.println("After running " + m + " times.. ");

        for (int i = 0; i < n.length; i++) {
            
            double sum = 0;

            for (int j = 0; j < m; j++) {

                sum += count(n[i]);
            }

            sum = sum / m;

            System.out.println("The number of objects(n): " + n[i] +
                    " the average number of connections generated(m): "
                    + sum) ;

            System.out.println("The function calculate the data is: " + n[i] * 0.53 * Math.log(n[i])
                    + " compare with sum the ratio is: " + sum / (n[i] * 0.53 * Math.log(n[i])));
        }
    }
}