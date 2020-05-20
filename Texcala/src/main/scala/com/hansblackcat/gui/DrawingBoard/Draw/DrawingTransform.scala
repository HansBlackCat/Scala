package com.hansblackcat.gui.DrawingBoard.Draw

import scalafx.scene.control.Label


class DrawingTransform extends Drawable {
    private var _children = List[Drawable]()
    def children = _children

    def addChild(d: Drawable): Unit = _children ::= d

    def propertiesPanel: scalafx.scene.Node = {
        new Label("Transform")
    }
    override def toString(): String = "Transform"
} 