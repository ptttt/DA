package cn.jsnu.demo.fitFunctionFactory;

import cn.jsnu.demo.fitFunctionFactory.oneVariableFunction.OneVariableFunction;
import cn.jsnu.demo.fitFunctionFactory.threeVariableFunction.ThreeVariableFunction;
import cn.jsnu.demo.fitFunctionFactory.twoVariableFunction.TwoVariableFunction;

public class FitFunctionFactory {


    public FitFunctionI functionTypeSelect(int functionTypeSelect){
        switch (functionTypeSelect){
            case 1:return new OneVariableFunction();
            case 2:return new TwoVariableFunction();
            case 3:return new ThreeVariableFunction();
            default:return null;
        }

    }
}
