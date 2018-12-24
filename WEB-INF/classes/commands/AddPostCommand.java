package commands;

import main.RequestContext;
import main.ResponseContext;
import util.Upload;
import beans.PostBean;

import java.util.ArrayList;

public class AddPostCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		Upload u = new Upload();
		PostBean pb = u.uploadFlie(reqc);
		
		resc.setTarget("showtest");
		return resc;
	}