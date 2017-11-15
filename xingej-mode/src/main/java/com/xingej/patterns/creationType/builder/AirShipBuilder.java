package com.xingej.patterns.creationType.builder;

/**
 * 定义构建者 接口，
 * 
 * 类似于 抽象工厂模式
 * 
 * @author erjun 2017年11月10日 下午2:15:55
 */
public interface AirShipBuilder {
    Engine builderEngine();

    EscapeTower builderEscapeTower();

    OrbitalModule builderOrbitalModule();
}
