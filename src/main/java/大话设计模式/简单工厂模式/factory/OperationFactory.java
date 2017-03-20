package 大话设计模式.简单工厂模式.factory;

import 大话设计模式.简单工厂模式.operations.*;

/**
 * Created by zhongym on 2017/3/20.
 */
public class OperationFactory {

    public static Operation createOperation(String operationStr){
        Operation operation =null;
        switch (operationStr){
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
        }
        return operation;
    }
}
