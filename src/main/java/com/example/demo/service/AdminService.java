package com.example.demo.service;

import com.example.demo.entity.Admin;

public interface AdminService {

    public void deletebyid(Long id);

    public void update(Admin admin);

    public void add(Admin admin);

    public Admin SearchByUsername(String username);
    
    
}
