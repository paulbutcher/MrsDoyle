package com.paulbutcher.mrsdoyle

import com.google.appengine.api.taskqueue.{DeferredTask, QueueFactory, TaskOptions}
  
class MakeTeaTask extends DeferredTask {
  def run() {
    StateMachine.handle( MakeTea )
  }
}

object Deferred {
  
  val queue = QueueFactory.getDefaultQueue
  
  def makeTeaIn(seconds: Int) {
    queue.add(
      TaskOptions.Builder.withCountdownMillis(seconds * 1000).payload(new MakeTeaTask))
  }
}