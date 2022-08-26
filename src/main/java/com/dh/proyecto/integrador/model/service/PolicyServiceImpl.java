package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.PolicyDTO;
import com.dh.proyecto.integrador.model.entity.PolicyEntity;
import com.dh.proyecto.integrador.model.repository.IPolicyRepository;
import com.dh.proyecto.integrador.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements IPolicyService {

    @Autowired
    private IPolicyRepository policyRepository;
    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public List<PolicyDTO> findAll() {
        return mapperUtil.mapAll(policyRepository.findAll(), PolicyDTO.class);
    }

    @Override
    public PolicyDTO findById(Long id) {
        return mapperUtil.map(policyRepository.findById(id), PolicyDTO.class);
    }

    @Override
    public PolicyDTO save(PolicyDTO policy) {
        return mapperUtil.map(policyRepository.save(mapperUtil.map(policy, PolicyEntity.class)), PolicyDTO.class);
    }

    @Override
    public PolicyDTO update(PolicyDTO policy, Long id) {
        PolicyEntity cityUpdated = policyRepository.findById(id).orElse(null);
        if (cityUpdated == null) {
            // error
        }
        cityUpdated.setName(policy.getName());
        cityUpdated.setDescription(policy.getDescription());
        cityUpdated.setInvoice(policy.getInvoice());
        return mapperUtil.map(policyRepository.save(cityUpdated), PolicyDTO.class);
    }

    @Override
    public PolicyDTO delete(Long id) {
        PolicyDTO cityDeleted = mapperUtil.map(policyRepository.findById(id), PolicyDTO.class);
        policyRepository.delete(mapperUtil.map(cityDeleted, PolicyEntity.class));
        return cityDeleted;
    }
}
