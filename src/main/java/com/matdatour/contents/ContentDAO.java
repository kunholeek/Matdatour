package com.matdatour.contents;

import java.util.List;


public interface ContentDAO {

	public int contentInsert(ContentDTO contentdto);

	public int contentUpdate(ContentDTO contentdto);

	public int contentDelete(int board_num);

}
