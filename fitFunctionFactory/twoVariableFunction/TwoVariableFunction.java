package cn.jsnu.demo.fitFunctionFactory.twoVariableFunction;

import cn.jsnu.demo.fitFunctionFactory.FitFunctionI;

public class TwoVariableFunction implements FitFunctionI {

    double PI = 3.1415926;
    @Override
    public double fit(double[] x,int functionSelect) {
        double x1 = x[0];
        double x2 = x[1];

        switch (functionSelect){
            case 0:return 3*Math.pow((Math.pow(x1,2) - x2),2);
            default:return 0;
        }
    }
}
