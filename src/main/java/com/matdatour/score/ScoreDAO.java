package com.matdatour.score;

import java.util.List;


public interface ScoreDAO {
	
	public List<ScoreDTO> selectAllScore();

	public ScoreDTO selectByScore(int board_num);

	public int scoreInsert(ScoreDTO scoredto);

	public int scoreUpdate(ScoreDTO scoredto);

	public int scoreDelete(int user_num);
	
	public int scoreAvgByID(int user_num);

	public int scoreAvgByBoard(int board_num);

}
