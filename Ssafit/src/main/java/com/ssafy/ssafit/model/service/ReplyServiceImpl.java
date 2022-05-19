package com.ssafy.ssafit.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.model.dao.ReplyDao;
import com.ssafy.ssafit.model.dto.Post;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyDao replyDao;

	@Autowired
	private ServletContext servletContext;
	
	@Transactional
	@Override
	public void create(Post board, MultipartFile file) {
		// TODO Auto-generated method stub
		System.out.println(board.toString());
		boardDao.insertBoard(saveImg(board, file));
		System.out.println(saveImg(board, file).toString());
	}

	@Transactional
	@Override
	public void update(Post board, MultipartFile file) {
		// TODO Auto-generated method stub
		Post originBoard = boardDao.selectOne(board.getId());
		originBoard.setTitle(board.getTitle());
		originBoard.setContent(board.getContent());
		if (isChanged(originBoard.getFileName(), file.getOriginalFilename()))
			originBoard = saveImg(originBoard, file);
		boardDao.updateBoard(originBoard);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Post board = boardDao.selectOne(id);
		if (board.getFileUri() != null) {
			new File(board.getFileUri()).delete();
		}
		boardDao.deleteBoard(id);
	}
	
	
	@Override
	public void updateCnt(int id) {
		// TODO Auto-generated method stub
		Post board = boardDao.selectOne(id);
		board.setViewCnt(board.getViewCnt() + 1);
		boardDao.updateBoard(board);
	}

	@Override
	public Post getOne(int id) {
		// TODO Auto-generated method stub
		this.updateCnt(id);
		return boardDao.selectOne(id);
	}

	@Override
	public List<Post> getList(HashMap<String, String> params) {
		// TODO Auto-generated method stub
		return boardDao.selectList(params);
	}

	private boolean isChanged(String originFileName, String newFileName) {
		if (originFileName.equals(newFileName))
			return false;
		return true;
	}

	private Post saveImg(Post board, MultipartFile file) {
		// TODO Auto-generated method stub
		if (file.getSize() != 0) {
			String uploadPath = servletContext.getRealPath("/file");
			String fileName = file.getOriginalFilename();
			String saveName = UUID.randomUUID() + "";
			File target = new File(uploadPath, saveName);
			if (!new File(uploadPath).exists())
				new File(uploadPath).mkdirs();
			try {
				FileCopyUtils.copy(file.getBytes(), target);
				board.setFileName(fileName);
				board.setFileUri(target.getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return board;
	}
}
