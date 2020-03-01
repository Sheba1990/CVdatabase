package com.cvdatabase.project.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;

@Converter(autoApply = false)
public class StringToDateSQLConverter implements AttributeConverter<String, Date> {

    public java.sql.Date convertToDatabaseColumn(String entityValue) {
        if(entityValue == null)
            return null;
        return java.sql.Date.valueOf(entityValue);
    }

    public String convertToEntityAttribute(java.sql.Date databaseValue) {
        if (databaseValue == null)
            return null;
        return databaseValue.toString();
    }

}
