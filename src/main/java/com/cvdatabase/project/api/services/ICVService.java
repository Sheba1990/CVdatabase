package com.cvdatabase.project.api.services;

import com.cvdatabase.project.dto.CVDto;
import com.cvdatabase.project.dto.ContactDataDto;
import com.cvdatabase.project.dto.PersonDto;
import com.cvdatabase.project.dto.TechnologyDto;

import java.util.List;

public interface ICVService {

    public List<CVDto> getAllCVs();

    CVDto addCV(CVDto cvDto, PersonDto personDto, ContactDataDto contactDataDto, int[] technologies);

    CVDto getCVbyId(long id);

    public List<CVDto> getByTechnologyName(String name);

    public List<CVDto> getCVByPersonFirstName(String firstName);

    public List<CVDto> getCVByPersonLastName(String lastName);

    public List<CVDto> getCVByPersonFullName(String firstName, String lastName);

    void updateCV(long id, CVDto cvDto, PersonDto personDto, ContactDataDto contactDataDto);

    void deleteCV(long id);

    public CVDto addPersonToCV(long personId, long cvId);
}
