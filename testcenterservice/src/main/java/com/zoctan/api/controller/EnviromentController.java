package com.zoctan.api.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zoctan.api.core.response.Result;
import com.zoctan.api.core.response.ResultGenerator;
import com.zoctan.api.entity.*;
import com.zoctan.api.service.DeployunitService;
import com.zoctan.api.service.EnviromentDbService;
import com.zoctan.api.service.EnviromentService;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Zoctan
 * @date 2020/04/18
 */
@RestController
@RequestMapping("/enviroment")
public class EnviromentController {
    @Resource
    private EnviromentService enviromentService;

    @Resource
    private DeployunitService deployunitService;

    @Resource
    private EnviromentDbService enviromentDbService;

    @PostMapping
    public Result add(@RequestBody final Map<String, Object> param) {
        Integer projectId = Integer.parseInt(param.get("projectid").toString());
        String strEnvid = param.get("id").toString();
        String envName = param.get("enviromentname").toString();
        String envDesc = param.get("memo").toString();

        Condition con = new Condition(Enviroment.class);
        con.createCriteria().andCondition("projectid = " + projectId)
                .andCondition("enviromentname = '" + envName.replace("'", "''") + "'");
        if (enviromentService.ifexist(con) > 0) {
            return ResultGenerator.genFailedResult("环境名称已存在");
        } else {
            Enviroment enviroment = new Enviroment();
            enviroment.setProjectid(projectId.longValue());
            enviroment.setEnviromentname(envName);
            enviroment.setMemo(envDesc);

            if (strEnvid.equals("")) {
                enviromentService.save(enviroment);
            } else {
                Integer intEnvId = Integer.parseInt(strEnvid);
                enviroment.setId(intEnvId.longValue());
                enviromentService.update(enviroment);
            }
        }
        return ResultGenerator.genOkResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        enviromentService.deleteById(id);
        return ResultGenerator.genOkResult();
    }

    @PatchMapping
    public Result update(@RequestBody Enviroment enviroment) {
        enviromentService.update(enviroment);
        return ResultGenerator.genOkResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        Enviroment enviroment = enviromentService.getById(id);
        return ResultGenerator.genOkResult(enviroment);
    }

    @GetMapping("/getenviromentnum")
    public Result getenviromentnum(@RequestParam long projectid) {
        Integer enviromentnum = enviromentService.getenviromentnum(projectid);
        return ResultGenerator.genOkResult(enviromentnum);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Enviroment> list = enviromentService.listAll();
        PageInfo<Enviroment> pageInfo = PageInfo.of(list);
        return ResultGenerator.genOkResult(pageInfo);
    }

    @GetMapping("/ens")
    public Result listall(@RequestParam long projectid) {
        Condition con = new Condition(Enviroment.class);
        con.createCriteria().andCondition("projectid = " + projectid);
        List<Enviroment> list = enviromentService.listByCondition(con);
//        List<Enviroment> list = enviromentService.listAll();
        return ResultGenerator.genOkResult(list);
    }

    /**
     * 更新自己的资料
     */
    @PutMapping("/detail")
    public Result updateDeploy(@RequestBody final Enviroment dic) {
        Condition con = new Condition(Enviroment.class);
        con.createCriteria().andCondition("projectid = " + dic.getProjectid())
                .andCondition("enviromentname = '" + dic.getEnviromentname().replace("'", "''") + "'").andCondition("id <> " + dic.getId());
        if (enviromentService.ifexist(con) > 0) {
            return ResultGenerator.genFailedResult("环境名已经存在");
        } else {

            this.enviromentService.updateEnviroment(dic);
            return ResultGenerator.genOkResult();
        }
    }

    /**
     * 输入框查询
     */
    @GetMapping("/getenvlist")
    public Result search(@RequestParam long projectid) {

        Condition con = new Condition(Enviroment.class);
        con.createCriteria().andCondition("projectid = " + projectid);
        List<Enviroment> list = enviromentService.listByCondition(con);
        List<EnviromentCount> enviromentCounts = new ArrayList<EnviromentCount>();

        for (Enviroment enviroment : list) {
            Integer appNum = deployunitService.getappnum(enviroment.getId());
            Integer machineNum = deployunitService.getmachinenum(enviroment.getId());
            EnviromentCount enviromentCount = new EnviromentCount();
            enviromentCount.setId(enviroment.getId());
            enviromentCount.setEnviromentname(enviroment.getEnviromentname());
            enviromentCount.setMemo(enviroment.getMemo());
            enviromentCount.setAppNum(appNum.longValue());
            enviromentCount.setMachineNum(machineNum.longValue());

            enviromentCounts.add(enviromentCount);
        }
        return ResultGenerator.genOkResult(enviromentCounts);


//        Integer page= Integer.parseInt(param.get("page").toString());
//        Integer size= Integer.parseInt(param.get("size").toString());
//        PageHelper.startPage(page, size);
//        final List<Enviroment> list = this.enviromentService.findEnviromentWithName(param);
//        final PageInfo<Enviroment> pageInfo = new PageInfo<>(list);
//        return ResultGenerator.genOkResult(pageInfo);
    }

    /**
     * 复制环境
     */
    @GetMapping("/copy")
    public Result copy(@RequestParam long id) {
        Enviroment enviroment = enviromentService.getById(id);
        enviroment.setId(null);
        enviroment.setEnviromentname(enviroment.getEnviromentname()+" 复制 " + enviromentService.listAll().size());
        enviromentService.save(enviroment);


        Condition con = new Condition(Deployunit.class);
        con.createCriteria().andCondition("envid = " + id);
        List<Deployunit> deployunitList = deployunitService.listByCondition(con);

        if(deployunitList.size()>0){
            for (Deployunit deployunit : deployunitList) {
                deployunit.setEnvid(enviroment.getId());
                deployunit.setId(null);
            }
            deployunitService.save(deployunitList);
        }


        con = new Condition(EnviromentDb.class);
        con.createCriteria().andCondition("envid = " + id);
        List<EnviromentDb> enviromentDbList = enviromentDbService.listByCondition(con);
        if(enviromentDbList.size()>0){
            for (EnviromentDb enviromentDb : enviromentDbList) {
                enviromentDb.setEnvid(enviroment.getId());
                enviromentDb.setId(null);
            }
            enviromentDbService.save(enviromentDbList);
        }
        return ResultGenerator.genOkResult();
    }
}
