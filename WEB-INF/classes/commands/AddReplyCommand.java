package commands;

import main.ResponseContext;
import main.RequestContext;
import beans.ReplyBean;


public class AddReplyCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		ReplyBean rb = new ReplyBean();
		String[] reply = reqc.getParameter("reply");
		String[] pid = reqc.getParameter("postId");
		rb.setReply(reply[0]);
		rb.setPostId(pid[0]);
		
		resc.setTarget("showtest");
		return resc;
	}