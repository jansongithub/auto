package org.yp.dao.daointerface;

import org.yp.pojo.CasePo;

import java.util.Collection;
import java.util.List;

/**
 * Created by  on 2016/7/1.
 */

public interface IActivityProcedureDao {

       public abstract int save(CasePo Testcase);

       public abstract void update(CasePo Testcase);
       public abstract CasePo getTestcase(Integer id);
       public abstract List<CasePo> getTestcase();
       public abstract void delete(Integer id);

}