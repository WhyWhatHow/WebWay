package demo.WordHint.dao;

import java.sql.SQLException;
import java.util.List;

import demo.WordHint.domain.WordBean;

public interface WordDao {
	List<WordBean> findWord(String word) throws SQLException;
}
