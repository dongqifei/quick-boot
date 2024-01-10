package com.quick.flow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.quick.flow.entity.FlowInstance;

public interface IFlowInstanceService extends IService<FlowInstance> {

    FlowInstance selectByFlowInstanceId(String flowInstanceId);
    boolean updateStatus(String flowInstanceId, Integer status);
}