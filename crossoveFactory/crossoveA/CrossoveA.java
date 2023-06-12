package cn.jsnu.demo.crossoveFactory.crossoveA;

import cn.jsnu.demo.Utils;
import cn.jsnu.demo.codeFactory.Popu;
import cn.jsnu.demo.crossoveFactory.CrossoveI;

import java.lang.reflect.Array;

public class CrossoveA implements CrossoveI {
    double crossPro = 0.9;
    Utils utils = new Utils();
    @Override
    public Popu crossove(Popu popu) {
        int j,k;
        for(int i = 0; i < popu.indv.length / 2; i++){
            if(utils.ranF(0,1) > crossPro);
            else{
                j = (int) utils.ranF(0,popu.indv.length);
                utils.ranF(0,1);
                k = (int) utils.ranF(0,popu.indv.length);
                Object[] jGene = (Object[]) popu.indv[j].gene;
                Object[] kGene = (Object[]) popu.indv[k].gene;
                for(int l = 0; l < popu.geneDimension; l++){
                    Object temp;
                    Object[] jTemp = utils.convertObject(jGene[l],popu.geneLength);
                    Object[] kTemp = utils.convertObject(kGene[l],popu.geneLength);
                    int m = (int) utils.ranF(1,popu.geneLength - 1);
                    for(; m < popu.geneLength; m++){
                        temp = jTemp[m];
                        jTemp[m] = kTemp[m];
                        kTemp[m] = temp;
                    }
                }
                popu.indv[j].gene = jGene;
                popu.indv[k].gene = kGene;
            }
        }
        return popu;
    }



}
