package cn.jsnu.demo;

import cn.jsnu.demo.codeFactory.Popu;

import java.lang.reflect.Array;

public class Utils {

    public double ranF(int x, int y){
        double result=(double)(x)+(double)((y-x)*Math.random());
        return result;
    }

    public double dou2ZD(double x,double lowBef,double upBef, double lowAft, double upAft){
        double result = (lowAft+(x-lowBef)*(upAft-lowAft)/(upBef-lowBef));
        return result;
    }

    public int HalfSear(double value, int LowBo, int UpBo, double InA[]){
        int Mid;
        if(LowBo >= UpBo){
            return UpBo;
        }
        Mid = (LowBo + UpBo) / 2;
        if(Mid == 0){
            return 0;
        }
        if(value <= InA[Mid] && value > InA[Mid - 1]){
            return Mid;
        }else{
            if(value >= InA[Mid]){
                return HalfSear(value,Mid,UpBo,InA);
            }else{
                return HalfSear(value,LowBo,Mid,InA);
            }
        }
    }

    public Object[] convertObject(Object object,int length){
        Object[] objectArr = new Object[length];
        for(int i = 0; i < length; i++){
            objectArr[i] = Array.get(object,i);
        }
        return objectArr;
    }
}
