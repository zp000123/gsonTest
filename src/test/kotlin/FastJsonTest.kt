
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.TypeReference
import org.junit.Test


class FastJsonTest {
    val str = "{\n" +
            "    \"message\": \"ok\",\n" +
            "    \"data\": {\n" +
            "        \"wrongBookId\": \"683514013589442560\",\n" +
            "        \"versionId\": \"1570756838142\",\n" +
            "        \"syncResult\": [\n" +
            "            {\n" +
            "                \"localWrongExamId\": \"703264411220971520\",\n" +
            "                \"serverWrongExamId\": \"703264487427280896\",\n" +
            "                \"syncType\": 0,\n" +
            "                \"syncDatetime\": 1570755459616,\n" +
            "                \"examData\": {\n" +
            "                    \"examId\": \"703264486236098560\",\n" +
            "                    \"phaseId\": null,\n" +
            "                    \"designModelCode\": 5,\n" +
            "                    \"answerModelCode\": 5,\n" +
            "                    \"examTypeCode\": \"000006\",\n" +
            "                    \"examTypeName\": \"手抄题\",\n" +
            "                    \"examImageUrl\": \"http://file.magicpie.com/upload/exam/794/f/15/9c27f52fd401000/4e13fa97ea0.png\",\n" +
            "                    \"examStem\": null,\n" +
            "                    \"solution\": null,\n" +
            "                    \"phaseName\": null,\n" +
            "                    \"subjectName\": null,\n" +
            "                    \"zipFileName\": null,\n" +
            "                    \"tagList\": [],\n" +
            "                    \"examInputList\": [\n" +
            "                        {\n" +
            "                            \"examInputId\": \"703264486257070080\",\n" +
            "                            \"subexamSeq\": 1,\n" +
            "                            \"examInputType\": 5,\n" +
            "                            \"sequence\": 1,\n" +
            "                            \"choiceCount\": 0,\n" +
            "                            \"haveAnswer\": false,\n" +
            "                            \"isObjective\": 0,\n" +
            "                            \"answerContent\": \"\",\n" +
            "                            \"rectList\": []\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"examDocList\": [],\n" +
            "                    \"solutionDocList\": null,\n" +
            "                    \"wrongBookExamId\": \"703264487427280896\",\n" +
            "                    \"wrongBookId\": \"683514013589442560\",\n" +
            "                    \"subjectId\": \"XK_01\",\n" +
            "                    \"masterFlag\": 0,\n" +
            "                    \"makeFrom\": 0,\n" +
            "                    \"fromObjId\": null,\n" +
            "                    \"localWrongExamId\": \"703264411220971520\",\n" +
            "                    \"createDatetime\": 1570755467000,\n" +
            "                    \"updateDatetime\": 1570755460000\n" +
            "                }\n" +
            "            },\n" +
            "            {\n" +
            "                \"localWrongExamId\": \"703270196957155328\",\n" +
            "                \"serverWrongExamId\": \"703270288036466688\",\n" +
            "                \"syncType\": 0,\n" +
            "                \"syncDatetime\": 1570756838142,\n" +
            "                \"examData\": {\n" +
            "                    \"examId\": \"703270286392299520\",\n" +
            "                    \"phaseId\": null,\n" +
            "                    \"designModelCode\": 5,\n" +
            "                    \"answerModelCode\": 5,\n" +
            "                    \"examTypeCode\": \"000006\",\n" +
            "                    \"examTypeName\": \"手抄题\",\n" +
            "                    \"examImageUrl\": \"http://file.magicpie.com/upload/exam/794/f/2d/9c2849971801000/4e1424cb8c0.png\",\n" +
            "                    \"examStem\": null,\n" +
            "                    \"solution\": null,\n" +
            "                    \"phaseName\": null,\n" +
            "                    \"subjectName\": null,\n" +
            "                    \"zipFileName\": null,\n" +
            "                    \"tagList\": [],\n" +
            "                    \"examInputList\": [\n" +
            "                        {\n" +
            "                            \"examInputId\": \"703270286409076736\",\n" +
            "                            \"subexamSeq\": 1,\n" +
            "                            \"examInputType\": 5,\n" +
            "                            \"sequence\": 1,\n" +
            "                            \"choiceCount\": 0,\n" +
            "                            \"haveAnswer\": false,\n" +
            "                            \"isObjective\": 0,\n" +
            "                            \"answerContent\": \"\",\n" +
            "                            \"rectList\": []\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"examDocList\": [],\n" +
            "                    \"solutionDocList\": null,\n" +
            "                    \"wrongBookExamId\": \"703270288036466688\",\n" +
            "                    \"wrongBookId\": \"683514013589442560\",\n" +
            "                    \"subjectId\": \"XK_01\",\n" +
            "                    \"masterFlag\": 0,\n" +
            "                    \"makeFrom\": 0,\n" +
            "                    \"fromObjId\": null,\n" +
            "                    \"localWrongExamId\": \"703270196957155328\",\n" +
            "                    \"createDatetime\": 1570756850000,\n" +
            "                    \"updateDatetime\": 1570756838000\n" +
            "                }\n" +
            "            },\n" +
            "            {\n" +
            "                \"localWrongExamId\": null,\n" +
            "                \"serverWrongExamId\": null,\n" +
            "                \"syncType\": 3,\n" +
            "                \"syncDatetime\": null,\n" +
            "                \"examData\": null\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"status\": \"S00000000\",\n" +
            "    \"timestamp\": 1570756850371,\n" +
            "    \"success\": true\n" +
            "}"


