package 大话设计模式.策略模式.strategies;

/**
 * Created by zhongym on 2017/3/20.
 */
public class IntermediateMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double booksPrice) {
        return booksPrice * 0.8;
    }
}
