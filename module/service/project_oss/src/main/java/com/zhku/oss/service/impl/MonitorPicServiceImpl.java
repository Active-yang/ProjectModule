package com.zhku.oss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhku.commonutils.R;
import com.zhku.oss.entity.Dto.MonitorPicDto;
import com.zhku.oss.entity.MonitorPic;
import com.zhku.oss.mapper.MonitorPicMapper;
import com.zhku.oss.service.MonitorPicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wzx
 * @since 2022-09-22
 */
@Service
public class MonitorPicServiceImpl extends ServiceImpl<MonitorPicMapper, MonitorPic> implements MonitorPicService {

    @Override
    public R getAllPic(MonitorPicDto monitorPicDto) {
        QueryWrapper<MonitorPic> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(monitorPicDto.getLocation())) {
            wrapper.eq("location", monitorPicDto.getLocation());
        }
        if (!StringUtils.isEmpty(monitorPicDto.getStartTime())){
            wrapper.ge("gmt_create", monitorPicDto.getStartTime());
        }
        if (!StringUtils.isEmpty(monitorPicDto.getEndTime())){
            wrapper.le("gmt_create", monitorPicDto.getEndTime());
        }
        List<MonitorPic> picList = baseMapper.selectList(wrapper);
        return R.ok().data("picList", picList);
    }

}
