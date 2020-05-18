package com.hansblackcat.gui.guitest

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.shape.Rectangle
import scalafx.scene.paint.Color

object DrawingMain extends JFXApp {
    stage = new JFXApp.PrimaryStage {
        title = "Drawing Program"
        scene = new Scene(800, 600) {
            val button = new Button("Click Me!")
            button.layoutX = 100
            button.layoutY = 100

            val rect = Rectangle(200, 200, 400, 150)
            rect.fill = Color.AliceBlue
            
            content = List(button, rect)
        }
    }
}