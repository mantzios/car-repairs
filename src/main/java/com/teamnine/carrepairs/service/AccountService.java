package com.teamnine.carrepairs.service;

import com.teamnine.carrepairs.domain.Owner;
import com.teamnine.carrepairs.exception.UserNotFoundException;
import com.teamnine.carrepairs.model.OwnerForm;
import javafx.util.Pair;
import org.springframework.security.core.AuthenticationException;

import java.util.List;

public interface AccountService {

    Owner login(String username, String password) throws AuthenticationException;

    Owner findOwnerbyAFM(long afm) throws UserNotFoundException;

    List<OwnerForm> findAllOwners();

    void insertUser(Owner owner);

    Owner findUser(long id) throws UserNotFoundException;

    void updateOwner(OwnerForm ownerForm);

    Owner findOwnerbyEmail(String email) throws UserNotFoundException;

    List<OwnerForm> searchOwnerByEmail(String searchText);
    List<OwnerForm> searchOwnerByAfm(Long searchText);

    void  deleteOwner (long id);
}
