package patten.strategy;

/**
 * 具体策略
 */
public class OperationMultiply implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }

}
