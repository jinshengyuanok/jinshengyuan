package com.yuan.dao.accountManager;

import com.yuan.model.accountManager.ConsumeType;
import com.yuan.model.accountManager.ConsumeTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsumeTypeMapper {
    long countByExample(ConsumeTypeExample example);

    int deleteByExample(ConsumeTypeExample example);

    int deleteByPrimaryKey(String consumeTypeCode);

    int insert(ConsumeType record);

    int insertSelective(ConsumeType record);

    List<ConsumeType> selectByExample(ConsumeTypeExample example);

    ConsumeType selectByPrimaryKey(String consumeTypeCode);

    int updateByExampleSelective(@Param("record") ConsumeType record, @Param("example") ConsumeTypeExample example);

    int updateByExample(@Param("record") ConsumeType record, @Param("example") ConsumeTypeExample example);

    int updateByPrimaryKeySelective(ConsumeType record);

    int updateByPrimaryKey(ConsumeType record);
}