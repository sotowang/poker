import java.math.BigInteger;
public class Fibonacci{
    public static BigInteger of(int n){
	if(n<0){
	   throw new RuntimeException("非法数字");
	}
	BigInteger[] result = new BigInteger[2];
	result[0] = new BigInteger("1");
	result[1] = new BigInteger("1");
	if(n<2){
	   return result[n];	
	}
	BigInteger MinOne = new BigInteger("1");
	BigInteger MinTwo =new BigInteger("0");
	BigInteger fibN = new BigInteger("0");
	for(int i=2;i<=n;i++){
	   fibN = MinOne.add(MinTwo);
	   MinTwo = MinOne;
	   MinOne = fibN;
	}
	return fibN;
    }

    public static void main(String[] args){
        for(int i=1;i<=200;i++){
	   System.out.println(Fibonacci.of(i));  
        }


    }

}
