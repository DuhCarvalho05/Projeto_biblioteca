package Model.Service;

import Model.Dao.LoanDao;
import Model.Dao.LoanDaoImpl;

public class LoanService {
    private LoanDao dao;

    public LoanService(LoanDao dao) {
        this.dao = LoanDaoImpl.getInstance();
    }



}
