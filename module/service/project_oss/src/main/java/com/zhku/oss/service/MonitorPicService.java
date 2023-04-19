package com.zhku.oss.service;

import com.zhku.commonutils.R;
import com.zhku.oss.entity.Dto.MonitorPicDto;
import com.zhku.oss.entity.MonitorPic;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wzx
 * @since 2022-09-22
 */
public interface MonitorPicService extends IService<MonitorPic> {

    /**
     * 获取所有监控图片信息
     * @param monitorPicDto 条件对象
     * @return 所有图片信息
     */
    R getAllPic(MonitorPicDto monitorPicDto);
}
