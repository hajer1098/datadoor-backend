package com.hajer.DataDoor.Services;

import com.hajer.DataDoor.Dto.AuthenticationRequest;
import com.hajer.DataDoor.Dto.AuthenticationResponse;
import com.hajer.DataDoor.Dto.UserDto;
import com.hajer.DataDoor.Dto.changePasswordRequest;

import java.security.Principal;

public interface UserService extends AbstractService<UserDto> {

   Integer validateAccount(Integer id);
   Integer invalidateAccount(Integer id);

  Integer Edit(Integer id,UserDto user);
    AuthenticationResponse register(UserDto user);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    void changePassword(changePasswordRequest request, Principal connectedUser);
}
