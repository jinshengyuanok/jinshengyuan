package com.yuan.service.accountManager;

import com.yuan.dao.accountManager.ConsumeTypeMapper;
import com.yuan.model.accountManager.ConsumeType;
import com.yuan.model.accountManager.ConsumeTypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2019-01-31
 * Time: 15:16
 * description:
 **/
@Service
public class ConsumeTypeService {
    @Autowired
    private ConsumeTypeMapper consumeTypeMapper;

    public List<ConsumeType> selectByExample(){
        ConsumeTypeExample consumeTypeExample = new ConsumeTypeExample();
        consumeTypeExample.createCriteria().andValidFlagEqualTo("1");
        return consumeTypeMapper.selectByExample(consumeTypeExample);
    }
}
