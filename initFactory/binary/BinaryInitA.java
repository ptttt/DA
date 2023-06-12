package cn.jsnu.demo.initFactory.binary;

import cn.jsnu.demo.codeFactory.Popu;
import cn.jsnu.demo.initFactory.InitI;

public class BinaryInitA implements InitI {
    @Override
    public Popu init(Popu popu) {
        popu.generan = 0;
        for(int i = 0; i < popu.indvDimension; i++){
            char[][] gene = new char[popu.geneDimension][popu.geneLength];
            for(int j = 0; j < popu.geneDimension; j++){
                for(int k = 0; k < popu.geneLength; k++){
                    gene[j][k] = (Math.random() > 0.5 ? '1' : '0');
                }
            }
            popu.indv[i].gene = gene;
        }
        popu.bestInd = popu.indv[0];

        for(int i = 0; i < popu.indvDimension; i++){
            char[][] xxx = (char[][]) popu.indv[i].gene;
            for(int j = 0; j < xxx.length; j++){
                for(int k = 0; k < xxx[j].length; k++){
                    System.out.print(xxx[j][k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }

        return popu;
    }
}
