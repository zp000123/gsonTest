
class Eink {
    // 客户端操作系统版本如：LeadPie_P9_V1.3.0....
    var clientOsVersion: String? = null
    var clientVersion: String? = null
    // 序列号
    var deviceId: String? = null
    // 设备名称 LeadPieP9
    @Transient
    var deviceName: String? = null
    //  吴明学生的设备
    @Transient
    var einkName: String? = null
    // ip 地址
    @Transient
    var ipAddress: String? = null
    // mac 地址
    var macAddress: String? = null
    // 屏幕分辨率 822x1200
    var resolution: String? = null

    // 设备类型
    @Transient
    var type: String? = null
    // 用户 id
    @Transient
    var userId: String? = null
    // app 包名

    var appName: String? = null
        get() {
            return if (field.isNullOrEmpty()) {
                field = "AppUtils.getAppPackageName()"
                field
            } else field
        }


    var appVersionCode: String? = null
        get() {
            return if (field.isNullOrEmpty()) {
                field = "AppUtils.getAppVersionCode().toString()"
                field
            } else field
        }

    var appVersion: String? = null
        get() {
            return if (field.isNullOrEmpty()) {
                field = "AppUtils.getAppVersionName()"
                field
            } else field
        }

}

fun Eink.getJsonStr(): String {
    this.appName
    this.appVersion
    this.appVersionCode
    return this.toJson()
}
