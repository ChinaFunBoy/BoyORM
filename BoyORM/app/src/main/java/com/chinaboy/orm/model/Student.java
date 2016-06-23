package com.chinaboy.orm.model;

import com.chinaboy.orm.db.BaseModel;
import com.chinaboy.orm.db.DatabaseField;

/**
 * Created by maoweiwei on 16/6/23
 * BoyORM
 */
public class Student extends BaseModel {

    private static final long serialVersionUID = 7544529434430293395L;
    private static final String ID = "id";
    private static final String NAME = "name";

    @DatabaseField(columnName = ID, index = true, unique = true, canBeNull = false)
    public int id;

    @DatabaseField(columnName = NAME)
    public String name;


}
