package cn.jsnu.demo.codeFactory;

public class Popu {

    public Indivi[] indv;
    public Indivi bestInd;
    public int generan;
    public int indvDimension;
    public int geneDimension;
    public int geneLength;

    public Popu(int indvDimension) {
        this.indv = new Indivi[indvDimension];
    }
}
