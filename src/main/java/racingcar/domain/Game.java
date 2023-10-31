package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.Converter;

public class Game {

    private List<Car> carList = new ArrayList<>();
    private List<Car> winner = new ArrayList<>();

    private Player player;
    private Long gameCount;

    public void raceSetting() {
        setPlayer();
        setCarList();
        setGameCount();
    }

    public void race() {
        while (leftGameCount()) {
            gameCount--;
            raceOneTime();
        }
    }

    private void setPlayer() {
        player = new Player();
    }

    private void setCarList() {
        player.inputCarNames();
        List<String> carNames = player.getCarNames();
        carList = Converter.convertStringListToCarList(carNames);
    }

    private void setGameCount() {
        player.inputGameCount();
        gameCount = player.getGameCount();
    }

    private boolean leftGameCount() {
        return gameCount != 0;
    }

    private void raceOneTime() {
        carList.forEach(Car::tryMove);
        carList.forEach(Car::printCurrentLocation);
    }

}
