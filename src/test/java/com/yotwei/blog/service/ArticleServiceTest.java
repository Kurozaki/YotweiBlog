package com.yotwei.blog.service;

import com.yotwei.blog.dao.TagDao;
import com.yotwei.blog.enity.ArticleContent;
import com.yotwei.blog.enity.ArticlePreview;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by YotWei on 2018/6/28.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class ArticleServiceTest {

    @Autowired
    private TagDao tagDao;

    @Autowired
    private ArticleService articleService;

    @Test
    public void getArticlePreviewList() {

        String title = "关于 0.1+0.2 == 0.3 不成立的一些细节";
        String intro = "js下0.1+0.2并不会精确地等于0.3，实际上这并不是js特有的问题，这个问题是计算机处理浮点数运算的过程中产生的";

        ArticlePreview pv = new ArticlePreview();
        ArticleContent ct = new ArticleContent();
        pv.setTitle(title);
        pv.setIntro(intro);

        ct.setContent("<p>\n" +
                "                    很早之前看到一关于js的问题，如下\n" +
                "                </p>\n" +
                "                <pre><code>&gt;&gt; 0.1+0.2\n" +
                "&lt; 0.300000000000004</code></pre>\n" +
                "                <p>\n" +
                "                    实际上 0.1+0.2 != 0.3 这个问题不是js特有，来看一段java代码\n" +
                "                </p>\n" +
                "                <pre>\n" +
                "                    <code>@Test\n" +
                "public strictfp void test() {\n" +
                "    System.out.println(0.1f + 0.2f == 0.3f);\n" +
                "    System.out.println(0.1 + 0.2 == 0.3);\n" +
                "}</code></pre>\n" +
                "                <p>\n" +
                "                    程序的运行结果是\n" +
                "                </p>\n" +
                "                <pre><code>true\n" +
                "false</code></pre>\n" +
                "                <p>\n" +
                "                    这个问题应该是基础中的基础，众所周知，这是一个不可避免的浮点数精度丢失问题，同十进制一样，二进制中也会存在无限循环小数，而计算机对浮点数的表示通常是用 32 或 64\n" +
                "                    位的二进制，这使得在二进制的表达上必须采用“截断”的手段丢掉一些二进制位\n" +
                "                </p>\n" +
                "                <p>\n" +
                "                    下面我来分析为什么上面的运行结果是这样，由于Java不能直接查看浮点数的十六进制表达，所以用c语言来分析\n" +
                "                </p>\n" +
                "                <h2>\n" +
                "                    1、IEEE754 标准\n" +
                "                </h2>\n" +
                "                <p>\n" +
                "                    IEEE754是最广泛运用的浮点数表达的格式。Java里面有一个不怎么常见的strictfp关键字，用于修饰方法，被修饰的方法中的浮点运算都会严格遵守IEEE754规范。关于IEE754的细节，可以翻阅相关资料，这里就讨论主要的。\n" +
                "                </p>\n" +
                "                <h2>\n" +
                "                    2、IEEE754 标准下浮点数的存储格式\n" +
                "                </h2>\n" +
                "                <p>\n" +
                "                    浮点数的存储分为三个部分，s, e, f，对应符号(sign)，指数(exp)，有效数位(fraction)\n" +
                "                </p>\n" +
                "                <p>\n" +
                "                    对于float，s+e+f = 1+8+23\n" +
                "                </p>\n" +
                "                <p>\n" +
                "                    对于double，s+e+f=1+11+52\n" +
                "                </p>\n" +
                "                <h3>\n" +
                "                    来看下面一段代码\n" +
                "                </h3>\n" +
                "                <p>\n" +
                "                    准备两个函数，用于显示浮点数的二进制表达\n" +
                "                </p>\n" +
                "                <pre>\n" +
                "                    <code>void float_hex(float* f) {\n" +
                "    int *p = (int *)f;\n" +
                "    printf(\"%f -> %08x\\n\", *f, *p);\n" +
                "}\n" +
                "\n" +
                "void double_hex(double* d){\n" +
                "    int *p = (int *)d;\n" +
                "    printf(\"%lf -> %08x %08x\\n\", *d, *p, *(p+1));\n" +
                "}</code></pre>\n" +
                "                <p>\n" +
                "                    main函数的调用\n" +
                "                </p>\n" +
                "                <pre><code>int main() {\n" +
                "    float f = 0.1f;\n" +
                "    float_hex(&f);\n" +
                "\n" +
                "    double d = 0.1;\n" +
                "    double_hex(&d);\n" +
                "    return 0;\n" +
                "}</code></pre>\n" +
                "                <h3>\n" +
                "                    运行结果\n" +
                "                </h3>\n" +
                "                <pre><code>0.1 -> 3dcccccd\n" +
                "0.1 -> 9999999a 3fb99999</code></pre>\n" +
                "                <p>下面来分析一下为什么是这样子</p>\n" +
                "                <h3>\n" +
                "                    1）规范化表达\n" +
                "                </h3>\n" +
                "                <p>\n" +
                "                    下面来验证一下，对于0.1，转化成二进制表达\n" +
                "                </p>\n" +
                "                <pre><code>0.000011001100110011....</code></pre>\n" +
                "                <p>\n" +
                "                    规范化表达（类似于十进制的科学记数法）\n" +
                "                </p>\n" +
                "                <pre><code>1.100110011001100 x 2^-4</code></pre>\n" +
                "                <p>\n" +
                "                    其中符号位0。\n" +
                "                </p>\n" +
                "                <h3>\n" +
                "                    2）指数的表达\n" +
                "                </h3>\n" +
                "                <p>\n" +
                "                    接下来的指数部分应该是-4，可是实际上存储的是是0111 1011，实际上这是<label style=\"color: darkred;\">移码的表达\n" +
                "                </label>，移的是127，也就是指数部分存储的最终内容是127+(-4)=123，也就是0111 1011\n" +
                "                </p>\n" +
                "                <h3>\n" +
                "                    3）有效部分截断时的四舍五入\n" +
                "                </h3>\n" +
                "                <p>\n" +
                "                    有效数位部分按道理来讲是 1100 1100 1100 的循环直至截断，由于规范化表达，使得小数点左边的一位一定是1，所以这一位被省略了，剩下的就是1001 1001\n" +
                "                    1001的循环，由于有效只能表达23位，所以应该是（灰色表达要被丢弃的部分）\n" +
                "                </p>\n" +
                "                <pre><code>100 1100 1100 1100 1100 1100 <label\n" +
                "                        style=\"color: lightgray\">1100 1100...</label></code></pre>\n" +
                "\n" +
                "                <p>\n" +
                "                    细心的人会注意到<strong>最后四位并不是1100，而是1101</strong>，这是因为截断尾数时采用了四舍五入的方式，如果截断的部分第一位为1，说明截断部分的数值大于或等于上一位的1/2，因此向前进一位所表达的误差会更小，因此被截断的\n" +
                "                    1100 1100 1100.. 会对上一位产生进位影响，所以最后四位是1100 + 1 = 1101\n" +
                "                </p>\n" +
                "                <p>\n" +
                "                    对于double型也是一样的方式，值得注意的是代码中显示的是 9999 9999a 3fb9 9999， 但实际上这个double的表达是 3fb9 9999 9999\n" +
                "                    9999a，代码打印的结果是因为这里采用<strong>大端存储</strong>的缘故\n" +
                "                </p>\n" +
                "\n" +
                "                <h2>\n" +
                "                    3、浮点数加法\n" +
                "                </h2>\n" +
                "                <p>\n" +
                "                    指数不同的两个浮点数是不能直接相加的，拿0.1+0.2举例\n" +
                "                </p>\n" +
                "                <p>\n" +
                "                    0.2的有效数位表达和0.1是相同的，但是指数部分比0.1的指数多1，因为恰好0.1x2=0.2，也可以写代码验证一下。\n" +
                "                </p>\n" +
                "                <p>\n" +
                "                    0.1的指数部分是-4，0.2指数部分是-3，小阶要向大阶“看齐”，0.1若要表示成指数为-3，就需要将有效数位整体右移，这样一来就能对有效数位相加\n" +
                "                </p>\n" +
                "\n" +
                "                <pre><code> 1.100 1100 1100 1100 1100 1101 <label style=\"color: orange\">0</label>\n" +
                " 0.110 0110 0110 0110 0110 0110 <label style=\"color: orange\">1</label>\n" +
                "______________________________________\n" +
                "10.011 0011 0011 0011 0011 0011 <label style=\"color: orange\">1</label></code></pre>\n" +
                "                <p>\n" +
                "                    橙色部分不会因为右移而丢失，因为在计算浮点数的时候会运用两个比float位数多的临时变量来计算，double也是\n" +
                "                </p>\n" +
                "                <p>\n" +
                "                    规范化，四舍五入后尾数为\n" +
                "                </p>\n" +
                "                <pre><code>001 1001 1001 1001 1010</code></pre>\n" +
                "                <p>\n" +
                "                    指数为-2，表达出来是 0111 1101，0.1+0.2的结果应该表达为\n" +
                "                </p>\n" +
                "                <pre><code>0011 1110 1001 1001 1001 1001 1001 1010（3E99 999A）</code></pre>\n" +
                "                <h2>\n" +
                "                    4、为什么 0.1f+0.2f == 0.3f 成立\n" +
                "                </h2>\n" +
                "                <p>\n" +
                "                    上面分析的是0.1+0.2都是浮点数表达，即0.1f+0.2f，结果是3E99 999A，直接用浮点数表达0.3f，也会得到结果3E99\n" +
                "                    999A，所以Java代码中第一个双等号的结果是true。因此，这个\n" +
                "                    true 的产生是二者截断后恰好都有进位的原因，并不是精确意义上的相等。\n" +
                "                </p>\n" +
                "                <h2>\n" +
                "                    5、为什么0.1+0.2 == 0.3 不成立\n" +
                "                </h2>\n" +
                "                <p>\n" +
                "                    用同样的方式分析double，给double型变量直接赋值 0.3 和赋值 0.1+0.2 会得到不一样的结果，具体原因是 0.1 + 0.2的时候尾数截断产生了进位，而直接表达 0.3\n" +
                "                    的时候没有，详细流程可以自己分析一下，这里不赘述。 因此Java代码中第二个双等号的结果是false\n" +
                "                </p>\n" +
                "\n" +
                "                <h2>\n" +
                "                    6、判断浮点数的运算结果\n" +
                "                </h2>\n" +
                "                <p>\n" +
                "                    如果要想判断0.1+0.2==0.3，应该写成形如 Math.abs(0.1+0.2 - 0.3) < 1e-6 的形式。\n" +
                "                </p>");

        System.out.println(articleService.addArticle(pv, ct));
    }

    @Test
    public void getArticleCatalogs() {
        System.out.println(articleService.getArticleCatalogs());
    }
}

