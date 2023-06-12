package cn.jsnu.demo.initFactory.decimal;

import cn.jsnu.demo.Utils;
import cn.jsnu.demo.codeFactory.Popu;
import cn.jsnu.demo.initFactory.InitI;

import java.util.Scanner;

public class DecimalInitA implements InitI {

    Utils utils = new Utils();
    @Override
    public Popu init(Popu popu) {

        int lowBound = 0;
        int upperBound = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("请输入初始化参数下界");
            lowBound = sc.nextInt();
            System.out.println("请输入初始化参数上界");
            upperBound = sc.nextInt();

            if(lowBound > upperBound){
                System.out.println("参数下界大于上界，请重新输入！");
            }
        }while (lowBound > upperBound);

        popu.generan = 0;
        for(int i = 0; i < popu.indvDimension; i++){
            double[][] gene = new double[popu.geneDimension][popu.geneLength];
            for(int j = 0; j < popu.geneDimension; j++){
                for(int k = 0; k < popu.geneLength; k++){
                    gene[j][k] = utils.ranF(lowBound,upperBound);
                }
            }
            popu.indv[i].gene = gene;
        }

        popu.bestInd = popu.indv[0];

        for(int i = 0; i < popu.indvDimension; i++){
            double[][] xxx = (double[][]) popu.indv[i].gene;
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
