
package bobsrockets {
    package navigation {
        class Navigator {
            val map = new StarMap
            // val full_map = new bobsrockets.navigation.StarMap
        }
        class StarMap
    }
    package fleets {
        class Fleet {
            def addShip() = { new Ship }
        }
    }
    class Ship {
        val nav = new navigation.Navigator
    }
}