import com.alibaba.fastjson.JSON
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.junit.Test

class BuilderTest {
    @Test
    fun testGson() {
        val jsonStr = "{\"a\":\"test\"}"
        val gson = GsonBuilder().create()
        println("开始:create")
        gson.fromJson(jsonStr, N1::class.java) // gson 是通过反射的实现的
        println("结束:create")

        val gson1 = Gson()
        println("开始:new")
        gson1.fromJson(jsonStr, N1::class.java)
        println("结束:new")
    }


    @Test
    fun testFastJson() {
        val jsonStr = "{\"a\":\"test\"}"
        println("开始:fastJson")
        JSON.parseObject(jsonStr, N1::class.java)  // fastJson 使用的是 set get 方法去设置值
        println("开始:fastJson")
    }

}

class N1 {
    var a = ""
        set(value) {
            println("set")
            field = value
        }
        get() {
            println("get")
            return field
        }


}