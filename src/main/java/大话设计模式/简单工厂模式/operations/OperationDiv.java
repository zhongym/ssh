package 大话设计模式.简单工厂模式.operations;

/**
 * Created by zhongym on 2017/3/20.
 */
public class OperationDiv extends Operation {
    @Override
    public double getResult() {
        if(nmuberB == 0){
            throw new RuntimeException("除数不能为0");
        }
        return numberA / nmuberB;
    }
}
