package dao;

import domain.KW;

import java.util.List;

public interface KWDao {
    List<KW> findAll(String value);
}
