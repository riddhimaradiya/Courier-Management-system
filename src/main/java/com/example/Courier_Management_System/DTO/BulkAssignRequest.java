package com.example.Courier_Management_System.DTO;

import java.util.List;

public class BulkAssignRequest {
    private Long agentId;
    private List<Long> packageIds;

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public List<Long> getPackageIds() {
        return packageIds;
    }

    public void setPackageIds(List<Long> packageIds) {
        this.packageIds = packageIds;
    }
}
