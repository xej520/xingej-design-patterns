package com.xingej.patterns.builder;

/**
 * 构造者接口
 * 
 * @author erjun 2017年11月10日 下午2:17:25
 */
public class BeijingAirShipBuilder implements AirShipBuilder {

    @Override
    public Engine builderEngine() {
        System.out.println("成功构建北京牌发动机!");
        return new Engine("北京发动机!");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("北京牌逃逸塔!");
        return new EscapeTower("北京牌逃逸塔");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        System.out.println("北京牌轨道!");
        return new OrbitalModule("北京牌轨道");
    }

}
