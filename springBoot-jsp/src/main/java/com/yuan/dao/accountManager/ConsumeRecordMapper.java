package com.yuan.dao.accountManager;

import com.yuan.model.accountManager.ConsumeRecord;
import com.yuan.model.accountManager.ConsumeRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ConsumeRecordMapper {
    long countByExample(ConsumeRecordExample example);

    int deleteByExample(ConsumeRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(ConsumeRecord record);

    int insertSelective(ConsumeRecord record);

    List<ConsumeRecord> selectByExample(ConsumeRecordExample example);

    ConsumeRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ConsumeRecord record, @Param("example") ConsumeRecordExample example);

    int updateByExample(@Param("record") ConsumeRecord record, @Param("example") ConsumeRecordExample example);

    int updateByPrimaryKeySelective(ConsumeRecord record);

    int updateByPrimaryKey(ConsumeRecord record);

    List<ConsumeRecord> selectByCondition(Map map);

    List<Map<String,Object>> countByConsumeType();

    List<Map<String,Object>> countByYear(Map map);
}