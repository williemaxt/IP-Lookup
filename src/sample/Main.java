package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class Main extends Application {
    @FXML
    Button getIPbtn;
    @FXML
    TextField webAdrs;
    @FXML
    Label ipAdrs;

    String url, htlink;




    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Layout1.fxml"));
        primaryStage.setTitle("IP Lookup");
        primaryStage.setScene(new Scene(root, 500, 700));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);



    }


    public void getIp(){


        url = webAdrs.getText().toString();
        htlink = "http://";
        url = htlink + url;
        try {
            //gets the web address name and ip
            InetAddress ip = InetAddress.getByName(new URL(url).getHost());
            System.out.println(ip.getHostAddress());
            //this extracts only the address(IP) and returns a string value to set the label
            ipAdrs.setText(ip.getHostAddress().toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }



}
