import org.junit.Test

class KotlinTest {

    /***
     * gson 直接反射，不会走 get() 方法
     */
    @Test
    fun getTest() {
        val eink = Eink()
        eink.apply {
            clientOsVersion = "LeadPie_P9_V1.3.0_STU_2019081901"
            deviceId = "unknown"
            einkName = "吴明学生的设备"
        }

        println("toJson : ${eink.toJson()}")
        println("getJsonStr: ${eink.getJsonStr()}")
    }
}
