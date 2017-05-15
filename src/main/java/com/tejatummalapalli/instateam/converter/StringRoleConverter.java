package com.tejatummalapalli.instateam.converter;

import com.tejatummalapalli.instateam.dao.RoleDao;
import com.tejatummalapalli.instateam.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringRoleConverter implements Converter<String,Role> {


        @Autowired
        private RoleDao roleDao;

        @Override
        public Role convert(String source) {
            // you can change the way , add
            // exception check and etc.
            return roleDao.findById(
                    Integer.valueOf(source)
            );
        }
}
