package com.enterprise.service;

import com.enterprise.entity.Enterprise;

public interface EnterpriseService {
    public String register(Enterprise enterprise);

    public Enterprise login(String entId, String entPassword, int entIdentity);
}
