package cn.jsnu.demo.selectFactory.selectA;

import cn.jsnu.demo.Utils;
import cn.jsnu.demo.codeFactory.Popu;
import cn.jsnu.demo.selectFactory.SelectI;

public class SelectA implements SelectI {

    Utils utils = new Utils();

    @Override
    public Popu getSelect(Popu popu) {
        popu = calUp(popu);
        popu = calSub(popu);
        return popu;
    }


    public Popu calUp(Popu popu){
        double sum = 0.0,temp;
        for(int i = 0; i < popu.indv.length; i++){
            sum += popu.indv[i].fitness;
        }
        popu.indv[0].upLim = popu.indv[0].fitness/sum;
        for(int i = 0; i < popu.indv.length - 1; i++){
            temp = popu.indv[i+1].fitness/sum;
            popu.indv[i+1].upLim = temp + popu.indv[i].upLim;
            if(popu.indv[i+1].upLim > 1.0 && i + 1 < popu.indv.length - 1){
                for (int j = 0; j < popu.indv.length; j++){
                    System.out.println("generation is:"+popu.generan + "fitness=" + popu.indv[j].fitness + "UpLim=" + popu.indv[j].upLim);
                }
                System.out.println("Error," + i + 1 + "'s upLim is greater than 1 ==================");
                return popu;
            }
        }
        popu.indv[popu.indv.length - 1].upLim = 1;
        return popu;
    }
    public Popu calSub(Popu popu){
        double rnd;
        Popu poptem = popu;

        int i,NumTemp;
        double TemFitn[] = new double[popu.indv.length];

        for(i = 0; i < popu.indv.length; i++){
            TemFitn[i] = popu.indv[i].upLim;
        }

        for(i = 0; i < popu.indv.length; i++){
            rnd = utils.ranF(0,1);
            NumTemp = utils.HalfSear(rnd,0,popu.indv.length,TemFitn);
            poptem.indv[i] = popu.indv[NumTemp];
        }

        poptem.generan = popu.generan;
        poptem.bestInd = popu.bestInd;
        popu = poptem;

        return popu;
    }


}
