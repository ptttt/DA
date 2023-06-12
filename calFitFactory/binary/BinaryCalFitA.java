package cn.jsnu.demo.calFitFactory.binary;

import cn.jsnu.demo.Utils;
import cn.jsnu.demo.calFitFactory.CalFitI;
import cn.jsnu.demo.codeFactory.Popu;
import cn.jsnu.demo.fitFunctionFactory.FitFunctionFactory;
import cn.jsnu.demo.fitFunctionFactory.FitFunctionI;
public class BinaryCalFitA implements CalFitI {
    Utils utils = new Utils();
    @Override
    public Popu calFit(Popu popu,int functionSelect) {
        FitFunctionFactory fitFunctionFactory = new FitFunctionFactory();
        FitFunctionI fitFunctionI = fitFunctionFactory.functionTypeSelect(popu.geneDimension);
        for (int i = 0; i < popu.indvDimension; i++){
            popu.indv[i].x = new double[popu.geneDimension];
            char[][] gene = (char[][]) popu.indv[i].gene;
            for(int j = 0; j < popu.geneDimension; j++){
                popu.indv[i].x[j] = utils.dou2ZD(bin2dou(gene[j]),0,Math.pow(2,popu.geneLength)-1,-1,2);
            }
            popu.indv[i].fitness = fitFunctionI.fit(popu.indv[i].x,functionSelect);
        }
        return popu;
    }

    long bin2dou(char[] bp){
        int i,tem;
        long retuV=0;
        for(i=0;i < bp.length; i++){
            if(bp[i] == '0'){
                tem = 0;
            }else{
                tem = 1;
            }
            retuV = retuV + tem*(int)Math.pow(2,bp.length-i-1);
        }
        return retuV;
    }
}
