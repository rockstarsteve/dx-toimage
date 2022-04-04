package com.dx.controller;

import com.dx.enums.ItemType;
import com.dx.util.FreemarkerUtils;
import freemarker.template.Template;
import gui.ava.html.image.generator.HtmlImageGenerator;
import gui.ava.html.parser.HtmlParser;
import gui.ava.html.parser.HtmlParserImpl;
import gui.ava.html.renderer.ImageRenderer;
import gui.ava.html.renderer.ImageRendererImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 *
 * @author
 * @version 1.0
 * @copyright Copyright (c)
 * @since 2022/4/3
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    /**
     * <groupId>com.github.xuwei-k</groupId>
     * <artifactId>html2image</artifactId>
     */
    @GetMapping("/getSimple")
    public void getSimpleItemImg(HttpServletResponse response) throws Exception {

        //填充模板渲染内容
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate(ItemType.IMAGE_MIX.getFileName());
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "<p><span style=\"color: #333333; font-family: Arial, sans-serif; font-size: 13px; background-color: #ffffff;\">简述清末的政党监督思想</span></p>");
        map.put("img", "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
        String templateHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);

        //将页面转换为图片
        HtmlImageGenerator htmlImageGenerator = new HtmlImageGenerator();
//        Dimension DEFAULT_SIZE = new Dimension(2000, 2000);
//        htmlImageGenerator.setSize(DEFAULT_SIZE);
        htmlImageGenerator.loadHtml(templateHtml);
        BufferedImage bufferedImage = htmlImageGenerator.getBufferedImage();
        ImageIO.write(bufferedImage, "PNG", response.getOutputStream());
    }


    /**
     * <groupId>gui.ava</groupId>
     * <artifactId>html2image</artifactId>
     */
    @GetMapping("/getDateItemImg2")
    public void getDateItemImg2(HttpServletResponse response) throws Exception {

        //填充模板渲染内容
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate(ItemType.IMAGE_MIX.getFileName());
        Map<String, String> map = new HashMap<>();
        map.put("msg", "<p><span style=\"color: #333333; font-family: Arial, sans-serif; font-size: 40px; background-color: #ffffff;\">简述清末的政党监督思想</span></p>");
        map.put("img", "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
        String templateHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);

        //正则处理数据
        templateHtml = removeFamilyStyle(templateHtml);


        //将页面转换为图片
        HtmlParser htmlParser = new HtmlParserImpl();
        htmlParser.loadHtml(templateHtml);
        // html 是我的html代码
        ImageRenderer imageRenderer = new ImageRendererImpl(htmlParser);
        BufferedImage bufferedImage = imageRenderer.getBufferedImage();

        BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        // TYPE_INT_RGB:创建一个RBG图像，24位深度，成功将32位图转化成24位
        newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);

        ImageIO.write(newBufferedImage, "JPG", response.getOutputStream());
    }


    /**
     * core-renderer
     */
    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    public void test(HttpServletResponse response) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("msg", "<p><span style=\"color: #333333; font-family: Arial, sans-serif; font-size: 13px; background-color: #ffffff;\">简述清末的政党监督思想</span></p>");
            map.put("img", "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
            FreemarkerUtils.turnImage(ItemType.IMAGE_MIX.getFileName(), map, response);
        } catch (Exception e) {
            log.error("异常", e.getMessage());
        }
    }

    /**
     * core-renderer
     */
    @RequestMapping(value = "/test2", method = {RequestMethod.GET})
    public void test2(HttpServletResponse response) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("msg", "<p><span style=\"color: #333333; font-family: Arial, sans-serif; font-size: 13px; background-color: #ffffff;\">简述清末的政党监督思想</span></p>");
            map.put("img", "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");


            org.fit.cssbox.demo.ImageRenderer render = new org.fit.cssbox.demo.ImageRenderer();
//            render.renderURL(url, out, org.fit.cssbox.demo.ImageRenderer.Type.PNG);

            FreemarkerUtils.turnImage(ItemType.IMAGE_MIX.getFileName(), map, response);
        } catch (Exception e) {
            log.error("异常", e.getMessage());
        }
    }


    /**
     * 清楚字体样式数据
     *
     * @param content 内容
     * @return 字符串结果集
     */
    public static String removeFamilyStyle(String content) {
        String regEx2 = "font-family:(.*?);";
        Pattern p2 = Pattern.compile(regEx2);
        Matcher m2 = p2.matcher(content);
        if (m2.find()) {
            content = m2.replaceAll("");
        }
        return content;
    }


}
