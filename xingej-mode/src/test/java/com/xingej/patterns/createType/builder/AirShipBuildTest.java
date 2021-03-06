package com.xingej.patterns.createType.builder;

import org.junit.Test;

import com.xingej.patterns.creationType.builder.AirShip;
import com.xingej.patterns.creationType.builder.AirShipBuilder;
import com.xingej.patterns.creationType.builder.AirShipDirector;
import com.xingej.patterns.creationType.builder.BeijingAirShipBuilder;
import com.xingej.patterns.creationType.builder.BeijingAirShipDirector;

/**
 * 建造者模式 测试
 * 
 * @author erjun 2017年11月10日 下午2:18:06
 */
public class AirShipBuildTest {

    // 建造者模式测试
    // 有两个角色
    // 构建者：类似于 抽象工厂模式
    // 组装者：简单工厂模式
    @Test
    public void testBuilder() {
        // 创建 构建者
        AirShipBuilder airShipBuilder = new BeijingAirShipBuilder();

        // 创建 组装者
        AirShipDirector airShipDirector = new BeijingAirShipDirector(airShipBuilder);

        AirShip airShip = airShipDirector.directAirShip();

        airShip.luanch();
    }

}
