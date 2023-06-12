package cn.jsnu.demo.mutationFactory.binary;

import cn.jsnu.demo.Utils;
import cn.jsnu.demo.codeFactory.Popu;
import cn.jsnu.demo.mutationFactory.MutationI;

public class BMutationA implements MutationI {

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

        char[][] gene = (char[][]) popu.indv[i].gene;
        int r = (int) utils.ranF(0,popu.geneLength);
        for(int m = 0; m < popu.geneDimension; m++){
            if(gene[m][r] == '0'){
                gene[m][r] = '1';
            }else{
                gene[m][r] = '0';
            }
        }
        popu.indv[i].gene = gene;

        return popu;

    }
}
