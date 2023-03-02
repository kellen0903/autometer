package com.zoctan.api.service.impl;

import com.zoctan.api.mapper.EnviromentDbMapper;
import com.zoctan.api.entity.EnviromentDb;
import com.zoctan.api.service.EnviromentDbService;
import com.zoctan.api.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author zhxina
* @date 2023/03/02
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class EnviromentDbServiceImpl extends AbstractService<EnviromentDb> implements EnviromentDbService {
@Resource
private EnviromentDbMapper enviromentDbMapper;

}