    @Test
    fun test() {
        val obj = JSON.parseObject(str, object : TypeReference<BaseResponse<SyncResponse>>() {})
        print(obj)
    }
}
class BaseResponse<T> {
    /**
     * @see SPContants
     * S00000000 表示正常
     */
    var status: String = ""
    var message: String? = null
    var data: T? = null
}
/**
 * 错题本同步后返回的数据
 */
 class SyncResponse{
    var wrongBookId: String? = null
    var versionId: String? = null
    var syncResult: List<SyncExamInfo>? = null
    override fun toString(): String {
        return "SyncResponse(wrongBookId=$wrongBookId, versionId=$versionId, syncResult=$syncResult)"
    }

}



/**
 * 错题同步后的信息
 */
data class SyncExamInfo(
    var localWrongExamId: String? = null,//本地错题Id
    var serverWrongExamId: String? = null,//服务端错题Id （需要Eink新增或修改的，单独取这个Id去下载错题包）
    var syncType: Int? = null,//同步类型,0:服务端新增返回的映射数据，1：新增，2：更新，3:删除
    var syncDatetime: Long? = null,//同步日期（本地）
    var examData: WrongExam? = null
)


data class WrongExam(
    var id: Long = 0,
    var wrongBookExamId: String? = null,//错题id
    var wrongBookId: String? = null,//错题本id
    var examId: String? = null,//试题id
    var subjectId: String? = null,//学科id
    var subjectName: String? = null,//学科名称
    var phaseId: String? = null,//学段id
    var phaseName: String? = null,//学段名称
    var answerModelCode: Int = 0,//[暂时不用,取examInputType]试题答题框类型。1:是非题 2:单选题 3:多选题 4:填空题 5:解答题 6:英语作文题 7:英语填空题 8:语文作文题,81:连线题，82:找一找，83:排序，97：口语朗读
    var designModelCode: Int = 0,//题型答题模板code。1：是非题，2：单选题，3：多选题，4：填空题，5：问答题，6：匹配题，7：排序题，8：比较题，10：上传题，11：作图题，12：选词填空，13：完型填空，97：口语朗读，98：听力，99：综合题。
    var zipFileName: String? = null,//zip文件名
    var examStem: String? = null,//题干数据（html）
    var examTypeCode: String? = null,//试题类型code
    var examTypeName: String? = null,//试题类型名
    var fromObjId: String? = null,//错题来源id，1：taskId
    var localWrongExamId: String? = null,//本地错题ID
    var makeFrom: Int = 0,//错题来源，0：自建错题，1：来自于作业
    var masterFlag: Int = 0,//是否已掌握标志。0：未掌握，1：已掌握
    var solution: String? = null,//试题解析
    var createDatetime: Long = 0,//加入错题时间
    var updateDatetime: Long = 0,//错题更新时间
    var examImageUrl: String? = null,//试题图片地址
    var sequence: Int = 0,//显示顺序
    var deleteFlag: Int = 0,// 1:该错题被删除
    var examInputList: List<WrongExamInput>? = null,//小题列表
    var examDocList: List<ExamDoc>? = null,//试题附件列表（比如听力的音频）
    var solutionDocList: List<ExamDoc>? = null//解析附件列表
//    var tagList: List<ExamTag>? = null//标签列表
)


class ExamDoc(
    /** 转换状态(0:未转换,1:转换成功,<0:转换失败) */
    var convertStatus: Int? = 0,
    /** 文件封面地址 */
    var coverUrl: String? = null,
    /** 文档id */
    var docId: String? = null,
    /** 文档名称 */
    var docName: String? = null,
    /** 文档类型。99：其他，1：文档，2：视频，3：音频，4：图片，5：思维导图，6：Geogebra数学动图，7：笔记，8：板书 */
    var docType: Int? = 0,
    /** 文件后缀名 */
    var fileExtendName: String? = null,
    /** 文件ID */
    var fileId: String? = null,
    /** 文件大小 */
    var fileSize: Int? = null,
    /** 文件类型 */
    var fileType: Int? = null,
    /** 文件播放地址 */
    var fileUrl: String? = null,
    /** 源文件地址 */
    var originUrl: String? = null,
    /** 访问权限。1：可读，2：可写，4：可分享，8：可下载 */
    var priority: Int? = null,
    /** 是否在作业中使用标识。0：未使用，1：已使用 */
    var taskFlag: Int? = null,
    /** 时间 */
    var updateDatetime: Long? = null,
    /** 创建人 */
    var userId: String? = null,
    /** 是否在课堂中使用标识。0：未使用，1：已使用 */
    var xclassFlag: Int? = null
)

