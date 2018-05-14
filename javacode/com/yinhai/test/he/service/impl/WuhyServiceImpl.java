package com.yinhai.test.he.service.impl;
import com.yinhai.test.he.service.WuhyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yinhai.test.he.Entity.WuhyEntity;
import org.apache.commons.beanutils.BeanUtils;
import com.evada.inno.core.enums.StatusEnum;

/**
* 描述：描述描述 服务实现层
* @author Wuhy
* @date 2018/05/14
*/
@Service
public class WuhyServiceImpl  implements WuhyService {

  



    @Override
    public WuhyEntity findEntityById(String id) throws Exception {
WuhyEntity wuhyEntity = wuhyDAO.findEntityById(id);
        return wuhyEntity;
    }

    @Override
    public WuhyEntity createWuhy(WuhyEntity wuhyEntity) throws Exception {
Wuhy wuhy = new Wuhy();
        BeanUtils.copyProperties(wuhy,wuhyEntity);
wuhy.setStatus(StatusEnum.ENABLE.toString());
wuhy = wuhyRepository.saveAndFlush(wuhy);
        return this.findEntityById(wuhy.getId());
    }

    @Override
    public WuhyEntity updateWuhy(WuhyEntity wuhyEntity)throws Exception {
Wuhy wuhy = new Wuhy();
        BeanUtils.copyProperties(wuhy,wuhyEntity);
wuhy = wuhyRepository.saveAndFlush(wuhy);
        return this.findEntityById(wuhy.getId());
    }
}