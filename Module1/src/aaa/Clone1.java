package aaa;

/**
 * Created by zuruzirou on 2013/07/23.
 */
public class Clone1 implements Cloneable {
    @Override
    public Clone1 clone (){
        System.out.println("gogo");
        return new Clone1();
    }
}
