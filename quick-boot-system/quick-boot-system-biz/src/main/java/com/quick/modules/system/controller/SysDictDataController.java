package com.quick.modules.system.controller;


import com.quick.common.aspect.annotation.PreAuth;
import com.quick.common.controller.SuperController;
import com.quick.modules.system.entity.SysDictData;
import com.quick.modules.system.service.ISysDictDataService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/SysDictData")
@RequiredArgsConstructor
@Tag(name = "字典数据信息")
@PreAuth(replace = "SysDictData:")
public class SysDictDataController extends SuperController<ISysDictDataService, SysDictData, String> {

}
