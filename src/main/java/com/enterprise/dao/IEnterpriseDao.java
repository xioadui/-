package com.enterprise.dao;

import com.enterprise.entity.Enterprise;

public interface IEnterpriseDao {
    void register(Enterprise enterprise);

    Enterprise login(String entId, String password, int Identity);
}
