package com.yinhai.test.he.service;
import com.yinhai.sysframework.service.BaseService;


/**
* 描述：描述描述 服务接口
* @author Wuhy
* @date 2018/05/14
*/
public interface WuhyService extends BaseService {

    WuhyEntity findWuhyById(String id)throws Exception;
    WuhyEntity createWuhy(WuhyEntity wuhyEntity) throws Exception;
    void deleteWuhy(String id) throws Exception;
    WuhyEntity updateWuhy(WuhyEntity wuhyEntity) throws Exception;

}