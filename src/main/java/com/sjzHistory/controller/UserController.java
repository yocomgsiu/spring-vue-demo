package com.sjzHistory.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sjzHistory.entity.RespResult;
import com.sjzHistory.entity.Statistics;
import com.sjzHistory.entity.User;
import com.sjzHistory.service.IStatisticsService;
import com.sjzHistory.service.IUserService;
import com.sjzHistory.utils.ResultGenerator;

/**
 * 用户控制层
 * . @RestController 该类下所有返回值默认以json格式进行返回
 * . @RequestMapping 匹配url地址 /user
 * . @Validated 代表该类启用参数验证，通过添加注解可以验证参数
 * Created by Yocomg on 2019/7/16
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final IUserService userService;

    private final ResultGenerator generator;
    
    private final IStatisticsService satisticsServices;

    @Autowired  //自动装配
    public UserController(IUserService userService, IStatisticsService satisticsServices, ResultGenerator generator) {
        this.userService = userService;
        this.generator = generator;
        this.satisticsServices = satisticsServices;
    }

    /**
     * 匹配 /user/register 地址
     * .在实体前添加 @Valid 注解代表要对这个实体进行验证，如果验证不通过就会报异常
     * bindingResult是对异常信息的包装，不过这里我们不用，而是交由异常处理器进行处理
     * @return 注册成功会将注册信息返回（！因为是demo所以没有考虑安全性）
     */
    @RequestMapping("/register")
    public RespResult register(@Valid User User, BindingResult bindingResult) {
        return generator.getSuccessResult("用户注册成功",userService.saveUser(User));
    }

    /**
     * 匹配 /user/login 地址 ,限定POST方法
     * 。@NotNull 在字段前添加注解代表验证该字段，如果为空则报异常
     * @return 登陆成功则返回相关信息，否则返回错误提示
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public RespResult login(@NotNull(message = "用户名不能为空") String name,@NotNull(message = "密码不能为空") String password, HttpSession session) {
        User user = userService.checkLogin(name, password);
        if(user != null) {
            //储存到session中
            session.setAttribute("user",user);
            return generator.getSuccessResult("登陆成功",user);
        }
        return generator.getFailResult("用户名/密码错误");
    }

	@RequestMapping(value = "/login2",method = RequestMethod.POST)
    public ResponseEntity<User> login2(@NotNull String name,@NotNull String password, HttpSession session) {
    	User user = userService.checkLogin(name, password);
    	if(user != null) {
    		log.info("find user {} and login",user.toString());
    		//储存到session中
    		session.setAttribute("user", user);
    		return new ResponseEntity<>(user, HttpStatus.OK);
    	}
    	return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    }
	
	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public void test(@PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.ASC) 
    Pageable pageable) {

		long articlesCount = satisticsServices.countArticles();
		System.out.println("articlesCount===="+articlesCount);		
		
		long usersCount = satisticsServices.countUsers();
		System.out.println("usersCount===="+usersCount);
		
		Page<Statistics> staPage = satisticsServices.findAllStatistics(pageable);
		System.out.println("staPage===="+staPage.getContent());
		
		Statistics statistics = new Statistics();
		statistics.setId(2346);
		statistics.setDate(12);
		statistics.setUserCount(3);
		statistics.setUserIncreaseCount(1);
		statistics.setArticleCount(33);
		statistics.setArticleIncreaseCount(4);
		Statistics saveStatistics = satisticsServices.saveStatistics(statistics);
		System.out.println("saveStatistics===="+saveStatistics);
		
	}

	
	
	
}
