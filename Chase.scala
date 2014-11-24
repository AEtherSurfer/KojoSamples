import Staging._
import math._
cleari()
val delay = 5
val t1 = newTurtle(-500, 0)
t1.setAnimationDelay(delay)
val t2 = newTurtle(500, 0)
t2.setAnimationDelay(delay)
val t3 = newTurtle(500, 500)
t3.setAnimationDelay(delay)

// the code that you provide to act runs in a different thread
// that allows this turtle to run concurrently with other turtles
t1.act { self => // we give this turtle the name 'self' within act {...}
    self.setPenColor(Color(0, 0, 255, 120))
    self.setPenThickness(4)
    var d = 1.0
    repeatWhile(true) {
      self.towards(mousePosition)
      d = dist(self.position, mousePosition)
      self.forward(min(0.0005*(d*d),8))
    } 
}

t2.act { self => 
    self.setPenColor(Color(0, 255, 0, 120))
    var d = 1.0
    repeatWhile(true) {
      self.towards(t1)
      d = dist(self.position, t1.position)
      self.forward(min(0.0005*(d*d),4))
    }
}

t3.act { self => 
    self.setPenColor(Color(255, 0, 0, 120))
    var d = 1.0
    repeatWhile(true) {
      self.towards(t2)
      d = dist(self.position, t2.position)
      self.forward(min(0.0005*(d*d),2))
    }
}
