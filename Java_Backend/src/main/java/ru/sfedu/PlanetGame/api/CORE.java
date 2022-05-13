package ru.sfedu.PlanetGame.api;

import ru.sfedu.PlanetGame.controllers.*;
import ru.sfedu.PlanetGame.models.*;
import ru.sfedu.PlanetGame.utils.Constants;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CORE {
    UnitController unitController = new UnitController();
    ArmyInfoController armyInfoController = new ArmyInfoController();
    ArmyController armyController = new ArmyController();
    BuildingController buildingController = new BuildingController();
    ResourcesController resourcesController = new ResourcesController();
    PlayerPlanetController playerPlanetController = new PlayerPlanetController();
    EnemyPlanetController enemyPlanetController = new EnemyPlanetController();
    GameController gameController = new GameController();

    /**
     * Создать игру,ресурсы,армию
     * Create game,resources,army
     * @param game Game
     * @return Game
     */

    public Game createUniverse(Game game) throws IOException {
        gameController.create(game);

        return game;
    }
    public Game createUniverse2(Game game,String telegramId) throws IOException {
        game.setTelegramId(telegramId);
        gameController.create(game);

        return game;
    }
    /**
     * Удалить игру,ресурсы,армию
     * Remove game,resources,army
     * @param gameId Long
     * @return Boolean
     */

    public Boolean deleteUniverse(Long gameId) throws IOException {
        try {
            System.out.println("YA ZASHEL UDALAT");
            gameController.delete(gameController.getById(gameId));
            return true;
        } catch (NullPointerException e){
            System.out.println(Constants.WRONG_PARAMETER);
            return false;
        }
    }
    /**
     * Получить вражескую планету по id
     * Get enemy planet by id
     * @param planetId Long
     * @return EnemyPlanet
     */

    public EnemyPlanet getEnemyPower(Long planetId) throws IOException {
        try {
            return enemyPlanetController.getById(planetId);
        } catch (NullPointerException e){
            System.out.println(Constants.WRONG_PARAMETER);
            return null;
        }
    }
    /**
     * Получить информацию об армии по id
     * Get army info by id
     * @param gameId Long
     * @return ArmyInfo
     */

    public ArmyInfo getArmyPower(Long gameId) throws IOException {
        try {
            return gameController.getById(gameId)
                    .getResources()
                    .getArmy()
                    .getArmyInfo();
        }catch (NullPointerException e){
            System.out.println(Constants.YOUR_ARMY_IS_DEAD);
            return null;
        }
    }
    /**
     * Атаковать планету по id
     * Если армия умирает:вы проиграете и данные быдут удалены
     * Если выиграете:вражеская планета станет вашей
     * Attack planet by id
     * if your army dies: you will lose and all data will be deleted
     * if you win: enemy planet will become yours
     * @param planetId Long
     * @param gameId Long
     * @return Boolean
     */

    public Game attackPlanet(Long planetId,Long gameId) throws IOException {
        Boolean result = null;
        System.out.println("103");
        List<Game> gameList = gameController.getAll();
        System.out.println("106");
        Game game = gameList.stream().filter(x -> Objects.equals(x.getTelegramId(), gameId.toString())).findFirst().get();
        System.out.println("108");
        ArmyInfo armyInfo = game.getResources().getArmy().getArmyInfo();
        System.out.println("110");
        EnemyPlanet enemyPlanet = enemyPlanetController.getById(planetId);
        System.out.println("112");
        try {
            while (enemyPlanet.getEnemyHealthPoints() > 0){
                if (armyInfo.getTotalHealth() > 0){
                    armyInfo.setTotalHealth(armyInfo.getTotalHealth() - enemyPlanet.getEnemyAttackPoints());
                    enemyPlanet.setEnemyHealthPoints(enemyPlanet.getEnemyHealthPoints()-armyInfo.getTotalDamage());
                } else {
                    System.out.println("YA TUT");
                    deleteUniverse(game.getId());
                    System.out.println(Constants.GAME_OVER);
                    result=false;
                    System.out.println("PORAZHENIE");
                    return null;
                }}
            if (game.getEnemyPlanetList().isEmpty()) {
                deleteUniverse(game.getId());
                return game;
            }
            List<EnemyPlanet> enemyPlanetList = game.getEnemyPlanetList();
            enemyPlanetList = enemyPlanetList.stream().filter(x -> !Objects.equals(x.getId(), planetId)).collect(Collectors.toList());
            PlayerPlanet playerPlanet = new PlayerPlanet();
            playerPlanet.setPlanetName(enemyPlanet.getPlanetName());
            playerPlanet.setType(Constants.PLAYER);
            playerPlanet.setBuildingLimit(Constants.DEFAULT_BUILDING_LIMIT);
            List<PlayerPlanet> playerPlanetList = game.getPlayerPlanetList();
            playerPlanetList.add(playerPlanet);
            game.setEnemyPlanetList(enemyPlanetList);
            game.setPlayerPlanetList(playerPlanetList);
            gameController.update(game);
            System.out.println("POBEDA");

            return game;
        }catch (NullPointerException e){
            System.out.println(Constants.ENEMY_PLANET+Constants.DO_NOT_EXIST);
            return game;
        }
    }
    /**
     * Добавить юнита в список юнитов
     * Add unit to army unit list
     * @param unitId Long
     * @return Game
     */

    public Game hireUnit(Long unitId,Game game) throws IOException, SQLException {
        Unit unit = getUnitById(unitId);
        System.out.println(game.getResources().getArmy().getArmyInfo());
        System.out.println(unit);
        System.out.println("НАСРАЛ");
        try {
            game
                    .getResources()
                    .getArmy()
                    .getArmyInfo()
                    .setTotalHealth(game
                            .getResources()
                            .getArmy()
                            .getArmyInfo()
                            .getTotalHealth() + unit.getUnitHealthPoints());
            game
                    .getResources()
                    .getArmy()
                    .getArmyInfo()
                    .setTotalDamage(game
                            .getResources()
                            .getArmy()
                            .getArmyInfo()
                            .getTotalDamage() + unit.getUnitAttackPoints());


//            List<Unit> unitList = game
//                    .getResources()
//                    .getArmy()
//                    .getUnits();
//            unitList.add(unit);
//            game
//                    .getResources()
//                    .getArmy()
//                    .setUnits(unitList);
            game
                    .getResources()
                    .setGold(game
                            .getResources()
                            .getGold() - unit.getGoldRequired());
            game
                    .getResources()
                    .setFood(game
                            .getResources()
                            .getFood() - unit.getFoodRequired());
            game
                    .getResources()
                    .setMetal(game
                            .getResources()
                            .getMetal() - unit.getMetalRequired());
            System.out.println("HIRe UNIT ОТРАБОТАЛ");
            System.out.println(game.getResources().getArmy().getArmyInfo());
            game.setTitle("fdsfsdsfd");
            //gameController.update(game);
            return game;
        } catch (NullPointerException e) {
            System.out.println(Constants.WRONG_PARAMETER + "PIZDOGLAZOE MUDILO");
            return game;
        }
    }
    /**
     * Получчить список зданий
     * Get building list
     * @param gameId Long
     * @return List<Building>
     */

    public List<Building> getBuildingsInfo(Long gameId) throws IOException {
        try {return gameController.getById(gameId)
                .getResources()
                .getBuildingList();
        }catch (NullPointerException e){
            return null;
        }

    }
    /**
     * Добавить здание в список зданий
     * Add building to resources building list
     * @param buildingId Long
     * @return Game
     */

    public Game addBuilding(Long buildingId,Game game) throws IOException, SQLException {
        if (game.getId()==null){
            return null;
        } else {
            Building building=getBuildingById(buildingId);
            if (building==null){
                return game;
            } else {
//                game
//                        .getResources()
//                        .getBuildingList().add(building);
                game
                        .getResources()
                        .setGold(game
                                .getResources()
                                .getGold()-building.getGoldCost());
                game
                        .getResources()
                        .setGold(game
                                .getResources()
                                .getGold()+building.getGoldBuff());
                game
                        .getResources()
                        .setMetal(game
                                .getResources()
                                .getMetal()-building.getMetalCost());
                game
                        .getResources()
                        .setMetal(game
                                .getResources()
                                .getMetal()+building.getMetalBuff());
                game
                        .getResources()
                        .setFood(game
                                .getResources()
                                .getFood()-building.getFoodCost());
                game
                        .getResources()
                        .setFood(game
                                .getResources()
                                .getFood()+building.getFoodBuff());
                return game;
            }}
    }
    /**
     * Убрать здание из скписка зданий
     * Remove building from resources building list
     * @param buildingId long
     * @param gameId Long
     * @return Game
     */

    public Game removeBuilding(Long buildingId,Long gameId) throws IOException, SQLException {
        Game game = gameController.getById(gameId);
        try {
            List<Building> buildingList = game
                    .getResources()
                    .getBuildingList();

            buildingList.remove(Math.toIntExact(buildingId)-1);
            game
                    .getResources()
                    .setBuildingList(buildingList);
        } catch (IndexOutOfBoundsException | NullPointerException e){
            System.out.println(Constants.BUILDING_LIST+Constants.IS_EMPTY);
        }

        return game;
    }
    /**
     * Если
     * operation==2 -> Добавить здание в список зданий
     * operation==3 -> Убрать здание из скписка зданий
     * operation==4 -> Добавить юнита в список юнитов
     * И обновить игру,ресурсы,армию
     * If
     * operation==2 -> Add building to resources building list
     * operation==3 -> Remove building from resources building list
     * operation==4 -> Add unit to army unit list
     * And update game,resources,army
     * @param gameId Long
     * @param operation int
     * @param id Long
     * @return Game
     */

    public Game manageResources(Long gameId,Integer operation,Long id) throws IOException {
        List<Game> gameList = gameController.getAll();
        Game game = gameList.stream().filter(x -> Objects.equals(x.getTelegramId(), gameId.toString())).findFirst().get();
        System.out.println("БАТЯ Я НАШЕЛ БАТЯ");
        try {
            switch (operation) {
                case (2) -> game = addBuilding(id, game);
                case (3) -> game = removeBuilding(id, game.getId());
                case (4) -> game = hireUnit(id, game);
                default -> System.out.println(Constants.WRONG_PARAMETER);
            }
            System.out.println("OFOFOFOFFOFOFFOF");
            System.out.println(game.getResources().getArmy().getArmyInfo());
            gameController.update(game);
            System.out.println("AFAFAFAFAFAFAFAFF");
            return game;
        } catch (NullPointerException | SQLException e){
            System.out.println(Constants.GAME+Constants.DO_NOT_EXIST+"dsgfdsfgdfgdfg");
            return game;
        }
    }
    /**
     * Если
     * operation==1 -> Получчить список зданий
     * If
     * operation==1 -> Get building list
     * @param gameId Long
     * @param operation int
     * @return Game
     */

    public Game manageResources(Long gameId,int operation) throws IOException {
        Game game=gameController.getById(gameId);
        if (operation == 1) {
            System.out.println(getBuildingsInfo(gameId));
        } else {
            System.out.println(Constants.WRONG_PARAMETER);
        }
        return game;
    }
    /**
     * Получить здание по id
     * Get building by id
     * @param id Long
     * @return Game
     */

    public Building getBuildingById(Long id) throws IOException {
        return buildingController.getById(id);
    }
    /**
     * Получить юнита по id
     * Get unit by id
     * @param id Long
     * @return Game
     */

    public Unit getUnitById(Long id) throws IOException {
        return unitController.getById(id);
    }
}
