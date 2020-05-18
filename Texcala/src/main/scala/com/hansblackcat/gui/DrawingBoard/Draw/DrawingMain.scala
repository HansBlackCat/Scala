package com.hansblackcat.gui.DrawingBoard.Draw

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
import scalafx.event.ActionEvent

object DrawingMain extends JFXApp {
    private var drawings = List[Drawing]()

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
            val firstDrawing = new Drawing
            firstDrawing.root.addChild(new DrawingRectangle)
            firstDrawing.root.addChild(new DrawingText)
            
            drawings = drawings :+ firstDrawing // append end - match with tabPlane
            tabPane += makeDrawingTab(firstDrawing, "My Drawing")

            newItem.onAction = (actionEvent: ActionEvent) => {
                val newDrawing = new Drawing
                drawings = drawings :+ newDrawing
                val newTab = makeDrawingTab(newDrawing, "Untitled")
                tabPane += newTab
            }
            addItem.onAction = (actionEvent: ActionEvent) => {

            }
            exitItem.onAction = (actionEvent: ActionEvent) => {
                // ToDo Save all tabs
                sys.exit(0)
            }

            val rootPane = new BorderPane
            rootPane.top = menuBar
            rootPane.center = tabPane
            root = rootPane
        }

    }

    private  def makeDrawingTab(drawing: Drawing, name: String): Tab = {
        val drawingTree = new TreeView[Drawable]
        drawingTree.root = drawing.makeTree()
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
        tab.text = name
        tab.content = topSplit
        tab
    }
}