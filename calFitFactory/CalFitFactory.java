package cn.jsnu.demo.calFitFactory;

import cn.jsnu.demo.calFitFactory.binary.BinaryCalFitA;
import cn.jsnu.demo.calFitFactory.decimal.DecimalCalFitA;

public class CalFitFactory {

    public CalFitI calFitSelect(int codeSelect,int calFitSelect){

        switch (codeSelect){
            case 0:switch (calFitSelect){
                case 0:return new BinaryCalFitA();
            }
            case 1:switch (calFitSelect){
                case 0:return new DecimalCalFitA();
            }
            default:return null;
        }

    }
}
