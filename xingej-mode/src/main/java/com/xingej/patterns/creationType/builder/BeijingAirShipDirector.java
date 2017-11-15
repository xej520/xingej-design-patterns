package com.xingej.patterns.builder;

/**
 * 实现组装者
 * 
 * @author erjun 2017年11月10日 下午2:17:00
 */
public class BeijingAirShipDirector implements AirShipDirector {
    private AirShipBuilder airShipBuilder;

    public BeijingAirShipDirector(AirShipBuilder airShipBuilder) {
        this.airShipBuilder = airShipBuilder;
    }

    @Override
    public AirShip directAirShip() {
        Engine engine = airShipBuilder.builderEngine();
        EscapeTower escapeTower = airShipBuilder.builderEscapeTower();
        OrbitalModule orbitalModule = airShipBuilder.builderOrbitalModule();

        AirShip airShip = new AirShip();

        airShip.setEngine(engine);
        airShip.setEscapeTower(escapeTower);
        airShip.setOrbitalModule(orbitalModule);

        return airShip;
    }

}
