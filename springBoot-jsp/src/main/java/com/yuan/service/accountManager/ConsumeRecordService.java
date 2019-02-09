package com.yuan.service.accountManager;

import com.yuan.dao.accountManager.ConsumeRecordMapper;
import com.yuan.model.accountManager.ConsumeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2019-01-31
 * Time: 15:13
 * description:
 **/
@Service
public class ConsumeRecordService {
    @Autowired
    private ConsumeRecordMapper consumeRecordMapper;
    public int insertSelective(ConsumeRecord record){
        return consumeRecordMapper.insertSelective(record);
    }

    public List<ConsumeRecord> selectByCondition(Map map){
        return consumeRecordMapper.selectByCondition(map);
    }

    public int deleteConsumeRecord(String id){
        return consumeRecordMapper.deleteByPrimaryKey(id);
    }

    public int updateConsumeRecord(ConsumeRecord consumeRecord){
        return consumeRecordMapper.updateByPrimaryKeySelective(consumeRecord);
    }

    public int updateConsumeRecordByCondition(ConsumeRecord consumeRecord){
        return consumeRecordMapper.updateByPrimaryKeySelective(consumeRecord);
    }

    public List<Map<String,Object>> countByConsumeType(){
        return consumeRecordMapper.countByConsumeType();
    }

    public List<Map<String,Object>> countByYear(Map map){
        return consumeRecordMapper.countByYear(map);
    }
}
