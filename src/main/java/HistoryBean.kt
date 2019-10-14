class HistoryBean {
    var status: Int? = 0
    var message: String? = null
    var data: List<DataBean>? = null
}

class DataBean {
    var id: String? = null
    var startTime: Long ?= 0          // 开始时间
    var endTime: Long? = 0
    var type: Int? = 0                 // 互动列表类型
    var classId: String? = null       //  教室ID
    var subject: String? = null
    var phase: String? = null
    var startLessonData: StartLessonDataBean? = null          //  上课
    var responderData: ResponderDataBean? = null              //  抢答
    var questionData: QuestionDataBean? = null                //  非抢答
    var evaluationData: EvaluationDataBean? = null            //  评价
    var stopLessonData: StopLessonDataBean? = null            //  下课
}

class StartLessonDataBean

class StopLessonDataBean

class ResponderDataBean {
    var uniqueId: String? = null
    var startTime: Long? = 0
    var endTime: Long ?= 0
    var responderTimeMap: Map<String, ResponderTimeMapBean>? = null   // 参与抢答学生名称
    var answerList: List<AnswerListBean>? = null                      // 学生回答数据
}

class ResponderTimeMapBean {
    var name: String? = null         // 学生名称
}

class AnswerListBean {
    var type: Int? = 0
    var examData: ExamDataBean? = null

}

class ExamDataBean {
    var questions: List<QuestionsBeanX>? = null
}

class AnswersBean {
    var name: String? = null
    var answerType: Int? = 0
    var isIsMe: Boolean? = false
    var penDatas: PenDatasX? = null
}

class PenDatasX {
    var packageInfo: PackageInfo? = null
}

class PackageInfo {
    var cover: String? = null
    var pages: List<Page>? = null
}

data class Page(
    val layers: List<String>?,
    val pageId: String?,
    val pageBg: String?
)


class EvaluatesBean {
    var avatar: String? = null
    var barcode: String? = null
    var classId: String? = null
    var ePadSocketId: String? = null
    var einkSocketId: String? = null
    var hwId: String? = null
    var mac: String? = null
    var macType: Int ?= 0
    var name: String? = null
    var no: Int? = 0
    var rssi: Int? = 0
    var state: Int? = 0
    var userId: String? = null
    var time: Long? = 0
    var type: Int? = 0
    var text: String? = null
    var isIsMe: Boolean? = false
}

class JoinStudentListBean {
    var avatar: String? = null
    var name: String? = null
    var userId: String? = null
}

class QuestionDataBean {
    var type: Int? = 0
    var uniqueId: String? = null
    var startTime: Long? = 0
    var endTime: Long? = 0
    var examData: ExamDataBeanX? = null
    var submitStudentIds: List<String>? = null

    class ExamDataBeanX {
        var questions: List<QuestionsBeanX>? = null
    }
}

/*
class QuestionsBean {
    var answers: List<AnswersBean>? = null
    var evaluates: List<EvaluatesBean>? = null
}*/
class QuestionsBeanX {
    var attachment: AttachmentBean? = null                  //  直播上黑板数据
    var answers: List<AnswersBeanX>? = null                 //  学生回答数据
    var evaluates: List<EvaluatesBeanX>? = null             //  学生评价
}

class EvaluatesBeanX {
    var avatar: String? = null
    var name: String? = null
    var userId: String? = null
    var time: Long? = 0
    var type: Int? = 0
    var text: String? = null
    var isIsMe: Boolean? = false
}

class JoinStudentListBeanX {
    var avatar: String? = null
    var name: String? = null
    var state: Int? = 0
    var userId: String? = null
}

class AttachmentBean {
    var id: String? = null
    var name: String? = null
    var type: Int? = 0
    var extname: String? = null
    var path: String? = null
}

class AnswersBeanX {
    var avatar: String? = null
    var name: String? = null
    var chooseData: String? = null
    var answerType: Int? = 0
    var submitTime: Long? = 0
    var isMe: Boolean? = false
    var userId: String? = null
    var penDatas: PenDatasX? = null
}

class EvaluationDataBean {
    var evaluateId: String? = null
    var time: Long ?= 0
    var evaluate_type: Int? = 0
    var evaluate_text: String? = null
    var to_students: List<ToStudentsBean>? = null
}

class ToStudentsBean {
    var userId: String? = null
    var studentName: String? = null
    var avatar: String? = null
}