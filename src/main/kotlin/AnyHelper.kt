import com.google.gson.Gson
import com.google.gson.GsonBuilder

val gson = Gson()
/**
 * 将 Any 对象转换为 json 字符串
 */
fun Any.toJson(): String {
    val gson = GsonBuilder().serializeNulls().create()
    return gson.toJson(this)
}