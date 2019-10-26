package cn.com.taiji.oauth2.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/coupon")
public class SampleController {

    /**
     * 会员列表页面
     */
    @RequestMapping("/list")
    public ModelAndView list() {
        return new ModelAndView("coupon/list");
    }

}
