package cn.jsnu.demo.mutationFactory;

import cn.jsnu.demo.mutationFactory.binary.BMutationA;
import cn.jsnu.demo.mutationFactory.decimal.DMutationA;

public class MutationFactory {

    public MutationI mutationSelect(int codeSelect,int mutationSelect){

        switch (codeSelect){
            case 0:switch (mutationSelect){
                case 0:return new BMutationA();
            }
            case 1:switch (mutationSelect){
                case 0:return new DMutationA();
            }
            default:return null;
        }

    }
}
