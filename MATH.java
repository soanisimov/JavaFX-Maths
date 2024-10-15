package JavaFxgame;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Orientation;

public class MATH extends Application{



    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Текстовые поля
        Label lbl = new Label();
        Label label = new Label();
        Label label1 = new Label();
        Label discriminatn = new Label();
        Label xx1 = new Label();
        Label xx2 = new Label();
        Label trichlen = new Label("");
        Label Error = new Label();
        Label Error2 = new Label();
        Error.getStyleClass().add("label-Err7or");
        Label D0 = new Label();
        Label x1_x2 = new Label("");
        Label x1x2 = new Label();
        Label Error_1 = new Label();
        Label Error_2 = new Label();
        Label hint = new Label("");

        //Поля для ввода
        TextField textField = new TextField();
        textField.setMaxSize(150,150);
        textField.setPromptText("Введите a");
        textField.setFocusTraversable(false);
        TextField textField2 = new TextField();
        textField2.setMaxSize(150,150);
        textField2.setPromptText("Введите b");
        textField2.setFocusTraversable(false);
        TextField textField13 = new TextField();
        textField13.setMaxSize(150,150);
        textField13.setPromptText("Введите c");
        textField13.setFocusTraversable(false);
        textField.getStyleClass().add("textfield");
        textField2.getStyleClass().add("textfield");
        textField13.getStyleClass().add("textfield");

        textField.setPrefColumnCount(11);
        textField2.setPrefColumnCount(11);
        textField13.setPrefColumnCount(11);
        //Кнопки
        Button btn = new Button("Расcчитать");
        Button button2 = new Button("2");
        button2.getStyleClass().add("help");
        Button button = new Button("Показать решение");
        button.setVisible(false);
        Button btn_error = new Button("Почему ошибка?");
        btn_error.setVisible(false);
        Button exit = new Button("Hазад");


        btn.setOnAction(event ->{
            discriminatn.setVisible(false);
            xx1.setVisible(false);
            xx2.setVisible(false);


            float a = Integer.parseInt(textField.getText());
            float b = Integer.parseInt(textField2.getText());
            float c = Integer.parseInt(textField13.getText());
            float d = b * b -4 * a * c;
            float x_1 = (float) (-b + Math.sqrt(d));
            float x_2 = (float) (-b - Math.sqrt(d));
            float a2 = 2*a;
            float x1 = x_1 / a2;
            float x2 = x_2 / a2;
            float sqvrt = (float) Math.sqrt(d);
            float d0 = b/a2;
            float x1__x2 = -b;
            float x1___x2 = c;
            lbl.setText("D: " +Float.toString(d));
            x1_x2.setText(" - - - т.Виета - - - "+"\n"+"x1 + x2 = " +String.valueOf(x1__x2));
            x1x2.setText("x1 ∗ x2 = " +String.valueOf(x1___x2)+"\n"+"- - - - - - - - - - - ");
            label.setText("x1: "+ Float.toString(x1));
            label1.setText("x2: "+Float.toString(x2)+"\n"+"\n"+"- - - квадратный тричлен - - -");
            button.setVisible(true);
            if (d > 0){
                trichlen.setText(Float.toString(a) + "(x " + Float.toString(-x1) +") " + "(x " + Float.toString(-x2) + ")");
                trichlen.setVisible(true);
                trichlen.setTextFill(Color.WHITE);
                D0.setVisible(false);
                Error.setVisible(false);

            }
            if (d<0){
                trichlen.setText("(Квадратний тричлен)Кореней нету");
                trichlen.setTextFill(Color.RED);
                trichlen.setVisible(true);
                D0.setVisible(false);
                Error.setVisible(true);

            }
            if (d == 0){
                D0.setText(Float.toString(a)+" (x +" + d0 + ")²");
                trichlen.setVisible(false);
                trichlen.setTextFill(Color.WHITE);
                Error.setVisible(false);
                D0.setVisible(true );

            }
            if (x1 < 1){
                Error.setText("(Теорема Виета) Кореней нету " + x1);
                Error.setVisible(true);
                trichlen.setTextFill(Color.WHITE);
            }
            else {
                Error.setVisible(false);
            }
            if (x2 < 1){
                Error2.setText("(Теорема Виета) Кореней нету у " + x2);
                Error2.setVisible(true);
                trichlen.setTextFill(Color.WHITE);
                Error2.setTextFill(Color.RED);
            }else{
                Error2.setVisible(false);
            }
            if (Float.isNaN(x1)){
                label.setText("Невозможно найти х1 при D = " + d);
                label.setTextFill(Color.RED);
                btn_error.setVisible(true);
                Error_1.setVisible(true);
                button.setVisible(false);
            }
            else{
                label.setTextFill(Color.WHITE);
                btn_error.setVisible(false);
                Error_1.setVisible(false);
            }
            if (Float.isNaN(x2)){
                label1.setText("Невозможно найти х2 при D = " + d);
                label1.setTextFill(Color.RED);
                btn_error.setVisible(true);
                Error_1.setVisible(true);
            }else {
                label1.setTextFill(Color.WHITE);
                btn_error.setVisible(false);
                Error_1.setVisible(false);
            }



            button.setOnAction(event1 -> {
                discriminatn.setVisible(true);
                xx1.setVisible(true);
                xx2.setVisible(true);
                discriminatn.setText("D = " + Float.toString(b) + "² - 4 ∗ " + Float.toString(a) + " ∗ " + Float.toString(c) + " = " + Float.toString(d));
                xx1.setText("x1 = " + Float.toString(-b) + " + " + Float.toString((sqvrt)) + "   = " + Float.toString(x1) +"\n"+"          ᅠᅠ"+Float.toString(a2));
                xx2.setText("x2 = " + Float.toString(-b) + " - " + Float.toString(sqvrt) +"   = " + Float.toString(x2)+ "\n"+"          ᅠᅠ"+Float.toString(a2));
            });


            btn_error.setOnAction(event1 -> {
                Error_1.setText("При D < 0  ⇒ " + "D = " + d + "\n"+ "найти его корень невозможно");
            });
        });
        FlowPane root2 = new FlowPane(Orientation.VERTICAL,10,10,hint,exit);
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10,button2,
                textField,
                textField2,
                textField13,btn,x1_x2,x1x2,lbl,label,label1,trichlen,Error,Error2,D0,button,discriminatn,xx1,xx2,btn_error,Error_1,
                Error_2);
        Scene scene = new Scene(root, 700, 630);
        Scene scene1 = new Scene(root2,700,500);

        stage.setScene(scene);
        scene.getStylesheets().add("my_css.css");
        stage.setTitle("Калькулятор");
        stage.show();

        button2.setOnAction(event1 ->{
            stage.setScene(scene1);
        });

        exit.setOnAction(event -> stage.setScene(scene));

        scene1.getStylesheets().add("second.css");


    }

}