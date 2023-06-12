package cn.jsnu.demo;

import cn.jsnu.demo.calFitFactory.CalFitFactory;
import cn.jsnu.demo.calFitFactory.CalFitI;
import cn.jsnu.demo.codeFactory.CodeFactory;
import cn.jsnu.demo.codeFactory.CodeI;
import cn.jsnu.demo.codeFactory.Popu;
import cn.jsnu.demo.crossoveFactory.CrossoveFactory;
import cn.jsnu.demo.crossoveFactory.CrossoveI;
import cn.jsnu.demo.initFactory.InitFactory;
import cn.jsnu.demo.initFactory.InitI;
import cn.jsnu.demo.mutationFactory.MutationFactory;
import cn.jsnu.demo.mutationFactory.MutationI;
import cn.jsnu.demo.selectFactory.SelectFactory;
import cn.jsnu.demo.selectFactory.SelectI;

import java.util.Scanner;

public class GA {

    public void gaAlgorithm(){


        Scanner sc = new Scanner(System.in);
        System.out.println("请选择编码：");
        int codeSelect = sc.nextInt();
        CodeFactory codeFactory = new CodeFactory();
        CodeI codeI = codeFactory.codeSelect(codeSelect);

        //System.out.println("请输入个体的维度");
        int indvDimension = 6;
        System.out.println("请输入基因的个数：");
        int geneDimension = sc.nextInt();
        System.out.println("请输入基因长度：");
        int geneLength = sc.nextInt();

        //System.out.println("请输入fitness上界：");
        double fitnessUpper = sc.nextInt();
        System.out.println("请输入进化次数：");
        int generanUpper =sc.nextInt();

        Popu popu = codeI.getPopu(indvDimension,geneDimension,geneLength);

        //System.out.println("请选择初始化方式：");
        int initSelect = 0;
        InitFactory initFactory = new InitFactory();
        InitI initI = initFactory.init(codeSelect,initSelect);
        popu = initI.init(popu);

        //System.out.println("请选择calFit：");
        int calFitSelect =0;
        //System.out.println("请选择适应度函数：");
        int functionSelect = 0;
        //System.out.println("选择的方式：");
        int selectSelect = 0;
        //System.out.println("交叉的方式：");
        int crossoveSelect = 0;
        //System.out.println("变异的方式：");
        int mutationSelect = 0;

        //计算适应度
        CalFitFactory calFitFactory = new CalFitFactory();
        CalFitI calFitI = calFitFactory.calFitSelect(codeSelect,calFitSelect);//根据编码选择calFit
        popu = calFitI.calFit(popu,functionSelect);

        popu.bestInd = popu.indv[0];
       // popu.bestInd = popu.indv[0];
        popu = max(popu);
        System.out.println("The generation is " + popu.generan++ + ",the best fitness is " + popu.bestInd.fitness);
        while(popu.bestInd.fitness <= fitnessUpper && popu.generan < generanUpper){   //3.85027

            Object tempGene = popu.bestInd.gene;
            double tempFitness = popu.bestInd.fitness;

            //选择 选择的方式
            SelectFactory selectFactory = new SelectFactory();
            SelectI selectI = selectFactory.selectSelect(selectSelect);
            popu = selectI.getSelect(popu);

            //选择交叉的方式
            CrossoveFactory crossoveFactory = new CrossoveFactory();
            CrossoveI crossoveI = crossoveFactory.crossoveSelect(crossoveSelect);
            popu = crossoveI.crossove(popu);

            System.out.println("after cross");

            //选择变异的方式
            MutationFactory mutationFactory = new MutationFactory();
            MutationI mutationI = mutationFactory.mutationSelect(codeSelect,mutationSelect);
            popu = mutationI.mutation(popu);

            //计算适应度
            popu = calFitI.calFit(popu,functionSelect);

            if(popu.bestInd.fitness < tempFitness){
                popu.bestInd.fitness = tempFitness;
                popu.bestInd.gene = tempGene;
            }

            if(popu.indv[0].fitness < tempFitness){
                popu.indv[0].fitness = tempFitness;
                popu.indv[0].gene = tempGene;
            }

            //将fitness最大的放在bestInd中
            popu = max(popu);

            System.out.println("The generation is " + popu.generan++ + ",the best fitness is " + popu.bestInd.fitness);


        }


//        do {
//
//            Object tempGene = popu.bestInd.gene;
//            double tempFitness = popu.bestInd.fitness;
//
//            //计算适应度
//            popu = calFitI.calFit(popu,functionSelect);
//            System.out.println(popu.bestInd.fitness);
//            //将fitness最大的放在bestInd中
//            popu = max(popu);
//            System.out.println("The generation is " + popu.generan++ + ",the best fitness is " + popu.bestInd.fitness);
//
//            //选择 选择的方式
//            SelectFactory selectFactory = new SelectFactory();
//            SelectI selectI = selectFactory.selectSelect(selectSelect);
//            popu = selectI.getSelect(popu);
//            System.out.println(popu.bestInd.fitness);
//
//            //选择交叉的方式
//            CrossoveFactory crossoveFactory = new CrossoveFactory();
//            CrossoveI crossoveI = crossoveFactory.crossoveSelect(crossoveSelect);
//            popu = crossoveI.crossove(popu);
//            System.out.println(popu.bestInd.fitness);
//
//            //选择变异的方式
//            MutationFactory mutationFactory = new MutationFactory();
//            MutationI mutationI = mutationFactory.mutationSelect(codeSelect,mutationSelect);
//            popu = mutationI.mutation(popu);
//            System.out.println(popu.bestInd.fitness);
//
//            popu.indv[0] = popu.bestInd;
//            System.out.println(popu.bestInd.fitness);
//        }while(popu.bestInd.fitness <= 3.85027 && popu.generan < 10000);
//        System.out.println("finished");

    }




    Popu max(Popu popu){
//        double temp = popu.indv[0].fitness;
//        int j = 0;
//        for(int i = 0; i < popu.indvDimension; i++){
//            if(popu.indv[i].fitness > temp){
//                temp = popu.indv[i].fitness;
//                j = i;
//            }
//        }
//        popu.bestInd = popu.indv[j];

        for(int i = 0; i < popu.indv.length; i++){
            if(popu.bestInd.fitness < popu.indv[i].fitness){
                popu.bestInd = popu.indv[i];
            }
        }
        return popu;
    }




}
