package com.wyl.designpattern.builder;

/**
 * @auther yanl.wang
 * @date 2023/1/10
 * 建造者模式的四个角色
 *  1。Product(产品角色)：一个具体的产品对象
 *  2。Builder(抽象建造者)：创建一个Product对象的各个部件指定的接口/抽象类
 *  3。ConcreteBuiler(具体建造者)：实现接口，构建和装配各个部件。
 *  4。Director(指挥者)：构建一个使用Builder接口的对象，它主要是用于创建一个复杂的对象。它主要有两个作用，一是：隔离了客户与对象的生产过程，
 *      二是：负责控制产品对象的生产过程。
 *
 * 建造者模式注意事项和细节
 *  1。客户端(使用程序)不必知道产品内部组成的细节，将产品本身与产品的创建过程解耦，使得相同的创建过程可以创建不同的产品对象
 *  2。每一个具体的建造者都相对独立，而与其他的具体建造者无关，因此可以很方便的替换具体建造者或增加新的具体建造者，用户使用不同的建造者即可得到不同的产品对象
 *  3。可以更加精细的控制产品的创建过程。将复杂产品的创建步骤分解在不同的方法中，使得创建过程更加清晰，也更方便使用程序来控制创建过程。
 *  4。增加新的具体建造者无须修改原有类库的代码，指挥者类针对抽象建造者类编程。系统扩展方便，符合"开闭原则"。
 *  5。建造者模式所创建的产品一般具有较多的共同点，其组成部分相似。如果产品间的差异性很大，则不适合使用建造者模式，因此其使用范围受到一定的限制。
 *  6。如果产品内部变化复杂，可能会导致需要定义很多具体的建造者类来实现这种变化，导致系统变得很庞大，因此在这种情况下，要考虑是否选用建造者模式。
 *  7。抽象工厂模式VS建造者模式：
 *      抽象工厂模式实现对产品家族的创建，一个产品家族是这样的一系列产品，具有不同分类纬度的产品组合，采用抽象工厂模式不需要关心构建过程，只关心什么产品由什么
 *      工厂生产即可。而建造者模式则是要求按照指定的蓝图建造产品，它的主要目的是通过组装零配件而产生一个新的产品
 *
 *
 *
 *
 **/
public class Client {
    public static void main(String[] args) {
        //盖普通房子
        CommonsHouse commonsHouse = new CommonsHouse();
        //准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonsHouse);
        //完成盖房，返回产品(房子)
        House house = houseDirector.constructHouse();

        System.out.println("====================================");
        //盖高级房子
        HightHouse hightHouse = new HightHouse();
        //重置建造者
        houseDirector.setHouseBuilder(hightHouse);
        //完成盖房，返回产品(房子)
        houseDirector.constructHouse();
    }
}
