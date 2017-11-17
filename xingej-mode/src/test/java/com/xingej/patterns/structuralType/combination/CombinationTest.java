package com.xingej.patterns.structuralType.combination;

import org.junit.Test;

import com.xingej.patterns.structuralType.combination.composite.Folder;
import com.xingej.patterns.structuralType.combination.composite.ImageFolder;
import com.xingej.patterns.structuralType.combination.composite.TextFolder;
import com.xingej.patterns.structuralType.combination.leaf.ImageFile;
import com.xingej.patterns.structuralType.combination.leaf.TextFile;

/**
 * 组合模式：测试
 * 
 * 
 * @author erjun 2017年11月17日 下午1:58:48
 */
public class CombinationTest {

    // 对图形文件 进行杀毒
    @Test
    public void test() {
        AbstractFile imageFile1 = new ImageFile("北京香山夜景");
        AbstractFile imageFile2 = new ImageFile("北京颐和园夜景");
        AbstractFile imageFile3 = new ImageFile("北京鸟巢夜景");

        ImageFolder imageFolder = new ImageFolder("图形文件夹");

        imageFolder.add(imageFile1);
        imageFolder.add(imageFile2);
        imageFolder.add(imageFile3);

        imageFolder.killVirus();

    }

    // 对文本文件 进行杀毒
    @Test
    public void test2() {

        AbstractFile textFile1 = new TextFile("西游记电子版");
        AbstractFile textFile2 = new TextFile("红楼梦电子版");
        AbstractFile textFile3 = new TextFile("三国演义电子版");

        TextFolder textFolder = new TextFolder("文本文件夹");

        textFolder.add(textFile1);
        textFolder.add(textFile2);
        textFolder.add(textFile3);

        textFolder.killVirus();

    }

    // 对整个文件夹 进行杀毒
    // 这里体现了，
    // ------------>递归调用<-------
    //
    @Test
    public void test3() {
        AbstractFile imageFile1 = new ImageFile("北京香山夜景");
        AbstractFile imageFile2 = new ImageFile("北京颐和园夜景");
        AbstractFile imageFile3 = new ImageFile("北京鸟巢夜景");

        AbstractFile textFile1 = new TextFile("西游记电子版");
        AbstractFile textFile2 = new TextFile("红楼梦电子版");
        AbstractFile textFile3 = new TextFile("三国演义电子版");

        ImageFolder imageFolder = new ImageFolder("图形文件夹");
        TextFolder textFolder = new TextFolder("文本文件夹");

        imageFolder.add(imageFile1);
        imageFolder.add(imageFile2);
        imageFolder.add(imageFile3);

        textFolder.add(textFile1);
        textFolder.add(textFile2);
        textFolder.add(textFile3);

        Folder folder = new Folder("综合文件夹");

        folder.add(imageFolder);
        folder.add(textFolder);

        folder.killVirus();

    }

}
