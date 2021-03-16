package com.joaogcm.api.geek.burguer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaogcm.api.geek.burguer.entities.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}