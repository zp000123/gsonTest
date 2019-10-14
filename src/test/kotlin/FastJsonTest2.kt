import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.TypeReference
import org.junit.Test

class FastJsonTest2 {
    @Test
    fun test() {
        val str = "{ \"list\":null }"
        val objects = JSON.parseObject(str, object : TypeReference<A2>() {

        })
        println(objects)
    }
}

//data class A2(var list: List<String>? = null)

class A2 {
    var list: List<String>? = null

    override fun toString(): String {
        return "A2{" +
                "list=" + list +
                '}'.toString()
    }
}