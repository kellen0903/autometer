package com.zoctan.api.dto;

import com.zoctan.api.entity.ApiCasedata;
import com.zoctan.api.entity.Apicases;

import java.util.List;

public class ApiCasesNew {
   private Apicases apiCase;
   private List<ApiCasedata> apiCaseDataList;
//   private List<ApicasesAssert> apiCaseAssertList;

    public Apicases getApiCase() {
        return apiCase;
    }
    public void setApiCase(Apicases apiCase) {
        this.apiCase = apiCase;
    }


    public List<ApiCasedata> getApiCaseDataList() {
        return apiCaseDataList;
    }
    public void setApiCaseDataList(List<ApiCasedata> apiCaseDataList) {
        this.apiCaseDataList = apiCaseDataList;
    }
}