package board.action;

public class BoardActionFactory {
	
	private static BoardActionFactory baf;
	
	private BoardActionFactory() {}
	
	public static BoardActionFactory getInstance() {
		if(baf == null) {
			baf = new BoardActionFactory();
		}
		return baf;
	}
	
	Action action = null;
	public Action action(String cmd) {
		//Action 생성시 path 지정(작업이 성공할 경우 움직일 페이지)
		if(cmd.equals("/qWrite.do")) {
			//등록
			action = new BoardInsertAction("/qList.do");
		}else if(cmd.equals("/qList.do")) {
			//목록보여주기
			action = new BoardListAction("/view/qna_board_list.jsp");
		}else if(cmd.equals("/qView.do")) {
			//게시판 보여주는 화면
			action = new BoardViewAction("/view/qna_board_view.jsp");
		}else if(cmd.equals("/qHitUpdate.do")) {
			//새로고침으로도 조회수가 올라가는 것을 막아주기 위해 거쳐가는 것을 만듬
			action = new BoardHitUpdateAction("/qView.do");
		}else if(cmd.equals("/qDelete.do")) {
			//탈퇴
			action = new BoardDeleteAction("/qList.do");
		}else if(cmd.equals("/qModify.do")) {
			//보여지는 게시판에서 수정버튼을 누르면 select로 value들을 부르고 수정창으로 넘어감 
			action = new BoardViewAction("/view/qna_board_modify.jsp");
		}else if(cmd.equals("/qUpdate.do")) {
			//수정하는 게시판에서 수정을 누르면 수정된 것 들을 update문으로 최신화하여 화면을 보여줌 
			action = new BoardUpdateAction("/qView.do");
		}else if(cmd.equals("/qReplyView.do")) {
			//댓글작업하는화면
			action = new BoardViewAction("/view/qna_board_reply.jsp");
		}else if(cmd.equals("/qReply.do")) {
			//댓글작업을 등록 누르는 작업
			action = new BoardReplyAction("/qList.do");
		}else if(cmd.equals("/qSearch.do")) {
			//검색
			action = new BoardSearchAction("/view/qna_board_list.jsp");
		}
		return action;
	}
}
