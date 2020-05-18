package com.hansblackcat.gui.guitest

import scalafx.application.JFXApp
import scalafx.stage.Stage
import scalafx.scene.Scene
import scalafx.scene.shape.Circle
import scalafx.scene.paint.Color
import scalafx.animation.AnimationTimer
import scalafx.animation._

object RunAway extends JFXApp {
    stage = new JFXApp.PrimaryStage {
        title = ""
        scene = new Scene(600, 600) {
            var enemies = List(Circle(10, 10, 10))

            var player = Circle(200, 200, 20)
            player.fill = Color.Green

            content = List(enemies.head, player)

            var lastTime = 0L
            val enemySpeed = 20
            val playerSpeed = 30
            val timer = AnimationTimer(t => {
                if (lastTime > 0) {
                    val delta = (t-lastTime)/1e9
                    for (e <- enemies) {
                        val dx = player.centerX.value - e.centerX.value
                        val dy = player.centerY.value - e.centerY.value
                        val dist = math.sqrt(dx*dx + dy*dy)
                        e.centerX = e.centerX.value + dx/dist * enemySpeed
                        e.centerY = e.centerY.value + dy/dist * enemySpeed
                    }
                }
                lastTime = t
            })
            timer.start
        }
    }
}