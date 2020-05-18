package com.hansblackcat.gui.DrawingBoard.Draw

class DrawingTransform extends Drawable {
    private var _children = List[Drawable]()
    def children = _children

    def addChild(d: Drawable): Unit = _children ::= d

    override def toString(): String = "Transform"
} 