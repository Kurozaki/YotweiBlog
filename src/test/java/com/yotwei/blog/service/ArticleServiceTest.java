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

        String title = "自己动手实现BlockingQueue";
        String intro = "Java的java.util.concurrent" +
                ".*包下有许多在并发场景下使用的集合，ArrayBlockingQueue是其中之一，它是一个循环队列，这个队列的特别之处在于take方法与put" +
                "方法，分别对应队列的元素出列和元素入列操作，当队列为空时，take会使得线程进入等待状态...";

        ArticlePreview pv = new ArticlePreview();
        ArticleContent ct = new ArticleContent();
        pv.setTitle(title);
        pv.setIntro(intro);

        ct.setContent("                <p>\n" +
                "                    Java的java.util.concurrent.*包下有许多在并发场景下使用的集合，ArrayBlockingQueue是其中之一，它是一个循环队列，这个队列的特别之处在于take方法与put方法，分别对应队列的元素出列和元素入列操作，当队列为空时，take会使得线程进入等待状态，直到队列不为空，有元素能够出列才会继续执行；同理，当队列满时，put方法也会使得线程进入等待状态。\n" +
                "                </p>\n" +
                "                <p>\n" +
                "                    实际上这是一个生产者-消费者模型，按照理解， 自己也试着实现了一个，代码如下\n" +
                "                </p>\n" +
                "                <pre>\n" +
                "                    <code>/**\n" +
                " * Created by YotWei on 2018/7/1.\n" +
                " */\n" +
                "public class BlockingQueue&lt;E&gt; {\n" +
                "\n" +
                "    /**\n" +
                "     * 有界队列内部固定长度，因此可以用数组实现\n" +
                "     */\n" +
                "    private Object[] elements;\n" +
                "\n" +
                "    /**\n" +
                "     * 队列的头和尾下标\n" +
                "     */\n" +
                "    private int head = 0, tail = 0;\n" +
                "\n" +
                "    /**\n" +
                "     * 队列目前的长度\n" +
                "     */\n" +
                "    private int size;\n" +
                "\n" +
                "    private ReentrantLock lock = new ReentrantLock();\n" +
                "\n" +
                "    private Condition notEmpty = lock.newCondition();\n" +
                "\n" +
                "    private Condition notFull = lock.newCondition();\n" +
                "\n" +
                "    public BlockingQueue(int capacity) {\n" +
                "        this.elements = new Object[capacity];\n" +
                "    }\n" +
                "\n" +
                "    public void put(E e) {\n" +
                "        lock.lock();\n" +
                "        try {\n" +
                "            while (size == elements.length)\n" +
                "                notFull.await();\n" +
                "            elements[tail] = e;\n" +
                "            if (++tail == elements.length) {\n" +
                "                tail = 0;\n" +
                "            }\n" +
                "            size++;\n" +
                "            notEmpty.signal();\n" +
                "\n" +
                "        } catch (InterruptedException ex) {\n" +
                "            ex.printStackTrace();\n" +
                "        } finally {\n" +
                "            lock.unlock();\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    public E take() {\n" +
                "        lock.lock();\n" +
                "        E e = null;\n" +
                "        try {\n" +
                "            while (size == 0) {\n" +
                "                notEmpty.await();\n" +
                "            }\n" +
                "            e = (E) elements[head];\n" +
                "            elements[head] = null;\n" +
                "            if (++head == elements.length)\n" +
                "                head = 0;\n" +
                "            size--;\n" +
                "            notFull.signal();\n" +
                "\n" +
                "        } catch (InterruptedException ex) {\n" +
                "            ex.printStackTrace();\n" +
                "        } finally {\n" +
                "            lock.unlock();\n" +
                "        }\n" +
                "        return e;\n" +
                "    }\n" +
                "\n" +
                "    public int size() {\n" +
                "        lock.lock();\n" +
                "        try {\n" +
                "            return size;\n" +
                "        } finally {\n" +
                "            lock.unlock();\n" +
                "        }\n" +
                "    }\n" +
                "}</code></pre>\n" +
                "                <p>\n" +
                "                    实际上ArrayBlockingQueue还包含许多其它方法，这两个是最核心的。\n" +
                "                </p>");

        System.out.println(articleService.addArticle(pv, ct));
    }

    @Test
    public void getArticleCatalogs() {
        System.out.println(articleService.getArticleCatalogs());
    }
}

