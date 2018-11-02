package com.pda.pda_android.db.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.pda.pda_android.db.Entry.CheckBean;
import com.pda.pda_android.db.Entry.SsxxBean;
import com.pda.pda_android.db.Entry.UserBean;

import com.pda.pda_android.db.dao.CheckBeanDao;
import com.pda.pda_android.db.dao.SsxxBeanDao;
import com.pda.pda_android.db.dao.UserBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig checkBeanDaoConfig;
    private final DaoConfig ssxxBeanDaoConfig;
    private final DaoConfig userBeanDaoConfig;

    private final CheckBeanDao checkBeanDao;
    private final SsxxBeanDao ssxxBeanDao;
    private final UserBeanDao userBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        checkBeanDaoConfig = daoConfigMap.get(CheckBeanDao.class).clone();
        checkBeanDaoConfig.initIdentityScope(type);

        ssxxBeanDaoConfig = daoConfigMap.get(SsxxBeanDao.class).clone();
        ssxxBeanDaoConfig.initIdentityScope(type);

        userBeanDaoConfig = daoConfigMap.get(UserBeanDao.class).clone();
        userBeanDaoConfig.initIdentityScope(type);

        checkBeanDao = new CheckBeanDao(checkBeanDaoConfig, this);
        ssxxBeanDao = new SsxxBeanDao(ssxxBeanDaoConfig, this);
        userBeanDao = new UserBeanDao(userBeanDaoConfig, this);

        registerDao(CheckBean.class, checkBeanDao);
        registerDao(SsxxBean.class, ssxxBeanDao);
        registerDao(UserBean.class, userBeanDao);
    }
    
    public void clear() {
        checkBeanDaoConfig.clearIdentityScope();
        ssxxBeanDaoConfig.clearIdentityScope();
        userBeanDaoConfig.clearIdentityScope();
    }

    public CheckBeanDao getCheckBeanDao() {
        return checkBeanDao;
    }

    public SsxxBeanDao getSsxxBeanDao() {
        return ssxxBeanDao;
    }

    public UserBeanDao getUserBeanDao() {
        return userBeanDao;
    }

}
