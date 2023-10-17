package com.quick.modules.system.entity;

import com.quick.common.aspect.annotation.Dict;
import com.quick.common.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "数据权限")
public class SysDataRule extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(description = "菜单id")
    private String menuId;

    @Schema(description = "规则名称")
    private String ruleName;

    @Schema(description = "字段")
    private String ruleColumn;

    @Schema(description = "条件")
    private String ruleConditions;

    @Schema(description = "规则值")
    private String ruleValue;

    @Schema(description = "描述")
    private String description;

    @Dict(dictCode = "sys_data_rule_status")
    @Schema(description = "状态")
    private String status;
}