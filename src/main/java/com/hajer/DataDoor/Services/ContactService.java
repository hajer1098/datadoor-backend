package com.hajer.DataDoor.Services;

import com.hajer.DataDoor.Dto.ContactDto;

import java.util.List;

public interface ContactService extends AbstractService<ContactDto>{

    List<ContactDto> findAllByUserId(Integer userId);
}
