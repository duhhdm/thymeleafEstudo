package com.aprendendothymeleaf.dao;

import org.springframework.stereotype.Repository;

import com.aprendendothymeleaf.domain.Cargo;
import com.aprendendothymeleaf.dao.AbstractDAO;

@Repository
public class CargoDAOImp extends AbstractDAO<Cargo,Integer> implements CargoDAO {

}
