package com.teamnine.carrepairs.service;

import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.model.OwnerForm;
import javafx.util.Pair;
import org.springframework.security.core.AuthenticationException;

import java.util.List;

public interface AccountService {

    Owner login(String username, String password) throws AuthenticationException;

    Owner findOwnerbyAFM(long afm);

    List<OwnerForm> findAllOwners();

    void insertUser(Owner owner);

    Owner findUser(long id);

    void updateOwner(OwnerForm ownerForm);

    Owner findOwnerbyEmail(String email);

    List<OwnerForm> searchOwnerByEmail(String searchText);
    List<OwnerForm> searchOwnerByAfm(Long searchText);

}
