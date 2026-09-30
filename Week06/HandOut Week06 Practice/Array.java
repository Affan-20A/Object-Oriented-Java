import java.util.Arrays;
public class Array implements Cloneable {
    private int[] anArray;
    private int value;

    public Array() {
        this.anArray = new int[]{1,2,3,4,5,6};
        this.value = 10;
    }

    public void increment() {
        this.value++;
        for(int i=0 ; i<this.anArray.length ; i++) {
            this.anArray[i]++;
        }
    }

    @Override
    public String toString() {
        return "Value = " + this.value + ", Array = " + Arrays.toString(this.anArray);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // @Override
    // public Object clone() throws CloneNotSupportedException {
    //     Array cloned = (Array) super.clone();
    //     cloned.anArray = this.anArray.clone();
    //     return cloned;
    // }

    public static void main(String[] args) throws CloneNotSupportedException {
        Array v1 = new Array();
        Array v2 = (Array) v1.clone();
        System.out.println("v1: " + v1);
        System.out.println("v2: " + v2);
        v2.increment();
        System.out.println("v2 after increment: " + v2);
        System.out.println("v1 after v2 increment: " + v1);
    }
}
