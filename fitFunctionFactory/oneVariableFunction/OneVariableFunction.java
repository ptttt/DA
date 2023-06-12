package cn.jsnu.demo.fitFunctionFactory.oneVariableFunction;

import cn.jsnu.demo.fitFunctionFactory.FitFunctionI;

public class OneVariableFunction implements FitFunctionI {
    double PI = 3.1415926;

    @Override
    public double fit(double[] x,int functionSelect) {
        double sumX = 0;
        for(int i = 0; i < x.length; i++){
            sumX += x[i];
        }

        switch (functionSelect){
            case 0:return sumX*Math.sin(10*PI*sumX)+2.0;
            case 1:return sumX*Math.cos(10*PI*sumX)+2.0;
        }
        return 0;
    }
}
