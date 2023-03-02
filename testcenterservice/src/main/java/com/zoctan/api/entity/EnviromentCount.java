package com.zoctan.api.entity;

public class EnviromentCount extends Enviroment {

    /**
     * 应用数量
     */

    private Long appnum;


    /**
     * 服务器数量
     */

    private Long machinenum;

    public Long getAppNum() {
        return appnum;
    }

    public void setAppNum(Long appcount) {
        this.appnum = appcount;
    }


    public Long getMachineNum() {
        return machinenum;
    }

    public void setMachineNum(Long machinecount) {
        this.machinenum = machinecount;
    }
}