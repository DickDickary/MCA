package com.mycars.repos;

import com.mycars.domain.CarForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CarFormsRepo  extends JpaRepository<CarForm,Long> {

    Set<CarForm> findByCarName(String carName);

}
