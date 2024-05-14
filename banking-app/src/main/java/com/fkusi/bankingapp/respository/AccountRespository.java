package com.fkusi.bankingapp.respository;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fkusi.bankingapp.entity.Account;
public interface AccountRespository extends JpaRepository<Account, Long> {

}
