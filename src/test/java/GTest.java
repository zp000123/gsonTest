import com.google.gson.Gson;
import org.junit.Test;

public class GTest {

    @Test
    public void test(){
        Gson gson = new Gson();
        System.out.println(gson.fromJson("{\"a\":}", A.class));
    }
}

class A {
    double a;
    public A(double a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                '}';
    }
}