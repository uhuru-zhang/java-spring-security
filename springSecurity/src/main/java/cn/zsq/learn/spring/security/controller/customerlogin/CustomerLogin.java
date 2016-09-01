package cn.zsq.learn.spring.security.controller.customerlogin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customerLoginLearn")
public class CustomerLogin {
	@RequestMapping(value = {"/", "welcome"}, method = RequestMethod.GET)
	public ModelAndView welcome(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "Spring Security Customer Login Form");
		mv.addObject("message", "This  is welcome page!");
		mv.setViewName("/customerLoginLearn/hello.jsp");
		return mv;
	}
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("/customerLoginLearn/admin.jsp");

		return model;

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("/customerLoginLearn/login.jsp");

		return model;

	}
}
