package ${package_name}.controller;
import com.yinhai.webframework.BaseAction;
import  ${package_name}.service.impl.${table_name_small!}Service;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* 描述：${table_annotation!}控制层
* @author ${author!}
* @date ${date!}
*/
@Controller
@RequestMapping("/${table_name_small!}")
public class ${table_name!}Controller extends BaseAction{

    @Resource(name = "${table_name_small!}Service")
    private ${table_name!}Service ${table_name_small!}Service;

    /**
     * 页面
     * @return 页面地址
     */
    @RequestMapping("/to${table_name!}Index.do")
    public String toExaminationJsp(){
        return "${jsp_file_path!}/${table_name_small!}/index";
    }

    /**
     * 获取所有考试信息
     * @return List
     */
    @RequestMapping("/toExaminationJsp!getAllExamInfo.do")
    public String getAllExamInfo(){
        List<Map<String, Object>> allExamInfo = examinationCountService.getAllExamInfo();
        setList("exam_dg" , allExamInfo);
        return JSON;
    }


    /**
     * 获取所有学习信息
     * @return List
     */
    @RequestMapping("/toExaminationJsp!getAllStudyInfo.do")
    public String getAllStudyInfo(){
        List<Map<String, Object>> allStudyInfo = examinationCountService.getAllStudyInfo();
        setList("study_dg" , allStudyInfo);
        return JSON;
    }

    /**
     * 跳转到查看考试详情页面
     * @return 考试详情页面
     */
    @RequestMapping("/toExaminationJsp!toExamWin.do")
    public String toExamWin(){
        setData("paper_id" , getDto().getAsString("paper_id"));
        return "zhjg/examination/count/examWin";
    }

    /**
     * 跳转到查看学习详情页面
     * @return 学习详情页面
     */
    @RequestMapping("/toExaminationJsp!toStudyWin.do")
    public String toStudyWin(){
        setData("course_id" , getDto().getAsString("course_id"));
        return "zhjg/examination/count/studyWin";
    }

    /**
     * 考试图形
     * @return 数据
     */
    @RequestMapping("/toExaminationJsp!getExamCompletedPieData.do")
    public String getExamCompletedPieData(){
        setData("exam" , examinationCountService.getExamCompletedPieData(getDto().getAsString("paper_id")));
        return JSON;
    }

    /**
     * 试卷试题的正确率排序
     * @return String
     */
    @RequestMapping("/toExaminationJsp!getExamQuestionOrder.do")
    public String getExamQuestionOrder(){
        Map<String,List<Map<String,Object>>> questionOrderInfo =  examinationCountService.getExamQuestionOrder(getDto().getAsString("paper_id"));
        setList("top10" , questionOrderInfo.get("top10"));
        setList("last10" , questionOrderInfo.get("last10"));
        return JSON;
    }

    /**
     * 显示试题详情
     * @return String
     */
    @RequestMapping("/toExaminationJsp!showQuestion.do")
    public String showQuestion(){
        setData("question" , examinationCountService.showQuestion(getDto().getAsString("question_id") , getDto().getAsString("paper_id")));
        return JSON;
    }

    /**
     * 获取试卷考试情况
     * @return String
     */
    @RequestMapping("/toExaminationJsp!getExamUserPaperInfo.do")
    public String getExamUserPaperInfo(){
        setList("exam_user_score_dg" , examinationCountService.getExamUserPaperInfo(getDto().getAsString("paper_id")));
        return JSON;
    }

    @RequestMapping("/toExaminationJsp!showPaper.do")
    public String showPaper(){
        setData("paper" , examinationCountService.getUserPaper(getDto().getAsString("paper_id") , getDto().getAsString("user_id")));
        return JSON;
    }

    /**
     * 获取试卷未完成的参考这信息
     * @return String
     */
    @RequestMapping("/toExaminationJsp!getNoFinishedUserInfo.do")
    public String getNoFinishedUserInfo(){
        setList("no_finish_dg" , examinationCountService.getNoFinishedUserInfo(getDto().getAsString("paper_id")));
        return JSON;
    }

    @RequestMapping("/toExaminationJsp!getCourseComplete.do")
    public String getCourseComplete(){
        Map<String, Object> result = examinationCountService.getCourseComplete(getDto().getAsString("course_id"));
        setList("study_complete_dg" , (List<Map<String,Object>>)result.get("list"));
        setData("complete" , result.get("complete"));
        return JSON;
    }

    /**
     * 获取课程的文件信息
     * @return String
     */
    @RequestMapping("/toExaminationJsp!getCourseFileInfo.do")
    public String getCourseFileInfo(){
        setData("file" , examinationCountService.getCourseFileInfo(getDto().getAsString("course_id")));
        return JSON;
    }

}
