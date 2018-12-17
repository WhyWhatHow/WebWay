package demo.WordHint.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import Util.DButil;
import demo.WordHint.dao.WordDao;
import demo.WordHint.domain.WordBean;

public class WordDaoImpl implements WordDao {

	@Override
	public List<WordBean> findWord(String word) throws SQLException {
		ComboPooledDataSource dataBase = DButil.getDataBase("wordhint");
		QueryRunner queryRunner = new QueryRunner(dataBase);
		return queryRunner.query("select * from wordlist where name like ? ",
				new BeanListHandler<WordBean>(WordBean.class), " %" + word + "%");

	}

	@Test
	public void run() {
		try {
			System.out.println("=========================");
			List<WordBean> list = findWord("lucy");
			if (list==null) {
				System.out.println("===============然而并沒有數據 =========");
			}
			for (WordBean wordBean : list) {
				System.out.println(wordBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
