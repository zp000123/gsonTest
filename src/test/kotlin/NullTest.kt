import org.junit.Test

class NullTest {
    @Test
    fun test(){
        val list = arrayListOf<String>()
        println(list.getOrNull( 0))
        val map = mutableMapOf<String,Any>()
        println(map["z"])
    }
}