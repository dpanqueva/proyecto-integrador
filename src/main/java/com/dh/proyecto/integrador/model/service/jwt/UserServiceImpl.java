package com.dh.proyecto.integrador.model.service.jwt;

import com.dh.proyecto.integrador.model.dto.jwt.UserDTO;
import com.dh.proyecto.integrador.model.entity.jwt.UserEntity;
import com.dh.proyecto.integrador.model.repository.jwt.IUserRepository;
import com.dh.proyecto.integrador.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public UserDTO findByEmail(String email) {
        return mapperUtil.map(userRepository.findByEmail(email), UserDTO.class);
    }

    @Override
    public List<UserDTO> findAll() {
        return mapperUtil.mapAll(userRepository.findAll(), UserDTO.class);
    }

    @Override
    public UserDTO findById(Long id) {
        return mapperUtil.map(userRepository.findById(id), UserDTO.class);
    }

    @Override
    public UserDTO save(UserDTO user) {
        return mapperUtil.map(userRepository.save(mapperUtil.map(user, UserEntity.class)), UserDTO.class);
    }

    @Override
    public UserDTO update(UserDTO user, Long id) {
        UserEntity userUpdated = userRepository.findById(id).orElse(null);
        if (userUpdated == null) {
            // error
        }
        UserEntity userNewData = mapperUtil.map(user, UserEntity.class);
        userUpdated.setName(userNewData.getName());
        userUpdated.setDocument(userNewData.getDocument());
        userUpdated.setEmail(userNewData.getEmail());
        userUpdated.setLastName(userNewData.getLastName());
        userUpdated.setPassword(userNewData.getPassword());
        userUpdated.setRole(userNewData.getRole());
        return mapperUtil.map(userRepository.save(userUpdated), UserDTO.class);
    }

    @Override
    public UserDTO delete(Long id) {
        UserDTO userDeleted = mapperUtil.map(userRepository.findById(id), UserDTO.class);
        userRepository.delete(mapperUtil.map(userDeleted, UserEntity.class));
        return userDeleted;
    }
}
