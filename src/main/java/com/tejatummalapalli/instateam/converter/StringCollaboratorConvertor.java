package com.tejatummalapalli.instateam.converter;

import com.tejatummalapalli.instateam.dao.CollaboratorDao;
import com.tejatummalapalli.instateam.model.Collaborator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringCollaboratorConvertor  implements Converter<String,Collaborator> {

    @Autowired
    CollaboratorDao collaboratorDao;

    @Override
    public Collaborator convert(String source) {
        return collaboratorDao.findById(Integer.valueOf(source));
    }
}
