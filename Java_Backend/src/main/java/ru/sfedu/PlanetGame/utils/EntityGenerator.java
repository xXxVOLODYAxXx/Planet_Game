package ru.sfedu.PlanetGame.utils;

import ru.sfedu.PlanetGame.controllers.UnitController;
import ru.sfedu.PlanetGame.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntityGenerator {
    private static Random random = new Random();

    public static Unit generateUnit() {
        Unit unit = new Unit();
        unit.setFoodRequired(EntityGenerator.random.nextInt());
        unit.setUnitAttackPoints(EntityGenerator.random.nextInt());
        unit.setUnitHealthPoints(EntityGenerator.random.nextInt());
        unit.setGoldRequired(EntityGenerator.random.nextInt());
        unit.setMetalRequired(EntityGenerator.random.nextInt());
        unit.setUnitType(UnitType.Melee);
        return unit;
    }

    public static Building generateBuilding() {
        Building building = new Building();
        building.setFoodBuff(EntityGenerator.random.nextInt());
        building.setGoldBuff(EntityGenerator.random.nextInt());
        building.setMetalBuff(EntityGenerator.random.nextInt());
        building.setFoodCost(EntityGenerator.random.nextInt());
        building.setGoldCost(EntityGenerator.random.nextInt());
        building.setMetalBuff(EntityGenerator.random.nextInt());
        building.setBuildingType(BuildingType.Farm);
        return building;
    }

    public static ArmyInfo generateArmyInfo() {
        ArmyInfo armyInfo = new ArmyInfo();
        armyInfo.setTotalHealth(EntityGenerator.random.nextInt());
        armyInfo.setTotalDamage(EntityGenerator.random.nextInt());
        return armyInfo;
    }

    public static Army generateArmy(){
        Army army = new Army();
        ArmyInfo armyInfo = generateArmyInfo();
        army.setArmyInfo(armyInfo);
        List<Unit> unitList = new ArrayList<>();
        unitList.add(generateUnit());
        unitList.add(generateUnit());
        army.setUnits(unitList);
        System.out.println(army);
        return army;
    }

    public static Resources generateResources() {
        Resources resources = new Resources();
        resources.setArmy(generateArmy());
        resources.setFood(EntityGenerator.random.nextInt());
        resources.setGold(EntityGenerator.random.nextInt());
        resources.setMetal(EntityGenerator.random.nextInt());
        List<Building> buildingList = new ArrayList<>();
        buildingList.add(generateBuilding());
        buildingList.add(generateBuilding());
        resources.setBuildingList(buildingList);
        resources.setOperation(0);
        return resources;
    }

    public static EnemyPlanet generateEnemyPlanet() {
        EnemyPlanet enemyPlanet = new EnemyPlanet();
        enemyPlanet.setEnemyAttackPoints(EntityGenerator.random.nextInt());
        enemyPlanet.setEnemyHealthPoints(EntityGenerator.random.nextInt());
        enemyPlanet.setType("ENEMY");
        enemyPlanet.setPlanetName("A");
        return enemyPlanet;
    }

    public static PlayerPlanet generatePlayerPlanet() {
        PlayerPlanet playerPlanet = new PlayerPlanet();
        playerPlanet.setPlanetName("B");
        playerPlanet.setType("PLAYER");
        playerPlanet.setBuildingLimit(EntityGenerator.random.nextInt());
        return playerPlanet;
    }

    public static Game generateGame() {
        Game game = new Game();
        game.setResources(generateResources());
        List<EnemyPlanet> enemyPlanetList = new ArrayList<>();
        enemyPlanetList.add(generateEnemyPlanet());
        enemyPlanetList.add(generateEnemyPlanet());
        List<PlayerPlanet> playerPlanetList = new ArrayList<>();
        playerPlanetList.add(generatePlayerPlanet());
        playerPlanetList.add(generatePlayerPlanet());
        game.setEnemyPlanetList(enemyPlanetList);
        game.setPlayerPlanetList(playerPlanetList);
        game.setTitle("A");
        return game;
    }
}
