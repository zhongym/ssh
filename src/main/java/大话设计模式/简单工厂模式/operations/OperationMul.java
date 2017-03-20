package 大话设计模式.简单工厂模式.operations;

/**
 * Created by zhongym on 2017/3/20.
 */
public class OperationMul extends Operation {
    @Override
    public double getResult() {
        return numberA  * nmuberB;
    }
}
