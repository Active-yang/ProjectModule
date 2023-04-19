package com.zhku.oss.entity.Dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 吴梓轩
 * @since 2022.09.23
 */
@Data
public class MonitorPicDto {

    /**
     * 所在监控位置
     */
    private String location;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String endTime;

}
