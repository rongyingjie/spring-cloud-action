package cn.gxufe.spring.cloud.provider.service;

import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BaseService<T> {

    PageInfo<T> findAll(int page , int pageSize);

    int deleteByPrimaryKey(Object key);

    int save(T recode);

    int saveSelective(T recode);

    List<T> findByRecode(T recode);

}
