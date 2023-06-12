package cn.jsnu.demo.calFitFactory.decimal;

import cn.jsnu.demo.calFitFactory.CalFitI;
import cn.jsnu.demo.codeFactory.Popu;
import cn.jsnu.demo.fitFunctionFactory.FitFunctionFactory;
import cn.jsnu.demo.fitFunctionFactory.FitFunctionI;

public class DecimalCalFitA implements CalFitI {

    @Override
    public Popu calFit(Popu popu,int functionSelect) {
        FitFunctionFactory fitFunctionFactory = new FitFunctionFactory();
        FitFunctionI fitFunctionI = fitFunctionFactory.functionTypeSelect(popu.geneDimension);
        for (int i = 0; i < popu.indvDimension; i++){
            popu.indv[i].x = new double[popu.geneDimension];
            double[][] gene = (double[][]) popu.indv[i].gene;
            for(int j = 0; j < popu.geneDimension; j++){
                double sumX = 0;
                for(int k = 0; k < popu.geneLength; k++){
                    sumX += gene[j][k];
                }
                popu.indv[i].x[j] =sumX;
            }
            popu.indv[i].fitness = fitFunctionI.fit(popu.indv[i].x,functionSelect);
        }
        return popu;
    }
}
