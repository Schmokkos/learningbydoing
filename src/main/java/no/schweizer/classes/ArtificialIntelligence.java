package no.schweizer.classes;

import java.util.ArrayList;
import java.util.List;

public class ArtificialIntelligence {

    public List<Integer> nimComputer(int[] array) {
        //calcing the nimsum
        int nimsum = 0;
        for (int a:array
             ) {
            if (nimsum == 0){
                nimsum = a;
            }
            else
            nimsum = (nimsum ^ a);
        }
        //Checking for stage in the game
        int morethantwopiles = 0;
        for (int a:array
             ) {
            if (a > 1){
                morethantwopiles++;
            }
        }
        boolean lategame = (morethantwopiles <= 1);
        int max = 0;

        //Making a list (checking it twice)
        List<Integer> valg = new ArrayList<Integer>();

        //Performing action
        if (nimsum % 2 == 0 && !lategame){
            //nimsum even and not lategame
            for (int i:array
                 ) {
                if (i > max){
                    max = i;
                }
            }
            for (int i = 0; ;i++){
                if (array[i] == max){
                    valg.add(0,i);
                    valg.add(1,2);
                    System.out.println("Nimsum: "+nimsum+". Lategame: "+lategame+"");
                    return valg;
                }
            }
        }
        else if (nimsum % 2 != 0 && !lategame){
            //nimsum odd and not lategame
            for (int i = 0; ;i++){
                if (array[i] >= 2){
                    valg.add(0,i);
                    valg.add(1,1);
                    System.out.println("Nimsum: "+nimsum+". Lategame: "+lategame+"");
                    return valg;
                }
            }
        }
        else if (nimsum % 2 == 0 && lategame){
            //nimsum even and lategame
            for (int i = 0;i < array.length;i++){
                if (array[i] >= 2){
                    valg.add(0,i);
                    valg.add(1,array[i]);
                    System.out.println("Nimsum: "+nimsum+". Lategame: "+lategame+"");
                    return valg;
                }
            }
        }
        //assuming nimsum odd and lategame
        for (int i = 0;i < array.length;i++){
            if (array[i] >= 2){
                valg.add(0,i);
                valg.add(1,array[i]-1);
                System.out.println("Nimsum: "+nimsum+". Lategame: "+lategame+"");
                return valg;
            }
        }
        for (int i = 0; ;i++){
            if (array[i] == 1){
                valg.add(0,i);
                valg.add(1,1);
                System.out.println("Nimsum: "+nimsum+". Lategame: "+lategame+"");
                return valg;
            }
        }
    }
}
