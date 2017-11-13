package com.matdatour.score;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("scoredao")
public class ScoreDAOImpl implements ScoreDAO {

	@Autowired
	SqlSession sqlSession;

	String namespace = "com.matdatour.score.";

	@Override
	public List<ScoreDTO> selectAllScore() {
		return sqlSession.selectList(namespace + "selectAllScore");
	}

	@Override
	public ScoreDTO selectByScore(int board_num) {
		return sqlSession.selectOne(namespace + "selectByScore", board_num);
	}

	@Override
	public int scoreInsert(ScoreDTO scoredto) {
		return sqlSession.insert(namespace + "scoreInsert", scoredto);
	}

	@Override
	public int scoreUpdate(ScoreDTO scoredto) {
		return sqlSession.update(namespace + "scoreUpdate", scoredto);
	}

	@Override
	public int scoreDelete(int user_num) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + "scoreDelete", user_num);
	}

	@Override
	public int scoreAvgByID(int user_num) {
		return sqlSession.selectOne(namespace+"scoreAvgByID", user_num);
	}

	@Override
	public int scoreAvgByBoard(int board_num) {
		return sqlSession.selectOne(namespace+"scoreAvgByBoard", board_num);
	}

	
}
