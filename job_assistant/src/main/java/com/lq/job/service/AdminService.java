package com.lq.job.service;

import com.lq.job.domain.Admin;

public interface AdminService {
    public Admin findOneAdmin(Admin admin);
    public int changeAdminPwd(String newPassword);
}
