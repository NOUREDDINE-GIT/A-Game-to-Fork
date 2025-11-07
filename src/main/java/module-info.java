package com.ieselgrao.gametofork.controller;

import com.ieselgrao.gametofork.model.GameModel;
import com.ieselgrao.gametofork.MainApplication;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

public class GameController {

    @FXML
    private Pane gamePane;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label livesLabel;

    private GameModel model;
    private AnimationTimer gameLoop;
    private Random random = new Random();

    // Parámetros de los círculos
    private final double MIN_RADIUS = 10;
    private final double MAX_RADIUS = 30;
    private final double FALL_SPEED = 1;
    private final double LOST_LINE_Y = 550; // Línea cerca del pie de la ventana (600px)

    @FXML
    public void initialize() {
        model = MainApplication.getGameModel();

        // 🟩 Bind score and lives labels to model properties
        scoreLabel.textProperty().bind(model.scoreProperty().asString("Puntuación: %d"));
        livesLabel.textProperty().bind(model.livesProperty().asString("Vidas: %d"));

        // Dibuja la línea roja de pérdida de vida
        Line lossLine = new Line(0, LOST_LINE_Y, gamePane.getWidth(), LOST_LINE_Y);
        lossLine.setStroke(Color.RED);
        lossLine.setStrokeWidth(2);
        gamePane.getChildren().add(lossLine);

        // Inicia el ciclo del juego
        startGameLoop();
    }

    private void startGameLoop() {
        gameLoop = new AnimationTimer() {
            private long lastSpawnTime = 0;
            private final long SPAWN_INTERVAL_NS = 1_000_000_000L; // Spawn cada 1 segundo

            @Override
            public void handle(long now) {
                if (now - lastSpawnTime > SPAWN_INTERVAL_NS) {
                    createRandomCircle();
                    lastSpawnTime = now;
                }

                updateCircles();

                if (model.isGameOver()) {
                    stop();
                    try {
                        MainApplication.switchToGameOverView();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        gameLoop.start();
    }

    private void createRandomCircle() {
        double radius = MIN_RADIUS + (MAX_RADIUS - MIN_RADIUS) * random.nextDouble();
        double x = radius + (random.nextDouble() * (gamePane.getWidth() - 2 * radius));

        Circle circle = new Circle(radius, Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        circle.setLayoutX(x);
        circle.setLayoutY(-radius);

        // 🟩 Smaller circles give more points
        int points = (int) (MAX_RADIUS - radius + 1);
        circle.setUserData(points);

        // 🟩 Clicking adds score and removes the circle
        circle.setOnMouseClicked(event -> {
            model.addScore((int) circle.getUserData());
            gamePane.getChildren().remove(circle);
            event.consume();
        });

        gamePane.getChildren().add(circle);
    }

    private void updateCircles() {
        Iterator<javafx.scene.Node> iterator = gamePane.getChildren().iterator();
        while (iterator.hasNext()) {
            javafx.scene.Node node = iterator.next();
            if (node instanceof Circle circle) {
                circle.setLayoutY(circle.getLayoutY() + FALL_SPEED);

                if (circle.getLayoutY() > LOST_LINE_Y) {
                    model.loseLife();
                    iterator.remove();
                }
            }
        }
    }
}
}