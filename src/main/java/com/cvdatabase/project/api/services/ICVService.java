package com.cvdatabase.project.api.services;

import com.cvdatabase.project.api.dto.CVDto;

import java.util.List;

public interface ICVService {

    public List<CVDto> getAllCVs();

    CVDto addCV(CVDto cvDto);

    CVDto getCVbyId(long id);

    public List<CVDto> getByTechnologyName(String name);

    public List<CVDto> getByPersonFirstName(String firstName);

    public List<CVDto> getByPersonLastName(String lastName);

    void updateCV(long id, CVDto cvDto);

    void deleteCV(long id);

    public CVDto addPersonToCV(long personId, long cvId);
}
