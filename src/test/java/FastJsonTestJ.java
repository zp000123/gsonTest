import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import java.util.List;

public class FastJsonTestJ {
    @Test
    public void test() {
        String str = "{ \"list\":null }";
        D objects = JSON.parseObject(str, new TypeReference<D>() {
        });
        System.out.println(objects);
    }
}

class D {
    List<String> list = null;

    @Override
    public String toString() {
        return "D{" +
                "list=" + list +
                '}';
    }
}