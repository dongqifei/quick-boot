package com.quick.modules.online.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "请求参数校验配置")
public class Request implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "是否为 DEBUG: 0-否，1-是。")
    private int debug;

    /**
     * GET,HEAD可用任意结构访问任意开放内容，不需要这个字段。
     * 其它的操作因为写入了结构和内容，所以都需要，按照不同的version选择对应的structure。
     *
     * 自动化版本管理：
     * Request JSON最外层可以传  “version”:Integer 。
     * 1.未传或 <= 0，用最新版。 “@order”:”version-“
     * 2.已传且 > 0，用version以上的可用版本的最低版本。 “@order”:”version+”, “version{}”:”>={version}”
     */
    @Schema(description = "版本")
    private int version;

    @Schema(description = "标签")
    private String tag;

    @Schema(description = "结构")
    private String structure;

    @Schema(description = "详细说明")
    private String detail;

    @Schema(description = "创建时间")
    private LocalDateTime date;

}