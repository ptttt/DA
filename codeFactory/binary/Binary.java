package cn.jsnu.demo.codeFactory.binary;

import cn.jsnu.demo.codeFactory.CodeI;
import cn.jsnu.demo.codeFactory.Indivi;
import cn.jsnu.demo.codeFactory.Popu;

public class Binary implements CodeI {

    @Override
    public Popu getPopu(int indvDimension,int geneDimension,int geneLength) {

        Popu popu = new Popu(indvDimension);
        popu.indvDimension = indvDimension;
        popu.geneDimension = geneDimension;
        popu.geneLength = geneLength;
        for(int i = 0; i < indvDimension; i++){
            popu.indv[i] = new Indivi();
            char[][] gene = new char[geneDimension][geneLength];
            popu.indv[i].gene = gene;
        }
        return popu;
    }
}
