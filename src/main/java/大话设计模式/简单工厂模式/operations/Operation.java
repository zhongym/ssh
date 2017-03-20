package 大话设计模式.简单工厂模式.operations;

/**
 * Created by zhongym on 2017/3/20.
 */
public abstract class Operation {
    protected double numberA;
    protected double nmuberB;

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNmuberB() {
        return nmuberB;
    }

    public void setNmuberB(double nmuberB) {
        this.nmuberB = nmuberB;
    }

    public abstract double getResult();
}
