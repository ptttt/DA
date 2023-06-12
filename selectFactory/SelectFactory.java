package cn.jsnu.demo.selectFactory;

import cn.jsnu.demo.selectFactory.selectA.SelectA;
import cn.jsnu.demo.selectFactory.selectB.SelectB;

public class SelectFactory {

    public SelectI selectSelect(int selectSelect){

        switch (selectSelect){
            case 0:return new SelectA();
            case 1:return new SelectB();
            default:return null;
        }

    }
}