data class WrongExamInput(
    /** 选择题的选择数量 */
    var choice: Int? = null,
    /** 试题id */
    var examId: String? = null,
    /** 输入框id */
    var examInputId: String? = null,
    /** 题号 */
    var examNum: String? = null,
    /** 试题类型code */
    var examTypeCode: String? = null,
    /** 试题类型名 */
    var examTypeName: String? = null,
    /** 试卷试题框id */
    var exampaperExamId: String? = null,
    /** 试卷id */
    var exampaperId: String? = null,
    /** 正确答案 */
    var rightAnswer: String? = null,
    /** 分数 */
    var score: Double? = null,
    /** 序号 */
    var sequence: Int? = 0,
    /** 试题输入框所属小题题号  */
    var subexamSeq: Int? = 0,
    /** 1：是非题 2：单选题 3：多选题 4：填空题 5：简答题 6：首字母填空（英语）7：翻译题（中译英）8：英语作文题 9：翻译题（英译中）10：语文作文题 11：作图题 12：选词填空 13：完型填空 81：连线题/匹配题 82：找一找 83：排序 97：口语朗读 98：听力 99：综合题 100：阅读四选一 71:听力-是非 72:听力-单选 73:听力-多选 74:听力-填空 75:听力-听选 61:口语-其他' **/
    var designModelCode: Int = 0,
    /** 试题答题框类型，1:是非题 2:单选题 3:多选题 4:填空题 5:解答题 6:英语作文题 7:英语填空题 8:语文作文题,81:连线题，82:找一找，83:排序，97：口语朗读 */
    var examInputType: Int = 0,
    /** 1：是非题 2：单选题 3：多选题 4：填空题 5：简答题 6：首字母填空（英语）7：翻译题（中译英）8：英语作文题 9：翻译题（英译中）10：语文作文题 11：作图题 81：连线题/匹配题 82：找一找 83：排序 97：口语朗读 98：听力 99：综合题', **/
    var answerModelCode: Int = 0,

    var answerContent: String? = null,

    var answerImage: String? = null,
    /** 选择题的数量 （分析数据中） **/
    var choiceCount: Int? = 0,

    var knowledgePointIdList: List<String?>? = null,
    var isObjective: Int? = 0 // 0 ：主观题 1： 客观题
)  {
    // 只有一个小题： 1  多个小题：2.1 2.2
    var examInputNum: String? = null

    /** 选择题 */
    val isSelectExam get() = examInputType in arrayOf(1, 2, 3, 98, 71, 72, 73)
    val isRecordExam get() = designModelCode in arrayOf(61, 97)

    /** 小题的位置 和 选项内容 **/
    @Transient
    var inputRectList: List<InputRect>? = null
    @Transient
    var answerWrap: AnswerWrap? = null
}


data class AnswerWrap(
    var answerContent: String? = null,
    var examInputId: String,
    var examId: String,
    var examInputType: Int? = 0, // 试题答题框类型，1:是非题 2:单选题 3:多选题 4:填空题 5:解答题 6:英语作文题 7:英语填空题 8:语文作文题,81:连线题，82:找一找，83:排序，97：口语朗读
    var rectType: Int? = 0, // 标引框类型 1选项框 2下拉框 3是非框 4连线框外框 5标记框外框 6书写框 41连线框内标记 51标记框标记
    var isAnswered: Int = 0, // 是否答题 ， 主要用于主观题
    var pageIndex: Int = 0,  // 从 1..
    /** 是否正确。0：未批，-1：错误，1：正确，2：半对 **/
    var isRight: Int = 0,
    var localFilePath: String? = null,
    val examInputNum: String = ""
)


class InputRect(
    /** 试题id */
    var examId: String = "",
    var examInputId: String = "",
    /** 试卷id */
    var exampaperId: String = "",
    /** 标引框id */
    var exampaperRectId: String = "",
    var examInputRectId: String = "",
    /** 高度 */
    var height: Int = 0,
    /** 相对页面左上角绝对定位 左边距 */
    var left: Int = 0,
    /** 页号 */
    var pageIndex: Int? = 0,
    /** 父标引框id，连线框或者标记框内的标记用 */
    var parentRectId: Long? = 0,
    /** 标引框内容，如选项名称A、B、C、D，下拉框内容[{\"value\":\"one\",\"key\":\"A\"},{\"value\":\"two\",\"key\":\"B\"}]等 */
    var rectContent: String? = null,
    /** 同组内顺序*/
    var rectSequence: Int? = 0,
    /** 标引框样式，连线框标记框内的标记用 c1:实心圆，c0:空心圆，t1:实心三角形，t0:空心三角形 */
    var rectStyle: String? = null,
    /** 暂时无用，用外接矩形算*/
    var rectStyleData: String? = null,
    /** 标引框类型 1选项框 2下拉框 3是非框 4连线框外框 5标记框外框 6书写框 41连线框内标记 51标记框标记 */
    var rectType: Int = 0,
    /** 相对页面左上角绝对定位 上边距 */
    var top: Int = 0,
    /** 宽度*/
    var width: Int = 0
)