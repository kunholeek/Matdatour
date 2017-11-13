package com.matdatour.score;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("scoreservice")
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	@Qualifier("scoredao")
	ScoreDAO score;

	public ScoreServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public ScoreServiceImpl(ScoreDAO score) {
		this.score = score;
	}

	public void setDao(ScoreDAO score) {
		this.score = score;
	}

	@Override
	public List<ScoreDTO> selectAllScore() {
		// TODO Auto-generated method stub
		return score.selectAllScore();
	}

	@Override
	public ScoreDTO selectByScore(int board_num) {
		// TODO Auto-generated method stub
		return score.selectByScore(board_num);
	}

	@Override
	public int scoreInsert(ScoreDTO scoredto) {
		// TODO Auto-generated method stub
		return score.scoreInsert(scoredto);
	}

	@Override
	public int scoreUpdate(ScoreDTO scoredto) {
		// TODO Auto-generated method stub
		return score.scoreUpdate(scoredto);
	}

	@Override
	public int scoreDelete(int user_num) {
		// TODO Auto-generated method stub
		return score.scoreDelete(user_num);
	}

	@Override
	public int scoreAvgByID(int user_num) {
		// TODO Auto-generated method stub
		return score.scoreAvgByID(user_num);
	}

	@Override
	public int scoreAvgByBoard(int board_num) {
		// TODO Auto-generated method stub
		return score.scoreAvgByBoard(board_num);
	}

}
