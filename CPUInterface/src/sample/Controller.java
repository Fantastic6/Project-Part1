package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

public class Controller implements Initializable {

    @FXML
    CheckBox R0_B1, R0_B2, R0_B4, R0_B8, R0_B16, R0_B32, R0_B64, R0_B128, R0_B256, R0_B512, R0_B1024, R0_B2048, R0_B4096, R0_B8192, R0_B16384, R0_B32768;
    @FXML
    CheckBox R1_B1, R1_B2, R1_B4, R1_B8, R1_B16, R1_B32, R1_B64, R1_B128, R1_B256, R1_B512, R1_B1024, R1_B2048, R1_B4096, R1_B8192, R1_B16384, R1_B32768;
    @FXML
    CheckBox R2_B1, R2_B2, R2_B4, R2_B8, R2_B16, R2_B32, R2_B64, R2_B128, R2_B256, R2_B512, R2_B1024, R2_B2048, R2_B4096, R2_B8192, R2_B16384, R2_B32768;
    @FXML
    CheckBox R3_B1, R3_B2, R3_B4, R3_B8, R3_B16, R3_B32, R3_B64, R3_B128, R3_B256, R3_B512, R3_B1024, R3_B2048, R3_B4096, R3_B8192, R3_B16384, R3_B32768;
    @FXML
    CheckBox Inst_B1, Inst_B2, Inst_B4, Inst_B8, Inst_B16, Inst_B32, Inst_B64, Inst_B128, Inst_B256, Inst_B512, Inst_B1024, Inst_B2048, Inst_B4096, Inst_B8192, Inst_B16384, Inst_B32768;
    @FXML
    Button setR0Btn, setR1Btn, setR2Btn, setR3Btn, setBtnInst;
    @FXML
    TextField TxtValInst;
    @FXML
    Label LabelValR0, LabelValR1, LabelValR2, LabelValR3;

    private double totalSumR0 = 0, totalSumR1 = 0, totalSumR2 = 0, totalSumR3 = 0;

