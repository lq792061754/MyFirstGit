package com.lq.job.mapper;

import com.lq.job.domain.Admin;

public interface AdminMapper {
    public Admin findOneAdmin(Admin admin);
    public int changeAdminPwd(String newPassword);
}
