package commands;

import main.RequestContext;
import main.ResponseContext;
import dao.OraConnectionManager;
import dao.AnimalDao;
import beans.UserBean;
import beans.PostBean;

public class GetPostViewCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
        String[] pidArr = (String[])reqc.getParameter("postId");
        String pid = pidArr[0];

        AnimalDao dao = new AnimalDao();
        PostBean pb = null;

        OraConnectionManager.getInstance().beginTransaction();
        pb = dao.getPost(pidArr[0]);
        OraConnectionManager.getInstance().closeConnection();

        resc.setResult(pb);
        resc.setTarget("getpostlist");
        return resc;
    }
}