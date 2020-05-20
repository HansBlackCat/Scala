package com.hansblackcat.gui.DrawingBoard.Draw

import scalafx.scene.control.Label

class DrawingText extends Drawable {
    def propertiesPanel: scalafx.scene.Node = {
        new Label("Text")
    }
    override def toString(): String = "Text"
}