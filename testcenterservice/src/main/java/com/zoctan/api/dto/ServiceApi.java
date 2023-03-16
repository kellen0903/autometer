package com.zoctan.api.dto;

import com.zoctan.api.entity.Api;

import java.util.List;

public class ServiceApi {

  private String serviceName;
  private List<Api> apiList;

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public List<Api> getApiList() {
    return apiList;
  }

  public void setApiList(List<Api> apiList) {

    this.apiList = apiList;
  }

}