    private int registerResArr[] = new int[4];


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EventHandler eventHandlerR0Line = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(event.getSource().toString().equals(setR0Btn.toString())) {
//                    registerResults.add(0, totalSum);
                    registerResArr[0] = (int) totalSumR0;
//                    totalSumR0 = 0;
                    for (int i = 0; i < registerResArr.length; i++)
                        System.out.println(registerResArr[i]);
                } else if(event.getSource().toString().equals(R0_B1.toString())) {
                    if(R0_B1.isSelected()) {
                        totalSumR0 += 1;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    } else {
                        totalSumR0 -= 1;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    }
                } else if(event.getSource().toString().equals(R0_B2.toString())) {
                    if(R0_B2.isSelected()) {
                        totalSumR0 += 2;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    } else {
                        if(totalSumR0 != 0) {
                            totalSumR0 -= 2;
                            LabelValR0.setText(String.valueOf(totalSumR0));
                        }
                    }
                } else if(event.getSource().toString().equals(R0_B4.toString())) {
                    if(R0_B4.isSelected()) {
                        totalSumR0 += 4;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    } else {
                        if(totalSumR0 != 0) {
                            totalSumR0 -= 4;
                            LabelValR0.setText(String.valueOf(totalSumR0));
                        }
                    }
                } else if(event.getSource().toString().equals(R0_B8.toString())) {
                    if(R0_B8.isSelected()) {
                        totalSumR0 += 8;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    } else {
                        totalSumR0 -= 8;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    }
                } else if(event.getSource().toString().equals(R0_B16.toString())) {
                    if(R0_B16.isSelected()) {
                        totalSumR0 += 16;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    } else {
                        totalSumR0 -= 16;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    }
                } else if(event.getSource().toString().equals(R0_B32.toString())) {
                    if(R0_B32.isSelected()) {
                        totalSumR0 += 32;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    } else {
                        totalSumR0 -= 32;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    }
                } else if(event.getSource().toString().equals(R0_B64.toString())) {
                    if(R0_B64.isSelected()) {
                        totalSumR0 += 64;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    } else {
                        totalSumR0 -= 64;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    }
                } else if(event.getSource().toString().equals(R0_B128.toString())) {
                    if(R0_B128.isSelected()) {
                        totalSumR0 += 128;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    } else {
                        totalSumR0 -= 128;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    }
                } else if(event.getSource().toString().equals(R0_B256.toString())) {
                    if(R0_B256.isSelected()) {
                        totalSumR0 += 256;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    } else {
                        totalSumR0 -= 256;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    }
                } else if(event.getSource().toString().equals(R0_B512.toString())) {
                    if(R0_B512.isSelected()) {
                        totalSumR0 += 512;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    } else {
                        totalSumR0 -= 512;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    }
                } else if(event.getSource().toString().equals(R0_B1024.toString())) {
                    if(R0_B1024.isSelected()) {
                        totalSumR0 += 1024;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    } else {
                        totalSumR0 -= 1024;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    }
                } else if(event.getSource().toString().equals(R0_B2048.toString())) {
                    if(R0_B2048.isSelected()) {
                        totalSumR0 += 2048;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    } else {
                        totalSumR0 -= 2048;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    }
                } else if(event.getSource().toString().equals(R0_B4096.toString())) {
                    if(R0_B4096.isSelected()) {
                        totalSumR0 += 4096;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    } else {
                        totalSumR0 -= 4096;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    }
                } else if(event.getSource().toString().equals(R0_B8192.toString())) {
                    if(R0_B8192.isSelected()) {
                        totalSumR0 += 8192;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    } else {
                        totalSumR0 -= 8192;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    }
                } else if(event.getSource().toString().equals(R0_B16384.toString())) {
                    if(R0_B16384.isSelected()) {
                        totalSumR0 += 16384;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    } else {
                        totalSumR0 -= 16384;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    }
                } else if(event.getSource().toString().equals(R0_B32768.toString())) {
                    if(R0_B32768.isSelected()) {
                        totalSumR0 -= 32768;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    } else {
                        totalSumR0 += 32768;
                        LabelValR0.setText(String.valueOf(totalSumR0));
                    }
                } else {

                }
            }
        };
        EventHandler eventHandlerR1Line = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(event.getSource().toString().equals(setR1Btn.toString())) {
//                    registerResults.add(1, totalSum);
                    registerResArr[1] = (int) totalSumR1;
                    for (int i = 0; i < registerResArr.length; i++)
                        System.out.println(registerResArr[i]);
                } else if(event.getSource().toString().equals(R1_B1.toString())) {
                    if(R1_B1.isSelected()) {
                        totalSumR1 += 1;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    } else {
                        totalSumR1 -= 1;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    }
                } else if(event.getSource().toString().equals(R1_B2.toString())) {
                    if(R1_B2.isSelected()) {
                        totalSumR1 += 2;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    } else {
                        if(totalSumR1 != 0) {
                            totalSumR1 -= 2;
                            LabelValR1.setText(String.valueOf(totalSumR1));
                        }
                    }
                } else if(event.getSource().toString().equals(R1_B4.toString())) {
                    if(R1_B4.isSelected()) {
                        totalSumR1 += 4;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    } else {
                        if(totalSumR1 != 0) {
                            totalSumR1 -= 4;
                            LabelValR1.setText(String.valueOf(totalSumR1));
                        }
                    }
                } else if(event.getSource().toString().equals(R1_B8.toString())) {
                    if(R1_B8.isSelected()) {
                        totalSumR1 += 8;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    } else {
                        totalSumR1 -= 8;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    }
                } else if(event.getSource().toString().equals(R1_B16.toString())) {
                    if(R1_B16.isSelected()) {
                        totalSumR1 += 16;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    } else {
                        totalSumR1 -= 16;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    }
                } else if(event.getSource().toString().equals(R1_B32.toString())) {
                    if(R1_B32.isSelected()) {
                        totalSumR1 += 32;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    } else {
                        totalSumR1 -= 32;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    }
                } else if(event.getSource().toString().equals(R1_B64.toString())) {
                    if(R1_B64.isSelected()) {
                        totalSumR1 += 64;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    } else {
                        totalSumR1 -= 64;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    }
                } else if(event.getSource().toString().equals(R1_B128.toString())) {
                    if(R1_B128.isSelected()) {
                        totalSumR1 += 128;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    } else {
                        totalSumR1 -= 128;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    }
                } else if(event.getSource().toString().equals(R1_B256.toString())) {
                    if(R1_B256.isSelected()) {
                        totalSumR1 += 256;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    } else {
                        totalSumR1 -= 256;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    }
                } else if(event.getSource().toString().equals(R1_B512.toString())) {
                    if(R1_B512.isSelected()) {
                        totalSumR1 += 512;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    } else {
                        totalSumR1 -= 512;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    }
                } else if(event.getSource().toString().equals(R1_B1024.toString())) {
                    if(R1_B1024.isSelected()) {
                        totalSumR1 += 1024;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    } else {
                        totalSumR1 -= 1024;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    }
                } else if(event.getSource().toString().equals(R1_B2048.toString())) {
                    if(R1_B2048.isSelected()) {
                        totalSumR1 += 2048;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    } else {
                        totalSumR1 -= 2048;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    }
                } else if(event.getSource().toString().equals(R1_B4096.toString())) {
                    if(R1_B4096.isSelected()) {
                        totalSumR1 += 4096;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    } else {
                        totalSumR1 -= 4096;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    }
                } else if(event.getSource().toString().equals(R1_B8192.toString())) {
                    if(R1_B8192.isSelected()) {
                        totalSumR1 += 8192;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    } else {
                        totalSumR1 -= 8192;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    }
                } else if(event.getSource().toString().equals(R1_B16384.toString())) {
                    if(R1_B16384.isSelected()) {
                        totalSumR1 += 16384;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    } else {
                        totalSumR1 -= 16384;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    }
                } else if(event.getSource().toString().equals(R1_B32768.toString())) {
                    if(R1_B32768.isSelected()) {
                        totalSumR1 -= 32768;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    } else {
                        totalSumR1 += 32768;
                        LabelValR1.setText(String.valueOf(totalSumR1));
                    }
                } else {

                }
            }
        };
        EventHandler eventHandlerR2Line = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(event.getSource().toString().equals(setR2Btn.toString())) {
//                    registerResults.add(2, totalSum);
                    registerResArr[2] = (int) totalSumR2;
//                    totalSumR2 = 0;
                    for (int i = 0; i < registerResArr.length; i++)
                        System.out.println(registerResArr[i]);
                } else if(event.getSource().toString().equals(R2_B1.toString())) {
                    if(R2_B1.isSelected()) {
                        totalSumR2 += 1;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    } else {
                        totalSumR2 -= 1;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    }
                } else if(event.getSource().toString().equals(R2_B2.toString())) {
                    if(R2_B2.isSelected()) {
                        totalSumR2 += 2;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    } else {
                        if(totalSumR2 != 0) {
                            totalSumR2 -= 2;
                            LabelValR2.setText(String.valueOf(totalSumR2));
                        }
                    }
                } else if(event.getSource().toString().equals(R2_B4.toString())) {
                    if(R2_B4.isSelected()) {
                        totalSumR2 += 4;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    } else {
                        if(totalSumR2 != 0) {
                            totalSumR2 -= 4;
                            LabelValR2.setText(String.valueOf(totalSumR2));
                        }
                    }
                } else if(event.getSource().toString().equals(R2_B8.toString())) {
                    if(R2_B8.isSelected()) {
                        totalSumR2 += 8;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    } else {
                        totalSumR2 -= 8;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    }
                } else if(event.getSource().toString().equals(R2_B16.toString())) {
                    if(R2_B16.isSelected()) {
                        totalSumR2 += 16;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    } else {
                        totalSumR2 -= 16;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    }
                } else if(event.getSource().toString().equals(R2_B32.toString())) {
                    if(R2_B32.isSelected()) {
                        totalSumR2 += 32;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    } else {
                        totalSumR2 -= 32;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    }
                } else if(event.getSource().toString().equals(R2_B64.toString())) {
                    if(R2_B64.isSelected()) {
                        totalSumR2 += 64;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    } else {
                        totalSumR2 -= 64;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    }
                } else if(event.getSource().toString().equals(R2_B128.toString())) {
                    if(R2_B128.isSelected()) {
                        totalSumR2 += 128;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    } else {
                        totalSumR2 -= 128;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    }
                } else if(event.getSource().toString().equals(R2_B256.toString())) {
                    if(R2_B256.isSelected()) {
                        totalSumR2 += 256;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    } else {
                        totalSumR2 -= 256;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    }
                } else if(event.getSource().toString().equals(R2_B512.toString())) {
                    if(R2_B512.isSelected()) {
                        totalSumR2 += 512;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    } else {
                        totalSumR2 -= 512;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    }
                } else if(event.getSource().toString().equals(R2_B1024.toString())) {
                    if(R2_B1024.isSelected()) {
                        totalSumR2 += 1024;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    } else {
                        totalSumR2 -= 1024;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    }
                } else if(event.getSource().toString().equals(R2_B2048.toString())) {
                    if(R2_B2048.isSelected()) {
                        totalSumR2 += 2048;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    } else {
                        totalSumR2 -= 2048;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    }
                } else if(event.getSource().toString().equals(R2_B4096.toString())) {
                    if(R2_B4096.isSelected()) {
                        totalSumR2 += 4096;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    } else {
                        totalSumR2 -= 4096;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    }
                } else if(event.getSource().toString().equals(R2_B8192.toString())) {
                    if(R2_B8192.isSelected()) {
                        totalSumR2 += 8192;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    } else {
                        totalSumR2 -= 8192;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    }
                } else if(event.getSource().toString().equals(R2_B16384.toString())) {
                    if(R2_B16384.isSelected()) {
                        totalSumR2 += 16384;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    } else {
                        totalSumR2 -= 16384;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    }
                } else if(event.getSource().toString().equals(R2_B32768.toString())) {
                    if(R2_B32768.isSelected()) {
                        totalSumR2 -= 32768;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    } else {
                        totalSumR2 += 32768;
                        LabelValR2.setText(String.valueOf(totalSumR2));
                    }
                } else {

                }
            }
        };
        EventHandler eventHandlerR3Line = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(event.getSource().toString().equals(setR3Btn.toString())) {
//                    registerResults.add(3, totalSum);
                    registerResArr[3] = (int) totalSumR3;
//                    totalSumR3 = 0;
                    for (int i = 0; i < registerResArr.length; i++)
                        System.out.println(registerResArr[i]);
                } else if(event.getSource().toString().equals(R3_B1.toString())) {
                    if(R3_B1.isSelected()) {
                        totalSumR3 += 1;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    } else {
                        totalSumR3 -= 1;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    }
                } else if(event.getSource().toString().equals(R3_B2.toString())) {
                    if(R3_B2.isSelected()) {
                        totalSumR3 += 2;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    } else {
                        if(totalSumR3 != 0) {
                            totalSumR3 -= 2;
                            LabelValR3.setText(String.valueOf(totalSumR3));
                        }
                    }
                } else if(event.getSource().toString().equals(R3_B4.toString())) {
                    if(R3_B4.isSelected()) {
                        totalSumR3 += 4;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    } else {
                        if(totalSumR3 != 0) {
                            totalSumR3 -= 4;
                            LabelValR3.setText(String.valueOf(totalSumR3));
                        }
                    }
                } else if(event.getSource().toString().equals(R3_B8.toString())) {
                    if(R3_B8.isSelected()) {
                        totalSumR3 += 8;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    } else {
                        totalSumR3 -= 8;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    }
                } else if(event.getSource().toString().equals(R3_B16.toString())) {
                    if(R3_B16.isSelected()) {
                        totalSumR3 += 16;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    } else {
                        totalSumR3 -= 16;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    }
                } else if(event.getSource().toString().equals(R3_B32.toString())) {
                    if(R3_B32.isSelected()) {
                        totalSumR3 += 32;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    } else {
                        totalSumR3 -= 32;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    }
                } else if(event.getSource().toString().equals(R3_B64.toString())) {
                    if(R3_B64.isSelected()) {
                        totalSumR3 += 64;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    } else {
                        totalSumR3 -= 64;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    }
                } else if(event.getSource().toString().equals(R3_B128.toString())) {
                    if(R3_B128.isSelected()) {
                        totalSumR3 += 128;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    } else {
                        totalSumR3 -= 128;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    }
                } else if(event.getSource().toString().equals(R3_B256.toString())) {
                    if(R3_B256.isSelected()) {
                        totalSumR3 += 256;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    } else {
                        totalSumR3 -= 256;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    }
                } else if(event.getSource().toString().equals(R3_B512.toString())) {
                    if(R3_B512.isSelected()) {
                        totalSumR3 += 512;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    } else {
                        totalSumR3 -= 512;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    }
                } else if(event.getSource().toString().equals(R3_B1024.toString())) {
                    if(R3_B1024.isSelected()) {
                        totalSumR3 += 1024;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    } else {
                        totalSumR3 -= 1024;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    }
                } else if(event.getSource().toString().equals(R3_B2048.toString())) {
                    if(R3_B2048.isSelected()) {
                        totalSumR3 += 2048;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    } else {
                        totalSumR3 -= 2048;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    }
                } else if(event.getSource().toString().equals(R3_B4096.toString())) {
                    if(R3_B4096.isSelected()) {
                        totalSumR3 += 4096;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    } else {
                        totalSumR3 -= 4096;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    }
                } else if(event.getSource().toString().equals(R3_B8192.toString())) {
                    if(R3_B8192.isSelected()) {
                        totalSumR3 += 8192;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    } else {
                        totalSumR3 -= 8192;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    }
                } else if(event.getSource().toString().equals(R3_B16384.toString())) {
                    if(R3_B16384.isSelected()) {
                        totalSumR3 += 16384;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    } else {
                        totalSumR3 -= 16384;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    }
                } else if(event.getSource().toString().equals(R3_B32768.toString())) {
                    if(R3_B32768.isSelected()) {
                        totalSumR3 -= 32768;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    } else {
                        totalSumR3 += 32768;
                        LabelValR3.setText(String.valueOf(totalSumR3));
                    }
                } else {

                }
            }
        };
        EventHandler eventHandlerInstLine = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(event.getSource().toString().equals(setBtnInst.toString())){

                }
            }
        };
        //R1 register Set Event Handler
        setR0Btn.setOnAction(eventHandlerR0Line);
        R0_B1.setOnAction(eventHandlerR0Line);
        R0_B2.setOnAction(eventHandlerR0Line);
        R0_B4.setOnAction(eventHandlerR0Line);
        R0_B8.setOnAction(eventHandlerR0Line);
        R0_B16.setOnAction(eventHandlerR0Line);
        R0_B32.setOnAction(eventHandlerR0Line);
        R0_B64.setOnAction(eventHandlerR0Line);
        R0_B128.setOnAction(eventHandlerR0Line);
        R0_B256.setOnAction(eventHandlerR0Line);
        R0_B512.setOnAction(eventHandlerR0Line);
        R0_B1024.setOnAction(eventHandlerR0Line);
        R0_B2048.setOnAction(eventHandlerR0Line);
        R0_B4096.setOnAction(eventHandlerR0Line);
        R0_B8192.setOnAction(eventHandlerR0Line);
        R0_B16384.setOnAction(eventHandlerR0Line);
        R0_B32768.setOnAction(eventHandlerR0Line);
        //R1 register Set Event Handler
        setR1Btn.setOnAction(eventHandlerR1Line);
        R1_B1.setOnAction(eventHandlerR1Line);
        R1_B2.setOnAction(eventHandlerR1Line);
        R1_B4.setOnAction(eventHandlerR1Line);
        R1_B8.setOnAction(eventHandlerR1Line);
        R1_B16.setOnAction(eventHandlerR1Line);
        R1_B32.setOnAction(eventHandlerR1Line);
        R1_B64.setOnAction(eventHandlerR1Line);
        R1_B128.setOnAction(eventHandlerR1Line);
        R1_B256.setOnAction(eventHandlerR1Line);
        R1_B512.setOnAction(eventHandlerR1Line);
        R1_B1024.setOnAction(eventHandlerR1Line);
        R1_B2048.setOnAction(eventHandlerR1Line);
        R1_B4096.setOnAction(eventHandlerR1Line);
        R1_B8192.setOnAction(eventHandlerR1Line);
        R1_B16384.setOnAction(eventHandlerR1Line);
        R1_B32768.setOnAction(eventHandlerR1Line);
        //R2 register Set Event Handler
        setR2Btn.setOnAction(eventHandlerR2Line);
        R2_B1.setOnAction(eventHandlerR2Line);
        R2_B2.setOnAction(eventHandlerR2Line);
        R2_B4.setOnAction(eventHandlerR2Line);
        R2_B8.setOnAction(eventHandlerR2Line);
        R2_B16.setOnAction(eventHandlerR2Line);
        R2_B32.setOnAction(eventHandlerR2Line);
        R2_B64.setOnAction(eventHandlerR2Line);
        R2_B128.setOnAction(eventHandlerR2Line);
        R2_B256.setOnAction(eventHandlerR2Line);
        R2_B512.setOnAction(eventHandlerR2Line);
        R2_B1024.setOnAction(eventHandlerR2Line);
        R2_B2048.setOnAction(eventHandlerR2Line);
        R2_B4096.setOnAction(eventHandlerR2Line);
        R2_B8192.setOnAction(eventHandlerR2Line);
        R2_B16384.setOnAction(eventHandlerR2Line);
        R2_B32768.setOnAction(eventHandlerR2Line);
        //R3 register Set Event Handler
        setR3Btn.setOnAction(eventHandlerR3Line);
        R3_B1.setOnAction(eventHandlerR3Line);
        R3_B2.setOnAction(eventHandlerR3Line);
        R3_B4.setOnAction(eventHandlerR3Line);
        R3_B8.setOnAction(eventHandlerR3Line);
        R3_B16.setOnAction(eventHandlerR3Line);
        R3_B32.setOnAction(eventHandlerR3Line);
        R3_B64.setOnAction(eventHandlerR3Line);
        R3_B128.setOnAction(eventHandlerR3Line);
        R3_B256.setOnAction(eventHandlerR3Line);
        R3_B512.setOnAction(eventHandlerR3Line);
        R3_B1024.setOnAction(eventHandlerR3Line);
        R3_B2048.setOnAction(eventHandlerR3Line);
        R3_B4096.setOnAction(eventHandlerR3Line);
        R3_B8192.setOnAction(eventHandlerR3Line);
        R3_B16384.setOnAction(eventHandlerR3Line);
        R3_B32768.setOnAction(eventHandlerR3Line);
        //Instruction register Set Event Handler
        setBtnInst.setOnAction(eventHandlerInstLine);
        Inst_B1.setOnAction(eventHandlerInstLine);
        Inst_B2.setOnAction(eventHandlerInstLine);
        Inst_B4.setOnAction(eventHandlerInstLine);
        Inst_B8.setOnAction(eventHandlerInstLine);
        Inst_B16.setOnAction(eventHandlerInstLine);
        Inst_B32.setOnAction(eventHandlerInstLine);
        Inst_B64.setOnAction(eventHandlerInstLine);
        Inst_B128.setOnAction(eventHandlerInstLine);
        Inst_B256.setOnAction(eventHandlerInstLine);
        Inst_B512.setOnAction(eventHandlerInstLine);
        Inst_B1024.setOnAction(eventHandlerInstLine);
        Inst_B2048.setOnAction(eventHandlerInstLine);
        Inst_B4096.setOnAction(eventHandlerInstLine);
        Inst_B8192.setOnAction(eventHandlerInstLine);
        Inst_B16384.setOnAction(eventHandlerInstLine);
        Inst_B32768.setOnAction(eventHandlerInstLine);
    }
}
