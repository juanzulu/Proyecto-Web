package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepo;

    @Override
    public void deletebyid(Long id) {
        adminRepo.deleteById(id);
    }

    @Override
    public void update(Admin admin) {
        adminRepo.save(admin);
    }

    @Override
    public void add(Admin admin) {
        adminRepo.save(admin);
    }

    @Override
    public Admin SearchByUsername(String username) {
        return adminRepo.findByUsername(username);
    }
}
