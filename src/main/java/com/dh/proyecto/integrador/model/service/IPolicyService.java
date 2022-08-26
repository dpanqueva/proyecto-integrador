package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.PolicyDTO;

import java.util.List;

public interface IPolicyService {

    public List<PolicyDTO> findAll();

    public PolicyDTO findById(Long id);

    public PolicyDTO save(PolicyDTO policy);

    public PolicyDTO update(PolicyDTO policy, Long id);

    public PolicyDTO delete(Long id);
}
