package service.impl;

import dao.KWDao;
import domain.KW;
import service.KWService;
import utils.BeanFactory;

import java.util.List;

public class KWServiceImpl implements KWService {
    private KWDao kwDao = BeanFactory.newInstance(KWDao.class);
    @Override
    public List<KW> findAll(String value) {
        return kwDao.findAll(value);
    }
}
