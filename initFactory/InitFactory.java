package cn.jsnu.demo.initFactory;

import cn.jsnu.demo.codeFactory.Popu;
import cn.jsnu.demo.initFactory.binary.BinaryInitA;
import cn.jsnu.demo.initFactory.decimal.DecimalInitA;

public class InitFactory {

    public InitI init(int codeSelect,int initSelect){
        switch (codeSelect){
            case 0:
                switch (initSelect){
                    case 0:return new BinaryInitA();
                }
            case 1:
                switch (initSelect){
                    case 0:return new DecimalInitA();
                }
            default:return null;
        }

    }
}
