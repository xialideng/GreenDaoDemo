package com.rudy.demo.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.rudy.demo.entity.Son;
import com.rudy.demo.entity.Student;
import com.rudy.demo.entity.Father;

import com.rudy.demo.greendao.SonDao;
import com.rudy.demo.greendao.StudentDao;
import com.rudy.demo.greendao.FatherDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig sonDaoConfig;
    private final DaoConfig studentDaoConfig;
    private final DaoConfig fatherDaoConfig;

    private final SonDao sonDao;
    private final StudentDao studentDao;
    private final FatherDao fatherDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        sonDaoConfig = daoConfigMap.get(SonDao.class).clone();
        sonDaoConfig.initIdentityScope(type);

        studentDaoConfig = daoConfigMap.get(StudentDao.class).clone();
        studentDaoConfig.initIdentityScope(type);

        fatherDaoConfig = daoConfigMap.get(FatherDao.class).clone();
        fatherDaoConfig.initIdentityScope(type);

        sonDao = new SonDao(sonDaoConfig, this);
        studentDao = new StudentDao(studentDaoConfig, this);
        fatherDao = new FatherDao(fatherDaoConfig, this);

        registerDao(Son.class, sonDao);
        registerDao(Student.class, studentDao);
        registerDao(Father.class, fatherDao);
    }
    
    public void clear() {
        sonDaoConfig.clearIdentityScope();
        studentDaoConfig.clearIdentityScope();
        fatherDaoConfig.clearIdentityScope();
    }

    public SonDao getSonDao() {
        return sonDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public FatherDao getFatherDao() {
        return fatherDao;
    }

}