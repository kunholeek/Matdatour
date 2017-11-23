package com.matdatour.board;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service("boardservice")
public class BoardServiceImpl implements BoardService {

	@Autowired
	@Qualifier("boarddao")
	BoardDAO board;

	public BoardServiceImpl() {
	}

	public BoardServiceImpl(BoardDAO board) {
		this.board = board;
	}

	public void setDao(BoardDAO board) {
		this.board = board;
	}

	@Override
	public List<BoardDTO> selectAll() {
		return board.selectAll();
	}

	@Override
	public int serv_boardInsert(BoardDTO boarddto) {

		String title = boarddto.getTitle();
		String content = boarddto.getM_content();

		title = title.replaceAll("<", "&lt;");
		title = title.replaceAll(">", "&gt;");
		title = title.replaceAll("  ", "&nbsp;&nbsp;");
		
		content = content.replaceAll("<", "&lt;");
		content = content.replaceAll(">", "&gt;");
		content = content.replaceAll("\n", "<br>");
		boarddto.setTitle(title);
		boarddto.setM_content(content);

		return board.boardInsert(boarddto);
	}

	@Override
	public int serv_boardUpdate(BoardDTO boarddto) {
		
		String title = boarddto.getTitle();
		String content = boarddto.getM_content();

		title = title.replaceAll("<", "&lt;");
		title = title.replaceAll(">", "&gt;");
		title = title.replaceAll("  ", "&nbsp;&nbsp;");
		
		content = content.replaceAll("<", "&lt;");
		content = content.replaceAll(">", "&gt;");
		content = content.replaceAll("\n", "<br>");
		boarddto.setTitle(title);
		boarddto.setM_content(content);
		
		return board.boardUpdate(boarddto);
	}

	@Override
	public int serv_boardDelete(int board_num) {
		return board.boardDelete(board_num);
	}

	@Override
	public BoardDTO detailView(int board_num) throws Exception {
		return board.detailView(board_num);
	}

	@Override
	public String fileUpload(MultipartHttpServletRequest mRequest) {
		String isSuccess = null;

		String uploadPath = mRequest.getRealPath("/upload/");

		File dir = new File(uploadPath);

		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		Iterator<String> iter = mRequest.getFileNames();
		while (iter.hasNext()) {
			String uploadFileName = iter.next();

			MultipartFile mFile = mRequest.getFile(uploadFileName);
			String originalFileName = mFile.getOriginalFilename();
			String saveFileName = originalFileName;

			//폴더
			
			if (saveFileName != null && !saveFileName.equals ("")) {
				if (new File(uploadPath + saveFileName).exists()) {

					saveFileName = System.currentTimeMillis()+"_"+saveFileName ;

				}

				try {
					System.out.println("uploadpath->" + uploadPath + "board->" + saveFileName);
					mFile.transferTo(new File(uploadPath + saveFileName));
					isSuccess = saveFileName;
				} catch (IllegalStateException e) {
					e.printStackTrace();

				} catch (IOException e) {
					e.printStackTrace();

				}
			}
		}
		return isSuccess;
	}
	
}
