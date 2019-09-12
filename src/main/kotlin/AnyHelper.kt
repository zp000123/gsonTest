import com.google.gson.Gson

val gson = Gson()
/**
 * 将 Any 对象转换为 json 字符串
 */
fun Any.toJson(): String {
    return gson.toJson(this)
}