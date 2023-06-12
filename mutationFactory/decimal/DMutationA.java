package cn.jsnu.demo.mutationFactory.decimal;

import cn.jsnu.demo.Utils;
import cn.jsnu.demo.codeFactory.Popu;
import cn.jsnu.demo.mutationFactory.MutationI;

public class DMutationA implements MutationI {
    double mutaPro = 0.1;
    Utils utils = new Utils();

    @Override
    public Popu mutation(Popu popu) {
        if(popu.generan == 100){
            mutaPro = 0.3;
        }

        for(int i = 0; i < popu.indvDimension; i++){
            if(utils.ranF(0,1) > mutaPro){
                continue;
            }else{
                popu = changeM(popu,i);
            }
        }
        return popu;
    }

    public Popu changeM(Popu popu,int i){

        double[][] gene = (double[][]) popu.indv[i].gene;
        int r = (int) utils.ranF(0,popu.geneLength);
        for(int m = 0; m < popu.geneDimension; m++){
            double mutaValue = utils.ranF(-1,1);
            gene[m][r] += mutaValue;
        }
        popu.indv[i].gene = gene;

        return popu;

    }
}
