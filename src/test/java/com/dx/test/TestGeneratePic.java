package com.dx.test;

/**
 * Description:
 *
 * @author cs
 * @version 1.0
 * @copyright Copyright (c) cs
 * @since 2022/4/3
 */

import lombok.extern.slf4j.Slf4j;
import org.fit.cssbox.demo.ImageRenderer;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;

@SpringBootTest
@Slf4j
public class TestGeneratePic {

    /**
     * org.fit.cssbox
     */
    @Test
    public void test() {
        try {
            ImageRenderer render = new ImageRenderer();
            render.setWindowSize(new Dimension(800, 1000), false);
            System.out.println("kaishi");
            String url = new File("D:\\project\\toimage\\src\\main\\resources\\templates\\image_mix_has.html").toURI().toString();
            FileOutputStream out = new FileOutputStream(new File("D:" + File.separator + "cssbox.png"));
            render.renderURL(url, out, ImageRenderer.Type.PNG);

            Thread.sleep(1000);
            System.out.println("OK");


//            try (DocumentSource docSource = new StreamDocumentSource(JAFIOUtils.toInputStream("htmlSource"),
//                    null, "text/html;charset=UTF-8")) {
//                log.error("Before parse " + "");
//                // Parse the input document
//                DOMSource parser = new DefaultDOMSource(docSource);
//                Document doc = parser.parse();
//                log.error("After parse " + doc.getFirstChild().getTextContent());
//            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * org.fit.cssbox
     */
    @Test
    public void test2() {
        try {
            ImageRenderer render = new ImageRenderer();
            System.out.println("start...");
            String url = "https://www.runoob.com/";
            FileOutputStream out = new FileOutputStream(new File("D:" + File.separator + "html.png"));
            render.renderURL(url, out, ImageRenderer.Type.PNG);
            Thread.sleep(10000);
            out.close();
            System.out.println("OK");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}