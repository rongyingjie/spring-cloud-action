package cn.gxufe.spring.cloud.provider.service.impl;


import cn.gxufe.spring.cloud.provider.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    protected Mapper<T> mapper ;

    @Override
    public PageInfo<T> findAll(int page ,int pageSize){
        PageHelper.startPage(page, pageSize);
        List<T> list = mapper.selectAll();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    @Override
    public int save(T recode) {
        return mapper.insert(recode);
    }

    @Override
    public int saveSelective(T recode) {
        return mapper.insertSelective(recode);
    }

    @Override
    public List<T> findByRecode(T recode) {
        return mapper.select(recode);
    }


}
