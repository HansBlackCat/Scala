package com.hansblackcat.gui.DrawingBoard.Draw

import scalafx.scene.control.TreeItem

class Drawing {
    val root = new DrawingTransform
    def makeTree(): TreeItem[Drawable] = {
        def helper(drawable: Drawable): TreeItem[Drawable] = {
            drawable match {
                case dt: DrawingTransform => {
                    val item = new TreeItem(drawable)
                    dt.children.foreach { c => item.children += helper(c) }
                    item
                }
                case _ => new TreeItem(drawable)
            }
        }
        helper(root)
    }

}