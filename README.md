# 网页转换成图片

- 支持最好的

```
<dependency>
    <groupId>net.sf.cssbox</groupId>
    <artifactId>cssbox</artifactId>
    <version>4.14</version>
</dependency>
```

支持html5和css3最好的是：https://github.com/radkovo/CSSBox/issues/71
缺点是：无法支持中文（https://github.com/radkovo/CSSBox/issues/71）希望以后能解决

- 支持不太友好的，就是html5和css3不支持

  对css不太友好，渲染效果不理想,对字体样式支持不够，所以在获取html后进行了正则处理才进行渲染的

```
<dependency>
    <groupId>gui.ava</groupId>
    <artifactId>html2image</artifactId>
    <version>2.0.1</version>
</dependency>
```

```
<dependency>
    <groupId>org.xhtmlrenderer</groupId>
    <artifactId>core-renderer</artifactId>
    <version>R8</version>
</dependency>

```

```
dependency>
    <groupId>net.sourceforge.nekohtml</groupId>
    <artifactId>nekohtml</artifactId>
    <version>1.9.14</version>
</dependency>

```

```
 <dependency>
    <groupId>com.github.xuwei-k</groupId>
    <artifactId>html2image</artifactId>
    <version>0.1.0</version>
</dependency>

```