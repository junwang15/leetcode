
public class BulbSwitch {
    public static int bulbSwitch(int n) {
        // This problem equals to how many squares number <= n
        return (int) Math.sqrt(n);
    }
    
    public static void main(String[] args) {
    	System.out.println(bulbSwitch(0));
    	System.out.println(bulbSwitch(1));
    	System.out.println(bulbSwitch(6));
    	System.out.println(bulbSwitch(99999999));

    }
}