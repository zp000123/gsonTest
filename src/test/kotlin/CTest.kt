
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.TypeReference
import org.junit.Test

class CTest {
    val str =
       "{\"message\":\"ok\",\"data\":[{\"id\":\"690325573485989888\",\"name\":\"作业收纳\",\"categorytype\":1,\"children\":[]},{\"id\":\"695330582971813888\",\"name\":\"课堂收纳\",\"categorytype\":2,\"children\":[]},{\"id\":\"710967453324152832\",\"name\":\"a\",\"categorytype\":0,\"children\":[{\"id\":\"710967476980027392\",\"name\":\"aa\",\"categorytype\":0,\"children\":[{\"id\":\"710967511121661952\",\"name\":\"aaa\",\"categorytype\":0,\"children\":[{\"id\":\"710967547347865600\",\"name\":\"aaaa\",\"categorytype\":0,\"children\":[{\"id\":\"710967574568898560\",\"name\":\"aaaaa\",\"categorytype\":0,\"children\":[{\"id\":\"710967591325143040\",\"name\":\"a\",\"categorytype\":0,\"children\":[{\"id\":\"710967614020521984\",\"name\":\"aa\",\"categorytype\":0,\"children\":[{\"id\":\"710967632144109568\",\"name\":\"aaa\",\"categorytype\":0,\"children\":[{\"id\":\"710967665828564992\",\"name\":\"aaaa\",\"categorytype\":0,\"children\":[{\"id\":\"710967707314425856\",\"name\":\"aaaaa\",\"categorytype\":0,\"children\":[{\"id\":\"710967836507377664\",\"name\":\"f\",\"categorytype\":0,\"children\":[]},{\"id\":\"710967816177586176\",\"name\":\"e\",\"categorytype\":0,\"children\":[]},{\"id\":\"710967786943287296\",\"name\":\"d\",\"categorytype\":0,\"children\":[]},{\"id\":\"710967772707819520\",\"name\":\"c\",\"categorytype\":0,\"children\":[]},{\"id\":\"710967757591547904\",\"name\":\"b\",\"categorytype\":0,\"children\":[{\"id\":\"710967863682273280\",\"name\":\"bb\",\"categorytype\":0,\"children\":[{\"id\":\"710967896351707136\",\"name\":\"bbb\",\"categorytype\":0,\"children\":[{\"id\":\"710967928329080832\",\"name\":\"bbbb\",\"categorytype\":0,\"children\":[{\"id\":\"710967967285776384\",\"name\":\"bbbbb\",\"categorytype\":0,\"children\":[]}]}]}]}]},{\"id\":\"710967742047457280\",\"name\":\"a\",\"categorytype\":0,\"children\":[]}]}]}]}]}]}]}]}]}]}]},{\"id\":\"710195772041203712\",\"name\":\"fffc\",\"categorytype\":0,\"children\":[]},{\"id\":\"695330561522143232\",\"name\":\"fff\",\"categorytype\":0,\"children\":[]}],\"status\":\"S00000000\",\"success\":true,\"timestamp\":1572594355302}"
    val str2 = "{\"a\":\"a\",\"arr\":[]}\n"

    @Test
    fun testGson() {
        val t = str.fromJson<BaseResponse<List<FolderTree>>>()
//        val list = arrayListOf<FolderTree>()
//        fromFolderTree(t!!.data.orEmpty(), list, null)
        println(t!!.data!!.toJson())
    }

    @Test
    fun testFastJson() {
        val objects = JSON.parseObject(str, object : TypeReference<BaseResponse<List<FolderTree>>>() {})
        print(objects.data!!.toJson())
    }

    @Test
    fun testFastJson2() {
        val t = JSON.parseObject(str, object : TypeReference<BaseResponse<String>>() {})
        val arrayList = arrayListOf<FolderTree>()
        fromFolderTree(t.data.orEmpty(),arrayList,null)
        print(arrayList.toJson())
    }

}

/**
 * 文件夹 树
 */
class FolderTree {
    var categorytype: Int = 0
    var children: List<FolderTree>? = null
    // 文件夹目录 id
    var id: String = ""
    var name: String = ""
    var parent: FolderTree? = null
    override fun toString(): String {
        return "FolderTree(categorytype=$categorytype, children=$children, id='$id', name='$name')"
    }

}


class FolderTreeHelper {
    var categorytype: Int = 0
    var children: Any? = null
    var id: String = ""
    var name: String = ""
}


fun fromFolderTree(t: String, list: MutableList<FolderTree>, parent: FolderTree?) {
    val originList = t.fromJson<List<FolderTreeHelper>>()

    originList?.forEach { helper ->
        val tree = FolderTree()
        tree.id = helper.id
        tree.categorytype = helper.categorytype
        tree.name = helper.name
        val childrenStr = helper.children?.toJson()
        tree.parent = parent

        if (childrenStr != "[]" && !childrenStr.isNullOrEmpty()) {
            val childrenList = arrayListOf<FolderTree>()
            tree.children = childrenList
            fromFolderTree(childrenStr.orEmpty(), childrenList, tree)
        }
        list.add(tree)
    }
}
