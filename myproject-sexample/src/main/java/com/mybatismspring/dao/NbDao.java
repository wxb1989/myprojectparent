package com.mybatismspring.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface NbDao {
    @Select(" select  * from  t_employee ")
    List<Map<String,Object>> getEmployees ();
}
