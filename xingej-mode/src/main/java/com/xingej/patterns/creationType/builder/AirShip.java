package com.xingej.patterns.creationType.builder;

public class AirShip {
    private OrbitalModule orbitalModule; // 轨道舱

    private Engine engine; // 发动机

    private EscapeTower escapeTower; // 逃逸塔

    // 发射功能
    public void luanch() {
        System.out.println("---->发射升空！-----");
    }

    public OrbitalModule getOrbitalModule() {
        return orbitalModule;
    }

    public void setOrbitalModule(OrbitalModule orbitalModule) {
        this.orbitalModule = orbitalModule;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public EscapeTower getEscapeTower() {
        return escapeTower;
    }

    public void setEscapeTower(EscapeTower escapeTower) {
        this.escapeTower = escapeTower;
    };

}

/**
 * 轨道模型
 * 
 * @author erjun 2017年11月10日 上午10:04:27
 */
class OrbitalModule {
    private String name;

    public OrbitalModule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

/**
 * 引擎模型
 * 
 * @author erjun 2017年11月10日 上午10:06:59
 */
class Engine {
    private String name;

    public Engine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

/**
 * 逃生模型
 * 
 * @author erjun 2017年11月10日 上午10:08:49
 */
class EscapeTower {
    private String name;

    public EscapeTower(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
