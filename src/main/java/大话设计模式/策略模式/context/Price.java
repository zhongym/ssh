package 大话设计模式.策略模式.context;

import 大话设计模式.策略模式.strategies.MemberStrategy;

/**
 * Created by zhongym on 2017/3/20.
 */
public class Price {
    private MemberStrategy memberStrategy;

    public Price(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    public double calcPrice(double price){
        return memberStrategy.calcPrice(price);
    }
}
