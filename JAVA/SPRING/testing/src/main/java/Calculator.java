public class Calculator {
    public double add(double firstNum, double secondNum){
        return firstNum+secondNum;
    }

    public double divide(double firstNum, double secondNum){
        if(secondNum == 0){
            throw new IllegalArgumentException("Division by 0 not possible");
        }
        return firstNum/secondNum;
    }
}
