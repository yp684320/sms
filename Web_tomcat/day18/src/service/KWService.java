package service;

import domain.KW;

import java.util.List;

public interface KWService {
    List<KW> findAll(String value);

}
