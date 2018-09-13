package main;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public static void main(String[] args) {launch(args); }

    @Override
    public void start(Stage primaryStage) {
        //Set le primary stage
        primaryStage.setWidth(800);
        primaryStage.setHeight(400);
        primaryStage.setTitle("Ma maison");
        primaryStage.setResizable(false);

        //Éléments graphiques
        Rectangle cielJour = new Rectangle(0, 0, 400, 400);
        Rectangle cielNuit = new Rectangle(400, 0, 400, 400);
        cielJour.setFill(Color.LIGHTGRAY);
        cielNuit.setFill(Color.BLACK);

        Font font = Font.font(40);

        Text jour = new Text(150, 325, "Jour");
        Text nuit = new Text(555, 325, "Nuit");
        jour.setFill(Color.BLACK);
        jour.setFont(font);
        nuit.setFill(Color.WHITE);
        nuit.setFont(font);

        Rectangle house1 = new Rectangle(150, 200, 100, 50);
        Rectangle house2 = new Rectangle(550, 200, 100, 50);
        house1.setFill(Color.BEIGE);
        house2.setFill(Color.BEIGE);
        DropShadow ds = new DropShadow(10,-10,10, Color.GREY);
        house1.setEffect(ds);


        Polygon toit1 = new Polygon(200, 150, 255, 200, 145, 200);
        Polygon toit2 = new Polygon(600, 150, 655, 200, 545, 200);
        toit1.setFill(Color.BROWN);
        toit2.setFill(Color.BROWN);
        toit1.setEffect(ds);

        Rectangle porte1 = new Rectangle(165, 220, 20, 30);
        Rectangle porte2 = new Rectangle(565, 220, 20, 30);
        porte1.setFill(Color.SADDLEBROWN);
        porte2.setFill(Color.SADDLEBROWN);

        Circle poignee1 = new Circle(180, 235, 4);
        Circle poignee2 = new Circle(580, 235, 4);
        poignee1.setFill(Color.YELLOWGREEN);
        poignee2.setFill(Color.YELLOWGREEN);

        Rectangle fenetre1 = new Rectangle(210, 210, 30, 20);
        Rectangle fenetre2 = new Rectangle(610, 210, 30, 20);
        fenetre1.setFill(Color.AQUA);
        fenetre2.setFill(Color.AQUA);
        fenetre1.setStrokeWidth(2);
        fenetre2.setStrokeWidth(2);
        fenetre1.setStroke(Color.rgb(197, 200, 204));
        fenetre2.setStroke(Color.rgb(197, 200, 204));

        Line horiz1 = new Line(210, 220, 240, 220);
        Line horiz2 = new Line(610, 220, 640, 220);
        horiz1.setStroke(Color.rgb(197, 200, 204));
        horiz2.setStroke(Color.rgb(197, 200, 204));
        horiz1.setStrokeWidth(2);
        horiz2.setStrokeWidth(2);

        Line vert1 = new Line(225, 210, 225, 230);
        Line vert2 = new Line(625, 210, 625, 230);
        vert1.setStroke(Color.rgb(197, 200, 204));
        vert2.setStroke(Color.rgb(197, 200, 204));
        vert1.setStrokeWidth(2);
        vert2.setStrokeWidth(2);

        Circle astre1 = new Circle(330, 60, 30);
        Circle astre2 = new Circle(730, 60, 30);
        astre1.setStroke(Color.LIGHTGRAY);
        astre1.setStrokeWidth(5);

        Stop[] stopsLune = new Stop[]{
                new Stop(0, Color.LIGHTGRAY),
                new Stop(1, Color.BLACK)
        };
        LinearGradient gradient = new LinearGradient(
                0, 0,
                1, 1,
                true,
                CycleMethod.NO_CYCLE,
                stopsLune);
        astre2.setFill(gradient);
        astre1.setFill(Color.YELLOW);

        FillTransition trans = new FillTransition(
                Duration.seconds(3), astre1);
        trans.setToValue(Color.ORANGE);
        trans.setCycleCount(Timeline.INDEFINITE);
        trans.setAutoReverse(true);
        trans.play();

        Line petitRayon1 = new Line(295, 25, (295+70.71), (25+70.71));
        Line petitRayon2 = new Line(295, (25+70.71), (295+70.71), 25);
        petitRayon1.setStroke(Color.YELLOW);
        petitRayon2.setStroke(Color.YELLOW);

        Line grosRayon1 = new Line(330, 0, 330, 120);
        Line grosRayon2 = new Line(270, 60, 270+120, 60);
        grosRayon1.setStroke(Color.YELLOW);
        grosRayon2.setStroke(Color.YELLOW);
        Group rayons = new Group(petitRayon1, petitRayon2, grosRayon1, grosRayon2);

        RotateTransition transRayon = new RotateTransition(
                Duration.seconds(5), rayons);
        transRayon.setInterpolator(Interpolator.LINEAR);
        transRayon.setByAngle(360);
        transRayon.setCycleCount(Timeline.INDEFINITE);
        transRayon.setAutoReverse(false);
        transRayon.play();

        QuadCurve gauche1 = new QuadCurve(10,125, 30,100, 50,125);
        QuadCurve gauche2 = new QuadCurve(5+150,150-75, 25+150,120-75, 45+150,150-75);
        gauche1.setFill(Color.TRANSPARENT);
        gauche2.setFill(Color.TRANSPARENT);
        gauche1.setStroke(Color.BLACK);
        gauche2.setStroke(Color.BLACK);

        QuadCurve droite1 = new QuadCurve(10+40,125, 30+40,100, 50+40,125);
        QuadCurve droite2 = new QuadCurve(5+150+40,150-75, 25+150+40,120-75, 45+150+40,150-75);
        droite1.setFill(Color.TRANSPARENT);
        droite2.setFill(Color.TRANSPARENT);
        droite1.setStroke(Color.BLACK);
        droite2.setStroke(Color.BLACK);

        Group oiseaux = new Group(droite1, droite2, gauche1, gauche2);

        Timeline steinsgate0 = new Timeline();
        steinsgate0.setCycleCount(Timeline.INDEFINITE);

        //KeyValue kv1 = new KeyValue(droite1.setTranslateY();)

        Group root = new Group(cielJour,
                cielNuit,
                jour,
                nuit,
                toit1,
                toit2,
                house1,
                house2,
                porte1,
                porte2,
                poignee1,
                poignee2,
                fenetre1,
                fenetre2,
                horiz1,
                horiz2,
                vert1,
                vert2,
                rayons,
                astre1,
                astre2,
                oiseaux);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
