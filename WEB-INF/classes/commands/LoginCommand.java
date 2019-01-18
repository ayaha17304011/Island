package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import main.RequestContext;
import main.ResponseContext;
import util.Upload;
import dao.AnimalDao;
import beans.UserBean;

public class LoginCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){
        RequestContext reqc = getRequestContext();
        HttpServletRequest req =(HttpServletRequest)reqc.getRequest();

        boolean loginflag= false;
        String result = "";
        UserBean ub = new UserBean();
        AnimalDao dao = new AnimalDao();

        String[] loginIdArray = (String[])reqc.getParameter("loginid");
        String loginId = loginIdArray[0];
        ub.setLoginId(loginId);

        String[] passArray = (String[])reqc.getParameter("pass");
        String pass = passArray[0];
        ub.setPassword(pass);

        // ���O�C����񂪃f�[�^�x�[�X�ɓo�^����Ă��邩�m�F����
        // ub = dao.LoginProcessing(ub);

        result = dao.Login(ub);

        if(result != null){
            loginflag = true;
        }else{
            System.out.println("�p�X���[�h��������ID���Ⴂ�܂�");
        }

        if(loginflag){
            HttpSession session = req.getSession();
            session.setAttribute("loginUser", ub);
            resc.setTarget("timeline");
        }else{
            resc.setTarget("login");
            // resc.setResult("�p�X���[�h��������ID���Ⴂ�܂�");
            // throw new exp.SystemException("�p�X���[�h��������ID���Ⴂ�܂�", new RuntimeException());
        }
        return resc;
    }
}