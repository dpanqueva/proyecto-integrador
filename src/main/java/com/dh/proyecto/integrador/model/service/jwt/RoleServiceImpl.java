package com.dh.proyecto.integrador.model.service.jwt;

import com.dh.proyecto.integrador.model.dto.jwt.RoleDTO;
import com.dh.proyecto.integrador.model.entity.jwt.RoleEntity;
import com.dh.proyecto.integrador.model.repository.jwt.IRoleRepository;
import com.dh.proyecto.integrador.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private MapperUtil mapperUtil;


    @Override
    public List<RoleDTO> findAll() {
        return mapperUtil.mapAll(roleRepository.findAll(), RoleDTO.class);
    }

    @Override
    public RoleDTO findById(Long id) {
        return mapperUtil.map(roleRepository.findById(id), RoleDTO.class);
    }

    @Override
    public RoleDTO save(RoleDTO role) {
        return mapperUtil.map(roleRepository.save(mapperUtil.map(role, RoleEntity.class)), RoleDTO.class);
    }

    @Override
    public RoleDTO update(RoleDTO role, Long id) {
        RoleEntity roleUpdated = roleRepository.findById(id).orElse(null);
        if (roleUpdated == null) {
            // error
        }
        roleUpdated.setName(role.getName());
        roleUpdated.setEnable(role.getEnable());

        return mapperUtil.map(roleRepository.save(roleUpdated), RoleDTO.class);
    }

    @Override
    public RoleDTO delete(Long id) {
        RoleDTO roleDeleted = mapperUtil.map(roleRepository.findById(id), RoleDTO.class);
        roleRepository.delete(mapperUtil.map(roleDeleted, RoleEntity.class));
        return roleDeleted;
    }
}
