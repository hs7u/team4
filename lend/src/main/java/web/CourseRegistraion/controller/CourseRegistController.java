package web.CourseRegistraion.controller;

import static web.CommonUtil.projectUtil.getCode;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import web.Course.service.CourseService;
import web.Course.vo.CourseVO;
import web.CourseRegistraion.service.CourseRegistraionService;
import web.CourseRegistraion.vo.CourseRegistraionVO;
import web.CourseTimeable.service.CourseTimeableService;
import web.CourseTimeable.vo.CourseTimeableVO;
import web.Customer.vo.CustomerVO;

@RestController
public class CourseRegistController {
    @Autowired
    private CourseRegistraionService crs;
    @Autowired
    private CourseTimeableService cts;
    @Autowired
    private CourseService cs;
    @RequestMapping(path = {"/Course/regist"}, method = RequestMethod.POST)
    public void courseRegist(@RequestBody(required = false) Map<String, String> registDetail, HttpSession session) {
        CourseVO            cVo  = cs.getOneCourse(Integer.valueOf(registDetail.get("courseId")));
        CourseTimeableVO    ctVo = cts.selectByTimeableId(Integer.valueOf(registDetail.get("courseTimeableId")));
        CourseRegistraionVO crVo = new CourseRegistraionVO();
        crVo.setCustomerId(((CustomerVO)session.getAttribute("customerInfo")).getCustomerId());
        crVo.setNumOfPeople(Integer.valueOf(registDetail.get("numOfPeople")));
        crVo.setCourse(cVo);
        crVo.setTimeable(ctVo);
        Integer serNo =  (Integer)crs.registCourse(crVo);

        AioCheckOutALL obj = new AioCheckOutALL();
        obj.setMerchantTradeNo(getCode()+cVo.getCourseId()+serNo);
        obj.setMerchantTradeDate(String.valueOf(new Date(System.currentTimeMillis())));
        obj.setTotalAmount(String.valueOf(cVo.getCoursePrice()));
        obj.setTradeDesc(cVo.getCourseDescribe());
        obj.setItemName(cVo.getCourseName());
        obj.setReturnURL("http://211.23.128.214:5000");
        obj.setNeedExtraPaidInfo("Y");
        AllInOne all = new AllInOne("");
        all.aioCheckOut(obj, null);
    }
}
