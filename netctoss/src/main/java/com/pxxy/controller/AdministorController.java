package com.pxxy.controller;

import com.pxxy.domain.Account;
import com.pxxy.domain.Administor;
import com.pxxy.domain.ResponseResult;
import com.pxxy.mapper.AdministorMapper;
import com.pxxy.service.IAdministorService;
import com.pxxy.service.ex.AdministorServiceException;
import com.pxxy.utils.ImgCheckCode;
import net.sf.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Descricption:管理员表现层
 * @Author:江灿
 * @Date:Create in 11:12 2019/5/29
 */
@Controller
@RequestMapping("/administor")
public class AdministorController {

    @Autowired
    private IAdministorService administorService;

   /*
    * @Author:江灿
    * @Description:获取验证码
    * @Date: 15:49 2019/5/30
    * @Param: []
    * @return: java.lang.String
    **/
   @RequestMapping("/getImgCode")
    public void getImgCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
       ImgCheckCode imgCheckCode = new ImgCheckCode();
       String code = imgCheckCode.getRandomCodeStr();
       BufferedImage buffImg = imgCheckCode.getImgCode(code);
       System.out.println("Code is " + code);
       // 将四位数字的验证码保存到Session中。
       HttpSession session = request.getSession();
       session.setAttribute("code", code);
       // 禁止图像缓存。
       response.setHeader("Pragma", "no-cache");
       response.setHeader("Cache-Control", "no-cache");
       response.setDateHeader("Expires", 0);
       response.setContentType("image/jpeg");
       // 将图像输出到Servlet输出流中。
       ServletOutputStream sos = response.getOutputStream();
       ImageIO.write(buffImg, "jpeg", sos);
       sos.close();
   }
    /**
     * 检查提交的验证码是否正确
     */
    @RequestMapping(value ="/checkCode")
    @ResponseBody//使用@ResponseBody 注解返回响应体 直接将返回值序列化json
    public ResponseResult<Void> checkCode(HttpServletRequest request , String code){
        HttpSession session = request.getSession();
        if(code.equals(session.getAttribute("code"))){
            //如果验证码正确，则给前台发送成功消息，让前台请求登录
            return new ResponseResult<Void>(0);
        }else{
            return new ResponseResult<Void>(1,"验证码不正确，请重新输入！");
        }
    }
    /*
     * @Author:江灿
     * @Description:管理员登录
     * @Date: 17:05 2019/5/30
     * @Param: [administor]
     * @return: com.pxxy.domain.ResponseResult<java.lang.Void>
     **/
    @RequestMapping("/login")
    @ResponseBody
    public ResponseResult<Void> login(Administor administor,HttpSession session){
        try {
            Administor administor1 = administorService.login(administor);
            //登录成功，将管理员信息保存到session中
            session.setAttribute("administor",administor1);
            System.out.println("登录成功");
            return new ResponseResult<>(0);
        } catch (AdministorServiceException e) {
            System.out.println("登录失败");
            System.out.println(e.getMessage());
            return new ResponseResult<>(1,e.getMessage());
        }
    }


}
