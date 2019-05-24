package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mysite.dao.UserDao;
import com.cafe24.mysite.vo.UserVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Long no = Long.parseLong(request.getParameter("no"));
		String password = request.getParameter("password");
		
		UserVo vo = new UserVo();
		vo.setNo(no);
		vo.setPassword(password);
		
		boolean check = new UserDao().update(vo);
		
		if(!check) {
			WebUtil.redirect(request, response, request.getContextPath());
			return;
		}
		
		WebUtil.redirect(request, response, request.getContextPath());
	}

}
