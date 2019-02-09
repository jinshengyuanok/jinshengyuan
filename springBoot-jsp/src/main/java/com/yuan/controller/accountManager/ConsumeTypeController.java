package com.yuan.controller.accountManager;

import com.yuan.model.accountManager.ConsumeType;
import com.yuan.service.accountManager.ConsumeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2019-01-31
 * Time: 15:18
 * description:
 **/
@Controller
@RequestMapping("consumeType")
public class ConsumeTypeController {
    @Autowired
    private ConsumeTypeService consumeTypeService;
    @GetMapping("/getConsumeType")
    @ResponseBody
    public List<ConsumeType> getConsumeTypeList(){
        return consumeTypeService.selectByExample();
    }
}
