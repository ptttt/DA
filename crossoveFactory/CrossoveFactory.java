package cn.jsnu.demo.crossoveFactory;

import cn.jsnu.demo.crossoveFactory.crossoveA.CrossoveA;
import cn.jsnu.demo.crossoveFactory.crossoveB.CrossoveB;

public class CrossoveFactory {

    public CrossoveI crossoveSelect(int crossoveSelect){
        switch (crossoveSelect){
            case 0:return new CrossoveA();
            case 1:return new CrossoveB();
            default:return null;
        }
    }
}
