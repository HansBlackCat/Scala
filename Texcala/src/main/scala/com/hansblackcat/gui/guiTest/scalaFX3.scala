package com.hansblackcat.gui.guiTest
// Drawing GUI Layout

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.Menu
import scalafx.scene.control.MenuBar
import scalafx.scene.control.MenuItem
import scalafx.scene.control.SeparatorMenuItem
import scalafx.scene.layout.BorderPane
import scalafx.scene.control.TabPane
import scalafx.scene.control.Tab
import scalafx.scene.control.SplitPane
import scalafx.scene.control.TreeView
import scalafx.scene.control.ScrollPane
import scalafx.geometry.Orientation
import scalafx.scene.control.Slider
import scalafx.scene.canvas.Canvas
import scalafx.scene.control.TextField
import scalafx.scene.control.TextArea

object DrawingMain extends JFXApp {
    stage = new JFXApp.PrimaryStage {
        title = "Drawing Program"
        scene = new Scene(800, 800) {
            val menuBar = new MenuBar
            val fileMenu = new Menu("File")
            val newItem = new MenuItem("New")
            val openItem = new MenuItem("Opne")
            val saveItem = new MenuItem("Save")
            val exitItem = new MenuItem("Exit")
            fileMenu.items = List(newItem, openItem, saveItem, new SeparatorMenuItem, exitItem)
            val editMenu = new Menu("Edit")
            val addItem = new MenuItem("Add Drawable")
            val copyItem = new MenuItem("Copy")
            val cutItem = new MenuItem("Cut")
            val pasteItem = new MenuItem("paste")
            editMenu.items = List(addItem, copyItem, cutItem, pasteItem)
            menuBar.menus = List(fileMenu, editMenu)

            val tabPane = new TabPane
            tabPane += makeDrawingTab()

            val rootPane = new BorderPane
            rootPane.top = menuBar
            rootPane.center = tabPane
            root = rootPane
        }

    }

    private  def makeDrawingTab(): Tab = {
        val drawingTree = new TreeView[String]
        val treeScroll = new ScrollPane
        treeScroll.content = drawingTree

        val propertyPane = new ScrollPane

        val leftSplit = new SplitPane
        leftSplit.orientation = Orientation.Vertical
        leftSplit.items ++= List(treeScroll, propertyPane)

        val rightSplit = new SplitPane
        rightSplit.orientation = Orientation.Vertical
        val topRightBorder = new BorderPane
        val slider = new Slider(0, 1000, 0)
        val canvas = new Canvas
        topRightBorder.top = slider
        topRightBorder.center = canvas
        val bottomRightBorder = new BorderPane
        val commandField = new TextField
        val commandArea = new TextArea
        commandArea.editable = false
        bottomRightBorder.top = commandField
        bottomRightBorder.center = commandArea
        rightSplit.items ++= List(topRightBorder, bottomRightBorder)
        rightSplit.dividerPositions = 0.7

        val topSplit = new SplitPane
        topSplit.items ++= List(leftSplit, rightSplit)
        topSplit.dividerPositions = 0.3

        val tab = new Tab
        tab.text = "Untitled"
        tab.content = topSplit
        tab
    }
}