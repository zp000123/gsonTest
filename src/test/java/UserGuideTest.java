import com.google.common.collect.Lists;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class UserGuideTest {

    /**
     * 1
     * "abcd"
     * 10
     * [1]
     */
    @Test
    public void test01() {
        Gson gson = new Gson();
        System.out.println(gson.toJson(1));
        System.out.println(gson.toJson("abcd"));
        System.out.println(gson.toJson(new Long(10)));
        int[] values = {1};
        System.out.println(gson.toJson(values));
    }

    /**
     * {"value1":1,"value2":"abc"}
     * value3 被 transient 修饰，所以没有被序列化
     */
    @Test
    public void test02() {
        BagOfPrimitives obj = new BagOfPrimitives();
        Gson gson = new Gson();
        System.out.println(gson.toJson(obj));
    }

    /**
     * 数组实例
     */
    @Test
    public void test03() {
        Gson gson = new Gson();
        int[] ints = {1, 2, 3, 4, 5};
        String[] strings = {"abc", "def", "ghi"};
        System.out.println(gson.toJson(ints));
        System.out.println(gson.toJson(strings));
        int[] ints2 = gson.fromJson("[1,2,3,4,5]", int[].class);
        Assert.assertNotEquals(ints, ints2); // ints ，ints2 不相同
    }

    /**
     * 集合实例
     * - 可以序列化任意对象的集合，但是不能反序列化
     * - 因为用户无法指定结果对象的类型
     * - 在反序列化的时候，Collection 必须是特定的泛型
     */
    @Test
    public void test04() {
        Gson gson = new Gson();
        Collection<Integer> ints = Lists.newArrayList(1, 2, 3, 4, 5);

        // Serialization
        String json = gson.toJson(ints);
        System.out.println(json);

        // Deserialization
        Type collectionType = new TypeToken<Collection<Integer>>() {
        }.getType();
        Collection<Integer> ints2 = gson.fromJson(json, collectionType);
        System.out.println(ints2);
    }

    /**
     * 泛型
     */
    @Test
    public void test05() {
        Gson gson = new Gson();
        Foo<Bar> foo = new Foo<Bar>();
        foo.value = new Bar();

        // 序列化
        String json = gson.toJson(foo); // May not serialize foo.value correctly
        System.out.println(json);
        // 反序列化
        System.out.println("无法识别转换为 Bar 类型 : " + gson.fromJson(json, foo.getClass())); // Fails to deserialize foo.value as Bar

        Type fooType = new TypeToken<Foo<Bar>>() {
        }.getType();
        String json1 = gson.toJson(foo);
        System.out.println(gson.toJson(foo, fooType));

        Foo<Bar> obj = gson.fromJson(json1, fooType);
        System.out.println("可以识别为 Bar 类型 ： " + obj);
    }

    /**
     * 集合
     */
    @Test
    public void test06() {
        Collection collection = new ArrayList();
        collection.add("hello");
        collection.add(5);
        collection.add(new Event("GREETINGS", "guest"));
        Gson gson = new Gson();
        System.out.println(gson.toJson(collection));
    }

    /**
     * 空支持
     */
    @Test
    public void test07() {
        Gson gson = new GsonBuilder().serializeNulls().create();
        Foo2 foo = new Foo2();
        String json = gson.toJson(foo);
        System.out.println(json);
        json = gson.toJson(null);
        System.out.println(json);
    }

    /**
     * 版本支持
     */
    @Test
    public void test08() {
        VersionedClass versionedObject = new VersionedClass();
        Gson gson = new GsonBuilder().setVersion(1.0).create();
        String jsonOutput = gson.toJson(versionedObject);
        System.out.println(jsonOutput);

        gson = new Gson();
        jsonOutput = gson.toJson(versionedObject);
        System.out.println(jsonOutput);
    }

    /**
     * 导出： 默认 static 和 transient 是不会在 gson 中序列化的
     * excludeFieldsWithModifiers 重新覆盖原有的导出配置
     */
    @Test
    public void test09() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers()
                .create();
        System.out.println(gson.toJson(new TranStatic()));
    }

    /**
     * @Expose
     */
    @Test
    public void test10() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation() // 未标记为 @Expose 的字段将被排除
                .create();
        System.out.println(gson.toJson(new ExposeObj()));
    }

    /**
     * 自定义导出策略
     */
    @Test
    public void test11() {
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new MyExclusionStrategy(String.class))
                .serializeNulls()
                .create();
        SampleObjectForTest src = new SampleObjectForTest();
        String json = gson.toJson(src);
        System.out.println(json);
    }
}

class SampleObjectForTest {
    @MyAnno
    int annotatedField;
    String stringField;
    long longField;

    public SampleObjectForTest() {
        annotatedField = 5;
        stringField = "someDefaultValue";
        longField = 1234;
    }
}

/**
 * 根据 class 和 MyAno 注解进行忽略
 */
class MyExclusionStrategy implements ExclusionStrategy {
    private final Class<?> typeToSkip;

    MyExclusionStrategy(Class<?> typeToSkip) {
        this.typeToSkip = typeToSkip;
    }

    public boolean shouldSkipClass(Class<?> clazz) {
        return (clazz == typeToSkip);
    }

    public boolean shouldSkipField(FieldAttributes f) {
        return f.getAnnotation(MyAnno.class) != null;
    }
}


class ExposeObj {
    @Expose
    public int a = 9;
    public int b = 8;
}

class TranStatic {
    public transient int a = 9;
    public static int b = 8;

}

class VersionedClass {
    @Since(1.1)
    private final String newerField;
    @Since(1.0)
    private final String newField;
    private final String field;

    public VersionedClass() {
        this.newerField = "newer";
        this.newField = "new";
        this.field = "old";
    }
}

class Foo2 {
    private final String s;
    private final int i;

    public Foo2() {
        this(null, 5);
    }

    public Foo2(String s, int i) {
        this.s = s;
        this.i = i;
    }

}

class Foo<T> {
    T value;

    @Override
    public String toString() {
        return "Foo{" +
                "value=" + value +
                '}';
    }
}

class Bar {
    public String a = "aaa";

    @Override
    public String toString() {
        return "Bar{" +
                "a='" + a + '\'' +
                '}';
    }
}

class Event {
    private String name;
    private String source;

    public Event(String name, String source) {
        this.name = name;
        this.source = source;
    }
}

/**
 * - 可以完美的使用私有字段（推荐）
 * - 无需使用任何注释指示字段需要序列化和反序列化。默认所有字段都包含
 * - 如果字段笔记为 transient ,则忽略此字段，并不进行序列化和反序列化
 * - 正确的处理空值
 * - 序列化时，将从输出中跳过 null
 * - 反序列化时，json 中缺少的字段使用 null 赋值
 * - 如果字段是合成的，则会被忽略，并且不包含在序列化和反序列化中
 * - 与内部类，匿名类和本地类中的外部类对应的字段会被忽略，并不包含在序列化和反序列化中
 */
class BagOfPrimitives {
    private int value1 = 1;
    private String value2 = "abc";
    private transient int value3 = 3;

    BagOfPrimitives() {
        // no-args constructor
    }
}
