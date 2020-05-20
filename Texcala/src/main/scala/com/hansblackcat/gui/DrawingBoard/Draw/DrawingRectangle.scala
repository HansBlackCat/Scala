package com.hansblackcat.gui.DrawingBoard.Draw

import scalafx.scene.control.Label

class DrawingRectangle extends Drawable {
    def propertiesPanel: scalafx.scene.Node = {
        new Label("Rectangle")
    }
    override def toString(): String = "Rectangle"
}