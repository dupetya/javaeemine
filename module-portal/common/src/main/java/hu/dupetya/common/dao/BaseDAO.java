package hu.dupetya.common.dao;

import java.util.List;

public interface BaseDAO<T> {

	public Long save(T entity) throws DAOException;

	public void update(T entity) throws DAOException;

	public void delete(Long id) throws DAOException;

	public T find(Long id) throws DAOException;

	public List<T> findAll() throws DAOException;

}
