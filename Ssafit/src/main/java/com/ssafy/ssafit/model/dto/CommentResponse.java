package com.ssafy.ssafit.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {
	private int id;
	private int userId;
	private String writer;
	private int postId;
	private String content;
	private boolean isDeleted;
	private String createdAt;
	private List<Reply> replyList;

	public static CommentResponse build(Comment comment, List<Reply> replys) {
		CommentResponse cr = new CommentResponse();
		cr.setId(comment.getId());
		cr.setUserId(comment.getUserId());
		cr.setWriter(comment.getWriter());
		cr.setPostId(comment.getPostId());
		cr.setContent(comment.getContent());
		cr.setDeleted(comment.isDeleted());
		cr.setCreatedAt(comment.getCreatedAt());
		cr.setReplyList(replys);
		return cr;
	}
}