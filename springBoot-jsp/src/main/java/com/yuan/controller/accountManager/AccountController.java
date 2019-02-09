package com.yuan.controller.accountManager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuan.model.accountManager.ConsumeRecord;
import com.yuan.service.accountManager.ConsumeRecordService;
import com.yuan.utils.CommonsUtil;
import com.yuan.utils.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2019-01-17
 * Time: 21:06
 * description:
 **/
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private ConsumeRecordService consumeRecordService;

    /**
     * 查询消费记录
     * @param pageNum 当前页码
     * @return
     */
    @GetMapping("/accountInit")
    public ModelAndView accountInit(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        //查询前传入页码及每页显示的记录
        PageHelper.startPage(pageNum,ConstantUtil.PAGESIZE);
        //PageHelper.startPage(pageNum,10);后面紧跟的查询就是一个分页查询
        List<ConsumeRecord> consumeRecordList = consumeRecordService.selectByCondition(null);
        PageInfo pageInfo = new PageInfo(consumeRecordList,ConstantUtil.NAVIGATEPAGES);//连续显示5页信息
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("accountAdd");
        return modelAndView;
    }

    /**
     * 每日一记_新增
     * @param consumeRecord
     * @return
     */
    @RequestMapping(value = "/addAccount",method = RequestMethod.POST)
    public String addAccount(ConsumeRecord consumeRecord){
        consumeRecord.setId(CommonsUtil.getLowerUUID());
        if(consumeRecord.getCreateDatetime() == null){
            consumeRecord.setConsumeDate(new Date());
        }else{
            consumeRecord.setConsumeDate(CommonsUtil.strTimeToDateTime(consumeRecord.getCreateDatetime()));
        }
        consumeRecord.setUserId(CommonsUtil.getLoginUserInfo().getId());
        consumeRecordService.insertSelective(consumeRecord);
        return "redirect:accountInit";
        //return new ModelAndView("accountAdd");
    }

    /**
     * 根据id删除记录(物理删除)
     * @param id
     * @return
     */
    @PostMapping(value = "/deleteAccount")
    public String deleteAccount(@RequestParam(value = "id")String id){
        consumeRecordService.deleteConsumeRecord(id);
        return "redirect:accountInit";
    }

    /**
     * 根据id删除记录(逻辑删除)
     * @return
     */
    @PostMapping(value = "/deleteAccountLogic")
    public String deleteAccountByCondition(@RequestParam(value = "id")String id){
        ConsumeRecord consumeRecord = new ConsumeRecord();
        consumeRecord.setId(id);
        consumeRecord.setValidFlag("0");
        consumeRecordService.updateConsumeRecordByCondition(consumeRecord);
        return "redirect:accountInit";
    }

    @GetMapping(value = "/countByConsumeType")
    @ResponseBody
    public List<Map<String,Object>> countByConsumeType(){
        return consumeRecordService.countByConsumeType();
    }

    @GetMapping(value = "/countByYear")
    @ResponseBody
    public List<Map<String,Object>> countByYear(@RequestParam("year") String year){
        Map<String,Object> map = new HashMap<>();
        map.put("year",year);
        return consumeRecordService.countByYear(map);
    }
}
