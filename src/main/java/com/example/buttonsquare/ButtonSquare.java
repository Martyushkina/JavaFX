package com.example.buttonsquare;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;


public class ButtonSquare extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Scene scene = new Scene(group, 800, 600);
        Label label_task = new Label("Площадь пересечения: ");
        label_task.setLayoutX(250);
        label_task.setLayoutY(50);
        label_task.setStyle("-fx-border-color: lightblue;");
        label_task.setMinHeight(30);
        label_task.setMaxHeight(30);
        label_task.setMinWidth(300);
        label_task.setMaxWidth(300);
        label_task.setFont(new Font(15));
        label_task.setAlignment(Pos.CENTER);

        Label label_A = new Label("");
        label_A.setLayoutX(200);
        label_A.setLayoutY(100);
        label_A.setStyle("-fx-border-color: lightgreen;");
        label_A.setMinHeight(50);
        label_A.setMaxHeight(50);
        label_A.setMinWidth(100);
        label_A.setMaxWidth(100);
        label_A.setFont(new Font(15));
        label_A.setAlignment(Pos.CENTER);
        final double[] label_ACoords = new double[2];

        Label label_B = new Label("");
        label_B.setLayoutX(500);
        label_B.setLayoutY(300);
        label_B.setStyle("-fx-border-color: red;");
        label_B.setMinHeight(50);
        label_B.setMaxHeight(50);
        label_B.setMinWidth(100);
        label_B.setMaxWidth(100);
        label_B.setFont(new Font(15));
        label_B.setAlignment(Pos.CENTER);
        final double[] label_BCoords = new double[2];

        label_A.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("A");
                label_ACoords[0] = mouseEvent.getX();
                label_ACoords[1] = mouseEvent.getY();
            }
        });
        double[] borders = new double[2];
        label_A.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label_A.setLayoutX(mouseEvent.getSceneX() - label_ACoords[0]);
                label_A.setLayoutY(mouseEvent.getSceneY() - label_ACoords[1]);
                double[] coordsX = new double[]{label_A.getLayoutX(),label_A.getLayoutX() + 100};
                double[] coordsY = new double[]{label_A.getLayoutY(),label_A.getLayoutY() + 50};
                int corner = 0;
                double a, b;

                if (label_B.getLayoutX() >= coordsX[0] & label_B.getLayoutX() <= coordsX[1] &
                        label_B.getLayoutY() >= coordsY[0] & label_B.getLayoutY() <= coordsY[1]){
                    corner = 1;

                } else if(label_B.getLayoutX() + 100 >= coordsX[0] & label_B.getLayoutX() + 100 <= coordsX[1] &
                        label_B.getLayoutY()  >= coordsY[0] & label_B.getLayoutY() <= coordsY[1]){
                    corner = 2;
                } else if(label_B.getLayoutX() >= coordsX[0] & label_B.getLayoutX() <= coordsX[1] &
                        label_B.getLayoutY() + 50 >= coordsY[0] & label_B.getLayoutY() + 50 <= coordsY[1]){
                    corner = 3;
                } else if(label_B.getLayoutX() + 100 >= coordsX[0] & label_B.getLayoutX() + 100 <= coordsX[1] &
                        label_B.getLayoutY() + 50 >= coordsY[0] & label_B.getLayoutY() +50 <= coordsY[1]) {
                    corner = 4;
                }

                if (corner == 1) {
                    a = coordsX[1] - label_B.getLayoutX();
                    b = coordsY[1] - label_B.getLayoutY();
                } else if (corner == 2){
                    a = label_B.getLayoutX() + 100 - coordsX[0];
                    b = coordsY[1]  - label_B.getLayoutY();
                } else if (corner == 3) {
                    a = coordsX[1] - label_B.getLayoutX();
                    b = label_B.getLayoutY() + 50 - coordsY[0];
                } else if (corner == 4){
                    a = label_B.getLayoutX() + 100 - coordsX[0];
                    b = label_B.getLayoutY() + 50 - coordsY[0];
                } else {
                    a = 0;
                    b = 0;
                }
                borders[0] = a;
                borders[1] = b;
                label_task.setText("Площадь пересечения: " + Math.round(borders[0] * borders[1]));
            }
        });

        label_B.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("B");
                label_BCoords[0] = mouseEvent.getX();
                label_BCoords[1] = mouseEvent.getY();
            }
        });


        label_B.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label_B.setLayoutX(mouseEvent.getSceneX() - label_BCoords[0]);
                label_B.setLayoutY(mouseEvent.getSceneY() - label_BCoords[1]);
                double[] coordsX = new double[]{label_B.getLayoutX(),label_B.getLayoutX() + 100};
                double[] coordsY = new double[]{label_B.getLayoutY(),label_B.getLayoutY() + 50};
                int corner = 0;
                double a, b;

                if (label_A.getLayoutX() >= coordsX[0] & label_A.getLayoutX() <= coordsX[1] &
                        label_A.getLayoutY() >= coordsY[0] & label_A.getLayoutY() <= coordsY[1]){
                    corner = 1;
                } else if(label_A.getLayoutX() + 100 >= coordsX[0] & label_A.getLayoutX() + 100 <= coordsX[1] &
                        label_A.getLayoutY()  >= coordsY[0] & label_A.getLayoutY() <= coordsY[1]){
                    corner = 2;
                } else if(label_A.getLayoutX() >= coordsX[0] & label_A.getLayoutX() <= coordsX[1] &
                        label_A.getLayoutY() + 50 >= coordsY[0] & label_A.getLayoutY() + 50 <= coordsY[1]){
                    corner = 3;
                } else if(label_A.getLayoutX() + 100 >= coordsX[0] & label_A.getLayoutX() + 100 <= coordsX[1] &
                        label_A.getLayoutY() + 50 >= coordsY[0] & label_A.getLayoutY() +50 <= coordsY[1]) {
                    corner = 4;
                }

                if (corner == 1) {
                    a = coordsX[1] - label_A.getLayoutX();
                    b = coordsY[1] - label_A.getLayoutY();
                } else if (corner == 2){
                    a = label_A.getLayoutX() + 100 - coordsX[0];
                    b = coordsY[1]  - label_A.getLayoutY();
                } else if (corner == 3) {
                    a = coordsX[1] - label_A.getLayoutX();
                    b = label_A.getLayoutY() + 50 - coordsY[0];
                } else if (corner == 4){
                    a = label_A.getLayoutX() + 100 - coordsX[0];
                    b = label_A.getLayoutY() + 50 - coordsY[0];
                } else {
                    a = 0;
                    b = 0;
                }
                borders[0] = a;
                borders[1] = b;
                label_task.setText("Площадь пересечения: " + Math.round(borders[0] * borders[1]));
            }
        });

        group.getChildren().add(label_task);
        group.getChildren().add(label_A);
        group.getChildren().add(label_B);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();

    }
}