import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ASCIISum2
{
    private Map<Integer, Integer> basicValues;

    public ASCIISum2()
    {
        basicValues = new HashMap<Integer, Integer>();

        for(Integer i = 1; i < 10; ++i)
            basicValues.put(i, eval(i));
    }

    public int findValue(int x)
    {
        Integer i = (Integer) basicValues.get(x);
        return i;
    }
    
    public int getASCIIValue(char c)
    {
        int value = c;
        return value;
    }

    public int evalString(String value)
    {
        char[] contents = value.toCharArray();
        int sum = 0;

        for(char c: contents)
        {
            sum += getASCIIValue(c);
        }

        return sum;
    }

    public int total(long N)
    {
        int finalSum = 0;
        int mod = (int)((10E+9)+7);

        N = N % mod;
        
        for(int i = 1; i <= N; i++)
        {
            finalSum += eval(i);
        }

        return finalSum;
    }

    public int eval(int x)
    {
        int res = evalString(Integer.toString(x));
        int sum = 0;
        
        if(x != res)
            sum += eval(res);
        else
            sum = res;

        return sum;
    }

    public static void main(String[] args)
    {
        ASCIISum2 a = new ASCIISum2();
        
        for(int i = 0; i < 10; ++i)
            System.out.println(i + ": " + a.findValue(i));
    }
}
