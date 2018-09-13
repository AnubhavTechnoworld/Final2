package com.training.ata.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.ata.bean.CredentialsBean;
import com.training.ata.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String ShowHome() {
		return "home";
	}
  @RequestMapping(value = "/Login", method = RequestMethod.GET)
  public String init(Model model) {
    model.addAttribute("msg", "Please Enter Your Login Details");
    return "Login";
  }

  @RequestMapping(value="/processlogin" ,method = RequestMethod.POST)
  public ModelAndView processLogin(HttpSession session,@ModelAttribute("credentialsBean") CredentialsBean cb,@RequestParam("user")String user) {
	  session.setAttribute("userID", cb.getUserID());
	  try {
		  boolean result=userService.isValidUser(cb.getUserID(), cb.getPassword());
		  if(result && cb.getUserID().equals("ADM101") && user.equals("admin")) {
			
				cb.setLoginStatus(1);
				return new ModelAndView("Administrator");
				
			}
		  
			else if(result && user.equals("customer") && !cb.getUserID().equals("ADM101")) {
				cb.setLoginStatus(1);
				return new ModelAndView("user");
			}
			else {
				return new ModelAndView("error1");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	  
	  
   /* if (loginBean != null && loginBean.getUserID() != null & loginBean.getPassword() != null) {
      if (loginBean.getUserID().equals("garvi") && loginBean.getPassword().equals("garvita123")) {
        model.addAttribute("msg", loginBean.getUserID());
        return "success";
      } else {
        model.addAttribute("error", "Invalid Details");
        return "Login";
      }
    } else {
      model.addAttribute("error", "Please enter Details");
      return "Login";
    }
  }*/
}
  
@RequestMapping("/logout")
public String logout(HttpServletRequest request) {
	HttpSession session=request.getSession();
	session.invalidate();
	return"home";
}
}
