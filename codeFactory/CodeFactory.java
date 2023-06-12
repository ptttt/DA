package cn.jsnu.demo.codeFactory;

import cn.jsnu.demo.codeFactory.binary.Binary;
import cn.jsnu.demo.codeFactory.decimal.Decimal;

public class CodeFactory {

    public CodeI codeSelect(int codeSelect){
        switch (codeSelect){
            case 0:return new Binary();
            case 1:return new Decimal();
            default:return null;
        }
    }
}
