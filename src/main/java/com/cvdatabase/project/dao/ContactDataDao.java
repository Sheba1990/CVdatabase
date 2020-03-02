package com.cvdatabase.project.dao;

import com.cvdatabase.project.api.dao.IContactDataDao;
import com.cvdatabase.project.entities.ContactData;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDataDao extends AGenericDao<ContactData> implements IContactDataDao {

    public ContactDataDao() {
        super(ContactData.class);
    }

}
