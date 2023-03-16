package com.zoctan.api.controller;

import com.alibaba.fastjson.JSON;
import com.zoctan.api.core.response.Result;
import com.zoctan.api.core.response.ResultGenerator;
import com.zoctan.api.entity.Deployunit;
import com.zoctan.api.entity.Enviroment;
import com.zoctan.api.entity.EnviromentDb;
import com.zoctan.api.entity.Machine;
import com.zoctan.api.service.EnviromentDbService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author zhxina
 * @date 2023/03/02
 */
@RestController
@RequestMapping("/enviroment/db")
public class EnviromentDbController {
    @Resource
    private EnviromentDbService enviromentDbService;

    @PostMapping
    public Result add(@RequestBody List<EnviromentDb> enviromentDbList) {
        for (EnviromentDb enviromentDb :
                enviromentDbList) {
            Condition con = new Condition(Deployunit.class);
            con.createCriteria().andCondition("envid = " + enviromentDb.getEnvid())
                    .andCondition("name = '" + enviromentDb.getName().replace("'", "''") + "'");
            if (enviromentDbService.countByCondition(con) > 0) {
                return ResultGenerator.genFailedResult("数据库已存在");
            } else {
                enviromentDbService.save(enviromentDb);
            }
        }
        return ResultGenerator.genOkResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        enviromentDbService.deleteById(id);
        return ResultGenerator.genOkResult();
    }

    @PatchMapping
    public Result update(@RequestBody EnviromentDb enviromentDb) {
        enviromentDbService.update(enviromentDb);
        return ResultGenerator.genOkResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        EnviromentDb enviromentDb = enviromentDbService.getById(id);
        return ResultGenerator.genOkResult(enviromentDb);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<EnviromentDb> list = enviromentDbService.listAll();
        PageInfo<EnviromentDb> pageInfo = PageInfo.of(list);
        return ResultGenerator.genOkResult(pageInfo);
    }

    @GetMapping("/getdblist")
    public Result getdblist(@RequestParam long envid) {
        Condition con = new Condition(EnviromentDb.class);
        con.createCriteria().andCondition("envid = " + envid);
        List<EnviromentDb> list = enviromentDbService.listByCondition(con);
        return ResultGenerator.genOkResult(list);
    }

    @PostMapping("/testlink")
    public Result testlink(@RequestBody final Map<String, Object> param) throws SQLException {
        String ip = param.get("ip").toString();
        String port = param.get("port").toString();
        String username = param.get("username").toString();
        String pass = param.get("password").toString();
        String dbname = param.get("dbname").toString();
        String type = param.get("type").toString();

        String DBUrl = "";
        if (type.equals("mysql")) {
            DBUrl = "jdbc:mysql://";
        }
        if (type.equals("oracle")) {
            DBUrl = "jdbc:oracle://";
        }

        DBUrl = DBUrl + ip + ":" + port + "/" + dbname;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DBUrl, username, pass);//获取连接
        } catch (Exception ex) {
            return ResultGenerator.genFailedResult("连接失败,请检查连接字：" + DBUrl + " ，异常原因：" + ex.getMessage());
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return ResultGenerator.genOkResult("连接成功！");
    }
}
